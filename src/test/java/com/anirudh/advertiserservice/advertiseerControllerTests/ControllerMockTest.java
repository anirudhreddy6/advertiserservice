package com.anirudh.advertiserservice.advertiseerControllerTests;


import com.anirudh.advertiserservice.controller.AdvertiserController;
import com.anirudh.advertiserservice.mapper.AdvertiserMapper;
import com.anirudh.advertiserservice.model.Advertiser;
import com.anirudh.advertiserservice.service.AdvertiserService;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.json.JSONObject;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AdvertiserController.class)
public class ControllerMockTest {
    @Autowired
    @MockBean
    private AdvertiserMapper advertiserMapper;
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    @MockBean
    private AdvertiserService advertiserService;


    @Test
    public void getAllAdvertisersShouldReturn2Records() throws Exception
    {
        List<Advertiser> advertiserList = new ArrayList<Advertiser>();
        advertiserList.add(new Advertiser("Advertiser1", "ContactName1", 10000));
        advertiserList.add(new Advertiser("Advertiser2", "ContactName2", 10000.00));
        advertiserList.add(new Advertiser("Advertiser3", "ContactName3", 1000.0));
        Mockito.when(advertiserService.getALLAdvertisers()).thenReturn(advertiserList);
        mockMvc.perform(get("/api/advertiser").accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andExpect(jsonPath("$",hasSize(3)));
    }

    @Test
    public void getAdvertiserShouldReturnSingleRecord() throws Exception
    {

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/api/Advertiser/Advertiser1").accept(
                MediaType.APPLICATION_JSON);
        List<Advertiser> advertiserList = new ArrayList<Advertiser>();
        advertiserList.add(new Advertiser("Advertiser1", "ContactName1", 5000));
        Mockito.when(advertiserService.getAdvertiserByName("Advertiser1")).thenReturn(advertiserList.get(0));
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        this.mockMvc.perform(get("/api/advertiser/Advertiser1")).andExpect(status().isOk()).andExpect(content().string("{\"advertiserName\":\"Advertiser1\",\"contactName\":\"ContactName1\",\"creditLimit\":5000.0}"));

    }

    @Test
    public void postAdvertiserShouldReturnPostedRecordFromService() throws Exception {
        Advertiser advertiser = new Advertiser();
        advertiser.setAdvertiserName("iheartmedia");
        advertiser.setContactName("contact1");
        advertiser.setCreditLimit(100.00);

        String jsonString = "{\"advertiserName\":\"Advertiser2\",\"contactName\":\"ContactName2\",\"creditLimit\":6000.0}";
        System.out.println(jsonString);
        MockHttpServletResponse response= this.mockMvc.perform(post("/api/Advertiser").contentType(MediaType.APPLICATION_JSON).content(asJsonString)
}




