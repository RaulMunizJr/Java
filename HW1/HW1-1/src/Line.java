
class Line {
    Point p1;
    Point p2;
    float m;
    float c;
    
    public Line(Point p1, Point p2) 
    {
        this.p1 = p1;
        this.p2 = p2;
        getSlop();
        getIntercept();
    }

    private void getSlop() 
    {
        if (p2.y == p1.y) 
        {
            this.m = 0;
        } 
        else if (p1.x != p2.x) 
        {
            this.m = (p2.y - p1.y) / (p2.x - p1.x); //calculating slope
        }
    }

    private void getIntercept() 
    {
        if (p1.x != p2.x) {
            if (m == 0) {
                this.c = p1.y;
    } 
            else 
            {
                this.c = p1.y - m * p1.x;
            }
        }
    }

    //@Override
    public String toString() 
    {
        return "Line{" + "y=" + m + "x +" + c + '}' + p1.toString() + " " + p2.toString();
    }
}

class Point {
    float x;
    float y;

    public Point(float x, float y) 
    {
        this.x = x;
        this.y = y;
    }

    public Point() 
    {

    }

    //@Override
    public String toString() 
    {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }
}