package Renderer;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import Elements.*;
import Geometry.*;
import Scene.*;
import primitives.*;
public class Render 
{
	Scene _scene;
    ImageWriter _imageWriter;
	// ***************** Constructors ********************** // 
	public Render(Scene _scene, ImageWriter _imageWriter) 
	{
		super();
		this._scene = _scene;
		this._imageWriter = _imageWriter;
	}
	public Render(Render other) 
	{
	    this._scene =other.get_scene();
		this._imageWriter =other.get_imageWriter();
	}
	// ***************** Getters/Setters ********************** //
	public Scene get_scene() {
		return _scene;
	}
	public void set_scene(Scene _scene) {
		this._scene = _scene;
	}
	public ImageWriter get_imageWriter() {
		return _imageWriter;
	}
	public void set_imageWriter(ImageWriter _imageWriter) {
		this._imageWriter = _imageWriter;
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
		Render other = (Render) obj;
		if (_imageWriter == null) {
			if (other._imageWriter != null)
				return false;
		} else if (!_imageWriter.equals(other._imageWriter))
			return false;
		if (_scene == null) {
			if (other._scene != null)
				return false;
		} else if (!_scene.equals(other._scene))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Render [_scene=" + _scene + ", _imageWriter=" + _imageWriter + "]";
	}
	// ***************** Operations ******************** // 
	public void renderImage() 
	 {
		Color c=new Color(0,0,0);
		Color c1=new Color(0,0,0);
		Color c2=new Color(0,0,0);
		Color c3=new Color(0,0,0);
		Color c4=new Color(0,0,0);

		 Ray ray=new Ray();
		 Ray ray1=new Ray();
		 Ray ray2=new Ray();
		 Ray ray3=new Ray();
		 Ray ray4=new Ray();
				 for (int i=0;i<this.get_imageWriter().getNx();i++)
		 {
			for(int j=0;j<this.get_imageWriter().getNy();j++)
			{
				 ray=this._scene.get_camera().constructRayThroughPixel(get_imageWriter().getNx(), this.get_imageWriter().getNy(),j,i, this.get_scene().get_screenDistance(), this.get_imageWriter().getWidth(), this.get_imageWriter().getHeight());
				 Map<geometries, List<Point3D>> intersectionPoints =this.getSceneRayIntersections(ray);
				double d=(this._imageWriter.getWidth()/this._imageWriter.getNx())/2;
				Point3D p1=new Point3D(d,d,ray.get_POO().getZ().getCoordinate());
				Point3D p2=new Point3D(d,-d,ray.get_POO().getZ().getCoordinate());
				Point3D p3=new Point3D(-d,d,ray.get_POO().getZ().getCoordinate());
				Point3D p4=new Point3D(-d,-d,ray.get_POO().getZ().getCoordinate());
				 ray1=new Ray(ray.get_POO().addPoint(p1),ray.get_direction());
				 ray2=new Ray(ray.get_POO().addPoint(p2),ray.get_direction());
				 ray3=new Ray(ray.get_POO().addPoint(p3),ray.get_direction());
				 ray4=new Ray(ray.get_POO().addPoint(p4),ray.get_direction());

				
				 Map<geometries, List<Point3D>> intersectionPoints1 =this.getSceneRayIntersections(ray1);	
				 Map<geometries, List<Point3D>> intersectionPoints2 =this.getSceneRayIntersections(ray2);	 
				 Map<geometries, List<Point3D>> intersectionPoints3 =this.getSceneRayIntersections(ray3);	 
				 Map<geometries, List<Point3D>> intersectionPoints4 =this.getSceneRayIntersections(ray4);	 

				if (intersectionPoints.isEmpty())
				{
					this.get_imageWriter().writePixel(j, i, this.get_scene().get_background());
				}
				else
				{
					Map<geometries, Point3D> closestPoint=this.getClosestPoint(intersectionPoints);
					Map<geometries, Point3D> closestPoint1=this.getClosestPoint(intersectionPoints1);

					Map<geometries, Point3D> closestPoint2=this.getClosestPoint(intersectionPoints2);
					Map<geometries, Point3D> closestPoint3=this.getClosestPoint(intersectionPoints3);
					Map<geometries, Point3D> closestPoint4=this.getClosestPoint(intersectionPoints4);

					for(Entry<geometries,Point3D> elem : closestPoint.entrySet())
						c=calcColor(elem.getValue(),elem.getKey(),ray,0 );
					for(Entry<geometries,Point3D> elem : closestPoint1.entrySet())
						c1=calcColor(elem.getValue(),elem.getKey(),ray1,0 );
					for(Entry<geometries,Point3D> elem : closestPoint2.entrySet())
						c2=calcColor(elem.getValue(),elem.getKey(),ray2,0 );
					for(Entry<geometries,Point3D> elem : closestPoint3.entrySet())
						c3=calcColor(elem.getValue(),elem.getKey(),ray3,0 );
					for(Entry<geometries,Point3D> elem : closestPoint4.entrySet())
						c4=calcColor(elem.getValue(),elem.getKey(),ray4,0 );
					c=new Color((int)(c.getRed()*0.8),(int)(c.getGreen()*0.8),(int)(c.getBlue()*0.8));
					c1=new Color((int)(c.getRed()*0.05),(int)(c.getGreen()*0.05),(int)(c.getBlue()*0.05));
					c3=new Color((int)(c.getRed()*0.05),(int)(c.getGreen()*0.05),(int)(c.getBlue()*0.05));
					c4=new Color((int)(c.getRed()*0.05),(int)(c.getGreen()*0.05),(int)(c.getBlue()*0.05));
				int r=c.getRed()+c1.getRed()+c2.getRed()+c3.getRed()+c4.getRed();
				int g=c.getGreen()+c1.getGreen()+c2.getGreen()+c3.getGreen()+c4.getGreen();
				int b=c.getBlue()+c1.getBlue()+c2.getBlue()+c3.getBlue()+c4.getBlue();
				if(r>255)
					 r=255;
				 if(g>255)
					 g=255;
				 if(b>255)
					 b=255;
									this._imageWriter.writePixel(j, i, c);
				}
			}
		}
	 }
	public void printGrid(int interval) 
	 {
		for(int i=0; i<500 ;i++)
            for(int j=0;j<500;j++)
               if((i%interval==0)||(j%interval==0))
            	   _imageWriter.writePixel(i, j, Color.WHITE);
		
	 }

