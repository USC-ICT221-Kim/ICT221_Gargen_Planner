package garden_planner.model;

public class Circle extends GardenBed {
    private double width = 1.0;
    private double height = 1.0;
    private  double radius = 3.14;
    private double CenterX = 1.0;
    private double CenterY = 1.0;

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
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 / (width + height);
    }

    @Override
    public void setRadius() {

    }

    @Override
    public void setCenterX() {

    }

    @Override
    public void setCenterY() {

    }

    @Override
    public String toString() {
        return String.format("Circle %.2f %.2f %.2f %.2f", left, top, width, height);
    }


    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public void setCenterX(double centerX) {
        this.CenterX = centerX;
    }
    public void setCenterY(double centerY) {
        this.CenterY = centerY;
    }


}
