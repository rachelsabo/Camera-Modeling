package Elements;
import primitives.Point3D;
import primitives.Vector;
import primitives.Ray;
public class Camera 
{
	Point3D _P0;
	Vector _vUp;
	Vector _vTo;
    Vector _vRight;
	// ***************** Constructors ********************** // 
    public Camera()
    {
    	this._P0=new Point3D(0,0,0);
       	this._vTo=new Vector(new Point3D(0,1,0));
    	this._vUp=new Vector(new Point3D(0,0,-1));
    	this._vRight=new Vector(new Point3D(1,0,0));
    }
    public Camera(Point3D _P,Vector _vT,Vector _vR)
    {
    	this._P0=_P;
       	this._vTo=_vT;
    	this._vUp=_vT.CrossProduct(_vR);
    	this._vRight=_vR;
    }
    public Camera(Camera other)
    {
    	this._P0=other._P0;
    	this._vRight=other._vRight;
    	this._vTo=other._vTo;
    	this._vUp=other._vUp;
    }
	// ***************** Getters/Setters ********************** // 
	public Point3D get_P0() 
	{
		return _P0;
	}
	public void set_P0(Point3D _P0)
	{
		this._P0 = _P0;
	}
	public Vector get_vUp() 
	{
		return _vUp;
	}
	public void set_vUp(Vector _vUp) 
	{
		this._vUp = _vUp;
	}
	public Vector get_vTo() 
	{
		return _vTo;
	}
	public void set_vTo(Vector _vTo)
	{
		this._vTo = _vTo;
	}
	public Vector get_vRight() 
	{
		return _vRight;
	}
	public void set_vRight(Vector _vRight)
	{
		this._vRight = _vRight;
	}
	// ***************** Administration  ******************** // 
	@Override
	public String toString() 
	{
		return "("+this._P0+" , "+ this._vRight + this._vTo + this._vUp + ")";
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
		Camera other = (Camera) obj;
		if (_P0 == null) {
			if (other._P0 != null)
				return false;
		} else if (!_P0.equals(other._P0))
			return false;
		if (_vRight == null) {
			if (other._vRight != null)
				return false;
		} else if (!_vRight.equals(other._vRight))
			return false;
		if (_vTo == null) {
			if (other._vTo != null)
				return false;
		} else if (!_vTo.equals(other._vTo))
			return false;
		if (_vUp == null) {
			if (other._vUp != null)
				return false;
		} else if (!_vUp.equals(other._vUp))
			return false;
		return true;
	}
	// ***************** Operations ******************** // 
	public Ray constructRayThroughPixel (float Nx, float Ny, double x, double y,  double screenDist, double screenWidth,double screenHeight)
	{
		/*Vector pc=this._P0.add(this._vTo.ScalarMultiplication(screenDist));
		double Pixelsx=screenWidth/Nx;
		double Pixelsy=screenHeight/Ny;
		Ray r=new Ray();
		r._direction=pc.add((this._vRight.ScalarMultiplication((x-Pixelsx/2)*Nx+Nx/2).Substrct(this._vUp.ScalarMultiplication((y-Pixelsy/2)*Ny+Ny/2))));
		r._POO=this._P0;
				return r;*/
		Point3D p=new Point3D();
		p=_P0.addPoint(_vTo.ScalarMultiplication(screenDist).get_head()).addPoint(_vRight.ScalarMultiplication((x-Nx/2)*(screenWidth/Nx)+((screenWidth/Nx)/2)).Substrct(_vUp.ScalarMultiplication((y-Ny/2)*(screenHeight/Ny)+((screenHeight/Ny)/2))).get_head());
		return new Ray(_P0, new Vector(p.Substrct(_P0)));
	}
 }