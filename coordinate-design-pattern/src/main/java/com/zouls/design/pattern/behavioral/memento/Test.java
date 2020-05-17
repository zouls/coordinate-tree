package com.zouls.design.pattern.behavioral.memento;

public class Test {
    public static void main(String[] args) {
        Article article = new Article("a", "b", "c");
        ArticleMemento articleMemento = article.saveToMemento();
        ArticleMementoManager manager = new ArticleMementoManager();
        manager.addArticleMemento(articleMemento);

        article.setTitle("a1");
        article.setContent("b1");
        article.setImags("c1");

        manager.addArticleMemento(article.saveToMemento());

        article.setTitle("a2");
        article.setContent("b2");
        article.setImags("c2");

        System.out.println(article);
        System.out.println(manager.getArticleMemento());
        System.out.println(manager.getArticleMemento());




    }
}
