package lab4;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class Lab5IcosahedronTests {


//___________________________________________________________________________________


        private static double phi() {
            return (1.0 + Math.sqrt(5.0)) / 2.0;
        }
        
    private static ArrayList<Point3D> canonicalIcosahedronVertices() {
        double Va = phi();
        ArrayList<Point3D> v = new ArrayList<>();

        v.addAll(Arrays.asList(
                new Point3D(0,  1,  Va),
                new Point3D(0, -1,  Va),
                new Point3D(0,  1, -Va),
                new Point3D(0, -1, -Va)
        )
        		);

        v.addAll(Arrays.asList(
                new Point3D( 1,  Va, 0),
                new Point3D(-1,  Va, 0),
                new Point3D( 1, -Va, 0),
                new Point3D(-1, -Va, 0)
        )
        		);

        v.addAll(Arrays.asList(
                new Point3D( Va, 0,  1),
                new Point3D( Va, 0, -1),
                new Point3D(-Va, 0,  1),
                new Point3D(-Va, 0, -1)
        )
        		);

        return v;
    }

    @Test
    void point3d_distance_3dPythagorean() {
        Point3D a = new Point3D(0, 0, 0);
        Point3D b = new Point3D(1, 2, 2);
        assertEquals(3.0, a.distance(b), 1e-8);
    }

    @Test
    void point3d_equals_sameCoordinates() {
        Point3D a = new Point3D(3.5, -2.0, 7.25);
        Point3D b = new Point3D(3.5, -2.0, 7.25);
        assertTrue(a.equals(b));
    }

    @Test
    void point3d_notEquals_diffZ() {
        Point3D a = new Point3D(1.0, 1.0, 1.0);
        Point3D b = new Point3D(1.0, 1.0, 1.1);
        assertFalse(a.equals(b));
    }

    @Test
    void icosahedron_surfaceArea_forEdgeLength2() throws Exception {
        ArrayList<Point3D> verts = canonicalIcosahedronVertices();
        Icosahedron ico = new Icosahedron(verts);
        double expected = 5 * Math.sqrt(3) * Math.pow(2.0, 2.0);
        assertEquals(expected, ico.surfaceArea(), 1e-8);
    }

    @Test
    void icosahedron_reject_irregularGeometry() {
        ArrayList<Point3D> verts = canonicalIcosahedronVertices();
        Point3D p = verts.get(0);
        verts.set(0, new Point3D(p.x + 0.1, p.y, p.z));
        assertThrows(Exception.class, () -> new Icosahedron(verts));
    }
    

    @Test
    void icosahedron_volume_forEdgeLength2() throws Exception {
        ArrayList<Point3D> verts = canonicalIcosahedronVertices();
        Icosahedron ico = new Icosahedron(verts);
        double expected = 5 * (3 + Math.sqrt(5)) / 12.0 * Math.pow(2.0, 3.0);
        assertEquals(expected, ico.volume(), 1e-8);
    }

    @Test
    void icosahedron_rejects_wrongVertexCount() {
        ArrayList<Point3D> verts = canonicalIcosahedronVertices();
        verts.remove(0);
        assertThrows(Exception.class, () -> new Icosahedron(verts));
    }


}

  


