package com.example.demo;

import java.util.Date;

class Marriage {
    private final InLove love;
    private final Date anniversaryDay;

    public Marriage(InLove inLove, Date anniversaryDay) {
        this.love = inLove;
        this.anniversaryDay = anniversaryDay;
    }

    public void divorce() {
        love.setMarriage(null);
        love.breakUp();
    }

    public Date getAnniversaryDay() {
        return anniversaryDay;
    }

}
