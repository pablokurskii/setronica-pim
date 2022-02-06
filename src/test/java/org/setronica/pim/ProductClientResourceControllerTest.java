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
        String names = "[{\"name\":\"table1\",\"lang\":\"us\"},{\"name\":\"mesa\",\"lang\":\"es\"}]";
        String description = "[{\"description\":\"table2\",\"lang\":\"us\"},{\"description\":\"table2\",\"lang\":\"es\"}]";
        String prices = "[{\"price\": 0.01,\"cur\": \"usd\"}]";
        Product expectedProduct = new Product(1L, names, description, prices);
        Gson gson = new GsonBuilder().create();
        given(service.get(1L)).willReturn(expectedProduct);
        mvc.perform(get("/api/product/{id}", 1L).accept("application/json; charset=utf-8"))
                .andExpect(status().isOk())
                .andExpect(content().string(gson.toJson(expectedProduct)));
    }

    @DisplayName("should return product list by name")
    @Test
    void shouldReturnProductListByName() throws Exception {
        String names = "[{\"name\":\"table1\",\"lang\":\"us\"}]";
        Product expectedProduct = new Product(1L, names);
        Gson gson = new GsonBuilder().create();
        given(service.get(1L)).willReturn(expectedProduct);
        mvc.perform(get("/api/product/{names}", 1L).accept("application/json; charset=utf-8"))
                .andExpect(status().isOk())
                .andExpect(content().string(gson.toJson(expectedProduct)));
    }
}
