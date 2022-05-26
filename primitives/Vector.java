package primitives;
public class Vector
{
	Point3D _head;
	// ***************** Constructors ********************** // 
	public Vector()
	{
		this._head=new Point3D();
		
	}
		public Vector(Point3D p3d)
	{
		this._head=new Point3D(p3d);
		
	}
	public Vector(Vector other) 
	{
		this._head= new Point3D(other._head);
	}
	// ***************** Getters/Setters ********************** // 
	public Point3D get_head()
	{
		return _head;
	}
	public void set_head(Point3D _head) 
	{
		this._head = _head;
	}
	// ***************** Administration  ******************** // 
	@Override
	public String toString() 
	{
		return "Vector [_head=" + _head + "]";
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
		Vector other = (Vector) obj;
		if (_head == null) {
			if (other._head != null)
				return false;
		} else if (!_head.equals(other._head))
			return false;
		return true;
	}
	// ***************** Operations ******************** // 
	public Vector add(Vector vec) 
	{
		Vector vector=new Vector();
		vector._head.x=this._head.getX().add(vec._head.getX());
		vector._head.y=this._head.getY().add(vec._head.getY());
		vector._head.z=this._head.getZ().add(vec._head.getZ());
				return vector;
	}
	
	
	public Vector Substrct(Vector vec) 
	{
		Vector vector=new Vector();
		vector._head.x=this._head.getX().Substrct(vec._head.getX());
		vector._head.y=this._head.getY().Substrct(vec._head.getY());
		vector._head.z=this._head.getZ().Substrct(vec._head.getZ());
				return vector;
	}
	public Vector ScalarMultiplication(double Scalar)
	{
		Vector vector=new Vector();
		vector._head.x.coordinate=this._head.x.coordinate*Scalar;
		vector._head.y.coordinate=this._head.y.coordinate*Scalar;
		vector._head.z.coordinate=this._head.z.coordinate*Scalar;
				return vector;
	}
	public Vector Mooving(double a,double b,double c)
	{
		Vector vector=new Vector();
		vector._head.x.coordinate=this._head.x.coordinate+=a;
		vector._head.y.coordinate=this._head.y.coordinate+=b;
		vector._head.z.coordinate=this._head.z.coordinate+=c;
		return vector;
	}
	public double VectorKLength()
	{
		double length= Math.sqrt(Math.pow(this._head.x.coordinate, 2)+Math.pow(this._head.y.coordinate, 2)+Math.pow(this._head.z.coordinate,2));
		return length;
	}
	public Vector Normal()
	{
		Vector vector=new Vector();
		vector._head.x.coordinate=this._head.x.coordinate/this.VectorKLength();
		vector._head.y.coordinate=this._head.y.coordinate/this.VectorKLength();
		vector._head.z.coordinate=this._head.z.coordinate/this.VectorKLength();
				return vector;
	}
	public Vector CrossProduct(Vector vec)
	{
		Vector newVector=new Vector();
		newVector._head.x.coordinate=this._head.y.coordinate*vec._head.z.coordinate-this._head.z.coordinate*vec._head.y.coordinate;
		newVector._head.y.coordinate=this._head.z.coordinate*vec._head.x.coordinate-this._head.x.coordinate*vec._head.z.coordinate;
		newVector._head.z.coordinate=this._head.x.coordinate*vec._head.y.coordinate-this._head.y.coordinate*vec._head.x.coordinate;
		return newVector;
				
	}	
	public double DotProduct(Vector vec)
	{
	double  v=this._head.x.mult(vec._head.x).getCoordinate()+this._head.y.mult(vec._head.y).getCoordinate()+this._head.z.mult(vec._head.z).getCoordinate();
				return v;
	
	}
}