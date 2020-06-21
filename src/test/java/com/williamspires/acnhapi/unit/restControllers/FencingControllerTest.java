package com.williamspires.acnhapi.unit.restControllers;

import com.williamspires.acnhapi.Controllers.FencingController;
import com.williamspires.acnhapi.Model.Fencing;
import com.williamspires.acnhapi.Repositories.ApiEventRepository;
import com.williamspires.acnhapi.Repositories.FencingRepository;
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
@WebMvcTest(FencingController.class)
public class FencingControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    FencingRepository fencingRepository;

    @MockBean
    ApiEventRepository apiEventRepository;

    private Fencing fencing;

    @Before
    public void setup() {
        fencing = new Fencing();
        fencing.setBuy("NFS");
        fencing.setDIY("DIY");
        fencing.setFilename("Filename");
        fencing.setInternalId("InternalID");
        fencing.setName("Name");
        fencing.setSell(100);
        fencing.setSource("Source");
        fencing.setSourceNotes("SourceNotes");
        fencing.setStackSize(1);
        fencing.setUniqueEntryId("Unique");
        fencing.setVersion("1.1.0");
    }

    @Test
    public void shouldReturnFencingWhenFencingExists() throws Exception {
        Mockito.when(fencingRepository.findFencingByName(Mockito.anyString())).thenReturn(fencing);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/fencing/Name")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String expected = "{\"uniqueEntryId\":\"Unique\",\"name\":\"Name\",\"stackSize\":1,\"buy\":\"NFS\",\"sell\":100,\"source\":\"Source\",\"sourceNotes\":\"SourceNotes\",\"version\":\"1.1.0\",\"filename\":\"Filename\",\"internalId\":\"InternalID\",\"diy\":\"DIY\"}";
        JSONAssert.assertEquals(expected, response.getContentAsString(), true);
        assertThat(response.getStatus()).isEqualTo(200);
    }

    @Test
    public void shouldReturn404WhenFencingDoesNotExist() throws Exception {
        Mockito.when(fencingRepository.findFencingByName(Mockito.anyString())).thenReturn(null);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/fencing/404")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertThat(response.getStatus()).isEqualTo(404);
        assertThat(response.getContentAsString()).isEqualTo("Could not find fencing with name 404");
    }
}
