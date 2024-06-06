package com.example.demo;

import java.util.Date;

class InLove {
    private final Person left;
    private final Person right;
    private Marriage marriage;

    public InLove(Person left, Person right) {
        this.left = left;
        this.right = right;
    }

    public Marriage marry() {
        setMarriage(new Marriage(this, new Date()));
        return marriage;
    }

    public void breakUp() {
        left.setInLoveWith(null);
        right.setInLoveWith(null);
    }

    public Person getLeft() {
        return left;
    }

    public Person getRight() {
        return right;
    }

    public void setMarriage(Marriage marriage) {
        this.marriage = marriage;
    }
}
