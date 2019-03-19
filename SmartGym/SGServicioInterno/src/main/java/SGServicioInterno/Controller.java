package SGServicioInterno;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.*;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import SGServicioInterno.Model.TablaRutina;

public class Controller {
	
	public static void GenerarPDF(TablaRutina rutina) {
		Document documento = new Document();
		
		Font tituloFuente = new Font(Font.FontFamily.COURIER,18,Font.BOLD);
		Font subtituloFuente = new Font(Font.FontFamily.COURIER, 12, Font.ITALIC);
		
		int NumeroColumnas = 2;
		
		try {
			String path = new File(".").getCanonicalPath();
			String name = path + "/test.pdf";
			
			File archivo = new File(name);
			FileOutputStream fos = new FileOutputStream(archivo);
			
			PdfWriter.getInstance(documento,fos);
			Image logo = Image.getInstance("logoSmartGym");
			
			documento.open();
			
			anadirTitulo(documento,rutina.getObjetivo(),tituloFuente);
			anadirFoto(documento,logo);
			anadirUsuarios(documento,rutina.getNombreUsuario(),rutina.getNombreEntrenador(),rutina.getDuracion(),subtituloFuente);
			
			
			
		}catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void anadirTitulo(Document documento,String titulo,Font fuente) throws DocumentException{
		Paragraph title = new Paragraph();
		title.add(new Paragraph(" "));
		title.add(new Paragraph(titulo,fuente));
		title.add(new Paragraph(" "));
		documento.add(title);
	}
	
	private static void anadirFoto(Document documento, Image logo) throws DocumentException {
		logo.scaleToFit(100, 100);
		logo.setAlignment(Element.ALIGN_CENTER);
		documento.add(logo);
		
	}
	
	private static void anadirUsuarios(Document documento, String usuario, String entrenador,int duracion,Font fuente) {
		Paragraph datos = new Paragraph();
		datos.add(new Paragraph(" "));
		datos.add(new Paragraph("Usuario: "+usuario, fuente));
		datos.add(new Paragraph(" "));
		datos.add(new Paragraph("Entrenador: "+entrenador, fuente));
		datos.add(new Paragraph(" "));
		datos.add(new Paragraph("Duración: "+ duracion +" semanas", fuente));
		datos.add(new Paragraph(" "));
	}
	
	private static void anadirTabla(int numColumnas) {
		PdfPTable tablaRutuina = new PdfPTable(numColumnas);
	}
	
	private static void anadirCelda(PdfPTable tablaRutina, String nombreEjercico, int series, int repeticiones, String intensidad, int descanso) {
		Paragraph ejercicio = new Paragraph();
		ejercicio.add(new Paragraph(nombreEjercico));
		ejercicio.add(new Paragraph("Series: "+ series));
		ejercicio.add(new Paragraph("Repeticiones: "+ repeticiones));
		ejercicio.add(new Paragraph("Intensidad: "+ intensidad));
		ejercicio.add(new Paragraph("Descanso: "+ descanso+" segundos"));
		tablaRutina.addCell(ejercicio);
	}

}
