package Elements;
import java.awt.Color;
import primitives.*;

public class AmbientLight extends Light
{
public Color _color;
public double _ka;
// ***************** Constructors ********************** // 
public AmbientLight()
{
	_color=new Color(0,0,0);
	_ka=0.1;
}
public AmbientLight(Color c,double ka,Color c1)
{
	super(c1);
	_color=c;
	_ka=ka;
	
}
public AmbientLight(int  c1,int  c2,int  c3,Color c)
{
	super(c);
	_color=new Color(c1,c2,c3);
	_ka=0.1;
}
public AmbientLight(AmbientLight other)
{
	_color1=other._color1;
	_color=other._color;
	_ka=other._ka;
}
// ***************** Getters/Setters ********************** // 
public Color get_color() {
	return _color;
}
public void set_color(Color _color) {
	this._color = _color;
}
public double get_ka() {
	return _ka;
}
public void set_ka(double _ka) {
	this._ka = _ka;
}
// ***************** Administration  ******************** // 


public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	AmbientLight other = (AmbientLight) obj;
	if (_color == null) {
		if (other._color != null)
			return false;
	} else if (!_color.equals(other._color))
		return false;
	if (Double.doubleToLongBits(_ka) != Double.doubleToLongBits(other._ka))
		return false;
	return true;
}
@Override
public String toString() {
	return "AmbientLight [_color=" + _color + ", _ka=" + _ka + "]";
}
// ***************** Operations ******************** //
@Override
public Color getIntesity()
{
	int a=_color.getRed()*(int)this._ka;
	int b=_color.getGreen()*(int)this._ka;
	int c=_color.getBlue()*(int)this._ka;
	if(a>255)
		 a=255;
	 if(b>255)
		 b=255;
	 if(c>255)
		 c=255;
		 
	
		
	 return	new Color(a,b,c);
		
	
	
	
}
}
