/**
 * @author Nahin Imtiaz
 *		email: nimtiaz000@citymail.cuny.edu
 *		CCNY ID : 23556198
 *
 *Interface MyPoint  describe the positional functions and behaviors of the specific object types of
 *the class hierarchy
 */
public interface MyPoint {
	
	double[] point= new double[2];
	/**
	 * this method returns the point x and y
	 * @return
	 */
	public static double[] getPoint() {
		return point;
	}
	/**this method sets the point x and y
	 * this method
	 * @param x
	 * this is the x point of the object
	 * @param y
	 * this is the y point of the object
	 */
	public static void setPoint(double x,double y) {
		point[0]=x;
		point[1]=y;
	}
	/**
	 * this method  moves point (x, y) to point (x + dx, y + dy)
	 * @param x
	 * this is the x of the new point
	 * @param y
	 * this is the y of the new point
	 */
	public static void moveTo(double x,double y) {
		//new x =x-dx
		point[0]=point[0]+(x-point[0]);
		point[1]=point[1]+(y-point[1]);
	}
	/**
	 *  this method returns distance from point (x, y) to a point; 
	 * @param x2
	 * this is the x of second point
	 * @param y2
	 * this is the y of second point
	 * @return
	 */
	public static double distanceTo(double x2,double y2) {
		//equation of distance between two points
		double d= Math.sqrt(Math.pow((x2-point[0]),2)+Math.pow((y2-point[1]),2));
		return d;
	}
}
