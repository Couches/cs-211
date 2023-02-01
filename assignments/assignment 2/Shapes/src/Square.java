// Robert De Lappe, CS211, January 20, 2023
// Square class, subclass of Rectangle containing side length
// rather than bottom right corner

public class Square extends Rectangle
{
    // Creates a square by calling 0 arg rectangle constructor
    public Square()
    {
        super();
    }

    // Creates a square based on top left corner and side length
    public Square(Point topLeft, int baseLength)
    {
        super(topLeft, new Point(topLeft.getX() + baseLength, topLeft.getY() - baseLength));
    }

    // Get Type method
    // Returns "Square"
    public String getType()
    {
        return "Square";
    }
}
