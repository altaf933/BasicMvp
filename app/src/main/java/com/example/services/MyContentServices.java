package com.example.services;

import com.example.interfaces.IMyServices;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by altaf.h.shaikh on 10/28/2016.
 */

public class MyContentServices implements IMyServices {
    @Override
    public List<String> getItems() {
        ArrayList<String> items = new ArrayList<>();
        items.add("one");
        items.add("two");
        items.add("three");
        items.add("four");
        return items;
    }
}
