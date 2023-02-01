// Robert De Lappe, CS211, January 20, 2023
// Circle class contaning center point, radius and various
// other methods relating to circles 

public class Circle extends AbstractShape
{
    private Point center;
    private int radius;

    // Creates a new circle of radius 0, with center at 0,0
    public Circle()
    {
        this(new Point(), 0);
    }

    // Creates a circle from center point and radius
    public Circle(Point center, int radius)
    {
        this.center = center;
        this.radius = radius;
    }

    // Get Type method
    // Returns "Circle"
    public String getType() {
        return "Circle";
    }

    // Get Perimeter method
    // Returns perimeter of circle
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    // Get Area method
    // Returns area of method
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
    
    // To String method
    // Returns circle data in string form
    // format: {Type=%s, Center=%s, Radius=%d}
    public String toString()
    {
        return String.format("{Type=%s, Center=%s, Radius=%d}", 
                        getType(), center.toString(), radius);
    }
}
