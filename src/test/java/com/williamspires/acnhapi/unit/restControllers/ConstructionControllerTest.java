package com.williamspires.acnhapi.unit.restControllers;

import com.williamspires.acnhapi.Controllers.ConstructionController;
import com.williamspires.acnhapi.Model.Construction;
import com.williamspires.acnhapi.Repositories.ApiEventRepository;
import com.williamspires.acnhapi.Repositories.ConstructionRepository;
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

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@WebMvcTest(ConstructionController.class)
public class ConstructionControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ConstructionRepository constructionRepository;
    @MockBean
    ApiEventRepository apiEventRepository;

    private Construction construction;

    @Before
    public void setup() {
        construction = new Construction();
        construction.setBuy(100);
        construction.setCategory("Category");
        construction.setFilename("FileName");
        construction.setName("Name");
        construction.setSource("Source");
        construction.setUniqueEntryID("Unique");
        construction.setVersion("1.2.0");
    }

    @Test
    public void ConstructionItemShouldBeReturnedWhenItExists() throws Exception {
        Mockito.when(constructionRepository.findConstructionByName(Mockito.anyString())).thenReturn(construction);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/construction/Name")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response  = result.getResponse();
        String expected = "{\"uniqueEntryID\":\"Unique\",\"name\":\"Name\",\"buy\":100,\"category\":\"Category\",\"source\":\"Source\",\"filename\":\"FileName\",\"version\":\"1.2.0\"}";
        JSONAssert.assertEquals(expected, response.getContentAsString(), true);
        assertThat(response.getStatus()).isEqualTo(200);
    }

    @Test
    public void shouldReturn404WhenEventDoesNotExist() throws Exception {
        Mockito.when(constructionRepository.findConstructionByName(Mockito.anyString())).thenReturn(null);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/construction/404")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertThat(response.getStatus()).isEqualTo(404);
        assertThat(response.getContentAsString()).isEqualTo("Could not find construction item called 404");
    }
}