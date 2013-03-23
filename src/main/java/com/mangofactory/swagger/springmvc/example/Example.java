package com.mangofactory.swagger.springmvc.example;

public class Example {
    private String foo;
    private int bar;
    private Baz baz;
    private Camp camp;

    public Example(String foo, int bar, Baz baz, Camp camp) {
        this.foo = foo;
        this.bar = bar;
        this.baz = baz;
        this.camp = camp;
    }

    public String getFoo() {
        return foo;
    }

    public int getBar() {
        return bar;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    public void setBar(int bar) {
        this.bar = bar;
    }

    public Baz getBaz() {
        return baz;
    }

    public void setBaz(Baz baz) {
        this.baz = baz;
    }

    public Camp getCamp() {
        return camp;
    }

    public void setCamp(Camp camp) {
        this.camp = camp;
    }
}

