package com.parviz.ai.search.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.StandardException;

@StandardException
@AllArgsConstructor
@Builder
@Setter
@Getter
public class DocumentNotFoundException extends RuntimeException{
    String id;
    String message;
    int errorCode;
}
