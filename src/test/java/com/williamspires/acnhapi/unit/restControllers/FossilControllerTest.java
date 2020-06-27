package com.williamspires.acnhapi.unit.restControllers;

import com.williamspires.acnhapi.Controllers.FossilController;
import com.williamspires.acnhapi.Model.Fossil;
import com.williamspires.acnhapi.Repositories.ApiEventRepository;
import com.williamspires.acnhapi.Repositories.FossilRepository;
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
@WebMvcTest(FossilController.class)
public class FossilControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    FossilRepository fossilRepository;

    @MockBean
    ApiEventRepository apiEventRepository;

    private Fossil fossil;

    @Before
    public void setup() {
        fossil = new Fossil();
        fossil.setBuy("buy");
        fossil.setCatalog("Catalog");
        fossil.setColor1("Color1");
        fossil.setColor2("Color2");
        fossil.setFilename("Filename");
        fossil.setInteract("no");
        fossil.setInternalID(1);
        fossil.setMuseum("Museum");
        fossil.setName("Name");
        fossil.setSize("Size");
        fossil.setSell(0);
        fossil.setSource("Source");
        fossil.setUniqueEntryID("UniqueEntryID");
        fossil.setVersion("Version");
    }

    @Test
    public void shouldReturnFossilWhenFossilExits() throws Exception {
        Mockito.when(fossilRepository.findFossilByName(Mockito.anyString())).thenReturn(fossil);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/fossils/Name")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String expected = "{\"name\":\"Name\",\"buy\":\"buy\",\"sell\":0,\"color1\":\"Color1\",\"color2\":\"Color2\",\"size\":\"Size\",\"source\":\"Source\",\"museum\":\"Museum\",\"version\":\"Version\",\"interact\":\"no\",\"catalog\":\"Catalog\",\"filename\":\"Filename\",\"internalID\":1,\"uniqueEntryID\":\"UniqueEntryID\"}";
        JSONAssert.assertEquals(expected, response.getContentAsString(), true);
        assertThat(response.getStatus()).isEqualTo(200);
    }

    @Test
    public void shouldReturn404WhenFossilNotFound() throws Exception {
        Mockito.when(fossilRepository.findFossilByName(Mockito.anyString())).thenReturn(null);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/fossils/404")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertThat(response.getStatus()).isEqualTo(404);
        assertThat(response.getContentAsString()).isEqualTo("Could not found fossil called 404");
    }
}
