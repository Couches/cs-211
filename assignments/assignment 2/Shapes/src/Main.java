public class Main
{
    public static void main(String[] args)
    {
        Point a = new Point(5, 3);
        Point b = new Point(3, 5);
        Point c = new Point(2, 3);

        Circle t = new Circle(c, 3);

        System.out.println(t.getArea());
        System.out.println(t.getPerimeter());
        System.out.println(t.toString());
    }
}