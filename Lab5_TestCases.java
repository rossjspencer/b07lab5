package lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Lab5_TestCases {

	@Test
	void testRectangle() {
		Point a = new Point(0, 0);
        Point b = new Point(1, 0);
        Point c = new Point(1, 1);
        Point d = new Point(0, 1);
        
        Rectangle r = new Rectangle(a,b,c,d);
        assertEquals(a, r.A);
        assertEquals(b, r.B);
        assertEquals(c, r.C);
        assertEquals(d, r.D);
	}
	
	@Test
	void testperimeter() {
		Point a = new Point(0, 0);
        Point b = new Point(1, 0);
        Point c = new Point(1, 3);
        Point d = new Point(0, 3);
        
        Rectangle r = new Rectangle(a,b,c,d);
        
        assertEquals(8.0, r.perimeter(), 0.000001);
	}
	
	@Test
	void testisSquare_True() {
		Point a = new Point(0, 0);
        Point b = new Point(1, 0);
        Point c = new Point(1, 1);
        Point d = new Point(0, 1);
        
        Rectangle square = new Rectangle(a,b,c,d);
        
        assertTrue(square.isSquare());
	}
	
	@Test
	void testisSquare_False() {
		Point a = new Point(0, 0);
        Point b = new Point(1, 0);
        Point c = new Point(1, 3);
        Point d = new Point(0, 3);
        
        Rectangle r = new Rectangle(a,b,c,d);
        
        assertFalse(r.isSquare());
	}

}
