package com.parviz.ai.search.dto.ai;

import com.parviz.ai.search.dto.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;


import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ChatRequest {

    private String model;
    private List<Message> messages;

    private int n = 1;

    private double temperature = 1d;

    public ChatRequest(String model, String prompt, int n, double temperature) {
        this.model = model;
        this.n = n;
        this.temperature = temperature;

        this.messages = new ArrayList<>();
        this.messages.add(new Message("user", prompt));
    }

    public ChatRequest(String model, String prompt) {
        this.model = model;

        this.messages = new ArrayList<>();
        this.messages.add(new Message("user", prompt));
    }

    // getters and setters
}
