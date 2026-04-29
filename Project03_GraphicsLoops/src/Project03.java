/*
 * 
 * Project 03: For Loops, Conditionals, Methods for Graphics
 * 
 * @author Ben Shepherd
 */
public class Project03 {
	public static void main(String[] args) {
		
		
	}
	/*
	 * Build the StdLib Canvas with inputs of parameters width and height
	 * @param width, height
	 */
		public static void setup(int width, int height) {
		 StdDraw.setCanvasSize(width, height);
		 StdDraw.setXscale(0, width);
		 StdDraw.setYscale(height, 0);
		 StdDraw.show();
		}
	/*
	 * makes a checkerboard with n*n squares with size being dimensions in terms of squares in pixels
	 * @parameters n, size 
	 */
		 public static void makeCheckers(int n, int size) {
			 for (int i = 0; i < n; i++) {
				 
				 for (int i = 0; i < (n / 2); i++) {
				 StdDraw.setPenColor(0, 0, 0);
				 StdDraw.filledSquare(0, 0,(size / 2)); 
				 StdDraw.setPenColor(255, 255, 255);
				 StdDraw.filledSquare(((3 / 2) * size), 0, (size / 2));
				 }
			 }
		 }
	
}
