package unitTests;
import java.awt.Color;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import Geometry.*;
import primitives.*;
public class PlaneTest 
{
	@Test
	public void test() 
	{
		Color c=new Color(30, 23, 22);
		Material m=new Material();
		Color ce=new Color(0,0,0);
		Plane p=new Plane(new Point3D(new Coordinate(4),new Coordinate(4), new Coordinate(4)),new Vector(new Point3D(new Coordinate(0),new Coordinate(0), new Coordinate(0))),c,m);
		Vector v=new Vector(), v1=new Vector(new Point3D(new Coordinate(0),new Coordinate(0), new Coordinate(0)));
		v=p.getNormal(new Point3D(new Coordinate(4),new Coordinate(4), new Coordinate(4)));
		assertEquals(v, v1 );

	}
	@Test
	public void intersectionsTest()
	{
		
		Material m=new Material();
		Color ce=new Color(0,0,0);
		Point3D p = new Point3D(3,1,1);
		Point3D p1 = new Point3D(3,0,0);
		Vector v = new Vector(p1);
		
	    Plane pl = new Plane(p,v,new Color(3,2,5),m);
	    
	    Point3D p0 = new Point3D(2,1,2);
		Vector v1 = new Vector(new Point3D(3,0,0));
		Ray ray = new Ray(p0,v1);
			
		List<Point3D> list1 = new ArrayList<Point3D>();
		List<Point3D> list2 = new ArrayList<Point3D>();
		list1 = pl.findIntersections(ray);
		Point3D p2 = new Point3D(3,1,2);
		list2.add(p2);
		
		assertEquals(list1,list2);
		
	}
		public void Test()
		{
			Material m=new Material();
			Color ce=new Color(0,0,0);
		Color color = new Color(0,0,0);
		Coordinate c0 = new Coordinate(0.0);
		Coordinate c1 = new Coordinate(1);
		Coordinate c2 = new Coordinate(2);
		Coordinate c3 = new Coordinate(3);
		Coordinate c4 = new Coordinate(4);
		Coordinate c5 = new Coordinate(5);
		Coordinate c7 = new Coordinate(7);
		Coordinate _c1 = new Coordinate(1.70833127);
		Coordinate _c2 = new Coordinate(5.12499938);
		Coordinate _c3 = new Coordinate(1.5);
		Coordinate _c4 = new Coordinate(3.868517092);
		Coordinate _c5 = new Coordinate(1.464816241);
		
		//plane intersections
		Plane plane1 = new Plane(new Point3D(c4,c2,c2),new Vector(new Point3D(c0,c1,c1)),color,m);
		Plane plane2 = new Plane(new Point3D(c5,c4,c4),new Vector(new Point3D(c1,c7,c2)),color,m);
		Ray ray1 = new Ray(new Point3D(c0,c0,c0), new Vector(new Point3D(c0,c1,c0)));
		Ray ray2 = new Ray(new Point3D(c0,c0,c0), new Vector(new Point3D(c1,c3,c1)));
		ArrayList<Point3D> intersectP1 = new ArrayList<Point3D>();
		intersectP1.add(new Point3D(c0,c4,c0));
		ArrayList<Point3D> intersectP2 = new ArrayList<Point3D>();
		intersectP2.add(new Point3D(_c1,_c2,_c1));
		assertEquals("plane1 intersections failed",intersectP1,plane1.findIntersections(ray1));
		
		}
		
	
}
	
	


