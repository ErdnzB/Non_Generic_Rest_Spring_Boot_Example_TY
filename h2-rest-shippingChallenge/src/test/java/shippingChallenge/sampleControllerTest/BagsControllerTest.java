package shippingChallenge.sampleControllerTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import shippingChallenge.baseServices.BagsService;
import shippingChallenge.entity.Bags;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class BagsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    BagsService bagsService;

    @Test
    public void testGetAllBags() throws Exception {
        Bags bag = new Bags();
        bag.setId(1);

        List<Bags> bagsList = new ArrayList<>();
        bagsList.add(bag);

        given(bagsService.getAllBags()).willReturn(bagsList);

        this.mockMvc.perform(get("/getAllBags")).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1));
    }

}
