package com.williamspires.acnhapi.unit.restControllers;

import com.williamspires.acnhapi.Controllers.AcnhEventsController;
import com.williamspires.acnhapi.Model.acnhevents;
import com.williamspires.acnhapi.Repositories.AcnhEventsRepository;
import com.williamspires.acnhapi.Repositories.ApiEventRepository;
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
import org.springframework.test.context.jdbc.Sql;
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
@WebMvcTest(AcnhEventsController.class)
public class AcnhEventsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    AcnhEventsRepository acnhEventsRepository;
    @MockBean
    ApiEventRepository apiEventRepository;

    private com.williamspires.acnhapi.Model.acnhevents acnhevents;

    @Before
    public void setup() {
        acnhevents = new acnhevents();
        acnhevents.setEvent("Test");
        acnhevents.setId(1);
        acnhevents.setNothernHemisphereDates("Test Date");
        acnhevents.setSouthernHemisphereDates("Test Date");
        acnhevents.setTimes("Test Time");
    }

    @Test
    public void EventIsReturnedWhenOneExists() throws Exception {
        List<acnhevents> events = new ArrayList<>();
        events.add(acnhevents);
        Mockito.when(acnhEventsRepository.findEventsByEvent(Mockito.anyString())).thenReturn(events);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/events/Test")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String expected = "[{\"id\":1,\"event\":\"Test\",\"nothernHemisphereDates\":\"Test Date\",\"southernHemisphereDates\":\"Test Date\",\"times\":\"Test Time\"}]";
        JSONAssert.assertEquals(expected, response.getContentAsString(), true);
        assertThat(response.getStatus()).isEqualTo(200);
    }

    @Test
    public void shouldReturn404WhenEventDoesNotExist() throws Exception {
        Mockito.when(acnhEventsRepository.findEventsByEvent(Mockito.anyString())).thenReturn(null);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/events/404")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertThat(response.getStatus()).isEqualTo(404);
        assertThat(response.getContentAsString()).isEqualTo("Could not find event with name 404");
    }

}