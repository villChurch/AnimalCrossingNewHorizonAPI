package com.williamspires.acnhapi.unit.restControllers;

import com.williamspires.acnhapi.Controllers.FishPunController;
import com.williamspires.acnhapi.Model.FishPuns;
import com.williamspires.acnhapi.Repositories.ApiEventRepository;
import com.williamspires.acnhapi.Repositories.FishPunRepository;
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

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@WebMvcTest(FishPunController.class)
public class FishPunControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    FishPunRepository fishPunRepository;

    @MockBean
    ApiEventRepository apiEventRepository;

    private FishPuns fishPuns;

    @Before
    public void setup() {
        fishPuns = new FishPuns();
        fishPuns.setLabel("Label");
        fishPuns.setText("Text");
    }

    @Test
    public void shouldReturnAFishPun() throws Exception {
        List<FishPuns> puns = new ArrayList<>();
        puns.add(fishPuns);
        puns.add(fishPuns);
        puns.add(fishPuns);
        puns.add(fishPuns);
        puns.add(fishPuns);
        puns.add(fishPuns);
        Mockito.when(fishPunRepository.getAllFishPuns()).thenReturn(puns);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/puns/fish")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String expected = "{\"label\":\"Label\",\"text\":\"Text\"}";
        JSONAssert.assertEquals(expected, response.getContentAsString(), true);
        assertThat(response.getStatus()).isEqualTo(200);
    }
}
