package grande.francis.lacasadealicia;

public class Articulo
{
	private int idArticulo, idFoto;
	private String nombre, categoria;
	private float precio;

	public Articulo(int idArticulo, int idFoto, String nombre, String categoria, float precio)
	{
		this.idArticulo = idArticulo;
		this.idFoto = idFoto;
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
	}

	public int getFoto()
	{
		return this.idFoto;
	}

	public String getNombre()
	{
		return this.nombre;
	}

	public String getCategoria()
	{
		return this.categoria;
	}

	public float getPrecio()
	{
		return this.precio;
	}


}
