package unitTests;
import static org.junit.Assert.*;
import java.awt.Color;
import org.junit.Test;

import Renderer.*;
public class ImageWriterTest
{

	@Test
	public void writePixelTest1() {
		System.out.println("writeToimage");
		ImageWriter instance = new ImageWriter("ImageWrither1", 500, 500, 50, 50);
        for(int i=0; i<500 ;i++)
            for(int j=0;j<500;j++)
                instance.writePixel(i, j, Color.BLACK);
        for(int i=0; i<500 ; i+=50)
            for(int j=0;j<500; j++)
                instance.writePixel(i, j, Color.WHITE);
        for(int i=0; i<500 ; i++)
            for(int j=0;j<500; j+=50)
                instance.writePixel(i, j, Color.WHITE);
        instance.writeToimage();
	}
	@Test
	public void writePixelTest2() {
		System.out.println("writeToimage");
        ImageWriter instance = new ImageWriter("ImageWrither2", 500, 500, 50, 50);
        for(int i=0; i<500 ;i++)
            for(int j=i;j<500;j++)
            {
                    instance.writePixel(i, j, Color.GREEN);
            }  
          instance.writeToimage();
	}
	@Test
	public void writePixelTest3() {
	      System.out.println("writeToimage");
	        ImageWriter instance = new ImageWriter("ImageWrither3", 500, 500, 50, 50);
	        for(int i=0; i<500 ;i++)
	            for(int j=i;j<500-i;j++)
	            {
	                    instance.writePixel(i, j, Color.pink);
	            }  
	     
	          instance.writeToimage();
	}

}
