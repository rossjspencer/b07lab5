package lab4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//only defines regular icosahedra
public class Icosahedron
{
    ArrayList<Point3D> vertices;
    final double tolerance = 1e-8;
    double edgeLength;

    //anything that is not a regular icosahedron will throw an exception during construction
    public Icosahedron(ArrayList<Point3D> vertices) throws Exception
    {
        if(vertices.size() != 12)
        {
            throw new Exception("Icosahedra must have 12 vertices.");
        }

        this.vertices = vertices;

        if(!this.checkValidity())
        {
            throw new Exception("Icosahedron is not valid.");
        }
    }

    public boolean checkValidity()
    {
        //get all point distances
        List<Double> distances = new ArrayList<Double>();
        for(int i = 0; i < this.vertices.size(); i++)
        {
            for(int j = i + 1; j < this.vertices.size(); j++)
            {
                distances.add(this.vertices.get(i).distance(this.vertices.get(j)));
            }
        }

        //a regular icosahedron should have three unique distances
        List<Double> uniqueDistances = new ArrayList<Double>();
        for(int i = 0; i < distances.size(); i++)
        {
            boolean uniqueFound = false;
            for(int j = 0; j < uniqueDistances.size(); j++)
            {
                if(Math.abs(distances.get(j) - uniqueDistances.get(i)) < tolerance)
                {
                    uniqueFound = true;
                    break;
                }
            }
            if(!uniqueFound)
            {
                uniqueDistances.add(distances.get(i));
            }
        }

        if(uniqueDistances.size() != 3)
        {
            return false;
        }

        //each vertex must connect to five others with the smallest unique distance
        this.edgeLength = Collections.min(uniqueDistances);

        for (int i = 0; i < vertices.size(); i++)
        {
            Point3D p = vertices.get(i);
            int neighborCount = 0;

            for (int j = 0; j < vertices.size(); j++)
            {
                if (i == j)
                {
                    continue;
                }

                Point3D q = vertices.get(j);
                double dist = p.distance(q);

                if (Math.abs(dist - this.edgeLength) < tolerance)
                {
                    neighborCount++;
                }
            }

            if (neighborCount != 5)
            {
                return false; //each vertex should have 5 equal-length neighbours
            }
        }

        //any set of points following these criteria SHOULD form a regular icosahedron
        return true;
    }

    public double surfaceArea()
    {
        return (5 * Math.sqrt(3) * Math.pow(this.edgeLength, 2));
    }

    public double volume()
    {
        return (5 * (3 + Math.sqrt(5)) / 12 * (Math.pow(this.edgeLength, 3)));
    }
}