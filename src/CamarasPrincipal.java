import java.util.ArrayList;

public class CamarasPrincipal {

	public static void main(String[] args) {
		ArrayList<Camara> lista_camaras=AccesoFichero.obtenerCamaras();
		String html=CrearHTML.crearTabla(lista_camaras);
		AccesoFichero.grabarHTML(html);

	}

}
