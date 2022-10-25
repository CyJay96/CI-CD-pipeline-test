package com.example.pipelinetest;

import com.example.pipelinetest.entity.Data;
import com.example.pipelinetest.repository.DataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SpringBootApplication
@RequiredArgsConstructor
public class PipelineTestApplication {

    private final DataRepository dataRepository;

    public static void main(String[] args) {
        SpringApplication.run(PipelineTestApplication.class, args);
    }

    @GetMapping("/test")
    public ResponseEntity<List<Data>> getAllData() {
        List<Data> allData = dataRepository.findAll();
        return new ResponseEntity<>(allData, HttpStatus.OK);
    }

}
