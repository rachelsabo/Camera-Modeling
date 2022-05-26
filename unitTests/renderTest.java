package unitTests;
import static org.junit.Assert.*;
import java.awt.Color;
import java.util.ArrayList;
import org.junit.Test;

import Geometry.*;
import Renderer.*;
import Scene.*;
import primitives.*;
import Elements.*;

public class renderTest {
	
		 
	    @Test
	    public void basicRendering()
	    {
	
		Scene scene = new Scene("E&C1", new Color(0,0,0), new ArrayList<geometries>(), new Camera(),  new AmbientLight(),
				250.0,new ArrayList<LightSource>());
		scene.set_camera(new Camera(
	    		new Point3D(0, 0, 0), 
	    		new Vector(new Point3D(0,0,-1)), 
	    		new Vector(new Point3D(0,1,0))));
		Material m = new Material(0.8, 1, 100,0,1);
		
		scene.addGeometry(new Sphere(30.0, new Point3D(0.0, 0.0, -150),new Color(10,10,10), m));
		
		Triangle triangle = new Triangle(new Point3D( 60, 0, -149),
				 						 new Point3D(  0, 60, -149),
				 						 new Point3D( 60, 60, -149),new Color(10,10,10),m);
		
		Triangle triangle2 = new Triangle(new Point3D( 60, 0, -149),
				 			 			  new Point3D(  0, -60, -149),
				 			 			  new Point3D( 60,-60, -149),new Color(0,0,200),m);
		
		Triangle triangle3 = new Triangle(new Point3D(-60, 0, -149),
				 						  new Point3D(  0, 60, -149),
				 						  new Point3D(-60, 60, -149),new Color(0,200,0),m);
		
		Triangle triangle4 = new Triangle(new Point3D(-60, 0, -149),
				 			 			  new Point3D(  0,  -60, -149),
				 			 			  new Point3D(-60, -60, -149),new Color(200,0,0),m);
		

		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		scene.addGeometry(triangle3);
		scene.addGeometry(triangle4);

		
		ImageWriter imageWriter = new ImageWriter("RenderTest", 501, 501, 501, 501);
		
		Render render = new Render(scene, imageWriter);
		
		render.renderImage();
		render.printGrid(50);
		render.get_imageWriter().writeToimage();
		
	}
	
	            

	 

}



