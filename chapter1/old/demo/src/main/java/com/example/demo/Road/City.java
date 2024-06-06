package com.example.demo.Road;

import java.util.Collection;
import java.util.HashSet;

public class City {
    private Collection<Road> roads = new HashSet<>();

    public Road connect(City city) {
        var road = new Road(this, city);
        roads.add(road);
        city.roads.add(road);
        return road;
    }
}
