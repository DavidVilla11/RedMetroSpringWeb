package es.redmetro.dam2.modelo.vo;

import java.util.Arrays;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


@Entity
@Table(name="T_LINEA")
public class Linea {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="cod_linea")
	@JacksonXmlProperty(localName = "codigoLinea")
	private int codigoLinea;
	
	@Column(name="nombre_corto")
	@JacksonXmlProperty(localName = "nombreCorto")
	private String nombreCorto;
	
	@Column(name="nombre_largo")
	@JacksonXmlProperty(localName = "nombreLargo")
	private String nombreLargo;
	
//	@OneToMany(mappedBy = "codigoEstacion")
//	private Set<Estacion> estaciones;
	
	@OneToOne
    @JoinColumn(name = "cod_color", foreignKey = @ForeignKey(name = "FK_COLORLINEA"))
	@JacksonXmlProperty(localName = "color")
	private Color color;
	
	@Column(name="kilometros")
	@JacksonXmlProperty(localName = "kilometros")
	private float kilometros;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "imagen_linea")
	@JacksonXmlProperty(localName = "imagen")
	private byte[] imagenLinea;
	
	@Column(name="Url")
	@JacksonXmlProperty(localName = "Url")
	private String Url;
	
	public String getUrl() {
		return Url;
	}
	public void setUrl(String Url) {
		this.Url = Url;
	}
	public int getCodigoLinea() {
		return codigoLinea;
	}
	public void setCodigoLinea(int codigoLinea) {
		this.codigoLinea = codigoLinea;
	}
	public String getNombreCorto() {
		return nombreCorto;
	}
	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}
	public String getNombreLargo() {
		return nombreLargo;
	}
	public void setNombreLargo(String nombreLargo) {
		this.nombreLargo = nombreLargo;
	}

	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public float getKilometros() {
		return kilometros;
	}
	public void setKilometros(float kilometros) {
		this.kilometros = kilometros;
	}
	
	public byte[] getImagenLinea() {
		return imagenLinea;
	}
	public void setImagenLinea(byte[] imagenLinea) {
		this.imagenLinea = imagenLinea;
	}
	@Override
	public String toString() {
		return "Linea [codigoLinea=" + codigoLinea + ", nombreCorto=" + nombreCorto + ", nombreLargo=" + nombreLargo
				+ ", color=" + color + ", kilometros=" + kilometros + ", imagenLinea="
				+ Arrays.toString(imagenLinea) + "]";
	}
	
	
	
	
//	public Set<Estacion> getEstaciones() {
//		return estaciones;
//	}
//	public void setEstaciones(Set<Estacion> estaciones) {
//		this.estaciones = estaciones;
//	}
}
