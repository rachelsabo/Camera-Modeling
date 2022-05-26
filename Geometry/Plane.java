package Geometry;
import primitives.Point3D;
import primitives.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import primitives.Vector;
public class Plane extends geometries implements FlatGeometry
{
	private Point3D p1;
	private Vector vec;
	// ***************** Constructors ********************** // 
	public Plane()
	{
		this.p1=new Point3D();
		this.vec=new Vector();
	}
	public Plane(Point3D p3d,Vector v,Color c, Material m)
	{
		super(m,c);
		this.p1=p3d;
		this.vec=v;
	}
	public Plane(Plane other) 
	{
		this.emission=other.emission;
		this.p1= new Point3D(other.p1);
		this.vec= new Vector(other.vec.get_head());
	}
	// ***************** Getters/Setters ********************** // 
	public Point3D getP1() {
		return p1;
	}
	public void setP1(Point3D p1) {
		this.p1 = p1;
	}
	public Vector getVec() {
		return vec;
	}
	public void setVec(Vector vec) {
		this.vec = vec;
	}
	// ***************** Administration  ******************** // 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plane other = (Plane) obj;
		if (p1 == null) {
			if (other.p1 != null)
				return false;
		} else if (!p1.equals(other.p1))
			return false;
		if (vec == null) {
			if (other.vec != null)
				return false;
		} else if (!vec.equals(other.vec))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Plane [p1=" + p1 + ", vec=" + vec + "]";
	}
	// ***************** Operations ******************** // 
	public Vector getNormal(Point3D p3d)
	{
		double d=this.p1.Distanc(p3d);
		return this.vec.Mooving(d, d, d);
		
	}
	
	
	public  List<Point3D> findIntersections(Ray r)
	{
		 List<Point3D> list = new ArrayList<Point3D>(1);
		 Point3D p0=r.get_POO();
		 Point3D Q0=this.getP1();
		 Vector N=this.getNormal(Q0);
		 Vector V1=r.get_direction();
		 Vector v=new Vector (p0.Substrct(Q0));
		 double t=(N.DotProduct(v)*-1)/(N.DotProduct(V1));
		 if(t>=0)
		 {
			 V1= V1.ScalarMultiplication(t);
			Vector vec= p0.add(V1);
			 list.add(vec.get_head());
			 return list;
		 }
		 return null;
		/*double t=-this.vec.DotProduct(new Vector( r._POO.Substrct(this.p1)))/(this.vec.DotProduct(r._direction.Normal()))	;	
		Vector vn =new Vector(r.get_direction().Normal());
     	 List<Point3D> list = new ArrayList<Point3D>();
		 Point3D p1 = new Point3D();
		 p1= r.get_POO().add(vn.ScalarMultiplication(t)).get_head();
		  if (vec.DotProduct(new Vector(new Point3D(r.get_POO().add(vn).get_head()).Substrct(p1)))==0)
		  {
			  list.add(p1);
		  return list;
		  }
		
		return null;*/

		 
	}
	
	

}