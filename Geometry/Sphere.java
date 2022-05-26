package Geometry;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import primitives.*;
public class Sphere extends RadialGeometry
{
	private Point3D _center;
	// ***************** Constructors ********************** // 
	public Sphere()
	{
		this._center=new Point3D();
	}
	public Sphere(double r,Point3D p3d,Color c,Material m)
	{
		
		super(r);
		this._material=m;
		this.emission=c;
		this._center=p3d;
	}
	public Sphere(Sphere other) 
	{
		
		this._center= new Point3D(other._center);
		this._material=other._material;
		this.emission=other.emission;
		
	}
	// ***************** Getters/Setters ********************** // 
	public Point3D get_center() {
		return _center;
	}
	public void set_center(Point3D _center) {
		this._center = _center;
	}
	// ***************** Administration  ******************** // 
	@Override
	public String toString() {
		return "Sphere [_center=" + _center + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sphere other = (Sphere) obj;
		if (_center == null) {
			if (other._center != null)
				return false;
		} else if (!_center.equals(other._center))
			return false;
		return true;
	}
	// ***************** Operations ******************** // 
	@Override
	public Vector getNormal (Point3D p) 
	{
		Vector v1= new Vector(p.Substrct(this._center));
		return v1;
				//return v1.Normal();
	}
	
	public  List<Point3D> findIntersections(Ray r)
	{
	Point3D l1=this._center.Substrct(r._POO);
	Vector l=new Vector(l1);
	double tm=l.DotProduct(r._direction.Normal());
	double a1=l.VectorKLength()*l.VectorKLength();
	double a2=tm*tm;
	double a3=a1-a2;
	double d=Math.sqrt(a3);
	/*double d=Math.sqrt(l.VectorKLength()*l.VectorKLength()-tm*tm);*/
	double th =Math.sqrt(this._radius*this._radius-d*d);
	double t1 = tm-th;
	double t2 = tm + th;
	/*Vector vP1 = r._direction.ScalarMultiplication(t1).Mooving(r._POO.getX().getCoordinate(),r._POO.getY().getCoordinate(),r._POO.getZ().getCoordinate());
	Vector vP2 = r._direction.ScalarMultiplication(t2).Mooving(r._POO.getX().getCoordinate(),r._POO.getY().getCoordinate(),r._POO.getZ().getCoordinate());*/
	Vector vP1=r._POO.add(r._direction.Normal().ScalarMultiplication(t1));
	Vector vP2=r._POO.add(r._direction.Normal().ScalarMultiplication(t2));
	List<Point3D> lis=new ArrayList<Point3D>();	
	if(d>this._radius)
			return null;
			if(t1<=0)
				return null;
			else 
				lis.add(vP1.get_head());
			if(t2<=0)
				return null;
			else
				lis.add(vP2.get_head());
				return lis;
		
	}
}