	 public  Map<geometries, List<Point3D>> getSceneRayIntersections(Ray ray)
	 {

		 Iterator<geometries> geometrie = this.get_scene().getGeometriesIterator();
		 Map<geometries, List<Point3D>> intersectionPoints = new HashMap<geometries, List<Point3D>>(); 
				 while (geometrie.hasNext())
		 {
		 geometries geometry = geometrie.next();
		 List<Point3D> geometryIntersectionPoints =  geometry.findIntersections(ray);
		 if(geometryIntersectionPoints!=null)
		 intersectionPoints.put(geometry, geometryIntersectionPoints);
		 }
		 return intersectionPoints;
	}
	 private Ray  constructReflectedRay(Vector n, Point3D point ,Ray  d)
		{
			Vector D = d.get_direction().Normal();
			Vector R1 = D.Substrct(n.ScalarMultiplication(2*D.DotProduct(n)));
			Ray  R = new Ray ( point.add(R1.ScalarMultiplication(2)).get_head() ,R1);
			
			return R;
		}
		private Ray constructRefractedRay(Vector n, Point3D point ,Ray  d)
		{
			//return new Ray(point.add( d.getDirection().multScalar(2).getHead()), d.getDirection());
			return new Ray (point.add(d.get_direction().ScalarMultiplication(0.001)).get_head(), d.get_direction());
		}
	
