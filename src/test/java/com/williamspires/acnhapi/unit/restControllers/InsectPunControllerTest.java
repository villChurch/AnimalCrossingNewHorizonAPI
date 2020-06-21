package com.williamspires.acnhapi.unit.restControllers;

import com.williamspires.acnhapi.Controllers.InsectPunController;
import com.williamspires.acnhapi.Model.InsectPuns;
import com.williamspires.acnhapi.Repositories.ApiEventRepository;
import com.williamspires.acnhapi.Repositories.InsectPunRepository;
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
@WebMvcTest(InsectPunController.class)
public class InsectPunControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    InsectPunRepository insectPunRepository;

    @MockBean
    ApiEventRepository apiEventRepository;

    private InsectPuns insectPuns;

    @Before
    public void setup() {
        insectPuns = new InsectPuns();
        insectPuns.setLabel("Label");
        insectPuns.setText("Text");
    }

    @Test
    public void shouldReturnAInsectPun() throws Exception {
        List<InsectPuns> puns = new ArrayList<>();
        puns.add(insectPuns);
        puns.add(insectPuns);
        puns.add(insectPuns);
        puns.add(insectPuns);
        puns.add(insectPuns);
        puns.add(insectPuns);
        Mockito.when(insectPunRepository.getAllInsectPuns()).thenReturn(puns);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/puns/insect")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String expected = "{\"label\":\"Label\",\"text\":\"Text\"}";
        JSONAssert.assertEquals(expected, response.getContentAsString(), true);
        assertThat(response.getStatus()).isEqualTo(200);
    }
}
