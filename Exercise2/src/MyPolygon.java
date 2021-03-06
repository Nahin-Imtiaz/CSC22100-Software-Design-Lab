import javafx.scene.canvas.GraphicsContext;
/**
 * @author Nahin Imtiaz
 *		email: nimtiaz000@citymail.cuny.edu
 *		CCNY ID : 23556198
 *
 *Class MyPolygon inherits class MyShape. The MyPolygon object is a regular polygon defined by the integer parameter, N� the number of the polygon�s equal side lengths and equal interior angles, and the radius, r, in which it is inscribed. The MyPolygon object may be filled with a color.
 */
public class MyPolygon extends MyShape{
	int number;
	double radius;
	/**
	 * this constructor is used to create a MyPolygon Object with parameters
	 * @param number
	 * this is the number of sides of the MyPolygon shape
	 * @param radius
	 * this is the radius of the MyPolygon shape
	 * @param color
	 * this is the color of the MyPolygon shape
	 */
	MyPolygon (int number,double radius,MyColor color){
		super(color);
		this.number=number;
		this.radius=radius;
	}
	/**
	 * this method returns the area of the MyPolygon object
	 * @return double
	 */
	public double getArea() {
		//equation of area given inscribed radius
		double area = ((Math.pow(radius, 2))*number* Math.tan(180/number));
		return area;
	}
	/**
	 * this method returns the perimeter of the MyPolygon object
	 * @return double
	 */
	public double getPerimeter() {
			return number*getSide();
	}
	/**
	 * this method returns the interior angle (in degrees) of the MyPolygon object
	 * @return double
	 */
	public double getAngle() {
		int sum_of_angles = (number-2)*180;
		return sum_of_angles/number;
	}
	/**
	 * this method returns the side length of the MyPolygon object
	 * @return double
	 */
	public double getSide() {
		//equation of side given inscribed radius
		double side = 2*radius* Math.tan(180/number); 
		return side;
	}
	/**
	 * this method returns a string representation of the MyPolygon object: side length, interior angle, perimeter, and area
	 */
	@Override
	public String toString() {
		return String.format(getSide()+""+getAngle()+""+getPerimeter()+""+getAngle());
	}
	/**
	 * this method draws a MyPolygon object whose center point (x, y) is defined in class MyShape and inscribed in a circle of radius r. 
	 */
	@Override
	public void draw(GraphicsContext gc) {
		// Coordinators of each vertex cetered at X and Y
		double[] x = new double [number];
		double[] y = new double [number];
		for (int i = 0; i < number; i++) {
			// equation for coordinators -> X+ circumscribed radius*(sin0/n),Y+radius*(cos0/n)  
			 x[i]= MyPoint.point[0] + ((getSide()/(2*Math.tan(180/number))) * Math.cos(2*Math.PI*i/number));
			 y[i]= MyPoint.point[1] + ((getSide()/(2*Math.tan(180/number))) * Math.sin(2*Math.PI*i/number));
			}
		gc.setFill(this.color.getColor());
		gc.fillPolygon(x, y, number);
	}
	/**
	 * this method returns bounding box MyRectangle of this MyPolygon object
	 */
	@Override
	public MyRectangle getMyBoundingBox() {
		MyPoint.setPoint(this.point[0]-radius, this.point[1]-radius);
		MyRectangle boundingBox = new MyRectangle(2*radius,2*radius,this.color);
		return boundingBox;
	}
	
}