package com.williamspires.acnhapi.unit.restControllers;

import com.williamspires.acnhapi.Controllers.RecipeController;
import com.williamspires.acnhapi.Model.Recipes;
import com.williamspires.acnhapi.Repositories.ApiEventRepository;
import com.williamspires.acnhapi.Repositories.RecipesRepository;
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

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@RunWith(SpringRunner.class)
@WebMvcTest(value = RecipeController.class)
public class RecipeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    RecipesRepository recipesRepository;
    @MockBean
    ApiEventRepository eventRepository;

    private Recipes testRecipe;

    @Before
    public void setup() {
        testRecipe = new Recipes();
        testRecipe.setBuy("10");
        testRecipe.setCategory("Category");
        testRecipe.setInternal_ID(1);
        testRecipe.setMaterial_1("mat1");
        testRecipe.setMaterial_2("mat2");
        testRecipe.setMaterial_3("mat3");
        testRecipe.setMaterial_4("mat4");
        testRecipe.setMaterial_5("mat5");
        testRecipe.setMaterial_6("mat6");
        testRecipe.setMatnum1(1);
        testRecipe.setMatnum2(2);
        testRecipe.setMatnum3(3);
        testRecipe.setMatnum4(4);
        testRecipe.setMatnum5(5);
        testRecipe.setMatnum6(6);
        testRecipe.setMiles_Price("NFS");
        testRecipe.setName("Name");
        testRecipe.setRecipes_to_Unlock(0);
        testRecipe.setSell(0);
        testRecipe.setSerial_ID(123);
        testRecipe.setSource("store");
        testRecipe.setSource_Notes("NA");
        testRecipe.setUnique_Entry_ID("1abc");
        testRecipe.setVersion("1.2.0");
    }

    @After
    public void teardown() {
        testRecipe = new Recipes();
    }

    @Test
    public void RecipeIsReturnedWhenOneExists() throws Exception {
        Mockito.when(recipesRepository.findRecipesByName(Mockito.anyString())).thenReturn(testRecipe);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/diy/Name")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String expected = "{\"name\":\"Name\",\"matnum1\":1,\"matnum2\":2,\"matnum3\":3,\"matnum4\":4,\"matnum5\":5,\"matnum6\":6,\"version\":\"1.2.0\",\"source\":\"store\",\"material_1\":\"mat1\",\"material_2\":\"mat2\",\"material_3\":\"mat3\",\"material_4\":\"mat4\",\"material_5\":\"mat5\",\"material_6\":\"mat6\",\"buy\":\"10\",\"sell\":0,\"miles_Price\":\"NFS\",\"source_Notes\":\"NA\",\"recipes_to_Unlock\":0,\"category\":\"Category\",\"serial_ID\":123,\"internal_ID\":1,\"unique_Entry_ID\":\"1abc\"}";
        JSONAssert.assertEquals(expected, response.getContentAsString(), true);
        assertThat(response.getStatus()).isEqualTo(200);
    }

    @Test
    public void shouldReturn404WhenRecipeDoesNotExist() throws Exception {
        Mockito.when(recipesRepository.findRecipesByName(Mockito.anyString())).thenReturn(null);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/diy/404")
                .accept(MediaType.ALL);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        assertThat(response.getStatus()).isEqualTo(404);
        assertThat(response.getContentAsString()).isEqualTo("Could not find any recipes called 404");
    }
}
