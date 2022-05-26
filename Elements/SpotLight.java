package Elements;

import java.awt.Color;

import primitives.*;

public class SpotLight extends PointLight implements LightSource
{
Vector _direction;
private Object direction;
public SpotLight()
{
	_direction=new Vector();
}



public SpotLight(Vector _direction,Point3D _position, double _kc, double _kl, double _kq,Color c)
{
	super(_position,_kc,_kl,_kq,c);
	this._direction = _direction;
}
public SpotLight(SpotLight other)
{
	_direction=other._direction;
	_position=other._position;
	_kc=other._kc;
	_kl=other._kl;
	_kq=other._kq;
	_color1=other._color1;
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
	return "SpotLight [_direction=" + _direction + "]";
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (!super.equals(obj))
		return false;
	if (getClass() != obj.getClass())
		return false;
	SpotLight other = (SpotLight) obj;
	if (_direction == null) {
		if (other._direction != null)
			return false;
	} else if (!_direction.equals(other._direction))
		return false;
	return true;
}
//***************** Operations ******************** //
	@Override
	public Color getIntesity(Point3D point)
	{
		double d = this._position.Distanc(point);
		double coef = _direction.DotProduct(getL(point)) / ((_kc < 1 ? 1.0 : _kc) + _kl * d + _kq * d * d);
		if (coef <= 0.0)
			return new Color(0,0,0);
		double k =Math.abs(coef);
		int rc =(int)(this.get_color1().getRed() * k);
		if(rc>255) rc=255; if(rc<0) rc=0;
		int gc =(int)(this.get_color1().getGreen() * k); 
		if(gc>255) gc=255; if(gc<0) gc=0;
		int bc = (int)(this.get_color1().getBlue() * k);
		if(bc>255) bc=255; if(bc<0) bc=0;
		return new Color(rc,gc,bc);
		/*
	int r = this.get_color1().getRed();
	int g = this.get_color1().getGreen();
	int b = this.get_color1().getBlue();
	double distance = get_position().Distanc(point);
	double k = (this.get_kc() + this.get_kl()*distance + this.get_kq()*Math.pow(distance, 2));
	if (k > 1)
	k=1;

	//System.out.println((int)(r/ k));
	//System.out.println((Math.abs(r/ k)));
	int a=(int)Math.abs(r / k);
	int s=(int)(Math.abs(g / k));
	int t=(int)(Math.abs(b / k));
	 if(a>255)
		 a=255;
	 if(s>255)
		 s=255;
	 if(t>255)
		 t=255;
	 if(a<0)
		 a=0;
	 if(s<0)
		 s=0;
	 if(t<0)
		 t=0;
	Color color = new Color(a,s, t);
	Vector l = getL(point);
	l.Normal();
	double kk = Math.abs(this._direction.DotProduct(l));
	if(kk > 1)
	kk = 1;
	a=(int)(color.getRed() * kk);
	s=(int)(color.getGreen() * kk);
	t=(int)(color.getBlue() * kk);
	if(a>255)
		 a=255;
	 if(s>255)
		 s=255;
	 if(t>255)
		 t=255;
	 if(a<0)
		 a=0;
	 if(s<0)
		 s=0;
	 if(t<0)
		 t=0;
	Color IO = new Color(a, s,t);
	
	return IO;
	}

	@Override
	public Vector getL(Point3D point) {
		return new Vector(point.Substrct(_position)).Normal();*/
	}



}

