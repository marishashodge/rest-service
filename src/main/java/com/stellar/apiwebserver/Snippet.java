package com.stellar.apiwebserver;

import java.time.LocalDateTime;

public class Snippet {
    private String url;
    private String name;
    private String snippet;
    private LocalDateTime expires_at;

    public Snippet(String url, String name, String snippet, LocalDateTime expires_at) {
        this.url = url;
        this.name = name;
        this.snippet = snippet;
        this.expires_at = expires_at;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public String getName() {
        return name;
    }

    public String getSnippet() {
        return snippet;
    }

    public LocalDateTime getExpires_at() {
        return expires_at;
    }

    public void setExpires_at(LocalDateTime expires_at) {
        this.expires_at = expires_at;
    }
}
