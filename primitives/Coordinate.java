package primitives;
public class Coordinate
{
	protected double coordinate;
	// ***************** Constructors ********************** // 
	public Coordinate() 
	{
		this.coordinate = 0.0D;
	}
	public Coordinate(double coordinate)
	{
		this.coordinate = coordinate;
	}

	public Coordinate(Coordinate other) 
	{
		this.coordinate = other.coordinate;
	}
	// ***************** Getters/Setters ********************** // 
	public double getCoordinate()
	{
		return this.coordinate;
	}
	public void setCoordinate(double coordinate)
	{
		this.coordinate = coordinate;
	}
	// ***************** Administration  ******************** // 
	@Override
	public String toString()
	{
		return "" + this.coordinate;
	}
	public boolean equals(Object obj)
	{
		if (this == obj) {
			return true;
		} else if (obj == null) {
			return false;
		} else if (this.getClass() != obj.getClass()) {
			return false;
		} else {
			Coordinate other = (Coordinate) obj;
			return this.coordinate == other.coordinate;
		}
	}
	// ***************** Operations ******************** // 
	public Coordinate add(Coordinate c)
	{
		double x = this.coordinate + c.coordinate;
		return new Coordinate(x);
	}

	public Coordinate Substrct (Coordinate c)
    {
		double x = this.coordinate - c.coordinate;
		return new Coordinate(x);
	}
	public Coordinate mult (Coordinate c)
	{
			double x = this.coordinate * c.coordinate;
			return new Coordinate(x);
	}
	
}