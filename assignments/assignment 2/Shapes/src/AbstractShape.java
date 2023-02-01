// Robert De Lappe, CS211, January 20, 2023
// Abstract Shape class to define types of shapes

public abstract class AbstractShape implements Shape
{
    // Compare To method
    // Returns 1, 0, or -1 based on area, perimeter, then type of shape
    @Override
    public int compareTo(final Shape other)
    {
        double areaDifference = getArea() - other.getArea();
        double perimeterDifference = getPerimeter() - other.getPerimeter();
        
        if (areaDifference > 0) return 1;
        if (areaDifference < 0) return -1;

        if (perimeterDifference > 0) return 1;
        if (perimeterDifference < 0) return -1;

        return getType().compareTo(other.getType());
    }
}