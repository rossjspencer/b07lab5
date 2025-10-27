import java.awt.Point;

public class Pentagon 
{
	Point A;
	Point B;
	Point C;
	Point D;
	Point E;
		
	//points must be defined in clockwise or counterclockwise order following the perimeter of the pentagon.
	public Pentagon(Point p1, Point p2, Point p3, Point p4, Point p5) 
	{
		this.A = p1;
		this.B = p2;
		this.C = p3;
		this.D = p4;
		this.E = p5;
	}
	
	private boolean isRegular() 
	{
	    final double floatTolerance = 1e-8;

	    //check side length equality
	    double AB = this.A.distance(B);
	    double BC = this.B.distance(C);
	    double CD = this.C.distance(D);
	    double DE = this.D.distance(E);
	    double EA = this.E.distance(A);

	    boolean equalSides = Math.abs(AB - BC) < floatTolerance &&
	                         Math.abs(BC - CD) < floatTolerance &&
	                         Math.abs(CD - DE) < floatTolerance &&
	                         Math.abs(DE - EA) < floatTolerance;

	    if (!equalSides) return false;

	    //check angle equality
	    double angleA = A.findInteriorAngle(E, B);
	    double angleB = B.findInteriorAngle(A, C);
	    double angleC = C.findInteriorAngle(B, D);
	    double angleD = D.findInteriorAngle(C, E);
	    double angleE = E.findInteriorAngle(D, A);

	    boolean equalAngles = Math.abs(angleA - angleB) < floatTolerance &&
	                          Math.abs(angleB - angleC) < floatTolerance &&
	                          Math.abs(angleC - angleD) < floatTolerance &&
	                          Math.abs(angleD - angleE) < floatTolerance;

	    return equalAngles;
	}
	
	private double getArea() 
	{
		if(!this.isRegular()) 
		{
			throw new Exception("Cannot find area of an irregular pentagon.");
		}
		
		double sideLength = this.A.distance(this.B);
		return (0.25 * Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) * Math.pow(sideLength, 2))
	}
	
	private double getPerimeter() 
	{
		return A.distance(B) + B.distance(C) + C.distance(D) + D.distance(E) + E.distance(A);
	}
}
