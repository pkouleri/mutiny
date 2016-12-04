package com.mutiny.model;

public class OutboundPost {

    private String content;

    private long date;

    private String author;

    public OutboundPost() {
    }

    public OutboundPost(String content, long date, String author) {
        this.content = content;
        this.date = date;
        this.author = author;
    }

    public OutboundPost(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
