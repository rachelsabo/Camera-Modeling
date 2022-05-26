package unitTests;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.Test;

import Elements.AmbientLight;
import Elements.Camera;
import Elements.LightSource;
import Elements.PointLight;
import Elements.SpotLight;
import Geometry.Plane;
import Geometry.Sphere;
import Geometry.Triangle;
import Geometry.geometries;
import Renderer.ImageWriter;
import Renderer.Render;
import Scene.Scene;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;

public class LightTest {

	
	@Test
	public void Targil_11() 
	{

		Scene scene = new Scene();
		scene.set_screenDistance(200);
		scene.set_camera(new Camera(
	    		new Point3D(0, 0, 0), 
	    		new Vector(new Point3D(0,0,-1)), 
	    		new Vector(new Point3D(0,1,0))));
		  Color c = new Color(52,231,208);
		  Color c1 = new Color(0,255,0);
		  Color c2 = new Color(255,255,0);
		  Color c3 = new Color(255,128,0);
		  Color c4 = new Color(247,32,9);
		  Material m1 = new Material(0.8, 1, 20, 0, 0);
		  scene.addGeometry(new Sphere(5.0, new Point3D(0,9,-32),c,m1));
		  scene.addGeometry(new Sphere(5.0, new Point3D(7,0,-32),c1,m1));
		  scene.addGeometry(new Sphere( 5.0, new Point3D(0,-9,-32),c2,m1));
		  scene.addGeometry(new Sphere(5.0, new Point3D(-10,-5.2,-32),c3,m1));
		  Material m = new Material(0.8, 1, 20, 1, 0);
		  scene.addGeometry(new Sphere( 5.0, new Point3D(-10, 5.2,-32),c4,m1));
		  Sphere sphere1 = new Sphere( 500, new Point3D(0, 0.0, -1000),Color.WHITE,m1);
		  sphere1.get_material().set_nShininess(20);
		  scene.addGeometry(sphere1);
		  Triangle triangle = new Triangle(new Point3D(  350/2,  350/2, -200),
		  new Point3D( -350/2, -350/2, -100),
		  new Point3D(  350/2, -350/2, -200),Color.black, m);
          Triangle triangle2 = new Triangle(new Point3D(  350/2,  350/2, -200),
		  new Point3D( -350/2,  350/2, -100),
		  new Point3D( -350/2, -350/2, -100),Color.black, m);
          scene.addGeometry(triangle);
          scene.addGeometry(triangle2);
          SpotLight spotLight = new SpotLight(new Vector(new Point3D(0, 0, -1)), new Point3D(-20, -20, 0), 1.0, 0.005, 0.0000001,
   		  new Color(255, 155, 255));
          scene.addLight(spotLight);
   		  ImageWriter imageWriter = new ImageWriter("final test1", 501, 501, 501, 501);
		  Render render = new Render(scene, imageWriter);
		  render.renderImage();
		  render.get_imageWriter().writeToimage();
	}
	
