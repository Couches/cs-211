// Robert De Lappe, CS211, January 20, 2023
// Triangle class, contains points for each corner of triangle
// in a two dimensional plane, with methods relating to triangles

public class Triangle extends AbstractShape
{
    private Point point1;
    private Point point2;
    private Point point3;

    // Create new triangle with all points at 0,0
    public Triangle()
    {
        this(new Point(), new Point(), new Point());
    }

    // Create new triangle taking 3 points
    public Triangle(Point point1, Point point2, Point point3)
    {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    public String getType()
    {
        return "Triangle";
    }

    // Get Perimeter method
    // Returns sum of side lengths of triangle
    public double getPerimeter()
    {
        double line1 = Point.calculateDistance(point1, point2);
        double line2 = Point.calculateDistance(point2, point3);
        double line3 = Point.calculateDistance(point3, point1);

        return line1 + line2 + line3;
    }

    // Get Area method
    // Returns area of the triangle
    public double getArea()
    {
        double a = point1.getX() * (point2.getY() - point3.getY());
        double b = point2.getX() * (point3.getY() - point1.getY());
        double c = point3.getX() * (point1.getY() - point2.getY());

        return 0.5 * (a + b + c);
    }
    
    // To String method
    // Returns triangle data in String form
    // format: {Type=%s, Point1=%s, Point2=%s, Point3=%s}
    public String toString()
    {
        return String.format("{Type=%s, Point1=%s, Point2=%s, Point3=%s}",
                        getType(), point1.toString(), point2.toString(), point3.toString());
    }
}
