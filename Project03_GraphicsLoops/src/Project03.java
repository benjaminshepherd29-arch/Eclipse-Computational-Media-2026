/*
 * 
 * Project 03: For Loops, Conditionals, Methods for Graphics
 * 
 * @author Ben Shepherd
 */
public class Project04 {
	public static void main(String[] args) {
		setup(600, 400);
		makeVerticalGradient(10);
		
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
	 * Creates a row of n squares starting at position x, y	with size n.
	 * This is a demonstration of using for loops to create drawing objects.
	 * @parameters x,y,n,size
	 */
		 public static void makeRowSquares(int x, int y,int n, int size) {
			 for (int i = 0; i < n; i++) {
				 int x_n = (i * size) + (size / 2) + x;
				 StdDraw.setPenColor(0, 0, 0);
				 if (i % 2 == 0) {
					 StdDraw.filledSquare(x_n, y, (size / 2));
				 }
				 else {
				 StdDraw.square(x_n, y, (size / 2));
				 }
			 }
		 }
		 public static void makeVerticalGradient(int n) {
			 int width = 600;
			 int height = 400;
			 int dColor = 255 / n;
			 int dx = width / n;
			 int sx = dx / 2;
			 int sy = height / 2;
			 for (int i = 0; i < n; i++) {
				 int nx = sx + i * dx;
				 int ny = sy;
				 int ncolor = i * dColor;
				 StdDraw.setPenColor(0, ncolor, 0);
				 StdDraw.filledRectangle(nx, ny, sx, sy);
			 }
			
		 }
		 public static void makeHorizontalGradient(int n) {
			 int width = 600;
			 int height = 400;
			 int dColor = 255 / n;
			 int deltay = height / n;
			 int startx = width / 2;
			 int starty = deltay / 2;
			 for (int i = 0; i < n; i++) {
				 int newx = startx;
				 int newy = starty + i * deltay;
				 int ncolor = i * dColor;
				 StdDraw.setPenColor(0, ncolor, 0);
				 StdDraw.filledRectangle(newx, newy, startx, deltay / 2);
			 }
			
		 }
		 public static void makeGradient(int n) {
			 int width = 600;
			 int height = 400;
			 int r = 400;
			 int dColor = 255 / n;
			 int dRadius = 600 / n;
			 for (int i = 0; i < n; i++) {
				 int deltaw = 600 / n;
				 int ncolor = i * dColor;
				 StdDraw.setPenColor(0, ncolor, 0);
				 StdDraw.filledCircle(300, 200, (r - (i - 1) * deltaw));
			 }
		 }
		 
		 
		 
		 /*
		  * int i_1 = # row
		  * int n = # of squares
		  * int size = size of square in pixels
		  * program auto cuts off if n is odd for squares
		  */
		 public static void makeCheckers(int n, int size) {
			 //row repeater
			 for (int i_1 = 0; i_1 < n; i_1++) {
				 //y pos for each column depending on the column the loop is on
				 int y_n = size * i_1 + (size / 2);
				 //loop if row is even (black squares first)
				 if (i_1 % 2 == 0) {
					 for (int i = 0; i < n; i++) {
					 	int x = 0;
					 	int y = 0;
					 	int x_n = (i * size) + (size / 2) + x;
					 	StdDraw.setPenColor(0, 0, 0);
					 	if (i % 2 == 0) {
						 StdDraw.filledSquare(x_n, y_n, (size / 2));
					    }
					 	else {
					 		StdDraw.square(x_n, y_n, (size / 2));
					 	}
				 	}
				 }
				 //loop if row is odd(white squares first)
				 else {
					 for (int i = 0; i < n; i++) {
						 	int x = 0;
						 	int y = 0;
						 	int x_n = (i * size) + (size / 2) + x;
						 	StdDraw.setPenColor(0, 0, 0);
						 	if (i % 2 == 0) {
							 StdDraw.square(x_n, y_n, (size / 2));
						 }
						 	else {
						 	StdDraw.filledSquare(x_n, y_n, (size / 2));
		
     }				 
    }		 	 			
   }
  }		 
 }
		 public static void makePyramid(int n, int size) {
			//row repeater
			 for (int i_1 = 0; i_1 < n; i_1++) {
				 //y pos for each column depending on the column the loop is on
				 int y_n = size * i_1 + (size / 2);
				 int newn = n - i_1;
				 //loop if row is even (black squares first)
				 if (i_1 % 2 == 0) {
					 for (int i = 0; i < newn; i++) {
					 	int x = 0;
					 	int y = 0;
					 	int x_n = (i * size) + (size / 2) + x;
					 	StdDraw.setPenColor(0, 0, 0);
					 	if (i % 2 == 0) {
						 StdDraw.filledSquare(x_n, y_n, (size / 2));
					    }
					 	else {
					 		StdDraw.square(x_n, y_n, (size / 2));
					 	}
				 	}
				 }
				 //loop if row is odd(white squares first)
				 else {
					 for (int i = 0; i < newn; i++) {
						 	int x = 0;
						 	int y = 0;
						 	int x_n = (i * size) + (size / 2) + x;
						 	StdDraw.setPenColor(0, 0, 0);
						 	if (i % 2 == 0) {
							 StdDraw.square(x_n, y_n, (size / 2));
						 }
						 	else {
						 	StdDraw.filledSquare(x_n, y_n, (size / 2));
		            }
              }
			}
		}
	}
}


		 
							 
						 

