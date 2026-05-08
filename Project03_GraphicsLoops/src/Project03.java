import java.awt.Color;

public class ImageWorker {
	public static void main(String[] args) {
		String path = "newyork2.jpg";
		Picture a = new Picture(path);
		Picture a_1 = ImageWorker.radialBlur(a, 0.02, 10, 800, 400);
		a_1.show();
	}
	public static Picture setAllRed(Picture p, int red) {
		Picture output = new Picture(p);
		int neww = output.height();
		int newh = output.width();
		for (int y = 0; y < neww; y++) {
			for (int x = 0; x < newh; x++) {
				Color c = output.get(x, y);
				Color newC = new Color(red, c.getGreen(), c.getBlue());
				output.set(x, y, newC);
			}
		}
		return output;
	}
	public static Picture setAllGreen(Picture p, int g) {
		Picture output = new Picture(p);
		int height = output.height();
		int width = output.width();
		for (int i_1 = 0; i_1 < height; i_1++) {
			for (int i = 0; i < width; i++) {
				Color c = p.get(i, i_1);
				Color newC = new Color(c.getRed(),g,c.getBlue());
				output.set(i, i_1, newC);
			}
		}
		return output;
	}
	public static Picture setAllBlue(Picture p, int b) {
		Picture output = new Picture(p);
		int height = output.height();
		int width = output.width();
		for (int i_1 = 0; i_1 < height; i_1++) {
			for (int i = 0; i < width; i++) {
				Color c = p.get(i, i_1);
				Color newC = new Color(c.getRed(),c.getGreen(),b);
				output.set(i, i_1, newC);
			}
		}
		return output;
	}
	public static Picture makeGrayscale(Picture p) {
		Picture output = new Picture(p);
		int height = output.height();
		int width = output.width();
;		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				Color c = output.get(x, y);
				int red = c.getRed();
				int green = c.getGreen();
				int blue = c.getBlue();
				int gray = (red + green + blue) / 3;
				Color ngray = new Color(gray, gray, gray);
				output.set(x, y, ngray);
			}
		}
	return output;
	}
	public static Picture makeLuminosity(Picture p) {
		Picture output = new Picture(p);
		int height = output.height();
		int width = output.width();
;		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				Color c = output.get(x, y);
				int red = c.getRed();
				int green = c.getGreen();
				int blue = c.getBlue();
				double nred = 0.21 * red;
				double ngreen = 0.72 * green;
				double nblue = 0.07 * blue;
				int n_1red = (int) Math.round(nred);
				int n_1green = (int) Math.round(ngreen);
				int n_1blue = (int) Math.round(nblue);
				Color ncolor = new Color(n_1red, n_1green, n_1blue);
				output.set(x, y, ncolor);
			}
		}
	return output;
	}
	public static Picture makeNegative(Picture p) {
		Picture output = new Picture(p);
		int height = output.height();
		int width = output.width();
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				Color c = output.get(x,  y);
				int red = c.getRed();
				int green = c.getGreen();
				int blue = c.getBlue();
				int newred = 255 - red;
				int newgreen  = 255 - green;
				int newblue = 255 - blue;
				Color ncolor = new Color(newred,newgreen,newblue);
				output.set(x,  y, ncolor);
			}
		}
		return output;
	}
	public static Picture reverseOnX(Picture p) {
		Picture output = new Picture(p);
		for (int y = 0; y < p.height(); y++) {
			for (int x = 0; x < p.width(); x++) {
				int newx = p.width() - 1 - x;
				Color c = p.get(newx, y);
				output.set(x, y, c);
			}
		}
		return output;
	}
	public static Picture reverseOnY(Picture p) {
		Picture output = new Picture(p);
		for (int y = 0; y < p.height(); y++) {
			for (int x = 0; x < p.width(); x++) {
				int newy = p.height() - 1 - y;
				Color c = p.get(x, newy);
				output.set(x, y, c);
			}
		}
		return output;
	}
	public static Picture mirrorOnX(Picture p) {
		Picture output = new Picture(p);
		for (int y = 0; y < p.height(); y++) {
			for (int x = 0; x < p.width(); x++) {
				int newx = p.width() - 1 - x;
				Color c = output.get(newx, y);
				output.set(x, y, c);
			}
		}
		return output;
	}
	public static Picture mirrorOnY(Picture p) {
		Picture output = new Picture(p);
		for (int y = 0; y < p.height(); y++) {
			for (int x = 0; x < p.width(); x++) {
				int newy = p.height() - 1 - y;
				Color c = output.get(x, newy);
				output.set(x, y, c);
			}
		}
		return output;
	}
	public static Picture mirrorOnDiag(Picture p) {
		Picture output = new Picture(p);
		for (int y = 0; y < (p.height() - 1); y++) {
			for (int x = 0; x < (p.width() - 1); x++) {
				Color c = output.get(x, y);
				output.set(y, x, c);
				}
		   }
		return output;
	}
	public static Picture averagePictures(Picture a, Picture b) {
		Picture c = new Picture(a);
		//define arrays w/ color data on each pixel and average those, return the answer
		for (int y = 0; y < a.height(); y++) {
			for (int x = 0; x < a.height(); x++) {
				Color a_1 = a.get(x, y);
				Color b_1 = b.get(x, y);
				int aRed = a_1.getRed();
				int bRed = b_1.getRed();
				int aGreen = a_1.getGreen();
				int bGreen = b_1.getGreen();
				int aBlue = a_1.getBlue();
				int bBlue = b_1.getBlue();
				int avgRed = (int) Math.round((aRed + bRed) / 2);
				int avgGreen = (int) Math.round((aGreen + bGreen) / 2);
				int avgBlue = (int) Math.round((aBlue + bBlue) / 2);
				Color ColorC = new Color(avgRed, avgGreen, avgBlue);
				c.set(x, y, ColorC);
				
			}
		}
		return c;
	}
	public static void placePicture(Picture p, Picture canvas, int firstx, int firsty) {
		int x = (int) Math.round(firstx);
		int y = (int) Math.round(firsty);
		for (int r = 0; r < p.height(); r++) {
			for (int c = 0; c < p.width(); c++) {
				int dx = c + x;
				int dy = r + y;
				Color pS = p.get(c, r);
				canvas.set(dx,dy,pS);
			}
		}
	}
	/**
	 * Applies a radial blur function calculated by summing up 	 from i=0 to n-1 and multiplying that by n^-1.
	 * @param P = pixel coordinates on which the loop is being activated on
	 * @param s = the weight (how close the blur is to center) of the final blur
	 * @param n = number of times you want the program to sample. the more the blurrier and higher quality.
	 * @param c_x = x coordinate of center of which the blur is being activated by
	 * @param c_y = y coordinate of center of which the blur is being activated by 
	 */
	public static Picture radialBlur(Picture p, double s, int n, int c_x, int c_y) {
		Picture output = new Picture(p);
		//
		for (int y = 0; y < p.height(); y++) {
			for (int x = 0; x < p.width(); x++) {
				//
				int dx = x - c_x;
				int dy = y - c_y;
				double d = Math.pow(dx*dx+dy*dy,(1.0/2.0));
				//
				if (d == 0) {
					continue;
				}
				else {
					double u_x = dx/d;
					double u_y = dy/d;
					double l = s * d;
					//
					int totalred = 0;
					int totalgreen = 0;
					int totalblue = 0;
					for (int k = 0; k <= n; k++) {
						if (n == 1) {
						double t_k = -l + k * ((2.0*l)/(1.0));
						double sx = x + t_k * u_x;
						double sy = y + t_k * u_y;
						double newsy = Math.max(0, Math.min(p.height() - 1, sy));
						double newsx = Math.max(0, Math.min(p.width() - 1, sx));
						int rsx = (int) Math.round(newsx);
						int rsy = (int) Math.round(newsy);
						Color a = p.get(rsx, rsy);
						int rval = a.getRed();
						int gval = a.getGreen();
						int bval = a.getBlue();
						totalred += rval;
						totalgreen += gval;
						totalblue += bval;	
						}
						else {
							double t_k = -l + k * ((2.0*l)/(n-1.0));
							double sx = x + t_k * u_x;
							double sy = y + t_k * u_y;
							double newsy = Math.max(0, Math.min(p.height() - 1, sy));
							double newsx = Math.max(0, Math.min(p.width() - 1, sx));
							int rsx = (int) Math.round(newsx);
							int rsy = (int) Math.round(newsy);
							Color a = p.get(rsx, rsy);
							int rval = a.getRed();
							int gval = a.getGreen();
							int bval = a.getBlue();
							totalred += rval;
							totalgreen += gval;
							totalblue += bval;	
						}
					}
					double Finalr = Math.max(0, Math.min(255, (totalred/(n+1.0))));
					double Finalg = Math.max(0, Math.min(255, (totalgreen/(n+1.0))));
					double Finalb = Math.max(0, Math.min(255, (totalblue/(n+1.0))));
					int finalr = (int) Math.round(Finalr);
					int finalg = (int) Math.round(Finalg);
					int finalb = (int) Math.round(Finalb);
					Color finalColor = new Color(finalr, finalg, finalb);
					output.set(x, y, finalColor);
				}
				
			}
		}
		return output;
	}
	/**Applies a "vivid cool" transformation to the picture so that it is slightly tinted blue.
	 * @param p - the picture
	 * @param s - how blue the image will be
	 */
	public static Picture vividCool(Picture p, double s) {
		Picture output = new Picture(p);
		for (int y = 0; y < p.height(); y++) {
			for (int x = 0; x < p.width(); x++) {
				//
				Color pic = p.get(x, y);
				int r = pic.getRed();
				int g = pic.getGreen();
				int b = pic.getBlue();
				double luma = 0.299 * r + 0.587 * g + 0.114 * b;
				//
				double newr = luma + s * (r - luma);
				double newg = luma + s * (g - luma);
				double newb = luma + s * (b - luma);
				//
				double cr = 0.9 * newr - 5;
				double cg = newg;
				double cb = 1.2 * newb + 5;
				//
				double Finalr = Math.max(0, Math.min(255, cr));
				double Finalg = Math.max(0, Math.min(255, cg));
				double Finalb = Math.max(0, Math.min(255, cb));
				//
				int finalr = (int) Math.round(Finalr);
				int finalg = (int) Math.round(Finalg);
				int finalb = (int) Math.round(Finalb);
				//
				Color finalColor = new Color(finalr, finalg, finalb);
				output.set(x, y, finalColor);
			}
		}
		return output;
	} 

	/**Applies a blur to a picture by looking at "neighbor pixels" and averages/mixes their colors based on the gaussian distribution.
	 * Formula: (tau*sigma^2)^-1 * exp(-(neighborpixeldistanceXaxis^2 + neighborpixeldistanceYaxis^2)/(2*sigma^2))
	 * @param p - picture
	 * @param sigma - how blurred the picture is
	 */
	public static Picture gaussianBlur(Picture p, int sigma) {
		Picture output = new Picture(p);
		int radius = sigma*3;
		for (int y = 0; y < p.height(); y++) {
			for (int x = 0; x < p.width(); x++) {
				//
				double totalR = 0;
				double totalG = 0;
				double totalB = 0;
				double totalW = 0;
				//
				for (int dx = -radius; dx <= radius; dx++) {
					for (int dy = -radius; dy <= radius; dy++) {
						//
						int tX = x + dx;
						int tY = y + dy;
						int cX = Math.max(0, Math.min(tX, p.width() - 1));
						int cY = Math.max(0, Math.min(tY, p.height() - 1));
						//
						double gWeight = ((1.0)/(Math.TAU*sigma*sigma))*Math.exp(-(dx*dx+dy*dy)/(2*sigma*sigma));
						Color a = p.get(cX, cY);
						int r = a.getRed();
						int g = a.getGreen();
						int b = a.getBlue();
						//
						double newr = r * gWeight;
						double newg = g * gWeight;
						double newb = b * gWeight;
						//
						totalW += gWeight;
						totalR += newr;
						totalG += newg;
						totalB += newb;
							}
						}	
					int newrk = (int) Math.round(totalR/totalW);
					int newgk = (int) Math.round(totalG/totalW);
					int newbk = (int) Math.round(totalB/totalW);
					//
					Color finalColor = new Color(newrk, newgk, newbk);
					output.set(x, y, finalColor);
					}
				}
		return output;
	}
}
