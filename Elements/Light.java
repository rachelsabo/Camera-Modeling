package Elements;
import primitives.*;
import java.awt.Color;

import Geometry.Sphere;

public abstract class Light 
{
public Color _color1;
abstract Color getIntesity();

//***************** Constructors ********************** // 
public Light()
{
	_color1=new Color(0,0,0);
}
public Light(Color c)
{
	_color1=c;
	
}
public Light(Light other) 
{
	_color1=other._color1;
	
}
//***************** Getters/Setters ********************** // 
public Color get_color1() {
	return _color1;
}
public void set_color1(Color _color1) {
	this._color1 = _color1;
}
@Override
public String toString() {
	return "Light [_color=" + _color1 + "]";
}
//***************** Administration  ******************** // 
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Light other = (Light) obj;
	if (_color1 == null) {
		if (other._color1 != null)
			return false;
	} else if (!_color1.equals(other._color1))
		return false;
	return true;
}

//***************** Operations ******************** // 
 


}
