package Geometry;
import primitives.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
public class Triangle extends geometries implements FlatGeometry
{
	private Point3D _p1;
	private Point3D _p2;
	private Point3D _p3;
	// ***************** Constructors ********************** // 

public Triangle()
{
	
	this._p1=new Point3D();
	this._p2=new Point3D();
	this._p3=new Point3D();
}
public Triangle(Point3D one,Point3D tow,Point3D three,Color c,Material m)
{
	super(m,c);
	this._p1=one;
	this._p2=tow;
	this._p3=three;
}
public Triangle(Triangle other) 
{
	this.emission=other.emission;
	this._p1= new Point3D(other._p1);
	this._p2= new Point3D(other._p2);
	this._p3= new Point3D(other._p3);
}
// ***************** Getters/Setters ********************** // 
public Point3D get_p1() {
	return _p1;
}
public void set_p1(Point3D _p1) {
	this._p1 = _p1;
}
public Point3D get_p2() {
	return _p2;
}
public void set_p2(Point3D _p2) {
	this._p2 = _p2;
}
public Point3D get_p3() {
	return _p3;
}
public void set_p3(Point3D _p3) {
	this._p3 = _p3;
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
	Triangle other = (Triangle) obj;
	if (_p1 == null) {
		if (other._p1 != null)
			return false;
	} else if (!_p1.equals(other._p1))
		return false;
	if (_p2 == null) {
		if (other._p2 != null)
			return false;
	} else if (!_p2.equals(other._p2))
		return false;
	if (_p3 == null) {
		if (other._p3 != null)
			return false;
	} else if (!_p3.equals(other._p3))
		return false;
	return true;
}
@Override
public String toString() {
	return "Triangle [_p1=" + _p1 + ", _p2=" + _p2 + ", _p3=" + _p3 + "]";
}
// ***************** Operations ******************** // 

public Vector getNormal(Point3D p3d)
{
	Vector vec1=new Vector(p3d.Substrct(_p1));
	Vector vec2=new Vector(p3d.Substrct(_p2));
	return new Vector(vec2.CrossProduct(vec1).Normal());
}



@Override
public List<Point3D> findIntersections(Ray r) 
{
	
Vector v1=new Vector(_p1.Substrct(r._POO))	;
Vector v2=new Vector(_p2.Substrct(r._POO))	;
Vector v3=new Vector(_p3.Substrct(r._POO))	;
Vector N1=new Vector(v1.CrossProduct(v2).Normal());
Vector N2=new Vector(v2.CrossProduct(v3).Normal());
Vector N3=new Vector(v3.CrossProduct(v1).Normal());
Plane pl=new Plane(this._p3,this.getNormal(_p3).Normal(),this.emission,this._material);
if(pl.findIntersections(r)==null)
	return null;
else
{
Point3D p=pl.findIntersections(r).get(0);
List<Point3D> lis=new ArrayList<Point3D>();	
if(sign(p,r.get_POO(),N1)>=0 &&
(sign(p,r.get_POO(),N2)>=0 &&
(sign(p,r.get_POO(),N3)>=0)))
{
	lis.add(p);
	return lis;
}

if(sign(p,r.get_POO(),N1)<0 &&
(sign(p,r.get_POO(),N2)<0 &&
(sign(p,r.get_POO(),N3)<0)))
{
	lis.add(p);
	return lis;
}
return null;
}
}
public double  sign(Point3D p,Point3D po,Vector vec)
{
	return (new Vector(p.Substrct(po)).DotProduct(vec));
 }
}