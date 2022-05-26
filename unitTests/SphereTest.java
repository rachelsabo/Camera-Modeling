package unitTests;
import java.awt.Color;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import Geometry.Sphere;


import primitives.*;

public class SphereTest 
{
	
	@Test
	public void normalTest()
	{
		Material m=new Material();
		Color ce=new Color(0,0,0);
		Color c=new Color(255,255,255);
	Point3D p1= new Point3D(1,2,3);
	Point3D p2= new Point3D(2,3,4);
	double x=0.5773502691896258;
	Point3D p3= new Point3D(x,x,x);
	double r = 1;
	Sphere s = new Sphere(r,p1,c,m);
	Vector v=new Vector(p3);
	Vector n=s.getNormal(p2);
		assertEquals(n,v);
	 }
		@Test
	public void intersectionsTest() 

	{
			Material m=new Material();
			Color ce=new Color(0,0,0);
    Color c=new Color(255,255,255);
	Coordinate c0 = new Coordinate(0.0);
	Coordinate c1 = new Coordinate(1);
	Coordinate c3 = new Coordinate(3);
	Coordinate c4 = new Coordinate(4);
	Coordinate _c4 = new Coordinate(3.868517091821332);
	Coordinate _c5 = new Coordinate(1.464816241512003);
	Ray ray3 = new Ray(new Point3D(c0,c0,c0), new Vector(new Point3D(c1,c1,c1)));
	Sphere sphere = new Sphere(3.0,new Point3D(c1,c3,c4),c,m);
	List<Point3D> intersectS1 = new ArrayList<Point3D>();
	intersectS1.add(new Point3D(_c5,_c5,_c5));
	intersectS1.add(new Point3D(_c4,_c4,_c4));
	assertEquals(intersectS1,sphere.findIntersections(ray3));
}
}
