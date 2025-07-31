package wipro;

public class shape_14 {

    // Area of square
    public double area(double side) {
        return side * side;
    }

    // Area of rectangle
    public double area(double length, double breadth) {
        return length * breadth;
    }

    // Perimeter of square
    public double perimeter(double side) {
        return 4 * side;
    }

    // Perimeter of rectangle
    public double perimeter(double length, double breadth) {
        return 2 * (length + breadth);
    }

    public static void main(String[] args) {
        shape_14 shape = new shape_14();

        double squareSide = 6;
        double rectLength = 10;
        double rectBreadth = 5;

        System.out.println("=== Square ===");
        System.out.println("Area: " + shape.area(squareSide));
        System.out.println("Perimeter: " + shape.perimeter(squareSide));

        System.out.println("\n=== Rectangle ===");
        System.out.println("Area: " + shape.area(rectLength, rectBreadth));
        System.out.println("Perimeter: " + shape.perimeter(rectLength, rectBreadth));
    }
}
/*=== Square ===
Area: 36.0
Perimeter: 24.0

=== Rectangle ===
Area: 50.0
Perimeter: 30.0
*/