	  public  Map<geometries, Point3D>  getClosestPoint(Map<geometries, List<Point3D>> intersectionPoints) 
	 {

	 double distance = Double.MAX_VALUE;
	 Point3D P0 = this.get_scene().get_camera().get_P0();
	 Map<geometries, Point3D> minDistancePoint = new HashMap<geometries, Point3D>();
	 for (Entry<geometries, List<Point3D>> entry: intersectionPoints.entrySet())
	 if(entry.getValue()!=null)
		 for (Point3D point: entry.getValue())
		 {
			 if (P0.Distanc(point) < distance)
			 {
				 minDistancePoint.clear();
				 minDistancePoint.put(entry.getKey(), new Point3D(point));
				 distance = P0.Distanc(point);
			 }
		 }
	 
			 return minDistancePoint;
	 }
	  private int RECURSION_LEVEL=3;
	 public Color calcColor( Point3D point,geometries geometry, Ray inRay, int level) 
	 {
		 
		 if (level == RECURSION_LEVEL) return new Color(0, 0, 0);
		 Color diffuseLight=new Color(0,0,0);
		 Color specularLight=new Color(0,0,0);
		 Color ambientLight = _scene.get_ambientLight().getIntesity();
		 Color emissionLight = geometry.getEmission();
		 Iterator<LightSource> lights = _scene.getLightsIterator();
		 while (lights.hasNext())
		 {
			 LightSource l = lights.next();
			
			 if(!occluded(l,point,geometry))
				
					 {
				 
			Color ca=calcDiffusiveComp(geometry.get_material().get_kd(),geometry.getNormal(point),l.getL(point),l.getIntesity(point));
			 int a=ca.getRed()+diffuseLight.getRed();
			 int b= ca.getGreen()+diffuseLight.getGreen();
			 int c=ca.getBlue()+diffuseLight.getBlue();
			 if(a>255)
				 a=255;
			 if(b>255)
				 b=255;
			 if(c>255)
				 c=255;
			
			diffuseLight=new Color(a,b,c);
		
			Color d= calcSpecularComp(geometry.get_material().get_ks(),new Vector(point.Substrct(this.get_scene().get_camera().get_P0())).Normal(),geometry.getNormal(point),l.getL(point),
					geometry.get_material().get_nShininess(),l.getIntesity(point));
			 a=d.getRed()+specularLight.getRed();
			 b= d.getGreen()+specularLight.getGreen();
			 c=d.getBlue()+specularLight.getBlue();
			 if(a>255)
				 a=255;
			 if(b>255)
				 b=255;
			 if(c>255)
				 c=255;
				 specularLight=new Color(a,b,c);
			
		 
		 
		 }
		 }
		 Color refractedColor = new Color(0,0,0);
			Color reflectedColor = new Color(0,0,0);
			Ray reflectedRay = constructReflectedRay(geometry.getNormal(point), point, inRay);
			Map<geometries,Point3D>reflectedEntry = getClosestPoint(getSceneRayIntersections(reflectedRay));
			
	           for(Entry<geometries, Point3D> entry: reflectedEntry.entrySet())
	        	  reflectedColor= calcColor(entry.getValue(), entry.getKey(), reflectedRay, level+1);
	      double kr = geometry.get_material().get_Kr();
			Color reflectedLight = mult( reflectedColor,kr);
			// Recursive call for a retracted ray
			Ray refractedRay = constructRefractedRay(geometry.getNormal(point), point, inRay);
			Map<geometries,Point3D> refractedEntry =getClosestPoint(getSceneRayIntersections(refractedRay));
	     		 for(Entry<geometries, Point3D> entry: refractedEntry.entrySet())
			refractedColor = calcColor(entry.getValue(), entry.getKey(), refractedRay, level+1);
	    	double kt = geometry.get_material().get_Kt();
			Color refractedLight =mult ( refractedColor, kt);
		int a=ambientLight.getRed()+geometry.getEmission().getRed()+diffuseLight.getRed()+specularLight.getRed()+reflectedLight.getRed()+refractedLight.getRed();
		int b=ambientLight.getGreen()+geometry.getEmission().getGreen()+diffuseLight.getGreen()+specularLight.getGreen()+reflectedLight.getGreen()+refractedLight.getGreen();
		int c=ambientLight.getBlue()+geometry.getEmission().getBlue()+diffuseLight.getBlue()+specularLight.getBlue()+reflectedLight.getBlue()+refractedLight.getBlue();
		 if(a>255)
			 a=255;
		 if(b>255)
			 b=255;
		 if(c>255)
			 c=255;
		 
		 return new Color(a,b,c); 		 
		 
		  	
	}
	 Color mult(Color c, double d)
		{
			int r =(int)( c.getRed()*d);
			if(r>255) r=255; if(r<0) r = -1*r;
			int g =(int)( c.getGreen()*d);
			if(g>255) g=255; if(g<0) g = -1*g;
			int b =(int)( c.getBlue()*d);
			if(b>255) b=255; if(b<0) b = -1*b;
			return new Color(r,g,b);
		}
	 private boolean occluded(LightSource light, Point3D point, geometries geometry) 
	 {
		  Vector lightDirection = light.getL(point);
		   lightDirection=lightDirection.ScalarMultiplication(-1); 
		   Point3D geometryPoint = new Point3D(point); 
		   Vector epsVector = new Vector(geometry.getNormal(point)); 
		   epsVector=epsVector.ScalarMultiplication(2);
		   geometryPoint=geometryPoint.addPoint(epsVector.get_head()); 
		   Ray lightRay = new Ray(geometryPoint, lightDirection);
		   Map<geometries,List<Point3D>> intersectionPoints = getSceneRayIntersections(lightRay);
		   if(geometry instanceof FlatGeometry)
			   intersectionPoints.remove(geometry);
		   for (Entry<geometries, List<Point3D>> entry: intersectionPoints.entrySet() )
			   if (entry.getKey().get_material().get_Kt() == 0)
			   return true;
			   return false;
		   //for (Entry<geometries, List<Point3D>>entry:intersectionPoints.entrySet() )
			  /* if (entry.getKey().get_material().getKt() == 0)
			   return true;
			   return false;/*/
		   
			/*Vector lightDirection = light.getL(point); 
			lightDirection=lightDirection.ScalarMultiplication(-1);
			Point3D geometryPoint = new Point3D(point);
			Vector epsVector = new Vector(geometry.getNormal(point));
			epsVector=epsVector.ScalarMultiplication(2);    
			geometryPoint.add(epsVector); 
			Ray lightRay = new Ray(geometryPoint, lightDirection);  
			Map<geometries, List<Point3D>> intersectionPoints = getSceneRayIntersections(lightRay);  
			// Flat geometry cannot self intersect  
			if (geometry instanceof FlatGeometry)
			  intersectionPoints.remove(geometry);
				
			  for (Entry<geometries, List<Point3D>>entry:intersectionPoints.entrySet() )
				  if(! intersectionPoints.isEmpty())
						return false;
						return true;
		 /*Vector lightDirection = light.getL(point);
		lightDirection.ScalarMultiplication(-1);

		 Point3D geometryPoint = new Point3D(point);
		 Vector epsVector = new Vector(geometry.getNormal(point));
		 epsVector.ScalarMultiplication(2);

		 geometryPoint.add(epsVector);
		 Ray lightRay = new Ray(geometryPoint, lightDirection);
		 Map<geometries, List<Point3D>> intersectionPoints =
		 getSceneRayIntersections(lightRay);

		 // Flat geometry cannot self intersect
		 if (geometry instanceof FlatGeometry)
		 {
		  intersectionPoints.remove(geometry);
		 }
		if(! intersectionPoints.isEmpty())
		return false;
		return true;
		
		
		 /*Vector lightDirection = light.getL(point);
		   lightDirection=lightDirection.multScalar(-1); 
		   Point3D geometryPoint = new Point3D(point); 
		   Vector epsVector = new Vector(geometry.getNormal(point)); 
		   epsVector=epsVector.multScalar(2);
		   geometryPoint=geometryPoint.add(epsVector); 
		   Ray lightRay = new Ray(geometryPoint, lightDirection);
		   Map<Geomtry,List<Point3D>> intersectionPoints = getSceneRayIntersections(lightRay);
		   if(geometry instanceof FlatGeometry)
			   intersectionPoints.remove(geometry);
		   if (intersectionPoints.isEmpty())
            return  false;
        return true;  */
		 }	 

public Color calcDiffusiveComp(double kd,Vector vecNormal,Vector VecL,Color lightIntensity)
{
	
	double d=vecNormal.Normal().DotProduct(VecL.Normal());
	if(d<0)
		d*=-1;
	 int a=(int)(lightIntensity.getRed()*d*kd);
	 int b= (int)(lightIntensity.getGreen()*d*kd);
	 int c=(int)(lightIntensity.getBlue()*d*kd);
	 if(a>255)
		 a=255;
	 if(a<0)
		 a=0; 
	 if(b>255)
		 b=255;
	 if(b<0)
		 b=0; 
	 if(c>255)
		 c=255;
	 if(c<0)
		 c=0; 
		 	return new Color(a,b,c);
}
public Color calcSpecularComp(double ks,Vector v,Vector n,Vector l,int Shininess,Color lightIntensity)
{
	v=v.ScalarMultiplication(-1);
	l=l.Normal();
	n=n.Normal();
	Vector  r=l.Substrct(n.ScalarMultiplication(l.DotProduct(n)*2));
	double d=Math.pow(r.DotProduct(v),Shininess )*ks;
	 int a=(int)(lightIntensity.getRed()*d);
	 int b= (int)(lightIntensity.getGreen()*d);
	 int c=(int)(lightIntensity.getBlue()*d);
	 if(a>255)
		 a=255;
	 if(a<0)
		 a=0;
	 if(b>255)
		 b=255;
	 if(b<0)
		 b=0;
	 if(c>255)
		 c=255;
	 if(c<0)
		 c=0;
	return new Color(a,b,c);
}
}