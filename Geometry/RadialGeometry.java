package Geometry;
import java.util.List;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
public class RadialGeometry extends geometries
{
	protected double _radius;
	// ***************** Constructors ********************** // 
	public RadialGeometry()
	{
	this._radius=0.0;
	}
	public RadialGeometry(double r)
	{
		this._radius=r;
		
	}
	public RadialGeometry(RadialGeometry other) 
	{
		this._radius = other._radius;
		
	}
	// ***************** Getters/Setters ********************** // 
	public double get_radius()
	{
		return _radius;
	}
		public void set_radius(double _radius)
	{
		this._radius = _radius;
	}
		// ***************** Administration  ******************** // 
	@Override
		public String toString()
	{
			return "" + _radius ;
	}
		@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		RadialGeometry other = (RadialGeometry) obj;
		if (Double.doubleToLongBits(_radius) != Double.doubleToLongBits(other._radius))
			return false;
		return true;
	}
		// ***************** Operations ******************** // 
	public Vector getNormal(Point3D p3d)
	{
		return new Vector();
	}
	@Override
	public List<Point3D> findIntersections(Ray r) {
		// TODO Auto-generated method stub
		return null;
	}
		
	
	
}