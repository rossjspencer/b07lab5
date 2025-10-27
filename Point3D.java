package lab4;

public class Point3D extends Point
{
    double z;

    public Point3D(double x, double y, double z)
    {
        super(x, y);
        this.z = z;
    }

    @Override
    public double distance(Point other)
    {
        if (other instanceof Point3D p3)
        {
            return Math.sqrt(Math.pow(x - p3.x, 2) + Math.pow(y - p3.y, 2) + Math.pow(z - p3.z, 2));
        }
        else
        {
            return Math.sqrt(Math.pow(x - other.x, 2) + Math.pow(y - other.y, 2) + Math.pow(z, 2));
        }
    }

    @Override
    public double findInteriorAngle(Point B, Point C) throws Exception
    {
        if (!(B instanceof Point3D) || !(C instanceof Point3D))
        {
            throw new Exception("Arguments must be Point3D.");
        }

        Point3D b = (Point3D) B;
        Point3D c = (Point3D) C;

        double vABX = b.x - this.x;
        double vABY = b.y - this.y;
        double vABZ = b.z - this.z;
        double magAB = Math.sqrt(vABX * vABX + vABY * vABY + vABZ * vABZ);

        double vBCX = c.x - b.x;
        double vBCY = c.y - b.y;
        double vBCZ = c.z - b.z;
        double magBC = Math.sqrt(vBCX * vBCX + vBCY * vBCY + vBCZ * vBCZ);

        if (magAB == 0 || magBC == 0)
        {
            throw new Exception("Vector magnitudes cannot be zero.");
        }

        double dotProduct = vABX * vBCX + vABY * vBCY + vABZ * vBCZ;
        double angle = Math.acos(dotProduct / (magAB * magBC));

        //just in case
        if (angle > Math.PI)
        {
            angle = 2 * Math.PI - angle;
        }

        return angle;
    }

    @Override
    public int hashCode()
    {
        return (int)(3*x + 5*y + 7*z);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }

        if (!(obj instanceof Point3D))
        {
            return false;
        }

        Point3D other = (Point3D) obj;
        return x == other.x && y == other.y && z == other.z;
    }
}