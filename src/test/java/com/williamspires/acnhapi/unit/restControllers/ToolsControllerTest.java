package com.williamspires.acnhapi.unit.restControllers;

import com.williamspires.acnhapi.Controllers.ToolsController;
import com.williamspires.acnhapi.Model.Tools;
import com.williamspires.acnhapi.Repositories.ToolRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
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

@Slf4j
@RunWith(SpringRunner.class)
@WebMvcTest(value = ToolsController.class)
public class ToolsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ToolRepository toolRepository;

    private Tools tools;

    @Before
    public void setup() {
        tools = new Tools();
        tools.setBody_Title("Body_title");
        tools.setBuy("100");
        tools.setColor_1("Color_1");
        tools.setColor_2("Color_2");
        tools.setCustomize("No");
        tools.setDIY("DIY");
        tools.setFilename("filename");
        tools.setInternal_ID("123");
        tools.setKit_Cost("1234");
        tools.setMiles_Price("1000");
        tools.setName("Name");
        tools.setSell(0);
        tools.setSet("set");
        tools.setSize("Small");
        tools.setSource("Nook");
        tools.setSource_Notes("NA");
        tools.setStack_Size(1);
        tools.setUnique_Entry_ID("123abc");
        tools.setUses("100");
        tools.setVariant_ID("variant");
        tools.setVariation("variation");
        tools.setVersion("version");
    }

    @After
    public void teardown() {
        tools = new Tools();
    }

    @Test
    public void shouldReturnAListOfToolsWhenThatNameExists() throws Exception {
        List<Tools> toolsList = new ArrayList<>();
        toolsList.add(tools);
        toolsList.add(tools);
        toolsList.get(1).setName("Tool1");

        Mockito.when(toolRepository.findToolByName(Mockito.anyString())).thenReturn(toolsList);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/tool/Name")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String expected = "[{\"name\":\"Tool1\",\"size\":\"Small\",\"version\":\"version\",\"source\":\"Nook\",\"body_Title\":\"Body_title\",\"buy\":\"100\",\"color_1\":\"Color_1\",\"color_2\":\"Color_2\",\"customize\":\"No\",\"diy\":\"DIY\",\"filename\":\"filename\",\"internal_ID\":\"123\",\"kit_Cost\":\"1234\",\"miles_Price\":\"1000\",\"sell\":0,\"set\":\"set\",\"source_Notes\":\"NA\",\"stack_Size\":1,\"unique_Entry_ID\":\"123abc\",\"uses\":\"100\",\"variant_ID\":\"variant\",\"variation\":\"variation\"},{\"name\":\"Tool1\",\"size\":\"Small\",\"version\":\"version\",\"source\":\"Nook\",\"body_Title\":\"Body_title\",\"buy\":\"100\",\"color_1\":\"Color_1\",\"color_2\":\"Color_2\",\"customize\":\"No\",\"diy\":\"DIY\",\"filename\":\"filename\",\"internal_ID\":\"123\",\"kit_Cost\":\"1234\",\"miles_Price\":\"1000\",\"sell\":0,\"set\":\"set\",\"source_Notes\":\"NA\",\"stack_Size\":1,\"unique_Entry_ID\":\"123abc\",\"uses\":\"100\",\"variant_ID\":\"variant\",\"variation\":\"variation\"}]";

        JSONAssert.assertEquals(expected, response.getContentAsString(), true);
        assertThat(response.getStatus()).isEqualTo(200);
    }

    @Test
    public void shouldReturn404WhenToolDoesNotExist() throws Exception {
        Mockito.when(toolRepository.findToolByName(Mockito.anyString())).thenReturn(null);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/tool/404")
                .accept(MediaType.ALL);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        assertThat(response.getStatus()).isEqualTo(404);
        assertThat(response.getContentAsString()).isEqualTo("Could not find any tools called 404");
    }
}
