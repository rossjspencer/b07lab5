package lab6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class pentagonTests {

	@Test
	void regularPoly() throws Exception {
        Point pA_reg = new Point(10 * Math.cos(0), 10 * Math.sin(0)); // (10, 0)
        Point pB_reg = new Point(10 * Math.cos(Math.toRadians(72)), 10 * Math.sin(Math.toRadians(72)));
        Point pC_reg = new Point(10 * Math.cos(Math.toRadians(144)), 10 * Math.sin(Math.toRadians(144))); // (-8.090, 5.878)
        Point pD_reg = new Point(10 * Math.cos(Math.toRadians(216)), 10 * Math.sin(Math.toRadians(216))); // (-8.090, -5.878)
        Point pE_reg = new Point(10 * Math.cos(Math.toRadians(288)), 10 * Math.sin(Math.toRadians(288))); // (3.090, -9.511)
        Pentagon regularPentagon = new Pentagon(pA_reg, pB_reg, pC_reg, pD_reg, pE_reg);
        assertTrue(regularPentagon.isRegular());
	}
	
	@Test
	void irregularPoly1() throws Exception {
		Point pA_irr = new Point(0, 0);
		Point pB_irr = new Point(10, 0);
		Point pC_irr = new Point(10, 10);
		Point pD_irr = new Point(5, 15);
		Point pE_irr = new Point(0, 10);
      	Pentagon irrPentagon = new Pentagon(pA_irr, pB_irr, pC_irr, pD_irr, pE_irr);
      	assertTrue(irrPentagon.isRegular()== false);
	}
	
	@Test
	void irregularPoly2() throws Exception {
		Point pA_col = new Point(0, 0);
        Point pB_col = new Point(1, 0);
        Point pC_col = new Point(2, 0); // A, B, C are collinear
        Point pD_col = new Point(1, 1);
        Point pE_col = new Point(0, 1);
        Pentagon irrPentagon = new Pentagon(pA_col, pB_col, pC_col, pD_col, pE_col);
      	assertTrue(irrPentagon.isRegular()== false);
	}
	
	@Test
	void regularPolyPeri() throws Exception {
        Point pA_reg = new Point(10 * Math.cos(0), 10 * Math.sin(0)); // (10, 0)
        Point pB_reg = new Point(10 * Math.cos(Math.toRadians(72)), 10 * Math.sin(Math.toRadians(72)));
        Point pC_reg = new Point(10 * Math.cos(Math.toRadians(144)), 10 * Math.sin(Math.toRadians(144))); // (-8.090, 5.878)
        Point pD_reg = new Point(10 * Math.cos(Math.toRadians(216)), 10 * Math.sin(Math.toRadians(216))); // (-8.090, -5.878)
        Point pE_reg = new Point(10 * Math.cos(Math.toRadians(288)), 10 * Math.sin(Math.toRadians(288))); // (3.090, -9.511)
        Pentagon regularPentagon = new Pentagon(pA_reg, pB_reg, pC_reg, pD_reg, pE_reg);
        System.out.println(regularPentagon.getPerimeter());
        assertTrue(Math.abs(regularPentagon.getPerimeter()-5*pA_reg.distance(pB_reg))<0.55);
	}
	
	@Test
	void regularPolyArea1() throws Exception {
		Point pA_reg = new Point(10 * Math.cos(0), 10 * Math.sin(0)); // (10, 0)
        Point pB_reg = new Point(10 * Math.cos(Math.toRadians(72)), 10 * Math.sin(Math.toRadians(72)));
        Point pC_reg = new Point(10 * Math.cos(Math.toRadians(144)), 10 * Math.sin(Math.toRadians(144))); // (-8.090, 5.878)
        Point pD_reg = new Point(10 * Math.cos(Math.toRadians(216)), 10 * Math.sin(Math.toRadians(216))); // (-8.090, -5.878)
        Point pE_reg = new Point(10 * Math.cos(Math.toRadians(288)), 10 * Math.sin(Math.toRadians(288))); // (3.090, -9.511)
        Pentagon regularPentagon = new Pentagon(pA_reg, pB_reg, pC_reg, pD_reg, pE_reg);
        System.out.println(regularPentagon.getArea());
        assertTrue(Math.abs(regularPentagon.getArea()-237.764)<0.5);
	}
	
}
