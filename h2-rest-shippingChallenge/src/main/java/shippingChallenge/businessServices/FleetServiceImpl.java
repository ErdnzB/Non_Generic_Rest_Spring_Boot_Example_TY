package shippingChallenge.businessServices;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import shippingChallenge.baseServices.BagsService;
import shippingChallenge.baseServices.PacksService;
import shippingChallenge.configuration.EnumMessages;
import shippingChallenge.configuration.ShippingChallengeApiException;
import shippingChallenge.entity.Bags;
import shippingChallenge.entity.Packs;
import shippingChallenge.enums.StatusOfBags;
import shippingChallenge.enums.StatusOfPacks;
import shippingChallenge.generic.GenericService;
import shippingChallenge.generic.IGenericService;
import shippingChallenge.requestModels.InnerRequestModel;
import shippingChallenge.responseModels.DeliveryModel;
import shippingChallenge.responseModels.RouteModel;
import shippingChallenge.responseModels.ShipmentModel;

import java.util.ArrayList;
import java.util.Locale;


@Slf4j
@Service
@Component
@AllArgsConstructor
public class FleetServiceImpl<T> implements FleetService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FleetServiceImpl.class);

    private final BagsService bagsService;

    private final PacksService packsService;

    private final IGenericService<T> genericService;

    public String shipLoad(ShipmentModel shipmentModel) {
        if (shipmentModel != null && !shipmentModel.getPlate().isEmpty()) {
            if(shipmentModel.getRoute().size() >0) {
                for (RouteModel route : shipmentModel.getRoute()) {
                    for (DeliveryModel deliveryModel : route.getDeliveries()) {
                        InnerRequestModel innerRequestModel = new InnerRequestModel();
                        if (deliveryModel.getBarcode().toUpperCase(Locale.ROOT).contains("C")) {
                            innerRequestModel.setBarcode(deliveryModel.getBarcode());

                            Bags bag = bagsService.findBagByBarcode(innerRequestModel);
                            if (bag != null) {
                                bag.setBagStatus(StatusOfBags.LOADED);
                                genericService.update(bag);
                            } else {
                                LOGGER.warn("Yüklemeye Dahil Edilen Çanta Kodu :" + deliveryModel.getBarcode() + "Kayıt Bulunmamaktadır.");
                            }
                        } else {
                            innerRequestModel.setBarcode(deliveryModel.getBarcode());
                            Packs pack = packsService.findPackByBarcode(innerRequestModel);
                            if (pack != null) {
                                pack.setStatusOfPacks(StatusOfPacks.LOADED);
                                genericService.update(pack);
                            } else {
                                LOGGER.warn("Yüklemeye Dahil Edilen Paket Kodu :" + deliveryModel.getBarcode() + "Kayıt Bulunmamaktadır.");
                            }
                        }
                    }
                }
            }else{
                throw new  ShippingChallengeApiException(EnumMessages.ROUTE_AND_DELIVERIES_NOT_FOUND);
            }
            return EnumMessages.COMPLETED.getMessage();
        }
        throw new ShippingChallengeApiException(EnumMessages.SHIP_NOT_FOUND);

    }

    public ShipmentModel shipUnLoad(ShipmentModel shipmentModel) {
        ShipmentModel shipmentResponse = new ShipmentModel();

        if (shipmentModel != null && shipmentModel.getPlate() != null) {
            shipmentResponse.setPlate(shipmentModel.getPlate());
            ArrayList<RouteModel> routeModelList = new ArrayList<>();
            if (shipmentModel.getRoute().size() > 0) {
                for (RouteModel routeModel : shipmentModel.getRoute()) {
                    RouteModel responseRouteModel = new RouteModel();
                    responseRouteModel.setDeliveryPoint(routeModel.getDeliveryPoint());
                    responseRouteModel.setDeliveries(handleDeliveries(routeModel));
                    routeModelList.add(responseRouteModel);
                }
            } else {
                throw new ShippingChallengeApiException(EnumMessages.ROUTE_AND_DELIVERIES_NOT_FOUND);
            }
            shipmentResponse.setRoute(routeModelList);
        } else {
            throw new ShippingChallengeApiException(EnumMessages.SHIP_NOT_FOUND);
        }
        return shipmentResponse;
    }

    public ArrayList<DeliveryModel> handleDeliveries(RouteModel routeModel) {
        ArrayList<DeliveryModel> responseDeliveryModelList = new ArrayList<>();

        for (DeliveryModel deliveryModel : routeModel.getDeliveries()) {
            InnerRequestModel innerRequestModelForBag = new InnerRequestModel();
            if (deliveryModel.getBarcode().toUpperCase(Locale.ROOT).contains("C")) {
                innerRequestModelForBag.setBarcode(deliveryModel.getBarcode());
                Bags bagEntity = bagsService.findBagByBarcode(innerRequestModelForBag);

                if (bagEntity.getDeliveryPoints().getDeliveryValue().equals(routeModel.getDeliveryPoint())) {
                    responseDeliveryModelList.add(handleBagsWithPacks(bagEntity, deliveryModel));

                } else {
                    LOGGER.warn("İNDİRME İŞLEMİNDE BELİRTİLEN ''ÇANTA'' TANIMLARA AYKIRIDIR :" + bagEntity.getBarcode());
                    responseDeliveryModelList.add(deliveryModelForResponse(bagEntity, StatusOfBags.LOADED, null, null));
                }
            } else {
                InnerRequestModel innerRequestModelForPack = new InnerRequestModel();
                innerRequestModelForPack.setBarcode(deliveryModel.getBarcode());
                Packs packsEntity = packsService.findPackByBarcode(innerRequestModelForPack);
                if (packsEntity.getDeliveryPoints().getDeliveryValue().equals(routeModel.getDeliveryPoint())) {
                    packsEntity.setStatusOfPacks(StatusOfPacks.UNLOADED);
                    genericService.update(packsEntity);
                    responseDeliveryModelList.add(deliveryModelForResponse(null, null, packsEntity, StatusOfPacks.UNLOADED));
                } else {
                    LOGGER.warn("İNDİRME İŞLEMİNDE BELİRTİLEN ''PAKET'' TANIMLARA AYKIRIDIR :" + packsEntity.getPackBarcode());
                    responseDeliveryModelList.add(deliveryModelForResponse(null, null, packsEntity, StatusOfPacks.LOADED));
                }
            }
        }
        return responseDeliveryModelList;
    }

    public DeliveryModel handleBagsWithPacks(Bags bagEntity, DeliveryModel deliveryModel) {

        DeliveryModel responseDeliveryModel = new DeliveryModel();

        for (int i = 0; i < bagEntity.getPacksList().size(); i++) {
            InnerRequestModel innerRequestModelForRelatedPacks = new InnerRequestModel();
            innerRequestModelForRelatedPacks.setBarcode(bagEntity.getPacksList().get(i).getPackBarcode());
            Packs packsEntity = packsService.findPackByBarcode(innerRequestModelForRelatedPacks);
            packsEntity.setStatusOfPacks(StatusOfPacks.UNLOADED);
            genericService.update(packsEntity);
        }

        deliveryModel.setBarcode(bagEntity.getBarcode());
        bagEntity.setBagStatus(StatusOfBags.UNLOADED);
        genericService.update(bagEntity);


        return deliveryModelForResponse(bagEntity, StatusOfBags.UNLOADED, null, null);

    }

    public DeliveryModel deliveryModelForResponse(Bags bagEntity, StatusOfBags statusOfBags, Packs packsEntity, StatusOfPacks statusOfPacks) {
        DeliveryModel deliveryModel = new DeliveryModel();

        if (bagEntity != null && statusOfBags != null) {
            deliveryModel.setState(statusOfBags.getKey());
            deliveryModel.setBarcode(bagEntity.getBarcode());
        }
        if (packsEntity != null && statusOfPacks != null) {
            deliveryModel.setState(statusOfPacks.getKey());
            deliveryModel.setBarcode(packsEntity.getPackBarcode());
        }

        return deliveryModel;


    }
}
