public class Point
{

    double x;
    double y;

    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public double distance(Point other)
    {
        return Math.sqrt(Math.pow(x-other.x, 2) + Math.pow(y-other.y, 2));
    }

    //takes in 3 points A, B, and C, and returns the angle between
    //the line segments AB and BC. Used in Pentagon.java
    public double findInteriorAngle(Point B, Point C) throws Exception
    {
        //treat AB and BC as vectors and determine dot product to find angle
        double vABX = B.x - this.x;
        double vABY = B.y - this.y;
        double magAB = Math.sqrt(Math.pow(vABX, 2) + Math.pow(vABY, 2));

        double vBCX = C.x - B.x;
        double vBCY = C.y - B.y;
        double magBC = Math.sqrt(Math.pow(vBCX, 2) + Math.pow(vBCY, 2));

        if (magAB == 0 || magBC == 0)
        {
            throw new Exception("Vector magnitudes cannot be zero.");
        }

        double dotProduct = (vABX * vBCX) + (vABY * vBCY);
        return Math.acos((dotProduct) / (magAB * magBC));
    }

    @Override
    public int hashCode()
    {
        return (int)(3*x + 5*y);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Point other = (Point) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }
}
