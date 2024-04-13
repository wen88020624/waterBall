package com.example.demo;

import java.util.Collection;
import java.util.HashSet;

public class Classmate {
    private Collection<Classmate> friends = new HashSet<>();

    public void makeFriend(Classmate classmate) {
        this.friends.add(classmate);
        classmate.friends.add(this);
    }
}
