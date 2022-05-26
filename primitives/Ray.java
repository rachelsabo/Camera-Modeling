package primitives;
import primitives.Vector;

import primitives.Point3D;
public class Ray 
{
   public Point3D _POO;
   public  Vector _direction;
	// ***************** Constructors ********************** // 
   public Ray() 
	{
		this._POO = new Point3D();
		this._direction = new Vector();
	}
	public Ray(Point3D _POO, Vector _direction) 
	{
			this._POO = _POO;
		this._direction = _direction;
	}
	public Ray(Ray other) 
	{
		
		this._POO= new Point3D(other._POO);
		this._direction= new Vector(other._direction);
	}
	// ***************** Getters/Setters ********************** // 
	public Point3D get_POO() 
	{
		return _POO;
	}

	public void set_POO(Point3D _POO)
	{
		this._POO = _POO;
	}

	public Vector get_direction()
	{
		return _direction;
	}

	public void set_direction(Vector _direction)
	{
		this._direction = _direction;
	}
	// ***************** Administration  ******************** // 
	@Override
	public String toString() 
	{
		return "Rey [=_POO" + _POO + ", _direction=" + _direction + "]";
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
		Ray other = (Ray) obj;
		if (_POO == null) {
			if (other._POO != null)
				return false;
		} else if (!_POO.equals(other._POO))
			return false;
		if (_direction == null) {
			if (other._direction != null)
				return false;
		} else if (!_direction.equals(other._direction))
			return false;
		return true;
	}
    
}
