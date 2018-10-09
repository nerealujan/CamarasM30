import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class AccesoFichero {
static String ruta_entrada="D:\\camaras_m30\\camaras.xml";
static String ruta_salida="D:\\camaras_m30\\tabla_camaras.html";
	public static ArrayList<Camara> obtenerCamaras() {
		// TODO Auto-generated method stub
		SAXBuilder saxBuilder = new SAXBuilder();
        Document document;
        ArrayList<Camara> lista_camaras=new ArrayList<>();
		try {
			document = saxBuilder.build(new File(ruta_entrada));
			Element raiz=document.getRootElement();
			List<Element> elementos_camara=raiz.getChildren("Camara");
			
			
			for (int i=0; i<elementos_camara.size(); i++)
			{
				Camara c=new Camara();
				Element elemento_camara=elementos_camara.get(i);
				Element elemento_posicion=elemento_camara.getChild("Posicion");
				Element elemento_latitud=elemento_posicion.getChild("Latitud");
				Element elemento_longitud=elemento_posicion.getChild("Longitud");
				Element elemento_url=elemento_camara.getChild("URL");
				String latitud=elemento_latitud.getText();
				String longitud=elemento_longitud.getText();
				String URL=elemento_url.getText();
				c.setLatitud(latitud);
				c.setLongitud(longitud);
				c.setURL(URL);
				lista_camaras.add(c);
				
			}
		} catch (JDOMException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
		return lista_camaras;
	}
	public static void grabarHTML(String html) {
		try {
			FileWriter fw=new FileWriter(ruta_salida, false);
			fw.write(html);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
