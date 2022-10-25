package com.example.pipelinetest;

import com.example.pipelinetest.entity.Data;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DataControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PipelineTestApplication dataController;

    @Test
    void getAllDomains() throws Exception {
        final Data data = Data.builder()
                .title("test title")
                .field("test field")
                .build();

        final List<Data> allData = new ArrayList<>(List.of(data));

        Mockito.when(dataController.getAllData()).thenReturn(new ResponseEntity<>(allData, HttpStatus.OK));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/test/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
