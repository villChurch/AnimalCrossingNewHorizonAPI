package com.williamspires.acnhapi.unit.restControllers;

import com.williamspires.acnhapi.Controllers.OutfitController;
import com.williamspires.acnhapi.Model.Outfits;
import com.williamspires.acnhapi.Repositories.ApiEventRepository;
import com.williamspires.acnhapi.Repositories.OutfitRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@WebMvcTest(OutfitController.class)
public class OutfitControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    OutfitRepository outfitRepository;

    @MockBean
    ApiEventRepository eventRepository;

    private Outfits outfits;

    @Before
    public void setup() {
        outfits = new Outfits();
        outfits.setName("Name");
        outfits.setUniqueEntryID("UniqueEntryID");
    }

    @Test
    public void OutfitsAreReturnedWhenTheyExists() throws Exception {
        List<Outfits> outfitsList = new ArrayList<>();
        outfitsList.add(outfits);
        Mockito.when(outfitRepository.findOutfitsByName(Mockito.anyString())).thenReturn(outfitsList);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/outfits/Name")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String expected = "[{\"uniqueEntryID\":\"UniqueEntryID\",\"name\":\"Name\",\"variation\":null,\"diy\":null,\"buy\":null,\"sell\":0,\"color1\":null,\"color2\":null,\"size\":null,\"source\":null,\"sourceNotes\":null,\"seasonalAvailability\":null,\"mannequinPiece\":null,\"version\":null,\"style\":null,\"labelThemes\":null,\"villagerEquippable\":null,\"catalog\":null,\"primaryShape\":null,\"secondaryShape\":null,\"filename\":null,\"internalID\":null}]";
        JSONAssert.assertEquals(expected, response.getContentAsString(), true);
        assertThat(response.getStatus()).isEqualTo(200);
    }

    @Test
    public void shouldReturn404WhenOutfitDoesNotExist() throws Exception {
        Mockito.when(outfitRepository.findOutfitsByName(Mockito.anyString())).thenReturn(null);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/outfits/404")
                .accept(MediaType.ALL);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertThat(response.getStatus()).isEqualTo(404);
        assertThat(response.getContentAsString()).isEqualTo("Could not find outfit called 404");
    }
}
