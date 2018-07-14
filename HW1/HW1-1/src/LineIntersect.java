import java.util.Scanner;

public class LineIntersect {

    static Point p = new Point();
    
    public static double distance(Point a, Point b) 
    {
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }
    public static boolean isBetween(Point a, Point b, Point c) 
    {
        return distance(a, c) + distance(c, b) == distance(a, b);
    }
    public static void verticalIntersect(Line l, float x) 
    {
        p.y = l.m * x + l.c;
        p.x = x;
    }
    public static void interSect(Line l1, Line l2) 
    {
        float x = (l2.c - l1.c) / (l1.m - l2.m);
        float y = l1.c + ((l2.c - l1.c) * l1.m / (l1.m - l2.m));
        p.x = x;
        p.y = y;
    }
    public static int getIntersection(Line l1, Line l2) 
    {
        if (l1.p1.x == l1.p2.x) 
        {
            verticalIntersect(l2, l1.p1.x);
        } 
        else if (l2.p1.x == l2.p2.x) 
        {
        	verticalIntersect(l1, l2.p1.x);
        } 
        else 
        {
            interSect(l1, l2);
        }
        if (isBetween(l1.p1, l1.p2, p) && isBetween(l2.p1, l2.p2, p)) 
        {
            return 1;
        } 
        else 
        {
            return 0;
        }

    }
    //------------MAIN-----------------------------------------------
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Input: ");
            float x1 = in.nextFloat();
            float y1 = in.nextFloat();
            float x2 = in.nextFloat();
            float y2 = in.nextFloat();
            float x3 = in.nextFloat();
            float y3 = in.nextFloat();
            float x4 = in.nextFloat();
            float y4 = in.nextFloat();

            Point p1 = new Point(x1, y1);
            Point p2 = new Point(x2, y2);
            Point p3 = new Point(x3, y3);
            Point p4 = new Point(x4, y4);

            Line l1 = new Line(p1, p2);
            Line l2 = new Line(p3, p4);
            System.out.print ("Output: " + LineIntersect.getIntersection(l1, l2));
            System.out.println();
            System.out.print("Do you want to test again? ");
            char s = in.next().charAt(0);
            if (s == 'N' || s == 'n') {
            	System.out.println("Thank You!");
                break;
            }
        }
    }
}