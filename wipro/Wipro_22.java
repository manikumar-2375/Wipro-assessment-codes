package wipro;

interface Drawable {
    void drawingColor();
    void thickness();
}

interface Fillable {
    void fillingColor();
    void size();
}

class Line implements Drawable {
    @Override
    public void drawingColor() {
        System.out.println("Line Drawing Color: Black");
    }

    @Override
    public void thickness() {
        System.out.println("Line Thickness: 2px");
    }
}

class Circle implements Drawable, Fillable {
    @Override
    public void drawingColor() {
        System.out.println("Circle Drawing Color: Red");
    }

    @Override
    public void thickness() {
        System.out.println("Circle Thickness: 3px");
    }

    @Override
    public void fillingColor() {
        System.out.println("Circle Filling Color: Yellow");
    }

    @Override
    public void size() {
        System.out.println("Circle Size: Radius = 10");
    }
}

class Square implements Drawable, Fillable {
    @Override
    public void drawingColor() {
        System.out.println("Square Drawing Color: Blue");
    }

    @Override
    public void thickness() {
        System.out.println("Square Thickness: 4px");
    }

    @Override
    public void fillingColor() {
        System.out.println("Square Filling Color: Green");
    }

    @Override
    public void size() {
        System.out.println("Square Size: Side = 20");
    }
}

// Main Class
public class Wipro_22 {
    public static void main(String[] args) {
        
        System.out.println("=== Line ===");
        Line line = new Line();
        line.drawingColor();
        line.thickness();

        // Circle
        System.out.println("\n=== Circle ===");
        Circle circle = new Circle();
        circle.drawingColor();
        circle.thickness();
        circle.fillingColor();
        circle.size();

        // Square
        System.out.println("\n=== Square ===");
        Square square = new Square();
        square.drawingColor();
        square.thickness();
        square.fillingColor();
        square.size();
    }
}
/*=== Line ===
Line Drawing Color: Black
Line Thickness: 2px

=== Circle ===
Circle Drawing Color: Red
Circle Thickness: 3px
Circle Filling Color: Yellow
Circle Size: Radius = 10

=== Square ===
Square Drawing Color: Blue
Square Thickness: 4px
Square Filling Color: Green
Square Size: Side = 20
*/