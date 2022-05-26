package Elements;

import java.awt.Color;

import primitives.*;

public interface LightSource 
{
    public Color getIntesity(Point3D p) ;
    public Vector getL(Point3D p);
}
