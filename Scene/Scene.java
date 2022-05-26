package Scene;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import Geometry.*;
import javafx.geometry.Point3D;
import primitives.Vector;
import Elements.*;
public class Scene
{
	private String _sceneName;
	private Color _background;
	private AmbientLight _ambientLight;
	private List<geometries> _geometries;
	private Camera _camera;
	private double _screenDistance;
	private List<LightSource> _lights;
	// ***************** Constructors ********************** // 
	
	public Scene(String _sceneName, Color _background, List<geometries> _geometries, Camera _camera,AmbientLight ambientLight,
			double _screenDistance,List<LightSource> lights) 
	{
		super();
		this._ambientLight=ambientLight;
		this._sceneName = _sceneName;
		this._background = _background;
		this._geometries = new ArrayList<geometries>();
		this._camera = _camera;
		this._screenDistance = _screenDistance;
		this._lights=lights;
	}
	public Scene() 
	{
		this._ambientLight=new AmbientLight();
		this._sceneName = new String();
		this._background =new Color(0,0,0);
		this._geometries = new ArrayList<geometries>();
		this._camera =new Camera();
		this._screenDistance =100;
		this._lights=new ArrayList<LightSource>();
	}
	public Scene(Scene other) 
	{
		
		this._sceneName =other.get_sceneName() ;
		this._background =other.get_background();
		this._geometries =other.get_geometries();
		this._camera =other.get_camera();
		this._screenDistance =other.get_screenDistance();
		this._lights=other._lights;
		this._ambientLight=other.get_ambientLight();
	}
	// ***************** Getters/Setters ********************** // 
	
	public String get_sceneName() {
		return _sceneName;
	}
	public void set_sceneName(String _sceneName) {
		this._sceneName = _sceneName;
	}
	public Color get_background() {
		return _background;
	}
	public void set_background(Color _background) {
		this._background = _background;
	}
	public AmbientLight get_ambientLight() {
		return _ambientLight;
	}
	public void set_ambientLight(AmbientLight _ambientLight) {
		this._ambientLight = _ambientLight;
	}
	public List<geometries> get_geometries() {
		return _geometries;
	}
	public void set_geometries(List<geometries> _geometries) {
		this._geometries = _geometries;
	}
	public Camera get_camera() {
		return _camera;
	}
	public void set_camera(Camera _camera) {
		this._camera = _camera;
	}
	public double get_screenDistance() {
		return _screenDistance;
	}
	public void set_screenDistance(double _screenDistance) {
		this._screenDistance = _screenDistance;
	}
	public List<LightSource> get_lights() {
		return _lights;
	}
	public void set_lights(List<LightSource> _lights) {
		this._lights = _lights;
	}
	// ***************** Administration  ******************** // 
	@Override
	public String toString() {
		return "Scene [_sceneName=" + _sceneName + ", _background=" + _background + ", _ambientLight="
				+ _ambientLight + ", _geometries=" + _geometries + ", _camera=" + _camera + ", _screenDistance="
				+ _screenDistance + ", _lights=" + _lights + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Scene other = (Scene) obj;
		if (_ambientLight == null) {
			if (other._ambientLight != null)
				return false;
		} else if (!_ambientLight.equals(other._ambientLight))
			return false;
		if (_background == null) {
			if (other._background != null)
				return false;
		} else if (!_background.equals(other._background))
			return false;
		if (_camera == null) {
			if (other._camera != null)
				return false;
		} else if (!_camera.equals(other._camera))
			return false;
		if (_geometries == null) {
			if (other._geometries != null)
				return false;
		} else if (!_geometries.equals(other._geometries))
			return false;
		if (_lights == null) {
			if (other._lights != null)
				return false;
		} else if (!_lights.equals(other._lights))
			return false;
		if (_sceneName == null) {
			if (other._sceneName != null)
				return false;
		} else if (!_sceneName.equals(other._sceneName))
			return false;
		if (Double.doubleToLongBits(_screenDistance) != Double.doubleToLongBits(other._screenDistance))
			return false;
		return true;
	}
		// ***************** Operations ******************** // 
		public void  addGeometry(geometries geometry)
	{
		this._geometries.add(geometry);
	}
	
	public Iterator<geometries> getGeometriesIterator()
		{
			 Iterator<geometries> iterator=this._geometries.iterator();
			 return iterator;
		}
	public Iterator<LightSource> getLightsIterator()
	{
		Iterator<LightSource> iterator=this._lights.iterator();
		 return iterator;	
	}
	public void  addLight(LightSource Light)
	{
		this.get_lights().add(Light);
		
	}
		
	
	
}
