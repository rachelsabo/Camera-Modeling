package primitives;

public class Material
{
public double _kd ;
public double _ks ;
public int _nShininess ;
public double _Kr;
public double _Kt;
// ***************** Constructors ********************** // 
public Material()
{
	_kd=1;
	_ks=1;
	_nShininess=1;
	_Kr=0;
	_Kt=0;
	
}
public Material(double kd,double ks,int nShininess,double kr,double kt)
{
	_kd=kd;
	_ks=ks;
	_nShininess=nShininess;
	_Kr=kr;
	_Kt=kt;
	
}
public Material(Material other)
{
	_kd=other._kd;
	_ks=other._ks;
	_nShininess=other._nShininess;
	_Kr=other._Kr;
	_Kt=other._Kt;
}
// ***************** Getters/Setters ********************** // 
public double get_kd() {
	return _kd;
}
public void set_kd(double _kd) {
	this._kd = _kd;
}
public double get_ks() {
	return _ks;
}
public void set_ks(double _ks) {
	this._ks = _ks;
}
public int get_nShininess() {
	return _nShininess;
}
public void set_nShininess(int _nShininess) {
	this._nShininess = _nShininess;
}
public double get_Kr() {
	return _Kr;
}
public void set_Kr(double _Kr) {
	this._Kr = _Kr;
}
public double get_Kt() {
	return _Kt;
}
public void set_Kt(double _Kt) {
	this._Kt = _Kt;
}
// ***************** Administration  ******************** // 

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Material other = (Material) obj;
	if (Double.doubleToLongBits(_Kr) != Double.doubleToLongBits(other._Kr))
		return false;
	if (Double.doubleToLongBits(_Kt) != Double.doubleToLongBits(other._Kt))
		return false;
	if (Double.doubleToLongBits(_kd) != Double.doubleToLongBits(other._kd))
		return false;
	if (Double.doubleToLongBits(_ks) != Double.doubleToLongBits(other._ks))
		return false;
	if (_nShininess != other._nShininess)
		return false;
	return true;
}
@Override
public String toString() {
	return "Material [_kd=" + _kd + ", _ks=" + _ks + ", _nShininess=" + _nShininess + ", _Kr=" + _Kr + ", _Kt=" + _Kt
			+ "]";
}

}
