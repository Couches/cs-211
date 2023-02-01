// Robert De Lappe, CS211, January 20, 2023
// Rectangle class, containg top left and bottom right points,
// and various methods relating to rectangles

public class Rectangle extends AbstractShape
{
    private Point topLeft;
    private Point bottomRight;

    // Create new rectangle with points at 0,0
    public Rectangle()
    {
        this(new Point(), new Point());
    }

    // Create new rectangle based on top left and bottom right corners
    public Rectangle(Point topLeft, Point bottomRight)
    {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    // Get Type method
    // Returns "Rectangle"
    public String getType()
    {
        return "Rectangle";
    }

    // Get Perimeter method
    // Returns sum of side lengths of rectangle
    public double getPerimeter()
    {
        double base = Math.abs(topLeft.getX() - bottomRight.getX());
        double height = Math.abs(topLeft.getY() - bottomRight.getY());

        return (base * 2) + (height * 2);
    }

    // Get Area method
    // Returns area of rectangle
    public double getArea()
    {
        double base = Math.abs(topLeft.getX() - bottomRight.getX());
        double height = Math.abs(topLeft.getY() - bottomRight.getY());

        return base * height;
    }

    // To String method
    // Returns object data in string form
    // format: {Type=%s, TopLeft=%s, BottomRight=%s}
    public String toString()
    {
        return String.format("{Type=%s, TopLeft=%s, BottomRight=%s}", 
                        getType(), topLeft.toString(), bottomRight.toString());
    }
}
