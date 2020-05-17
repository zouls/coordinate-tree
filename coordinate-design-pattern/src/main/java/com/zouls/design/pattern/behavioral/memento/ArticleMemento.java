package com.zouls.design.pattern.behavioral.memento;

public class ArticleMemento {
    private String title;
    private String content;
    private String imags;

    public ArticleMemento(String title, String content, String imags) {
        this.title = title;
        this.content = content;
        this.imags = imags;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getImags() {
        return imags;
    }
}
