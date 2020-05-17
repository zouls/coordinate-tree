package com.zouls.design.pattern.behavioral.memento;

public class Article {
    private String title;
    private String content;
    private String imags;

    public Article(String title, String content, String imags) {
        this.title = title;
        this.content = content;
        this.imags = imags;
    }

    public ArticleMemento saveToMemento() {
        return new ArticleMemento(this.title, this.content, this.imags);
    }

    public void undoFromMemento(ArticleMemento articleMemento) {
        this.title = articleMemento.getTitle();
        this.content = articleMemento.getContent();
        this.imags = articleMemento.getImags();
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImags() {
        return imags;
    }

    public void setImags(String imags) {
        this.imags = imags;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", imags='" + imags + '\'' +
                '}';
    }
}
