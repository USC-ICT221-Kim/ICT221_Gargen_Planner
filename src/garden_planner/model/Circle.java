package garden_planner.model;

public class Circle extends GardenBed {
    private  double radius = 3.14;

    public Circle() {

    }

    @Override
    public double getWidth() {
        return 2 * radius;
    }

    @Override
    public double getHeight() {
        return 2* radius;
    }

    @Override
    public double getArea() {
        return (radius * radius) * Math.PI;
    }

    @Override
    public double getPerimeter() {
        return 2 / (radius);
    }


    public void setRadius(double r) {
        radius = r;
    }


    @Override
    public String toString() {
        return String.format("Circle %.2f %.2f %.2f %.2f", left, top, radius, radius);
    }



}
