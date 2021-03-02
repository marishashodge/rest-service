package com.stellar.apiwebserver;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "snippet not found")
public class SnippetNotFoundException extends RuntimeException{
}
