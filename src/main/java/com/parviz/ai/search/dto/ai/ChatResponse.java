package com.parviz.ai.search.dto.ai;

import com.parviz.ai.search.dto.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ChatResponse {

    private List<Choice> choices;

    // constructors, getters and setters

    @AllArgsConstructor
    @Getter
    @Setter
    public static class Choice {

        private int index;
        private Message message;

        // constructors, getters and setters
    }
}
