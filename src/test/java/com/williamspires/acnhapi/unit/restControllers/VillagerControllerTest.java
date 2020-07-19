package com.williamspires.acnhapi.unit.restControllers;

import com.williamspires.acnhapi.Controllers.VillagerController;
import com.williamspires.acnhapi.Model.Villager;
import com.williamspires.acnhapi.Repositories.ApiEventRepository;
import com.williamspires.acnhapi.Repositories.RaymondRepository;
import com.williamspires.acnhapi.Repositories.VillagerRepository;
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
@WebMvcTest(value = VillagerController.class)
public class VillagerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VillagerRepository villagerRepository;
    @MockBean
    private RaymondRepository raymondRepository;
    @MockBean
    private ApiEventRepository eventRepository;

    private Villager testVillager;

    @Before
    public void setup() {
        testVillager = new Villager();
        testVillager.setName("Raymond");
        testVillager.setBirthday("Apr 28");
        testVillager.setSpecies("Cat");
        testVillager.setCatchphrase("Catchphrase");
        testVillager.setColor_1("Color_1");
        testVillager.setColor_2("Color_2");
        testVillager.setFavoriteSong("Bubblegum");
        testVillager.setFilename("RaymondFileName");
        testVillager.setFlooring("Standard");
        testVillager.setFurniture_List("furnitureList");
        testVillager.setGender("Male");
        testVillager.setHobby("Learning");
        testVillager.setPersonality("Cheeky");
        testVillager.setStyle_1("Normal");
        testVillager.setStyle_2("Cheeky");
        testVillager.setUnique_Entry_ID("1abc");
        testVillager.setWallpaper("Test wallper");
    }

    @After
    public void teardown() {
        testVillager = new Villager();
    }

    @Test
    public void testGetOnVillagerNameReturnsInformationWhenVillagerExists() throws Exception{
        Mockito.when(villagerRepository.findVillagerByName(Mockito.anyString())).thenReturn(testVillager);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/villager/Raymond")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String expected = "{\"name\":\"Raymond\",\"species\":\"Cat\",\"personality\":\"Cheeky\",\"favoriteSong\":\"Bubblegum\",\"birthday\":\"Apr 28\",\"catchphrase\":\"Catchphrase\",\"color_1\":\"Color_1\",\"color_2\":\"Color_2\",\"filename\":\"RaymondFileName\",\"flooring\":\"Standard\",\"furniture_List\":\"furnitureList\",\"gender\":\"Male\",\"hobby\":\"Learning\",\"style_1\":\"Normal\",\"style_2\":\"Cheeky\",\"unique_Entry_ID\":\"1abc\",\"wallpaper\":\"Test wallper\"}";
        JSONAssert.assertEquals(expected, response.getContentAsString(), true);
        assertThat(response.getStatus()).isEqualTo(200);
    }

    @Test
    public void shouldReturn404WhenVillagerDoesNotExist() throws Exception {
        List<Villager> villagers = new ArrayList<>();
        villagers.add(testVillager);
        Mockito.when(villagerRepository.findVillagerByName(Mockito.anyString())).thenReturn(null);
        Mockito.when(villagerRepository.getAllVillagers()).thenReturn(villagers);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/villager/404")
                .accept(MediaType.ALL);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        assertThat(result.getResponse().getStatus()).isEqualTo(404);
    }

    @Test
    public void shouldReturnAListOfVillagersWithAPersonalityWhenThatPersonalityExists() throws Exception {
        List<Villager> villagers = new ArrayList<>();
        villagers.add(testVillager);
        villagers.add(testVillager);
        villagers.get(1).setName("NotRaymond");
        Mockito.when(villagerRepository.findVillagerByPersonality(Mockito.anyString())).thenReturn(villagers);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/villager/personality/Cheeky")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String expected = "[{\"name\":\"NotRaymond\",\"species\":\"Cat\",\"personality\":\"Cheeky\",\"favoriteSong\":\"Bubblegum\",\"birthday\":\"Apr 28\",\"catchphrase\":\"Catchphrase\",\"color_1\":\"Color_1\",\"color_2\":\"Color_2\",\"filename\":\"RaymondFileName\",\"flooring\":\"Standard\",\"furniture_List\":\"furnitureList\",\"gender\":\"Male\",\"hobby\":\"Learning\",\"style_1\":\"Normal\",\"style_2\":\"Cheeky\",\"unique_Entry_ID\":\"1abc\",\"wallpaper\":\"Test wallper\"},{\"name\":\"NotRaymond\",\"species\":\"Cat\",\"personality\":\"Cheeky\",\"favoriteSong\":\"Bubblegum\",\"birthday\":\"Apr 28\",\"catchphrase\":\"Catchphrase\",\"color_1\":\"Color_1\",\"color_2\":\"Color_2\",\"filename\":\"RaymondFileName\",\"flooring\":\"Standard\",\"furniture_List\":\"furnitureList\",\"gender\":\"Male\",\"hobby\":\"Learning\",\"style_1\":\"Normal\",\"style_2\":\"Cheeky\",\"unique_Entry_ID\":\"1abc\",\"wallpaper\":\"Test wallper\"}]";
        JSONAssert.assertEquals(expected, response.getContentAsString(), true);
        assertThat(response.getStatus()).isEqualTo(200);
    }

    @Test
    public void shouldReturn404WhenNoVillagersHaveTheRequestedPersonality() throws Exception {
        Mockito.when(villagerRepository.findVillagerByPersonality(Mockito.anyString())).thenReturn(null);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/villager/personality/404")
                .accept(MediaType.ALL);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        assertThat(response.getStatus()).isEqualTo(404);
        assertThat(response.getContentAsString()).isEqualTo("No villagers found with a personality of 404");
    }

    @Test
    public void shouldReturnAListOfVillagersWithTheSameSpeciesWhenThatSpeciesExists() throws Exception {
        List<Villager> villagers = new ArrayList<>();
        villagers.add(testVillager);
        villagers.add(testVillager);
        villagers.get(1).setName("NotRaymond");

        Mockito.when(villagerRepository.findVillagersBySpecies(Mockito.anyString())).thenReturn(villagers);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/villager/species/cat")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String expected = "[{\"name\":\"NotRaymond\",\"species\":\"Cat\",\"personality\":\"Cheeky\",\"favoriteSong\":\"Bubblegum\",\"birthday\":\"Apr 28\",\"catchphrase\":\"Catchphrase\",\"color_1\":\"Color_1\",\"color_2\":\"Color_2\",\"filename\":\"RaymondFileName\",\"flooring\":\"Standard\",\"furniture_List\":\"furnitureList\",\"gender\":\"Male\",\"hobby\":\"Learning\",\"style_1\":\"Normal\",\"style_2\":\"Cheeky\",\"unique_Entry_ID\":\"1abc\",\"wallpaper\":\"Test wallper\"},{\"name\":\"NotRaymond\",\"species\":\"Cat\",\"personality\":\"Cheeky\",\"favoriteSong\":\"Bubblegum\",\"birthday\":\"Apr 28\",\"catchphrase\":\"Catchphrase\",\"color_1\":\"Color_1\",\"color_2\":\"Color_2\",\"filename\":\"RaymondFileName\",\"flooring\":\"Standard\",\"furniture_List\":\"furnitureList\",\"gender\":\"Male\",\"hobby\":\"Learning\",\"style_1\":\"Normal\",\"style_2\":\"Cheeky\",\"unique_Entry_ID\":\"1abc\",\"wallpaper\":\"Test wallper\"}]";
        JSONAssert.assertEquals(expected, response.getContentAsString(), true);
        assertThat(response.getStatus()).isEqualTo(200);
    }

    @Test
    public void shouldReturn404WhenNoVillagersOfThatSpeciesExist() throws Exception {
        Mockito.when(villagerRepository.findVillagersBySpecies(Mockito.anyString())).thenReturn(null);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/villager/species/404")
                .accept(MediaType.ALL);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        assertThat(response.getStatus()).isEqualTo(404);
        assertThat(response.getContentAsString()).isEqualTo("No villagers found with a species of 404");
    }

    @Test
    public void shouldReturnAListOfVillagersWithTheSameFavouriteSongWhenThatSongExists() throws Exception {
        List<Villager> villagers = new ArrayList<>();
        villagers.add(testVillager);
        villagers.add(testVillager);
        villagers.get(1).setName("NotRaymond");

        Mockito.when(villagerRepository.findVillagersByFavoriteSong(Mockito.anyString())).thenReturn(villagers);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/villager/song/Bubblegum")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String expected = "[{\"name\":\"NotRaymond\",\"species\":\"Cat\",\"personality\":\"Cheeky\",\"favoriteSong\":\"Bubblegum\",\"birthday\":\"Apr 28\",\"catchphrase\":\"Catchphrase\",\"color_1\":\"Color_1\",\"color_2\":\"Color_2\",\"filename\":\"RaymondFileName\",\"flooring\":\"Standard\",\"furniture_List\":\"furnitureList\",\"gender\":\"Male\",\"hobby\":\"Learning\",\"style_1\":\"Normal\",\"style_2\":\"Cheeky\",\"unique_Entry_ID\":\"1abc\",\"wallpaper\":\"Test wallper\"},{\"name\":\"NotRaymond\",\"species\":\"Cat\",\"personality\":\"Cheeky\",\"favoriteSong\":\"Bubblegum\",\"birthday\":\"Apr 28\",\"catchphrase\":\"Catchphrase\",\"color_1\":\"Color_1\",\"color_2\":\"Color_2\",\"filename\":\"RaymondFileName\",\"flooring\":\"Standard\",\"furniture_List\":\"furnitureList\",\"gender\":\"Male\",\"hobby\":\"Learning\",\"style_1\":\"Normal\",\"style_2\":\"Cheeky\",\"unique_Entry_ID\":\"1abc\",\"wallpaper\":\"Test wallper\"}]";
        JSONAssert.assertEquals(expected, response.getContentAsString(), true);
        assertThat(response.getStatus()).isEqualTo(200);
    }

    @Test
    public void shouldReturn404WhenNoVillagersHaveThatFavouriteSong() throws Exception {
        Mockito.when(villagerRepository.findVillagersByFavoriteSong(Mockito.anyString())).thenReturn(null);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/villager/song/404")
                .accept(MediaType.ALL);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        assertThat(response.getStatus()).isEqualTo(404);
        assertThat(response.getContentAsString()).isEqualTo("Could not find any villagers with a favourite song of 404");
    }
}
