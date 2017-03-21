package com.example;

public class Shape {
    String type;
    int radius;
    int width;
    int height;
    double area;

    public String isValid(){
        if(type == "circle" && radius == 0) return "Invalid";
        if(type == "rectangle" && radius != 0) return "Invalid";
        return "Valid";
    }

    public double getArea() {
        return area;
    }

    public void setArea() {
        if(type == "circle"){
            area = Math.PI * (radius * radius);

        } else if (type == "rectangle"){
            area =  width * height;
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