	@Test
	public void spotLightTest1(){
		
	Scene scene = new Scene();
	scene.set_screenDistance(200);
	scene.set_camera(new Camera(
    		new Point3D(0, 0, 0), 
    		new Vector(new Point3D(0,0,-1)), 
    		new Vector(new Point3D(0,1,0))));
	Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000),new Color(0), new Material());
	sphere.get_material().set_nShininess(20);
	sphere.setEmission(new Color(0, 0, 100));
	scene.addGeometry(sphere);
	scene.addLight(new SpotLight(new Vector(new Point3D(2, 2, -3)),new Point3D(-200, -200, -150),0.1, 0.00001, 0.000005,new Color(255, 100, 100)));

	ImageWriter imageWriter = new ImageWriter("Spot test 1 ", 500, 500, 500, 500);
	
	Render render = new Render(scene, imageWriter );
	render.renderImage();
	render.get_imageWriter().writeToimage();
	
	}
	@Test
	public void spotLightTest2()
        {
		
		Scene scene = new Scene();
		scene.set_camera(new Camera(
	    new Point3D(0, 0, 0), 
	    new Vector(new Point3D(0,0,-1)), 
	    new Vector(new Point3D(0,1,0))));
        scene.set_screenDistance(100);
        Material m1=new Material();
		Sphere sphere = new Sphere(650.0,new Point3D(0,0,-1000),new Color(85,140,140),m1);
		scene.addGeometry(sphere);
	   scene.addLight(new SpotLight( new Vector(new Point3D(2.0,2.0,-3.0)),
        new Point3D((-200.0),(200.0),(-100.0)), 0.0, 0.00001, 0.000005,new Color(230, 95, 95)));
        ImageWriter imageWriter = new ImageWriter("SpotTest 2", 500, 500, 500, 500);
		Render render = new Render(scene,imageWriter);
		render.renderImage();	
		render.get_imageWriter().writeToimage();
	}
	@Test
	public void pointLightTest()
	{
	    Scene scene = new Scene();
		scene.set_camera(new Camera(
	    		new Point3D(0, 0, 0), 
	    		new Vector(new Point3D(0,0,-1)), 
	    		new Vector(new Point3D(0,1,0))));
		scene.set_screenDistance(200);
		Sphere sphere = new Sphere(500, new Point3D(0, 0, -1000),new Color(0), new Material());
		sphere.get_material().set_nShininess(20);
		sphere.setEmission(new Color(0, 0, 100));
		scene.addGeometry(sphere);
		Triangle triangle = new Triangle(new Point3D(  3500,  3500, -2000),
				 						 new Point3D( -3500, -3500, -1000),
				 						 new Point3D(  3500, -3500, -2000),new Color(0), new Material());

		Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, -2000),
				  						  new Point3D( -3500,  3500, -1000),
				  						  new Point3D( -3500, -3500, -1000),new Color(0), new Material());
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		
		scene.addLight(new PointLight( new Point3D(200, 200, -100), 
					   0, 0.000001, 0.0000005,new Color(255, 100, 100)));
	
		
		ImageWriter imageWriter = new ImageWriter("Point test", 500, 500, 500, 500);
		
		Render render = new Render( scene,imageWriter);
		
		render.renderImage();
		render.get_imageWriter().writeToimage();
		
	}
	
		@Test
         public void Render_test_lights() 
		{
		
		Scene scene = new Scene();
		scene.set_screenDistance(100);
		scene.set_camera(new Camera(
	    		new Point3D(0, 0, 0), 
	    		new Vector(new Point3D(0,0,-1)), 
	    		new Vector(new Point3D(0,1,0))));

		Material m = new Material();

		scene.addGeometry(new Triangle(
                new Point3D((-1750.0/4),(-3000.0/4),(-260.0)),
	new Point3D((-3000.0/4),(-1750.0/4), (-260.0)),
	new Point3D((-3000.0/4),(-3000.0/4), (-270.0)),new Color (0, 0, 100),new Material()));	

		scene.addGeometry(new Sphere((double) 150,  new Point3D(0.0, 0.0, -200),new Color(0, 0, 150),m));
	    PointLight pointLight = new PointLight(new Point3D(-50, -50, 0), 1, 0.0001, 0.0001,new Color(255, 200, 200));
		SpotLight spotLight = new SpotLight(new Vector(new Point3D(0, 0, -1)), new Point3D(-30, -30, 0), 1.0, 0.005, 0.0000001,
		new Color(255, 155, 255));
		scene.addLight(pointLight);
		scene.addLight(spotLight);
		ImageWriter imageWriter = new ImageWriter("Render test lights", 501, 501, 501, 501);
		Render render = new Render(scene, imageWriter);
		render.renderImage();
		render.get_imageWriter().writeToimage();
	}
		
		
	@Test
		public void shadow_test(){
			
			Scene scene = new Scene();
			scene.set_screenDistance(100);
			scene.set_camera(new Camera(
		    		new Point3D(0, 0, 0), 
		    		new Vector(new Point3D(0,0,-1)), 
		    		new Vector(new Point3D(0,1,0)))); 
			Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000),new Color(0), new Material());
			sphere.get_material().set_nShininess(20);
			sphere.setEmission(new Color(0, 0, 100));
			
			scene.addGeometry(sphere);
			
			Triangle triangle = new Triangle(new Point3D(  3500,  3500, -2000),
					 						 new Point3D( -3500, -3500, -1000),
					 						 new Point3D(  3500, -3500, -2000),new Color(0), new Material());

			Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, -2000),
					  						  new Point3D( -3500,  3500, -1000),
					  						  new Point3D( -3500, -3500, -1000),new Color(0), new Material());
			
			scene.addGeometry(triangle);
			scene.addGeometry(triangle2);
			
			scene.addLight(new SpotLight(  new Vector(new Point3D(-2, -2, -3)), new Point3D(200, 200, -100), 0, 0.000001, 0.0000005,
					 new Color(255, 100, 100)));
		
			
			ImageWriter imageWriter = new ImageWriter("shadow test", 500, 500, 500, 500);
			
			Render render = new Render(scene, imageWriter);
			
			render.renderImage();
			render.get_imageWriter().writeToimage();
			
		}

	@Test
	public void Reflection_test() {

		Scene scene = new Scene();
		scene.set_screenDistance(200);
		scene.set_camera(new Camera(
	    		new Point3D(0, 0, 0), 
	    		new Vector(new Point3D(0,0,-1)), 
	    		new Vector(new Point3D(0,1,0))));
        Color c = (Color.MAGENTA);
		Material m = new Material(0.8, 1, 20, 1, 0);
		Material m1 = new Material(0.8, 1, 20, 0, 0);
        scene.addGeometry(new Triangle( new Point3D(-10,-10,-20),new Point3D(-10,20,-20),new Point3D(20,-10,-40),new Color (0,0,0), m));
        scene.addGeometry(new Sphere( 5.0, new Point3D(10,10,-25),c,m1));
        PointLight pointLight = new PointLight( new Point3D(-20, -20, 0), 1, 0.0001, 0.0001,new Color(255, 200, 200));
		SpotLight spotLight = new SpotLight(new Vector(new Point3D(0, 0, -1)), new Point3D(-20, -20, 0), 1.0, 0.005, 0.0000001,new Color(255, 155, 255));
		scene.addLight(pointLight);
		scene.addLight(spotLight);
		ImageWriter imageWriter = new ImageWriter("Reflection test", 501, 501, 501, 501);
		Render render = new Render(scene, imageWriter);
		render.renderImage();
		render.get_imageWriter().writeToimage();
	}
	
