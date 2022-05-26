package Geometry;

import java.awt.Color;
import java.util.List;
import primitives.*;
import primitives.Ray;
public abstract class geometries
{
	protected Material _material ;
	protected Color emission ;
	public abstract  Vector getNormal(Point3D p3d);
	// ***************** Constructors ********************** // 
	public geometries()
	{
		this._material=new Material();
		this.emission= new Color(0,0,0);
	}
	public geometries(Material m,Color cemission)
	{
		this._material=m;
		this.emission=cemission;
	}

	public geometries(geometries other) 
	{
		this._material=other._material;
		this.emission=other.emission;
	}
	// ***************** Getters/Setters ********************** // 
	public Material get_material() {
		return _material;
	}
	public void set_material(Material _material) {
		this._material = _material;
	}
	public Color getEmission() {
		return emission;
	}
	public void setEmission(Color emission) {
		this.emission = emission;
	}
	// ***************** Administration  ******************** // 
	@Override
	public String toString() 
	{
		return "geometries [_material=" + _material + ", emission=" + emission + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		geometries other = (geometries) obj;
		if (_material == null) {
			if (other._material != null)
				return false;
		} else if (!_material.equals(other._material))
			return false;
		if (emission == null) {
			if (other.emission != null)
				return false;
		} else if (!emission.equals(other.emission))
			return false;
		return true;
	}
	// ***************** Operations ******************** //
	public abstract List<Point3D> findIntersections(Ray r);
	
	
	
	
	
}