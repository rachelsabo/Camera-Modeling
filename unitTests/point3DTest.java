package unitTests;
import static org.junit.Assert.*;
import primitives.Point3D;
import primitives.Vector;
import org.junit.Test;
public class point3DTest
{
	@Test
	public void testAdd() 
	{
		Point3D p3D_1=new Point3D(1,2,3);
		Point3D p3D_2=new Point3D(1,2,3);
		Point3D p3D_4=new Point3D(2,4,6);
		Vector vec=new Vector(p3D_2);
		Vector v1=p3D_1.add(vec);
		Vector v2=new Vector(p3D_4);
		assertEquals(v1.toString(), v2.toString());
	}
	@Test
	public void testSubstrct() 
	{
		Point3D p3D_1=new Point3D(1,2,3);
		Point3D p3D_2=new Point3D(4,5,6);
		Point3D p3D_3=p3D_2.Substrct(p3D_1);
		Point3D p3D_4=new Point3D(3,3,3);
		assertEquals(p3D_4.toString(),p3D_3.toString());
	}
	@Test
	public void testDistanc() 
	{
		Point3D p3D_1=new Point3D(1,2,3);
		Point3D p3D_2=new Point3D(4,5,6);
		double x=p3D_2.Distanc(p3D_1);
		double y=Math.sqrt(27);
		assertEquals(y,x,0);
	}
}