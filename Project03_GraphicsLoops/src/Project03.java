import java.awt.Color;

public class ImageWorker {
	public static void main(String[] args) {
		String path = "newyork2.jpg";
		Picture a = new Picture(path);
		Picture a_1 = ImageWorker.mirrorOnDiag(a);
		//String fileName = "reversedxnewyork2.jpg";
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
				return c;
			}
		}
	}
}
