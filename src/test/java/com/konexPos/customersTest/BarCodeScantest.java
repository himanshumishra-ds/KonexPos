package com.konexPos.customersTest;

import java.awt.image.BufferedImage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.konex.commonUtils.BaseClass;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import javax.imageio.ImageIO;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BarCodeScantest extends BaseClass{
	


	@Test(groups= {"regression"})  
	public void barCodeScan() throws Throwable {
		
		
		
		        try {
		            File file = new File("F:\\OCM\\OCMWORKSPACE\\KonexPoS\\src\\test\\resources\\TestData\\Sample_BAR_Code.png");
		            String decodedText = null;

		            // store the file as an image
		            BufferedImage bufferedImage = ImageIO.read(file);

		            // process the image
		            LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
		            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
		            // store the details of the QR code
		            Result result = new MultiFormatReader().decode(bitmap);
		            decodedText =  result.getText();

		            // print to console
		           // System.out.println("Decoded text = " + decodedText);

		            // testng assertion
		            Assert.assertEquals(decodedText, "140587079913877");
		            Reporter.log("Barcode is successfully verified ");

		        } catch (IOException e) {
		           // System.out.println("Could not decode QR Code, IOException :: " + e.getMessage());
		        }
		 
	}



}
