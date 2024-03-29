package com.parviz.ai.search.dto.app;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse extends Response{
    private String message;
}
