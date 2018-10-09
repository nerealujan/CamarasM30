
public class Camara {
	private String latitud, longitud, URL;

	public Camara(String latitud, String longitud, String uRL) {
		super();
		this.latitud = latitud;
		this.longitud = longitud;
		URL = uRL;
	}

	public Camara() {
		super();
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}
	
}
