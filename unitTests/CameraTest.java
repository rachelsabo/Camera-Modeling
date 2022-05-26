package unitTests;

import primitives.*;

import static org.junit.Assert.*;

import org.junit.Test;

import Elements.*;
public class CameraTest {

	@Test
	public void testConstructRayThroughPixel()
	{
				Point3D p1=new Point3D(0,0,0);
				Point3D p2=new Point3D(0,0,1);
				Point3D p3=new Point3D(0,1,0);
				Vector v1=new Vector(p2);
				Vector v2=new Vector(p3);
				Camera c=new Camera(p1,v1,v2);
				Ray r1=new Ray(new Point3D(0,0,0), new Vector(new Point3D(3,3,-6)));
				Ray r2=c.constructRayThroughPixel(3, 3, 2, 3, 3, 9, 9);
				assertEquals(r2.toString(), r1.toString());
			
	}
}
