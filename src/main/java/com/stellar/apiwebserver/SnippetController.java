package com.stellar.apiwebserver;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;



@RestController
public class SnippetController {
    @Value("${server.host}")
    private String host;

    @Value("${server.port}")
    private String port;

    private final AtomicLong counter = new AtomicLong();

    private HashMap<String, Snippet> snippets = new HashMap<>();

    @PostMapping ("/snippets")
    public ResponseEntity<Snippet> snippet(@RequestBody Snippet snippet) {

        LocalDateTime expires_at = LocalDateTime.now().plusSeconds(30);
        String url = "https://" + host + ":" + port + "/snippets/" + snippet.getName();

        snippet.setUrl(url);
        snippet.setExpires_at(expires_at);
        snippets.put(snippet.getName(), snippet);

        ResponseEntity<Snippet> response = new ResponseEntity<>(snippet, HttpStatus.OK);
        response.getBody().setUrl(url);
        return response;
    }

    @GetMapping ("/snippets/{name}")
    @ResponseBody
    public ResponseEntity<Snippet> snippet(@PathVariable String name) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        Snippet snippet = null;

        if (snippets.containsKey(name)) {
            snippet = snippets.get(name);
            if (snippet.getExpires_at().isBefore(currentDateTime)) {
                snippet.setExpires_at(LocalDateTime.now().plusSeconds(30));
            }
        } else {
            return new ResponseEntity<Snippet>(snippet, HttpStatus.NOT_FOUND);
        }

        ResponseEntity<Snippet> response = new ResponseEntity<>(snippet, HttpStatus.OK);
        response.getBody().setUrl(snippet.getUrl());
        return response;
    }
}