@Test
	public void RefractionTest() 
{

		Scene scene = new Scene();
		scene.set_screenDistance(100);
		scene.set_camera(new Camera(
	    		new Point3D(0, 0, 0), 
	    		new Vector(new Point3D(0,0,-1)), 
	    		new Vector(new Point3D(0,1,0))));
		Material m = new Material(0.8, 1, 20, 0, 1);
		Material m1 = new Material(0.8, 1, 20, 0, 0);
		
        scene.addGeometry(new Sphere(4.0 ,new Point3D(0,0,-20),(new Color(0,200,0)),m1));
        scene.addGeometry(new Sphere(18.0 ,new Point3D(0,0,-20),(new Color(100,0,0)),m));
		PointLight pointLight = new PointLight( new Point3D(-30, -30, 0), 1, 0.0001, 0.0001,new Color(0, 255, 200));
		SpotLight spotLight = new SpotLight(new Vector(new Point3D(0, 0, -1)), new Point3D(-20, -20, 0), 1.0, 0.005, 0.0000001,
				new Color(255, 155, 255));
		scene.addLight(pointLight);
		ImageWriter imageWriter = new ImageWriter("Refraction test", 501, 501, 501, 501);
		Render render = new Render(scene, imageWriter);
		render.renderImage();
		render.get_imageWriter().writeToimage();
	}
	
@Test
	public void basicRendering()
	{

		Scene scene = new Scene("E&C3", new Color(0, 0, 0), new ArrayList<geometries>(),new Camera(), new AmbientLight(),
				100.0,new ArrayList<LightSource>());
		scene.set_camera(new Camera(
	    		new Point3D(0, 0, 0), 
	    		new Vector(new Point3D(0,0,-1)), 
	    		new Vector(new Point3D(0,1,0))));
		Material m = new Material(0.8, 1, 20, 0, 1);
		Material m1 = new Material(0.8, 1, 20, 0, 0);
        scene.addGeometry(new Sphere(15.0,new Point3D(0,0,-20),new Color(239,57,191),m));
        Triangle triangle = new Triangle(new Point3D( 60, 0, -149),
				 new Point3D(  0, 60, -149),
				 new Point3D( 60, 60, -149),new Color(200,0,0),m1);
        Triangle triangle2 = new Triangle(new Point3D( 60, 0, -149),
	 			  new Point3D(  0, -60, -149),
	 			  new Point3D( 60,-60, -149),new Color(0,0,200),m1);

Triangle triangle3 = new Triangle(new Point3D(-60, 0, -149),
				  new Point3D(  0, 60, -149),
				  new Point3D(-60, 60, -149),new Color(48,248,53),m1);

Triangle triangle4 = new Triangle(new Point3D(-60, 0, -149),
	 			  new Point3D(  0,  -60, -149),
	 			  new Point3D(-60, -60, -149),new Color(200,0,0),m1);
scene.addGeometry(triangle);
scene.addGeometry(triangle2);
scene.addGeometry(triangle3);
scene.addGeometry(triangle4);
	
PointLight pointLight = new PointLight( new Point3D(-30, -30, 0), 1, 0.0001, 0.0001,new Color(0, 255, 200));
SpotLight spotLight = new SpotLight(new Vector(new Point3D(0, 0, -1)), new Point3D(-20, -20, 0), 1.0, 0.005, 0.0000001,
		new Color(255, 155, 255));


		scene.addLight(pointLight);


		ImageWriter imageWriter = new ImageWriter("RefractionTest21", 501, 501, 501, 501);

		Render render = new Render(scene, imageWriter);

		render.renderImage();
		render.get_imageWriter().writeToimage();
}

