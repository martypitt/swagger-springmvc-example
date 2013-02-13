package com.mangofactory.swagger.springmvc.example;

public class Example {
    private String foo;
    private int bar;

    public Example(String foo, int bar) {
        this.foo = foo;
        this.bar = bar;
    }

    public String getFoo() {
        return foo;
    }

    public int getBar() {
        return bar;
    }
}

