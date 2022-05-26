package Elements;
import java.awt.Color;


import primitives.*;
public class PointLight extends Light implements LightSource
{
	Point3D _position  ;
	double _kc;
	double _kl;
	double _kq;
	// ***************** Constructors ********************** // 
	public PointLight()
	{
		_position=new Point3D();
		_kc=0;
		_kl=0;
		_kq=0;
	}
	
	public PointLight(Point3D _position, double _kc, double _kl, double _kq, Color c) {
		super(c);
		this._position = _position;
		this._kc = _kc;
		this._kl = _kl;
		this._kq = _kq;
	}
	public PointLight(PointLight other)
	{
		_color1=other._color1;
		_position=other._position;
		_kc=other._kc;
		_kl=other._kl;
		_kq=other._kq;
	}
	//***************** Getters/Setters ********************** // 

	public Point3D get_position() {
		return _position;
	}

	public void set_position(Point3D _position) {
		this._position = _position;
	}

	public double get_kc() {
		return _kc;
	}

	public void set_kc(double _kc) {
		this._kc = _kc;
	}

	public double get_kl() {
		return _kl;
	}

	public void set_kl(double _kl) {
		this._kl = _kl;
	}

	public double get_kq() {
		return _kq;
	}

	public void set_kq(double _kq) {
		this._kq = _kq;
	}
	//***************** Administration  ******************** // 

	@Override
	public String toString() {
		return "PointLight [_position=" + _position + ", _kc=" + _kc + ", _kl=" + _kl + ", _kq=" + _kq + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PointLight other = (PointLight) obj;
		if (Double.doubleToLongBits(_kc) != Double.doubleToLongBits(other._kc))
			return false;
		if (Double.doubleToLongBits(_kl) != Double.doubleToLongBits(other._kl))
			return false;
		if (Double.doubleToLongBits(_kq) != Double.doubleToLongBits(other._kq))
			return false;
		if (_position == null) {
			if (other._position != null)
				return false;
		} else if (!_position.equals(other._position))
			return false;
		return true;
	}
	//***************** Operations ******************** //

@Override
	public Color getIntesity(Point3D point)
{
double distance = point.Distanc(_position);
Color color = new Color(this.get_color1().getRGB());
double K = 1/(_kc + _kl * distance +_kq * Math.pow(distance, 2));
if(K<1) 
K=1;
int red = (int)(color.getRed() * K);
int green = (int)(color.getGreen() * K);
int blue = (int)(color.getBlue() * K);
if (red<0)
red=0;
if (green<0)
green=0;
if (blue<0)
blue=0;
if (red>255)
red=255;
if (green>255)
green=255;
if (blue>255)
blue=255;
return new Color(red,green,blue);
}
@Override
	public Vector getL(Point3D point)
{
	Vector v=new Vector(point);
	Vector v1=new Vector(_position);
	v=v.Substrct(v1).Normal();
	return v;
	
}
@Override
  Color getIntesity()
{
	return null;
}

}
