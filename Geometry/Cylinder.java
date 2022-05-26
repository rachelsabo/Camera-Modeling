package Geometry;
import java.awt.Color;

import primitives.Material;
import primitives.Point3D;
import primitives.Vector;;
public class Cylinder extends RadialGeometry
{
	private Point3D _axisPoint;
    private Vector _axisDirection;
	// ***************** Constructors ********************** // 
    public Cylinder()
	{
		this._axisPoint=new Point3D();
		this._axisDirection=new Vector();
	}
	public Cylinder(Point3D p3d,Vector v,RadialGeometry r,Material m,Color ce)
	{
		super(r);
		this._material=m;
		this.emission=ce;
		this._axisPoint=p3d;
		this._axisDirection=v;
	}
	public Cylinder(Cylinder other) 
	{
		this._material=other._material;
		this.emission=other.emission;
		this._axisPoint= new Point3D(other._axisPoint);
		this._axisDirection= new Vector(other._axisDirection.get_head());
	}
	// ***************** Getters/Setters ********************** // 
	public Point3D get_axisPoint()
	{
		return _axisPoint;
	}
	public void set_axisPoint(Point3D _axisPoint) 
	{
		this._axisPoint = _axisPoint;
	}
	public Vector get_axisDirection()
	{
		return _axisDirection;
	}
	public void set_axisDirection(Vector _axisDirection)
	{
		this._axisDirection = _axisDirection;
	}
	// ***************** Administration  ******************** // 
	@Override
	public String toString() 
	{
		return "Cylinder [_axisPoint=" + _axisPoint + ", _axisDirection=" + _axisDirection + "]";
	}
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cylinder other = (Cylinder) obj;
		if (_axisDirection == null) {
			if (other._axisDirection != null)
				return false;
		} else if (!_axisDirection.equals(other._axisDirection))
			return false;
		if (_axisPoint == null) {
			if (other._axisPoint != null)
				return false;
		} else if (!_axisPoint.equals(other._axisPoint))
			return false;
		return true;
	}
	// ***************** Operations ******************** // 
	@Override
		public Vector getNormal (Point3D p) 
	{
		return new Vector();
	}

}