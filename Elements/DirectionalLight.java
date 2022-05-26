package Elements;
import java.awt.Color;

import primitives.*;
public class DirectionalLight extends Light implements LightSource
{
 public Vector _direction ; 
//***************** Constructors ********************** // 
 public DirectionalLight()
 {
	 _direction=new Vector();		 
 }
 public DirectionalLight(Vector direction,Color c)
 {
	 super(c);
	 _direction=direction;
 }
 public DirectionalLight(DirectionalLight other)
 {
	 _color1=other._color1;
	 _direction=other._direction;
 }
//***************** Getters/Setters ********************** // 
public Vector get_direction() {
	return _direction;
}
public void set_direction(Vector _direction) {
	this._direction = _direction;
}
//***************** Administration  ******************** // 
@Override
public String toString() {
	return "DirectionalLight [_direction=" + _direction + "]";
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (!super.equals(obj))
		return false;
	if (getClass() != obj.getClass())
		return false;
	DirectionalLight other = (DirectionalLight) obj;
	if (_direction == null) {
		if (other._direction != null)
			return false;
	} else if (!_direction.equals(other._direction))
		return false;
	return true;
}
//***************** Operations ******************** //
@Override
public Color getIntesity(Point3D p)
{
	return this.get_color1();
}
@Override
public Vector getL(Point3D p)
{
	Vector v=new Vector(p);
	Vector v1=new Vector(_direction);
	v=v.Substrct(v1).Normal();
	return v;
}
@Override
 Color getIntesity()
{
	return null;
}
}

