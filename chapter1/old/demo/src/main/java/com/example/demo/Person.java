package com.example.demo;

class Person {
    private InLove inLove;

    public void love(Person person) {
        if (inLove != null) {
            throw new IllegalStateException("你只能愛一個人");
        }
        inLove = new InLove(this, person);
    };

    protected void setInLoveWith(Person loved) {
        inLove = null;
    }
}
