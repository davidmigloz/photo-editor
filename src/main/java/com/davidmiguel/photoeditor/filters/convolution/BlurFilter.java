package com.davidmiguel.photoeditor.filters.convolution;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.scene.image.Image;

/**
 * Blur convolution filter. 
 * value < 5  -> kernel 3x3 
 * value >= 5 -> kernel 5x5
 * http://pippin.gimp.org/image_processing/chap_area.html#id2559765
 */
public class BlurFilter extends ConvolutionFilter {

	private final Logger logger = LoggerFactory.getLogger(getClass().getName());

	private final static double OFFSET = 0;
	private final static double DIVISOR3 = 9;
	private final static double DIVISOR5 = 25;
	private final static double[][] KERNEL3 = {{ 1, 1, 1 }, 
											   { 1, 1, 1 },
											   { 1, 1, 1 }};
	private final static double[][] KERNEL5 = {{ 1, 1, 1, 1, 1 },
											   { 1, 1, 1, 1, 1 }, 
											   { 1, 1, 1, 1, 1 }, 
											   { 1, 1, 1, 1, 1 },
											   { 1, 1, 1, 1, 1 }};

	public BlurFilter(int value) {
		super(value < 5 ? KERNEL3 : KERNEL5,
			  value < 5 ? DIVISOR3 : DIVISOR5,
			  OFFSET);
	}

	@Override
	public Image apply(Image input) {
		logger.info("Apply BlurFilter");
		return super.apply(input);
	}
}