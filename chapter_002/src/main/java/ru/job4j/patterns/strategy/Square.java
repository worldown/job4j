package ru.job4j.patterns.strategy;

import java.util.StringJoiner;

public class Square implements Shape {
    @Override
    public String draw() {
        return  new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("++++")
                .add("+  +")
                .add("+  +")
                .add("++++")
                .toString();
    }
}
