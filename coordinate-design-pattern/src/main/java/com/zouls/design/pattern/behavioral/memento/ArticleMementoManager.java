package com.zouls.design.pattern.behavioral.memento;

import java.util.Stack;

public class ArticleMementoManager {
    private final Stack<ArticleMemento> stack = new Stack<>();
    public ArticleMemento getArticleMemento() {
        return stack.pop();
    }
    public void addArticleMemento(ArticleMemento articleMemento) {
        stack.push(articleMemento);
    }
}
