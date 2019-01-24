package com.ejet.comm.utils.tree;

import java.util.List;

public class Tree<T> {
    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public List<Tree<T>> getChildren() {
        return children;
    }

    public void setChildren(List<Tree<T>> children) {
        this.children = children;
    }

    private T item;
    private List<Tree<T>> children;
}
