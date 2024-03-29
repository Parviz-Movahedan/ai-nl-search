package com.parviz.ai.search.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.parviz.ai.search.dto.ai.ChatRequest;
import com.parviz.ai.search.dto.ai.ChatResponse;
import com.parviz.ai.search.dto.SearchRequest;
import com.parviz.ai.search.dto.app.ErrorResponse;
import com.parviz.ai.search.dto.app.Patient;
import com.parviz.ai.search.dto.app.Response;
import com.parviz.ai.search.exception.DocumentNotFoundException;
import com.parviz.ai.search.service.PatientService;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;


import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController("/v1")
@Slf4j
public class SearchController {

    @Qualifier("openaiRestTemplate")
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private PatientService patientService;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${openai.model}")
    private String model;

    @Value("${spring.ai.openai.base-url}")
    private String apiUrl;

    @Value("${ai.chat.endpoint}")
    private String chatEndpoint;

    @GetMapping("/patients/{patientId}")
    public ResponseEntity<Patient> getPatient(@PathVariable String patientId) {
        return ResponseEntity.ok(patientService
                .findPatient(patientId)
                .orElseThrow(() ->
                    DocumentNotFoundException
                                    .builder()
                                    .id(patientId)
                                    .message(patientId + " not found")
                                    .errorCode(NOT_FOUND.value())
                                    .build()
                )
        );
    }

    @PostMapping("/patients")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.addPatient(patient));
    }

    @PutMapping("/patients")
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient){
        return ResponseEntity.ok(patientService.updatePatient(patient));
    }

    @DeleteMapping("/patients/{patientId}")
    public ResponseEntity<Patient> removePatient(@PathVariable String patientId) {
        Optional<Patient> maybePatient = patientService.findPatient(patientId);
        patientService.removePatient(patientId);
        return ResponseEntity.ok(maybePatient.orElse(null));
    }

    @PostMapping("/search")
    public String search(@RequestBody SearchRequest requestPrompt) {
        String primer = "Can you extract search terms into a JSON payload from the " +
                "following statement? Return only the JSON payload. Any inequality modifiers " +
                "should be either MAX, MIN, or equalTo. \n\n";

        // create a request
        ChatRequest request = new ChatRequest(model, primer + requestPrompt.getSearchPrompt());

        // call the API
        ChatResponse response = restTemplate.postForObject(apiUrl + chatEndpoint, request, ChatResponse.class);

        if (response == null || response.getChoices() == null || response.getChoices().isEmpty()) {
            return "No response";
        }

        // return the first response
        return response.getChoices().get(0).getMessage().getContent();
    }
}
