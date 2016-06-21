package grande.francis.lacasadealicia;

public class Articulo
{
	private int idArticulo, idFoto;
	private String nombre;
	private float precio;

	public Articulo(int idArticulo, int idFoto, String n, float p)
	{
		this.idArticulo = idArticulo;
		this.idFoto = idFoto;
		this.nombre = n;
		this.precio = p;
	}

	public String getNombre()
	{
		return this.nombre;
	}

	public float getPrecio()
	{
		return this.precio;
	}
}
