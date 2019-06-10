package SGServicioInterno;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.persistence.EntityNotFoundException;

import com.itextpdf.text.*;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import SGServicioInterno.Model.EjerciciosTabla;
import SGServicioInterno.Model.TablaRutina;
import SGServicioInterno.Repository.TablaRutinaRepository;


@RestController
public class Controller {
	@Autowired
	public TablaRutinaRepository tablaRutina;
	
	public static FileOutputStream generarPDF(TablaRutina rutina) throws DocumentException, IOException{
		Document documento = new Document();
		
		Font tituloFuente = new Font(Font.FontFamily.COURIER,18,Font.BOLD);
		Font subtituloFuente = new Font(Font.FontFamily.COURIER, 12, Font.ITALIC);
		
		int NumeroColumnas = 2;
		
		
			
			String name = "TablaEjercicio" + rutina.getEjercicios().getId();
			
			File archivo = new File(name);
			FileOutputStream fos = new FileOutputStream(archivo);
			
			PdfWriter.getInstance(documento,fos);
			Image logo = Image.getInstance("logoSmartGym");
			
			documento.open();
			
			anadirTitulo(documento,rutina.getObjetivo(),tituloFuente);
			anadirFoto(documento,logo);
			anadirUsuarios(documento,rutina.getNombreUsuario(),rutina.getNombreEntrenador(),rutina.getDuracion(),subtituloFuente);
			anadirTabla(documento,2,rutina);
			return fos;
		
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
	
	private static void anadirUsuarios(Document documento, String usuario, String entrenador,int duracion,Font fuente) throws DocumentException {
		Paragraph datos = new Paragraph();
		datos.add(new Paragraph(" "));
		datos.add(new Paragraph("Usuario: "+usuario, fuente));
		datos.add(new Paragraph(" "));
		datos.add(new Paragraph("Entrenador: "+entrenador, fuente));
		datos.add(new Paragraph(" "));
		datos.add(new Paragraph("Duracion: "+ duracion +" semanas", fuente));
		datos.add(new Paragraph(" "));
		documento.add(datos);
	}
	
	private static void anadirTabla(Document documento, int numColumnas,TablaRutina rutina) throws DocumentException {
		Paragraph tabla = new Paragraph();
		PdfPTable tablaRutina = new PdfPTable(numColumnas);
		EjerciciosTabla ejercicios = rutina.getEjercicios();
		for(int i = 0; i < numColumnas; i++) {
			anadirCelda(tablaRutina,ejercicios.getEjercicio(i),ejercicios.getSerie(i),ejercicios.getRepeticiones(i),ejercicios.getDescanso(i));
		}
		tabla.add(tablaRutina);
		documento.add(tabla);
	}
	
	private static void anadirCelda(PdfPTable tablaRutina, String nombreEjercico, int series, int repeticiones, int descanso) {
		Paragraph ejercicio = new Paragraph();
		ejercicio.add(new Paragraph(nombreEjercico));
		ejercicio.add(new Paragraph("Series: "+ series));
		ejercicio.add(new Paragraph("Repeticiones: "+ repeticiones));
		ejercicio.add(new Paragraph("Descanso: "+ descanso+" segundos"));
		tablaRutina.addCell(ejercicio);
	}
	
	
	@GetMapping("/crearPDF/{id}")
	public ResponseEntity<Object> crearPDF(@PathVariable long id) throws DocumentException, IOException{
		try {
			TablaRutina rutina = tablaRutina.getById(id);
			FileOutputStream fos = generarPDF(rutina);
			//ByteArrayOutputStream baos = new ByteArrayOutputStream();
			//baos = generarPDF(rutina).toByteArray();
			return new ResponseEntity<>(fos,HttpStatus.OK);
		}catch (EntityNotFoundException e){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}

}
