package primitives;

import primitives.Coordinate;
import primitives.Point2D;
import primitives.Vector;

public class Point3D extends Point2D 
{
	protected Coordinate z;
	// ***************** Constructors ********************** // 
	public Point3D() 
	{
		this.z = new Coordinate();
	}

	public Point3D(Coordinate c1, Coordinate c2, Coordinate c3)
	{
		super(c1, c2);
		this.z = new Coordinate(c3);
	}

	public Point3D(double n1, double n2, double n3)
	{
		super(n1, n2);
		this.z = new Coordinate(n3);
	}

	public Point3D(Point3D other) {
		super(other);
		this.z = new Coordinate(other.z);
	}
	// ***************** Getters/Setters ********************** // 
	public Coordinate getZ() 
	{
		return z;
	}

	public void setZ(Coordinate z) 
	{
		this.z = z;
	}
	// ***************** Administration  ******************** // 
	public boolean equals(Object obj) 
	{
		if (this.getClass() != obj.getClass()) {
			return false;
		} else {
			Point3D other = (Point3D) obj;
			if (!super.equals(obj)) {
				return false;
			} else {
				if (this.z == null) {
					if (other.z != null) {
						return false;
					}
				} else if (!this.z.equals(other.z)) {
					return false;
				}

				return true;
			}
		}
	}
	@Override
	public String toString() 
	{
		return "Point3D [z=" + z + ", x=" + x + ", y=" + y + "]";
	}
	// ***************** Operations ******************** // 
	public Vector add(Vector vec) 
	{
		Vector v =new Vector();
		v._head.x=this.x.add(vec._head.x);
		v._head.y=this.y.add(vec._head.y);
		v._head.z=this.z.add(vec._head.z);
			return v;
	}
	public Point3D addPoint(Point3D p)
	{
		Coordinate x=this.x.add(p.x);
		Coordinate y=this.y.add(p.y);
		Coordinate z=this.z.add(p.z);
		return new Point3D(x, y, z);
	}
	public Point3D Substrct(Point3D p3d) 
	{
		Point3D p=new Point3D();
		p.x=this.x.Substrct(p3d.x);
		p.y=this.y.Substrct(p3d.y);
		p.z=this.z.Substrct(p3d.z);
			return p;
	}
	public double Distanc(Point3D two)
	{
		Point3D p3d=new Point3D();
		p3d=this.Substrct(two);
		double x=Math.sqrt((p3d.x.mult(p3d.x).add(p3d.y.mult(p3d.y)).add(p3d.z.mult(p3d.z))).getCoordinate());
		return x;
	}
}