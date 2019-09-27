package com.alphasense.Testautomation.utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.mortbay.jetty.servlet.FilterHolder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.ProtocolHandshake.Result;

import com.alphasense.Testautomation.pages.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.itextpdf.awt.geom.Rectangle;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import junit.swingui.TestRunContext;

public class PDFGenerator {

	public static ExtentReports extent;
	public static ExtentTest test;
	private TestRunContext context;
	public static Document document = new Document();
	public static String path;
		

	/*
	 * Method responsible to start the pdf file
	 *
	 */
	public void startPDF(String textTestCase) throws Exception {
		
		document = new Document(PageSize.A4, 50, 50, 50, 50);
		document.setPageSize(PageSize.A4);
		new File("./report/").mkdirs();
		String path= Utils.configProp().getProperty("Path_ScreenShot").toString();
		PdfWriter.getInstance(document, new FileOutputStream((path+textTestCase+""+System.currentTimeMillis() +"alpha-sense-evidencia.pdf")));
		
		document.open();

		Font f = new Font();
		f.setFamily("Courier");
		f.setStyle(Font.BOLD);
		f.setSize(25);

		Font font = new Font();
		font.setFamily("Courier");
		font.setStyle(Font.BOLD);
		font.setSize(20);
		
		
		Image brand = Image.getInstance(Utils.configProp().getProperty("brandmark").toString());
		brand.scalePercent(10);
		document.add(brand);

		document.add(new Paragraph(textTestCase, f));

		document.add(new Paragraph("Environment Information " , font));

		DateTimeFormatter dia = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime today = LocalDateTime.now();
		String data = dia.format(today).toString();
		document.add(new Paragraph("Data: " + data, font));

		DateTimeFormatter hora = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDateTime agora = LocalDateTime.now();
		String horario = hora.format(agora).toString();
		document.add(new Paragraph("Horário: " + horario + " hs", font));

		String nameOS = "os.name";
		document.add(new Paragraph("Sistema operacional: " + System.getProperty(nameOS), font));

		document.add(new Paragraph("Browser:" + " MEthod that get the browser name", font));

		document.add(Chunk.NEWLINE);

	}

	/*
	 * Method Responsible for adding the content in the document
	 *
	 */
	public void PDFcontent(String conteudoTestCaseTexts, String evidenceStringPath) throws Exception, DocumentException {

		document.newPage();
		Font color = new Font();
		color.setFamily("Courier");
		color.setStyle(Font.BOLD);
		color.setSize(15);
		color.setColor(BaseColor.BLUE);

		document.add(new Paragraph(conteudoTestCaseTexts, color));
		Image image = Image.getInstance(evidenceStringPath);
		 path = evidenceStringPath;
		
		float documentWidth = document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin();
		float documentHeight = document.getPageSize().getHeight() - document.topMargin() - document.bottomMargin();
		image.setBorder(Rectangle.OUT_BOTTOM);
		image.setBorderColor(BaseColor.BLACK);
		image.setBorderWidth(1f);
		image.scaleToFit(documentWidth, documentHeight);
		document.add(image);

	}
	
	
/*
 * MEthod Responsible to close the pdf file
 */
	public void closePDF(boolean bResult) throws Exception {
		if (bResult == false) {

			document.newPage();

			Font colorFailed = new Font();
			colorFailed.setFamily("Courier");
			colorFailed.setStyle(Font.BOLD);
			colorFailed.setSize(15);
			colorFailed.setColor(BaseColor.RED);

			document.add(new Paragraph("Status: " + "Failed", colorFailed));
			document.add(new Paragraph("Evidência da falha: ", colorFailed));

			String imagepath = Utils.takeScreenshot(BaseClass.driver);
			Image image = Image.getInstance(imagepath);
			float documentWidth = document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin();
			float documentHeight = document.getPageSize().getHeight() - document.topMargin() - document.bottomMargin();
			image.scaleToFit(documentWidth, documentHeight);
			image.setBorder(Rectangle.OUT_BOTTOM);
			image.setBorderColor(BaseColor.BLACK);
			image.setBorderWidth(1f);
			document.add(image);
			document.close();
		} else {
			Font colorPassed = new Font();
			colorPassed.setFamily("Courier");
			colorPassed.setColor(BaseColor.GREEN);
			colorPassed.setStyle(Font.BOLD);
			colorPassed.setSize(20);
			document.add(new Paragraph("Status: Passed", colorPassed));
			
			document.close();
		}
	}

	public static String getDefaultBrowser() {
		try {
			// Get registry where we find the default browser
			Process process = Runtime.getRuntime().exec("REG QUERY HKEY_CLASSES_ROOT\\http\\shell\\open\\command");
			Scanner kb = new Scanner(process.getInputStream());
			while (kb.hasNextLine()) {
				// Get output from the terminal, and replace all '\' with '/' (makes regex a bit
				// more manageable)
				String registry = (kb.nextLine()).replaceAll("\\\\", "/").trim();

				// Extract the default browser
				Matcher matcher = Pattern.compile("/(?=[^/]*$)(.+?)[.]").matcher(registry);
				if (matcher.find()) {
					// Scanner is no longer needed if match is found, so close it
					kb.close();
					String defaultBrowser = matcher.group(1);

					// Capitalize first letter and return String
					defaultBrowser = defaultBrowser.substring(0, 1).toUpperCase()
							+ defaultBrowser.substring(1, defaultBrowser.length());
					return defaultBrowser;
				}
			}
			// Match wasn't found, still need to close Scanner
			kb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Have to return something if everything fails
		return "Error: Unable to get default browser";
	}
	

}

