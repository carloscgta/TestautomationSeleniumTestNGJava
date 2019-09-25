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

	private Result result;

	
	public void geraPDF(String textTestCase, boolean brResult) {
		try {

			//File screenshot = ((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.FILE);
			//FileUtils.copyFile(screenshot, new File("screenshot.png"));
			Document document = new Document(PageSize.A4, 50, 50, 50, 50);
			document.setPageSize(PageSize.A4);
			//PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\carlos.almeida\\Documents\\SIGT\\Automation\\NewVentures\\Testautomation\\evidences\\alpha-sense-evidencia.pdf"));
			PdfWriter.getInstance(document, new FileOutputStream(""+Utils.prop.getProperty("Path_ScreenShot").toString()+"\\alpha-sense-evidencia.pdf"));
			
			document.open();

			Font f = new Font();
			f.setFamily("Courier");
			f.setStyle(Font.BOLD);
			f.setSize(30);

			Font font = new Font();
			font.setFamily("Courier");
			font.setStyle(Font.BOLD);
			font.setSize(25);

			Image logo = Image.getInstance("./font/brandmark.png");
			logo.scalePercent(10);
			document.add(logo);

			String textContent = textTestCase;
			
			document.add(new Paragraph(textContent, f));

			//document.add(new Paragraph("Cenário: " + scenario.getName(), f));
			//document.add(new Paragraph("Testautomation"));
			DateTimeFormatter dia = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDateTime today = LocalDateTime.now();
			String data = dia.format(today).toString();
			document.add(new Paragraph("Data: " + data, font));

			DateTimeFormatter hora = DateTimeFormatter.ofPattern("HH:mm:ss");
			LocalDateTime agora = LocalDateTime.now();
			String horario = hora.format(agora).toString();
			document.add(new Paragraph("Horário: " + horario + " hs", font));
			

			if (brResult == true) {
				Font color = new Font();
				color.setFamily("Courier");
				color.setStyle(Font.BOLD);
				color.setSize(25);
				color.setColor(BaseColor.GREEN);
				document.add(new Paragraph("Status: Passed ", color));
			} else {
				
				Font color = new Font();
				color.setFamily("Courier");
				color.setColor(BaseColor.RED);
				color.setStyle(Font.BOLD);
				color.setSize(25);
				document.add(new Paragraph("Status: Failed" , color));
			}

			// document.add(new Paragraph("Step: " + Thread.currentThread().getStackTrace(),
			// f));

			Image image = Image.getInstance("screenshot.jpg");
			float documentWidth = document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin();
			float documentHeight = document.getPageSize().getHeight() - document.topMargin() - document.bottomMargin();
			image.scaleToFit(documentWidth, documentHeight);
			image.setBorder(Rectangle.OUT_BOTTOM);
			image.setBorderColor(BaseColor.BLACK);
			image.setBorderWidth(1f);
			document.add(image);

			document.close();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

	}

	/*
	 * Method responsible to start the pdf file
	 *
	 */
	public void iniciaPDF(String textTestCase) throws Exception {
		
		document = new Document(PageSize.A4, 50, 50, 50, 50);
		document.setPageSize(PageSize.A4);
		new File("./evidences/").mkdirs();
		PdfWriter.getInstance(document, new FileOutputStream(("//evidences//"+textTestCase+""+System.currentTimeMillis() +"alpha-sense-evidencia.pdf")));
		//PdfWriter.getInstance(document, new FileOutputStream("//" + "Feature " + featureName + "//" + "evidencia.pdf"));
		document.open();

		Font f = new Font();
		f.setFamily("Courier");
		f.setStyle(Font.BOLD);
		f.setSize(25);

		Font font = new Font();
		font.setFamily("Courier");
		font.setStyle(Font.BOLD);
		font.setSize(20);
		
		//Image logo = Image.getInstance("C:\\Users\\carlos.almeida\\Documents\\SIGT\\Automation\\NewVentures\\Testautomation\\font\\brandmark.png");
		Image logo = Image.getInstance(Utils.prop.getProperty("brandmark").toString());
		logo.scalePercent(10);
		document.add(logo);

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

		document.add(new Paragraph("Browser: " + " MEthod that get the browser name", font));

		document.add(Chunk.NEWLINE);

	}

	/*
	 * Method Responsible for adding the content in the document
	 *
	 */
	public void conteudoPDF(String conteudoTestCaseTexts, String evidenceStringPath) throws Exception, DocumentException {

		document.newPage();
		Font color = new Font();
		color.setFamily("Courier");
		color.setStyle(Font.BOLD);
		color.setSize(15);
		color.setColor(BaseColor.BLUE);

		document.add(new Paragraph(conteudoTestCaseTexts, color));

		//File screenshot = ((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.FILE);
	//	FileUtils.copyFile(screenshot, new File("screenshot.png"));

		Image image = Image.getInstance(evidenceStringPath);
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
	public void fechaPDF(boolean bResult) throws DocumentException, IOException {
		if (bResult == false) {

			document.newPage();

			Font colorFailed = new Font();
			colorFailed.setFamily("Courier");
			colorFailed.setStyle(Font.BOLD);
			colorFailed.setSize(15);
			colorFailed.setColor(BaseColor.RED);

			document.add(new Paragraph("Status: " + "Failed", colorFailed));
			document.add(new Paragraph("Evidência da falha: ", colorFailed));
			
			
			//File screenshot = ((TakesScreenshot)BaseClass.driver).getScreenshotAs(OutputType.FILE);
			//FileUtils.copyFile(screenshot, new File("screenshot.jpg"));
			
			//Image image = Image.getInstance(evidenceStringPath);
			//float documentWidth = document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin();
			//float documentHeight = document.getPageSize().getHeight() - document.topMargin() - document.bottomMargin();
			//image.scaleToFit(documentWidth, documentHeight);
			//image.setBorder(Rectangle.OUT_BOTTOM);
			//image.setBorderColor(BaseColor.BLACK);
			//image.setBorderWidth(1f);
			//document.add(image);
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