@Test
public void finalProject()
{
	 Color c = new Color(0,0,255);
	  Color c1 = new Color(97,35,29);
	  Color c2 = new Color(59,56,70);
	  Color c3 = new Color(67,27,3);
	  Color c4 = new Color(226,231,23);
	  Color c5 = new Color(221,1,1);
	  Material m1 = new Material(0.8, 1, 20, 0, 0);
	  Material m = new Material(0.8, 1, 20, 0, 1);
	  Material m2 = new Material(0.8, 1, 20, 1, 0);
	Scene scene = new Scene();
	scene.set_screenDistance(100);
	scene.set_camera(new Camera(
    		new Point3D(0, 0, 0), 
    		new Vector(new Point3D(0,0,-1)), 
    		new Vector(new Point3D(0,1,0))));
	 scene.addGeometry(new Sphere(4, new Point3D(0,13,-25),c,m));
	  scene.addGeometry(new Sphere(4, new Point3D(0,-13,-25),c,m));
	  scene.addGeometry(new Sphere(1, new Point3D(0,13,-25),c1,m1));
	  scene.addGeometry(new Sphere(1, new Point3D(0,-13,-25),c1,m1));
	  scene.addGeometry(new Sphere(9, new Point3D(0,13,-25),c2,m));
	  scene.addGeometry(new Sphere(9, new Point3D(0,-13,-25),c2,m));
	  Triangle triangle = new Triangle(new Point3D( 1, 24, -149),
 			  new Point3D(  -5, -24, -149),
 			  new Point3D( -5,24, -149),c2,m);
	 
      Triangle triangle2 = new Triangle(new Point3D( 1, 24, -149),
	 			  new Point3D(  -5, -24, -149),
	 			  new Point3D( 1,-24, -149),c2,m);
      Triangle triangle3 = new Triangle(new Point3D( 90, 50, -149),
 			  new Point3D(  90, 150, -149),
 			  new Point3D( 100,100, -149),c3,m);

      Triangle triangle4 = new Triangle(new Point3D( 90, -50, -149),
 			  new Point3D(  90, -150, -149),
 			  new Point3D( 100,-100, -149),c3,m);
      Triangle triangle5 = new Triangle(new Point3D( -20, 0, -149),
 			  new Point3D(  -100, -10, -149),
 			  new Point3D( -100,10, -149),c4,m);


      Triangle triangle6 = new Triangle(new Point3D( -150, 0, -149),
 			  new Point3D(  -120, -20, -149),
 			  new Point3D( -150,-40, -149),c5,m2);
      Triangle triangle7 = new Triangle(new Point3D( -150, 0, -149),
 			  new Point3D( -120, 20, -149),
 			  new Point3D( -150,40, -149),c5,m2);
      Triangle triangle8 = new Triangle(new Point3D( -150, 0, -149),
 			  new Point3D(  -180, -20, -149),
 			  new Point3D( -150,-40, -149),c5,m2);
      Triangle triangle9= new Triangle(new Point3D( -150, 0, -149),
 			  new Point3D( -180, 20, -149),
 			  new Point3D( -150,40, -149),c5,m2);
      Triangle triangle10= new Triangle(new Point3D( -150, 0, -149),
 			  new Point3D(  -180, -20, -149),
 			  new Point3D( -180, 20, -149),c5,m2);
      Triangle triangle11 = new Triangle(new Point3D(  3500,  3500, -2000),
    			 new Point3D( -3500, -3500, -1000),
    			 new Point3D(  3500, -3500, -2000),new Color(0), new Material());

    	Triangle triangle12 = new Triangle(new Point3D(  3600,  3500, -2000),
    				  new Point3D( -3500,  3500, -1000),
    				  new Point3D( -3400, -3500, -1000),new Color(0), new Material());
    	
    	

    	scene.addGeometry(triangle11);
    	scene.addGeometry(triangle12);
      
scene.addGeometry(triangle);
scene.addGeometry(triangle2);
scene.addGeometry(triangle3);
scene.addGeometry(triangle4);
scene.addGeometry(triangle5);
scene.addGeometry(triangle6);
scene.addGeometry(triangle7);
scene.addGeometry(triangle8);
scene.addGeometry(triangle9);
scene.addGeometry(triangle10);
scene.addLight(new SpotLight(new Vector(new Point3D(0, 0,-1)), new Point3D(70, 40, 25),0, 0.000001, 0.0000005,new Color(255, 155, 255)));



	  ImageWriter imageWriter = new ImageWriter("final test1", 501, 501, 501, 501);
	  Render render = new Render(scene, imageWriter);
	  render.renderImage();
	  render.get_imageWriter().writeToimage();
}

	
}
