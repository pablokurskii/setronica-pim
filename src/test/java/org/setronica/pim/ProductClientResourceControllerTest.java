package org.setronica.pim;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.setronica.pim.controllers.ProductClientResource;
import org.setronica.pim.domain.Product;
import org.setronica.pim.services.ProductService;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("StandaloneTest: REST product controller ")
@ExtendWith(MockitoExtension.class)
class ProductClientResourceControllerTest {
    private MockMvc mvc;
    @Mock
    private ProductService service;

    @BeforeEach
    public void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(new ProductClientResource(service)).build();
    }

    @DisplayName("should return product by id")
    @Test
    void shouldReturnExpectedProductById() throws Exception {
        Product expectedProduct = new Product(1L, "table1", "null", "null");
        Gson gson = new GsonBuilder().create();
        given(service.get(1L)).willReturn(expectedProduct);
        mvc.perform(get("/api/product/{id}?language=en&currency=usd", 1L).accept("application/json; charset=utf-8"))
                .andExpect(status().isOk())
                .andExpect(content().string(gson.toJson(expectedProduct)));
    }

    @DisplayName("should return product list by name")
    @Test
    void shouldReturnProductListByName() throws Exception {
        String name = "chair";
        Product expectedProduct = new Product(1L, name, "null", "null");
        Gson gson = new GsonBuilder().create();
        given(service.getByName(name)).willReturn(List.of(expectedProduct));
        mvc.perform(get("/api/product?name=" + name + "&language=en&currency=usd", 1L).accept("application/json; charset=utf-8"))
                .andExpect(status().isOk())
                .andExpect(content().string(gson.toJson(List.of(expectedProduct))));
    }

    @DisplayName("should return product list by description")
    @Test
    void shouldReturnProductListByDescription() throws Exception {
        String description = "chair description";
        Product expectedProduct = new Product(1L, "name", description, "null");
        Gson gson = new GsonBuilder().create();
        given(service.getByDescription(description)).willReturn(List.of(expectedProduct));
        mvc.perform(get("/api/product?description=" + description + "&language=en&currency=usd", 1L).accept("application/json; charset=utf-8"))
                .andExpect(status().isOk())
                .andExpect(content().string(gson.toJson(List.of(expectedProduct))));
    }
}
