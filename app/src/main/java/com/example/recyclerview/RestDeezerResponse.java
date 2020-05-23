package com.example.recyclerview;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RestDeezerResponse {

    private int total;
    private ArrayList<PlaylistDeezer> result;

public int getTotal() {
        return total;
    }

    public ArrayList<PlaylistDeezer> getResult() {
        return result;
    }
}
