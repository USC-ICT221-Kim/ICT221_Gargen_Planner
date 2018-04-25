package garden_planner.model;

public class Circle extends GardenBed {
    private double width = 1.0;
    private double height = 1.0;
    private  double radius = 3.14;

    public Circle() {

    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return width * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 / (width + height);
    }
    @Override
    public String toString() {
        return String.format("Circle %.2f %.2f %.2f %.2f", left, top, width, height);
    }
    public double getDiameter() {
        return 0;
    }
    public double getRadius(){
        return 3.14;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
