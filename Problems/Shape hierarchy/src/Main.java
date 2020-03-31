abstract class Shape {

    abstract double getPerimeter();

    abstract double getArea();
}

class Triangle extends Shape {
    protected double sideA;
    protected double sideB;
    protected double sideC;

    Triangle (double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    double getPerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    double getArea() {
        double halfPerimeter = getPerimeter();
        return Math.sqrt(halfPerimeter * (halfPerimeter - sideA) * (halfPerimeter - sideB) * (halfPerimeter - sideC));
    }
}

class Rectangle extends Shape {
    protected double width;
    protected double length;

    Rectangle(double width, double length) {
        this.length = length;
        this.width = width;
    }

    double getPerimeter() {
        return  width * 2 + length * 2;
    }

    double getArea() {
        return width * length;
    }
}

class Circle extends Shape {
    protected double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}