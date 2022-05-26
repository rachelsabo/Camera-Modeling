package unitTests;
import static org.junit.Assert.*;
import org.junit.Test;
import primitives.Vector;
import primitives.Point3D;
public class VectorTests 
{
	@Test
	public void testadd() 
	{
		Vector vec1=new Vector(new Point3D(1,2,3));
		Vector vec2=new Vector(new Point3D(4,5,6));
		Vector vec3=new Vector();
		vec3=vec1.add(vec2);
		Vector vec4=new Vector(new Point3D(5,7,9));
		assertEquals(vec4.toString(),vec3.toString());
	} 
	@Test
	public void testSubstrct() 
	{
		Vector vec1=new Vector(new Point3D(1,2,3));
		Vector vec2=new Vector(new Point3D(4,5,6));
		Vector vec3=new Vector();
		vec3=vec2.Substrct(vec1);
		Vector vec4=new Vector(new Point3D(3,3,3));
		assertEquals(vec4.toString(),vec3.toString());
	} 
	@Test
	public void testScalarMultiplication() 
	{
		Vector vec1=new Vector(new Point3D(1,2,3));
		Vector vec2=new Vector();
		vec2=vec1.ScalarMultiplication(3);
		Vector vec3=new Vector(new Point3D(3,6,9));
		assertEquals(vec3.toString(),vec2.toString());
	} 
	@Test
	public void testMooving() 
	{
		Vector vec1=new Vector(new Point3D(1,2,3));
		Vector vec2=new Vector();
		vec2=vec1.Mooving(3, 4, 5);
		Vector vec3=new Vector(new Point3D(4,6,8));
		assertEquals(vec3.toString(),vec2.toString());
	} 
	@Test
	public void testVectorKLength() 
	{
		Vector vec1=new Vector(new Point3D(0,3,4));
		double d1=vec1.VectorKLength();
		double d2=5;
		assertEquals(d2,d1,0);
	} 
	@Test
	public void testNormal() 
	{
		Vector vec1=new Vector(new Point3D(0,3,4));
		Vector vec2=new Vector();
		vec2=vec1.Normal();
		double d=5;
		double d1=0/d,d2=3/d,d3=4/d;
		Vector vec3=new Vector(new Point3D(d1,d2,d3));
		assertEquals(vec3.toString(),vec2.toString());
	} 
	@Test
	public void testCrossProduct() 
	{
		Vector vec1=new Vector(new Point3D(0,3,4));
		Vector vec2=new Vector(new Point3D(1,2,3));
		Vector vec3=new Vector();
		vec3=vec2.CrossProduct(vec1);
		Vector vec4=new Vector(new Point3D(-1,-4,3));
		assertEquals(vec3.toString(),vec4.toString());
	} 
}