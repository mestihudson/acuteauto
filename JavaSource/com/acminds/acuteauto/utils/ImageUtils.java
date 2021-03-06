/**
 * 
 */
package com.acminds.acuteauto.utils;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author Mansur
 * 
 */
public class ImageUtils {
	
	public static byte[] toByteArray(BufferedImage img) throws IOException {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
	    ImageIO.write(img, "jpg", buffer);
	    return buffer.toByteArray();		
	}
	
	public static int getScaledHeight(BufferedImage img, int width) {
		double imageRatio = (double)img.getWidth() / (double)img.getHeight();
	    return (int)(width / imageRatio);
	}
	
	
	/**
     * Convenience method that returns a scaled instance of the
     * provided {@code BufferedImage}.
     *
     * @param img the original image to be scaled
     * @param targetWidth the desired width of the scaled instance,
     *    in pixels
     * @param targetHeight the desired height of the scaled instance,
     *    in pixels
     * @param hint one of the rendering hints that corresponds to
     *    {@code RenderingHints.KEY_INTERPOLATION} (e.g.
     *    {@code RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR},
     *    {@code RenderingHints.VALUE_INTERPOLATION_BILINEAR},
     *    {@code RenderingHints.VALUE_INTERPOLATION_BICUBIC})
     * @param higherQuality if true, this method will use a multi-step
     *    scaling technique that provides higher quality than the usual
     *    one-step technique (only useful in down-scaling cases, where
     *    {@code targetWidth} or {@code targetHeight} is
     *    smaller than the original dimensions, and generally only when
     *    the {@code BILINEAR} hint is specified)
     * @return a scaled version of the original {@code BufferedImage}
	 * @throws IOException 
     */
    public static byte[] reScaleMultiStep(byte[] fileData, int width) throws IOException
    {
		BufferedImage img = ImageIO.read(new ByteArrayInputStream(fileData));
        int type = (img.getTransparency() == Transparency.OPAQUE) ?
            BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
        BufferedImage ret = (BufferedImage)img;
        // Calculate scaled height based on width.
       double imageRatio = (double)img.getWidth() / (double)img.getHeight();
       int height = (int)(width / imageRatio);
        int w, h;
        if (true) {
            // Use multi-step technique: start with original size, then
            // scale down in multiple passes with drawImage()
            // until the target size is reached
            w = img.getWidth();
            h = img.getHeight();
        } do {        	 
        	if (true && w > width) {
                w /= 2;
                if (w < width) {
                    w = width;
                }
            }
            if (true && h > height) {
                h /= 2;
                if (h < height) {
                    h = height;
                }
            }
            BufferedImage tmp = new BufferedImage(w, h, type);
            Graphics2D g2 = tmp.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
            g2.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
            g2.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);	            
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.drawImage(ret, 0, 0, w, h, null);
            g2.dispose();

            ret = tmp;
        } while (w != width || h != height);
        return toByteArray(ret);    	
    }

	/**
	 * This approach uses a special "trilinear mipmapping" technique
	 * written by Jim Graham. Some developers may find the visual quality
	 * provided by this technique to be similar to SCALE_AREA_AVERAGING, but at
	 * a fraction of the performance cost (although visually slightly "fuzzier"
	 * perhaps).
	 * @throws IOException 
	 */
	public static byte[] reScaleTrilinear(byte[] fileData, int targetWidth, int targetHeight) throws IOException {
		// REMIND: This only works for opaque images...
		BufferedImage img = ImageIO.read(new ByteArrayInputStream(fileData));
		// Use multi-step technique: start with original size, then
		// scale down in multiple passes with drawImage()
		// until the target size is reached
		int iw = img.getWidth();
		int ih = img.getHeight();

		Object hint = RenderingHints.VALUE_INTERPOLATION_BILINEAR;
		int type = (img.getTransparency() == Transparency.OPAQUE) ? BufferedImage.TYPE_INT_RGB
				: BufferedImage.TYPE_INT_ARGB;

		// First get down to no more than 2x in W & H
		while (iw > targetWidth * 2 || ih > targetHeight * 2) {
			iw = (iw > targetWidth * 2) ? iw / 2 : iw;
			ih = (ih > targetHeight * 2) ? ih / 2 : ih;
			img = scaleImage(img, type, hint, iw, ih);
		}

		// REMIND: Conservative approach:
		// first get W right, then worry about H

		// If still too wide - do a horizontal trilinear blend
		// of img and a half-width img
		if (iw > targetWidth) {
			int iw2 = iw / 2;
			BufferedImage img2 = scaleImage(img, type, hint, iw2, ih);
			if (iw2 < targetWidth) {
				img = scaleImage(img, type, hint, targetWidth, ih);
				img2 = scaleImage(img2, type, hint, targetWidth, ih);
				interp(img2, img, iw - targetWidth, targetWidth - iw2);
			}
			img = img2;
			iw = targetWidth;
		}
		// iw should now be targetWidth or smaller

		// If still too tall - do a vertical trilinear blend
		// of img and a half-height img
		if (ih > targetHeight) {
			int ih2 = ih / 2;
			BufferedImage img2 = scaleImage(img, type, hint, iw, ih2);
			if (ih2 < targetHeight) {
				img = scaleImage(img, type, hint, iw, targetHeight);
				img2 = scaleImage(img2, type, hint, iw, targetHeight);
				interp(img2, img, ih - targetHeight, targetHeight - ih2);
			}
			img = img2;
			ih = targetHeight;
		}
		// ih should now be targetHeight or smaller

		// If we are too small, then it was probably because one of
		// the dimensions was too small from the start.
		/*if (iw < targetWidth && ih < targetHeight) {
			img = scaleImage(img, type, hint, targetWidth, targetHeight);
		}*/
		return toByteArray(img);		
	}

	private static BufferedImage scaleImage(BufferedImage orig, int type, Object hint,
			int w, int h) {
		BufferedImage tmp = new BufferedImage(w, h, type);
		Graphics2D g2 = tmp.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, hint);
		g2.drawImage(orig, 0, 0, w, h, null);
		g2.dispose();
		return tmp;
	}

	private static void interp(BufferedImage img1, BufferedImage img2, int weight1,
			int weight2) {
		float alpha = weight1;
		alpha /= (weight1 + weight2);
		Graphics2D g2 = img1.createGraphics();
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
				alpha));
		g2.drawImage(img2, 0, 0, null);
		g2.dispose();
	}

}
