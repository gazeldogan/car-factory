package tr.com.vodafone.carfactory.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import tr.com.vodafone.carfactory.model.Cabrio;
import tr.com.vodafone.carfactory.model.Hatchback;
import tr.com.vodafone.carfactory.model.Sedan;
import tr.com.vodafone.carfactory.service.impl.CarFactoryServiceImpl;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(CarFactoryController.class)
public class CarFactoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CarFactoryServiceImpl carFactoryService;

    @Test
    public void createCarFactoryForCabrio() throws Exception {
        when(carFactoryService.createCarFactory("cabrio")).thenReturn(
                (new Cabrio()).getType());

        RequestBuilder request = MockMvcRequestBuilders
                .get("/api/car-factory")
                .param("carTypeName", "cabrio")
                .accept(MediaType.APPLICATION_JSON);


        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Cabrio Car has produced."))
                .andReturn();

    }

    @Test
    public void createCarFactoryForSedan() throws Exception {
        when(carFactoryService.createCarFactory("Sedan")).thenReturn(
                (new Sedan()).getType());

        RequestBuilder request = MockMvcRequestBuilders
                .get("/api/car-factory")
                .param("carTypeName", "Sedan")
                .accept(MediaType.APPLICATION_JSON);


        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Sedan Car has produced."))
                .andReturn();

    }

    @Test
    public void createCarFactoryForHatchback() throws Exception {
        when(carFactoryService.createCarFactory("HATCHBACK")).thenReturn(
                (new Hatchback()).getType());

        RequestBuilder request = MockMvcRequestBuilders
                .get("/api/car-factory")
                .param("carTypeName", "HATCHBACK")
                .accept(MediaType.APPLICATION_JSON);


        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Hatchback Car has produced."))
                .andReturn();

    }
}
