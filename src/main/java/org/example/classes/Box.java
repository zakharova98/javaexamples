package org.example.classes;

import java.io.Serializable;

public class Box implements Serializable {

    private double width;
    private double height;
    private double depth;

    protected transient String name;

    public Box() {
        this.width = 0.0;
        this.height = 0.0;
        this.depth = 0.0;
    }

    // это будет куб
    public Box (double value) {
        this.width = value;
        this.height = value;
        this.depth = value;
    }

    // инициализируем все измерения
    public Box(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public Box(double width, double height, double depth, String name) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.name = name;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getDepth() {
        return depth;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setWidth(int width) {
        this.width = (double) width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setHeight(int height) {
        this.height = (double) height;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public void setDepth(int depth) {
        this.depth = (double) depth;
    }

    public double getVolume() {
        return width * height * depth;
    }

    public void print() {
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
        System.out.println("Depth: " + depth);
    }

    @Override
    public String toString() {
        return "Box{" +
                "width=" + width +
                ", height=" + height +
                ", depth=" + depth +
                ", name='" + name + '\'' +
                '}';
    }
}
