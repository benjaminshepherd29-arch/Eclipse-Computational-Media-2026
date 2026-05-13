import java.awt.Color;  
import java.util.Random;
/**
 * @author Ben Shepherd
 * 
 */
public class ImageWorker {
	public static void main(String[] args) {
		Picture a = new Picture("finalLA.jpg");
		Picture a_1 = repeatedCollage(a, 5, 2);
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
		for (int y = 0; y < p.height(); y++) {
			for (int x = 0; x < p.width(); x++) {
				Color c = output.get(x, y);
				output.set(y, x, c);
				}
		   }
		return output;
	}
	public static Picture averagePictures(Picture a, Picture b) {
		Picture c = new Picture(a);
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
				int newdx = Math.max(0, Math.min(canvas.width() - 1, dx));
				int newdy = Math.max(0, Math.min(canvas.height() - 1, dy));
				canvas.set(newdx,newdy,pS);
			}
		}
	}
	/**
	 * Applies a radial blur function
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
				double cr = 0.85 * newr - 8;
				double cg = newg;
				double cb = 1.3 * newb + 10;
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
		int radius = sigma;
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
	public static Picture imageResizer(Picture p, int nWidth, int nHeight) {
		Picture output = new Picture(nWidth, nHeight);
		double deltaX = p.width() * 1.0/nWidth;
		double deltaY = p.height() * 1.0/nHeight;
		for (int y = 0; y < output.height(); y++) {
			for (int x = 0; x < output.width(); x++) {
				int targetX = (int) (deltaX * x);
				int targetY = (int) (deltaY * y);
				Color c = p.get(targetX, targetY);
				output.set(x, y, c);
			}
		}
		return output;
	}
	public static Picture imageTurner90(Picture p) {
	Picture output = new Picture(p);
	for (int y = 0; y < p.height(); y++) {
		for (int x = 0; x < p.width(); x++) {
			Color a = p.get(x, y);
			output.set(y, x, a);
		}
	}
	return output;
	}
	public static Picture warmTint(Picture p) {	
		Picture output = new Picture(p);
		double roffset = 6;
		double goffset = 2;
		double boffset = -6;
		double s = 1.6;
		for (int y = 0; y < p.height(); y++) {
			for (int x = 0; x < p.width(); x++) {
				Color a = p.get(x,y);
				int r = a.getRed();
				int g = a.getGreen();
				int b = a.getBlue();
				double lum = 0.299 * r + 0.587 * g + 0.114 * b;
				double yr = lum + s * (r - lum) + roffset;
				double yg = lum + s * (g - lum) + goffset;
				double yb = lum + s * (b - lum) + boffset;
				double doublefinalr = Math.max(0, Math.min(yr, 255));
				double doublefinalg = Math.max(0, Math.min(yg, 255));
				double doublefinalb = Math.max(0, Math.min(yb, 255));
				int finalr = (int) Math.round(doublefinalr);
				int finalg = (int) Math.round(doublefinalg);
				int finalb = (int) Math.round(doublefinalb);
				Color finalColor = new Color(finalr, finalg, finalb);
				output.set(x, y, finalColor); 
			}
		}
		return output;
	}
	public static Picture forestTint(Picture p) {
		Picture output = new Picture(p);
		double roffset = -3;
		double goffset = 5;
		double boffset = -3;
		for (int y = 0; y < p.height(); y++) {
			for (int x = 0; x < p.width(); x++) {
				Color a = p.get(x, y);
				int fr = a.getRed();
				int fg = a.getGreen();
				int fb = a.getBlue();
				double nextr = 0.5 * fr + roffset;
				double nextg = 1.18 * fg + goffset;
				double nextb = 0.75 * fb + boffset;
				int finalr = (int) Math.round(Math.max(0, Math.min(nextr, 255)));
				int finalg = (int) Math.round(Math.max(0, Math.min(nextg, 255)));
				int finalb = (int) Math.round(Math.max(0, Math.min(nextb, 255)));
				Color finalColor = new Color(finalr, finalg, finalb);
				output.set(x, y, finalColor);
			}
		}
		return output;
	}
	public static Picture redTint(Picture p) {
		Picture output = new Picture(p);
		double roffset = 5;
		double goffset = -3;
		double boffset = -3;
		for (int y = 0; y < p.height(); y++) {
			for (int x = 0; x < p.width(); x++) {
				Color a = p.get(x, y);
				int fr = a.getRed();
				int fg = a.getGreen();
				int fb = a.getBlue();
				double nextr = 1.18 * fr + roffset;
				double nextg = 0.75 * fg + goffset;
				double nextb = 0.75 * fb + boffset;
				int finalr = (int) Math.round(Math.max(0, Math.min(nextr, 255)));
				int finalg = (int) Math.round(Math.max(0, Math.min(nextg, 255)));
				int finalb = (int) Math.round(Math.max(0, Math.min(nextb, 255)));
				Color finalColor = new Color(finalr, finalg, finalb);
				output.set(x, y, finalColor);
			}
		}
		return output;
	}
	public static Picture duotone(Picture p, int r1, int g1, int b1, int r2, int g2, int b2) {
		Picture output = new Picture(p);
		for (int x = 0; x < p.width(); x++) {
			for (int y = 0; y < p.height(); y++) {
				Color a = p.get(x, y);
				int r = a.getRed();
				int g = a.getGreen();
				int b = a.getBlue();
				double monolum = (0.299 * r + 0.587 * g + 0.114 * b)/(255.0);
				double rprime = monolum * r1 + (1 - monolum) * r2;	
				double gprime = monolum * g1 + (1 - monolum) * g2;	
				double bprime = monolum * b1 + (1 - monolum) * b2;
				int finalr = (int) Math.round(rprime);
				int finalg = (int) Math.round(gprime);
				int finalb = (int) Math.round(bprime);
				Color finalColor = new Color(finalr, finalg, finalb);
				output.set(x, y, finalColor);
			}
		}
		return output;
	}
	public static Picture seamCarve(Picture p) {
		Picture output = new Picture(p);
		int total = p.width();
		double[] totalpath = new double[total];
		for (int y = 0; y < p.height(); y++) {
			for (int x = 0; x < p.width(); x++) {
				if (x == 0 && y == 0)  {
					int pixenergy = 0;
					continue;
				}
				else if (x == 0) {
					//horizontal gradient
					Color a1 = p.get(Math.max(0, Math.min(p.width(), (x + 1))), Math.max(0, Math.min(p.height(), y - 1)));
					int r = a1.getRed();
					int g = a1.getGreen();
					int b = a1.getBlue();
					//
					Color a2 = p.get(Math.max(0, Math.min(p.width(), (x))), Math.max(0, Math.min(p.height(), y - 1)));
					int r1 = a2.getRed();
					int g1 = a2.getGreen();
					int b1 = a2.getBlue();
					//
					int horGradR = r - r1;
					int horGradG = g - g1;
					int horGradB = b - b1;
					double gradX = Math.pow((horGradR * horGradR + horGradG * horGradG + horGradB * horGradB), (1.0/2.0));
					//vertical gradient
					int vertGradR = r - r1;
					int vertGradG = g - g1;
					int vertGradB = b - b1;
					double gradY = Math.pow((vertGradR * vertGradR + vertGradG * vertGradG + vertGradB * vertGradB), (1.0/2.0));
					//
					double pixenergy = gradX * gradX + gradY * gradY;
				}
				else if (y == 0) {
					//horizontal gradient
					Color a1 = p.get(Math.max(0, Math.min(p.width(), (x + 1))), Math.max(0, Math.min(p.height(), y)));
					int r = a1.getRed();
					int g = a1.getGreen();
					int b = a1.getBlue();
					//
					Color a2 = p.get(Math.max(0, Math.min(p.width(), (x - 1))), Math.max(0, Math.min(p.height(), y)));
					int r1 = a2.getRed();
					int g1 = a2.getGreen();
					int b1 = a2.getBlue();
					//
					int horGradR = r - r1;
					int horGradG = g - g1;
					int horGradB = b - b1;
					double gradX = Math.pow((horGradR * horGradR + horGradG * horGradG + horGradB * horGradB), (1.0/2.0));
					//vertical gradient
					Color a3 = p.get(Math.max(0, Math.min(p.width(), (x))), Math.max(0, Math.min(p.height(), (y + 1))));
					int r2 = a3.getRed();
					int g2 = a3.getGreen();
					int b2 = a3.getBlue();
					//
					Color a4 = p.get(Math.max(0, Math.min(p.width(), (x))), Math.max(0, Math.min(p.height(), (y - 1))));
					int r3 = a4.getRed();
					int g3 = a4.getGreen();
					int b3 = a4.getBlue();
					//
					int vertGradR = r2 - r3;
					int vertGradG = g2 - g3;
					int vertGradB = b2 - b3;
					double gradY = Math.pow((vertGradR * vertGradR + vertGradG * vertGradG + vertGradB * vertGradB), (1.0/2.0));
					//
					double pixenergy = gradX * gradX + gradY * gradY;
				}
				else if (x == (p.width() - 1)) {
					//horizontal gradient
					Color a1 = p.get(Math.max(0, Math.min(p.width(), (x - 1))), Math.max(0, Math.min(p.height(), y - 1)));
					int r = a1.getRed();
					int g = a1.getGreen();
					int b = a1.getBlue();
					//
					Color a2 = p.get(Math.max(0, Math.min(p.width(), (x))), Math.max(0, Math.min(p.height(), y - 1)));
					int r1 = a2.getRed();
					int g1 = a2.getGreen();
					int b1 = a2.getBlue();
					//
					int horGradR = r - r1;
					int horGradG = g - g1;
					int horGradB = b - b1;
					double gradX = Math.pow((horGradR * horGradR + horGradG * horGradG + horGradB * horGradB), (1.0/2.0));
					//vertical gradient
					int vertGradR = r - r1;
					int vertGradG = g - g1;
					int vertGradB = b - b1;
					double gradY = Math.pow((vertGradR * vertGradR + vertGradG * vertGradG + vertGradB * vertGradB), (1.0/2.0));
					//
					double pixenergy = gradX * gradX + gradY * gradY;
				}
				else if (y == p.height() - 1) {
					//horizontal gradient
					Color a1 = p.get(Math.max(0, Math.min(p.width(), (x + 1))), Math.max(0, Math.min(p.height(), y)));
					int r = a1.getRed();
					int g = a1.getGreen();
					int b = a1.getBlue();
					//
					Color a2 = p.get(Math.max(0, Math.min(p.width(), (x - 1))), Math.max(0, Math.min(p.height(), y)));
					int r1 = a2.getRed();
					int g1 = a2.getGreen();
					int b1 = a2.getBlue();
					//
					int horGradR = r - r1;
					int horGradG = g - g1;
					int horGradB = b - b1;
					double gradX = Math.pow((horGradR * horGradR + horGradG * horGradG + horGradB * horGradB), (1.0/2.0));
					//vertical gradient
					Color a3 = p.get(Math.max(0, Math.min(p.width(), (x))), Math.max(0, Math.min(p.height(), (y + 1))));
					int r2 = a3.getRed();
					int g2 = a3.getGreen();
					int b2 = a3.getBlue();
					//
					Color a4 = p.get(Math.max(0, Math.min(p.width(), (x))), Math.max(0, Math.min(p.height(), (y - 1))));
					int r3 = a4.getRed();
					int g3 = a4.getGreen();
					int b3 = a4.getBlue();
					//
					int vertGradR = r2 - r3;
					int vertGradG = g2 - g3;
					int vertGradB = b2 - b3;
					double gradY = Math.pow((vertGradR * vertGradR + vertGradG * vertGradG + vertGradB * vertGradB), (1.0/2.0));
					//
					double pixenergy = gradX * gradX + gradY * gradY;
				}
				else if (x == p.width() - 1 && y == p.height() - 1) {
					//horizontal gradient
					Color a1 = p.get(p.width() - 2, p.height() - 2);
					int r = a1.getRed();
					int g = a1.getGreen();
					int b = a1.getBlue();
					//
					Color a2 = p.get(p.width() - 1, p.height() - 2);
					int r1 = a2.getRed();
					int g1 = a2.getGreen();
					int b1 = a2.getBlue();
					//
					int horGradR = r - r1;
					int horGradG = g - g1;
					int horGradB = b - b1;
					double gradX = Math.pow((horGradR * horGradR + horGradG * horGradG + horGradB * horGradB), (1.0/2.0));
					//vertical gradient
					Color a3 = p.get(Math.max(0, Math.min(p.width(), (x))), Math.max(0, Math.min(p.height(), (y + 1))));
					int r2 = a3.getRed();
					int g2 = a3.getGreen();
					int b2 = a3.getBlue();
					//
					Color a4 = p.get(Math.max(0, Math.min(p.width(), (x))), Math.max(0, Math.min(p.height(), (y - 1))));
					int r3 = a4.getRed();
					int g3 = a4.getGreen();
					int b3 = a4.getBlue();
					//
					int vertGradR = r2 - r3;
					int vertGradG = g2 - g3;
					int vertGradB = b2 - b3;
					double gradY = Math.pow((vertGradR * vertGradR + vertGradG * vertGradG + vertGradB * vertGradB), (1.0/2.0));
					//
					double pixenergy = gradX * gradX + gradY * gradY;
					pixenergy[]
				}
				else {
					//horizontal gradient
					Color a1 = p.get(Math.max(0, Math.min(p.width(), (x + 1))), Math.max(0, Math.min(p.height(), y)));
					int r = a1.getRed();
					int g = a1.getGreen();
					int b = a1.getBlue();
					//
					Color a2 = p.get(Math.max(0, Math.min(p.width(), (x - 1))), Math.max(0, Math.min(p.height(), y)));
					int r1 = a2.getRed();
					int g1 = a2.getGreen();
					int b1 = a2.getBlue();
					//
					int horGradR = r - r1;
					int horGradG = g - g1;
					int horGradB = b - b1;
					double gradX = Math.pow((horGradR * horGradR + horGradG * horGradG + horGradB * horGradB), (1.0/2.0));
					//vertical gradient
					Color a3 = p.get(Math.max(0, Math.min(p.width(), (x))), Math.max(0, Math.min(p.height(), (y + 1))));
					int r2 = a3.getRed();
					int g2 = a3.getGreen();
					int b2 = a3.getBlue();
					//
					Color a4 = p.get(Math.max(0, Math.min(p.width(), (x))), Math.max(0, Math.min(p.height(), (y - 1))));
					int r3 = a4.getRed();
					int g3 = a4.getGreen();
					int b3 = a4.getBlue();
					//
					int vertGradR = r2 - r3;
					int vertGradG = g2 - g3;
					int vertGradB = b2 - b3;
					double gradY = Math.pow((vertGradR * vertGradR + vertGradG * vertGradG + vertGradB * vertGradB), (1.0/2.0));
					//
					double pixenergy = gradX * gradX + gradY * gradY;
					pixenergy += totalpath[total];
					
				}
				
			}
		}
		return output;
	} 
	public static Picture bilateralFilter(Picture p) {
		int spatialsig = 3;
		int spatialrange = 20;
		int radius = 3 * spatialsig;
		Picture output = new Picture(p);
		for (int y = 0; y < p.height(); y++) {
			for (int x = 0; x < p.width(); x++) {
				Color a = p.get(x, y);
				int r = a.getRed();
				int g = a.getGreen();
				int b = a.getBlue();
				double totalr = 0;
				double totalg = 0;
				double totalb = 0;
				double totaltotalweight = 0;
				for (int dy = -radius; dy <= radius; dy++) {
					for (int dx = -radius; dx <= radius; dx++) {
						Color a1 = p.get(Math.max(0, Math.min(p.width() - 1, dx + x)), Math.max(0, Math.min(p.height() - 1, dy + y)));
						int r1 = a1.getRed();
						int g1 = a1.getGreen();
						int b1 = a1.getBlue();
						//
						int sqdist = dx * dx + dy * dy;
						//
						int dr = r - r1;
						int dg = g - g1;
						int db = b - b1;
						int sqcolor = dr * dr + dg * dg + db * db;
						//
						double totalweight = Math.exp(-((sqdist)/(2.0*spatialsig*spatialsig)) - (sqcolor)/(2.0*spatialrange*spatialrange));
						//
						totalr += totalweight * r1;
						totalg += totalweight * g1;
						totalb += totalweight * b1;
						totaltotalweight += totalweight;
					}
				}
				//
				if (totaltotalweight == 0) {
					output.set(x, y, a);
					continue;
				}
				else {
				int finalr = (int) Math.round(Math.max(0, Math.min(255, (totalr / totaltotalweight))));
				int finalg = (int) Math.round(Math.max(0, Math.min(255, (totalg / totaltotalweight))));
				int finalb = (int) Math.round(Math.max(0, Math.min(255, (totalb / totaltotalweight))));
				Color finalColor = new Color(finalr, finalg, finalb);
				output.set(x, y, finalColor);
				}
			}
		}
		return output;
	}
	/**@author Ben Shepherd
	 * returns a collage of one picture spread multiple times across a canvas depending on the number of rows and columns involved
	 * @param p - picture
	 * @param r - how many items in one row to be displayed
	 * @param c - how many columns
	 * @return
	 */
	public static Picture repeatedCollage(Picture p, int r, int c) {
		Picture output = new Picture(p.width() * r, p.height() * c);
		for (int cindex = 0; cindex < c; cindex++) {
			for (int index = 0; index < r; index++) {
				for (int y = 0; y < p.height(); y++) {
					for (int x = 0; x < p.width(); x++) {
						Color a = p.get(x, y);
							output.set(x + index * p.width(), y + cindex * p.height(), a);
					}
				}
			}
		}
			return output;
	}
	public static Picture randomAlpha(Picture p) {
		Picture output = new Picture(p);
		for (int y = 0; y < p.height(); y++) {
			for (int x = 0; x < p.width(); x++) {
				 Color z = p.get(x, y);
				 int r = z.getRed();
				 int g = z.getGreen();
				 int b = z.getBlue();
				 Random rand = new Random();
				 int newa = rand.nextInt(256);
				 Color finalColor = new Color(r, g, b, newa);
				 output.set(x, y, finalColor);
			}
		}
		return output;
	}
	public static int forlooppractice() {
		int output = 0;
		for (int i = 100; i < 201; i++) {
			output+=i;
		}
		return output;
	}
}	
