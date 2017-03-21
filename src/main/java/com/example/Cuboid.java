package com.example;

public class Cuboid {
    int height;
    int width;
    int length;
    int volume;



    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(){
        this.volume = length * height * width;
    }


}
