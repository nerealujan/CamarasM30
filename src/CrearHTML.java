import java.util.ArrayList;

public class CrearHTML {

	public static String crearTabla(ArrayList<Camara> lista_camaras) {
		String html="<html><head>";
		html+="<style>div {width: 500px; height:300px}</style>";
		html+= "</head><body>";
		html+="<script>\r\n" + 
				"      function initMap() {";
		html+=crearMapa(lista_camaras);
		html+="}</script>";
		html+="<table border='1px' ><tr><th>Latitud</th>"
				+ "<th>Longitud</th>"
				+ "<th>Foto</th></tr>";
		for (int i=0; i<lista_camaras.size(); i++)
		{
			
			String latitud=lista_camaras.get(i).getLatitud();
			String longitud=lista_camaras.get(i).getLongitud();
			String URL=lista_camaras.get(i).getURL();
			html+="<tr>";
			html+="<td>"+latitud+"</td>";
			html+="<td>"+longitud+"</td>";
			html+="<td><div id='mapa"+i+"'></div></td>";
			html+="<td><img src='http://"+URL+"'></td>";
			html+="</tr>";
			
		}
		
		html+="</table>";
		html+="<script async defer\r\n" + 
				"    src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyA2nnTwxI_6v6FgZQ_HYALbkWsL3qhFjT4&callback=initMap\">\r\n" + 
				"    </script>";
		html+="</body></html>";
		return html;
	}

	private static String crearMapa(ArrayList<Camara> lista_camaras) {
		String aux="";
		for (int i=0; i<lista_camaras.size(); i++)
		{
			Camara c=lista_camaras.get(i);
			String latitud=c.getLatitud();
			String longitud=c.getLongitud();
			aux+="var punto"+i+" = {lat:"+latitud+
					", lng: "+longitud+"};";
			aux+="var mapa"+i+" = new google.maps.Map("
					+ "document.getElementById('mapa"+i+"'), {\r\n" + 
					"          zoom: 15,\r\n" + 
					"          center: punto"+i+"\r\n" + 
					"        });";
			aux+="var marcador"+i+" = new google.maps.Marker({\r\n" + 
					"          position: punto"+i+",\r\n" + 
					"         \r\n" + 
					"        });";
			aux+="marcador"+i+".setMap(mapa"+i+");";
			
		}
		return aux;
	}

}
