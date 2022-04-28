INSERT INTO licence_plate (id, plate_name) VALUES (1, '34 TL 34');

INSERT INTO route (id, plate) VALUES (1, '34 TL 34');

INSERT INTO delivery_points (id, delivery_point,delivery_value,route_id) VALUES (1, 'Branch',1,1);
INSERT INTO delivery_points (id, delivery_point,delivery_value,route_id) VALUES (2, 'Distribution Center',2,1);
INSERT INTO delivery_points (id, delivery_point,delivery_value,route_id) VALUES (3, 'Transfer Center',3,1);

INSERT INTO bags (id, bag_status,barcode,delivery_point_delivery_value) VALUES (1, 1,'C725799',2);
INSERT INTO bags (id, bag_status,barcode,delivery_point_delivery_value) VALUES (2, 1,'C725800',3);

INSERT INTO packs (id, pack_barcode,status_of_packs,volumetric_weight,bags_barcode,delivery_point_delivery_value) VALUES (1,'P7988000121',1,5,null,1);
INSERT INTO packs (id, pack_barcode,status_of_packs,volumetric_weight,bags_barcode,delivery_point_delivery_value) VALUES (2,'P7988000122',1,5,null,1);
INSERT INTO packs (id, pack_barcode,status_of_packs,volumetric_weight,bags_barcode,delivery_point_delivery_value) VALUES (3,'P7988000123',1,9,null,1);
INSERT INTO packs (id, pack_barcode,status_of_packs,volumetric_weight,bags_barcode,delivery_point_delivery_value) VALUES (4,'P8988000120',1,33,null,2);
INSERT INTO packs (id, pack_barcode,status_of_packs,volumetric_weight,bags_barcode,delivery_point_delivery_value) VALUES (5,'P8988000121',1,17,null,2);
INSERT INTO packs (id, pack_barcode,status_of_packs,volumetric_weight,bags_barcode,delivery_point_delivery_value) VALUES (6,'P8988000122',2,26,'C725799',2);
INSERT INTO packs (id, pack_barcode,status_of_packs,volumetric_weight,bags_barcode,delivery_point_delivery_value) VALUES (7,'P8988000123',1,35,null,2);
INSERT INTO packs (id, pack_barcode,status_of_packs,volumetric_weight,bags_barcode,delivery_point_delivery_value) VALUES (8,'P8988000124',1,1,null,2);
INSERT INTO packs (id, pack_barcode,status_of_packs,volumetric_weight,bags_barcode,delivery_point_delivery_value) VALUES (9,'P8988000125',1,200,null,2);
INSERT INTO packs (id, pack_barcode,status_of_packs,volumetric_weight,bags_barcode,delivery_point_delivery_value) VALUES (10,'P8988000126',2,50,'C725799',2);
INSERT INTO packs (id, pack_barcode,status_of_packs,volumetric_weight,bags_barcode,delivery_point_delivery_value) VALUES (11,'P9988000126',1,15,null,3);
INSERT INTO packs (id, pack_barcode,status_of_packs,volumetric_weight,bags_barcode,delivery_point_delivery_value) VALUES (12,'P9988000127',1,16,null,3);
INSERT INTO packs (id, pack_barcode,status_of_packs,volumetric_weight,bags_barcode,delivery_point_delivery_value) VALUES (13,'P9988000128',2,55,'C725800',3);
INSERT INTO packs (id, pack_barcode,status_of_packs,volumetric_weight,bags_barcode,delivery_point_delivery_value) VALUES (14,'P9988000129',2,28,'C725800',3);
INSERT INTO packs (id, pack_barcode,status_of_packs,volumetric_weight,bags_barcode,delivery_point_delivery_value) VALUES (15,'P9988000130',1,17,null,3);
