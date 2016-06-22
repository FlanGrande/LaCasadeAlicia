package grande.francis.lacasadealicia;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBController extends SQLiteOpenHelper
{
	public static final String CATEGORIA_TODOS = "ALL";
	public static final String CATEGORIA_ARTESANIA = "ART";
	public static final String CATEGORIA_MATERNIDAD = "MAT";
	public static final String CATEGORIA_VARIOS = "VAR";
	public static Context cAplicacion;
	public static final int NUMELEM = 24;

	public DBController(Context applicationcontext)
	{
		super(applicationcontext, "androidsqlite.db", null, 1);
		cAplicacion = applicationcontext;
	}

	public void onCreate(SQLiteDatabase database)
	{
		String nextQuery;

		nextQuery = "CREATE TABLE articulos(IDARTICULO INT, " +
				"IDFOTO INT, " +
				"NOMBRE TEXT, " +
				"CATEGORIA TEXT, " +
				"PRECIO REAL); ";

		database.execSQL(nextQuery);

		nextQuery = "INSERT INTO `articulos` (`IDARTICULO`, `IDFOTO`, `NOMBRE`, `CATEGORIA`, `PRECIO`) VALUES ";

		for(int i = 0; i < NUMELEM; i++)
		{
			int foto = R.drawable.ic_launcher;
			String nombre = "Articulo", categoria = cAplicacion.getString(R.string.varios);
			float precio = 0;

			switch(i)
			{
				case 0:
					foto = R.drawable.cojin00;
					nombre = cAplicacion.getString(R.string.cojin_angel_guarda);
					categoria = CATEGORIA_ARTESANIA;
					precio = 22.50f; break;
				case 1:
					foto = R.drawable.cojin11;
					nombre = cAplicacion.getString(R.string.cojin_nombre_personalizado);
					categoria = CATEGORIA_ARTESANIA;
					precio = 22.95f; break;
				case 2:
					foto = R.drawable.cojin13;
					nombre = cAplicacion.getString(R.string.cojin_cuadrado_angel);
					categoria = CATEGORIA_ARTESANIA;
					precio = 19.95f; break;
				case 3:
					foto = R.drawable.cojin15;
					nombre = cAplicacion.getString(R.string.cojin_personalizado_angel);
					categoria = CATEGORIA_ARTESANIA;
					precio = 23.95f; break;
				case 4:
					foto = R.drawable.cojin17;
					nombre = cAplicacion.getString(R.string.cojin_nino_luna);
					categoria = CATEGORIA_ARTESANIA;
					precio = 28.95f; break;
				case 5:
					foto = R.drawable.cojin21;
					nombre = cAplicacion.getString(R.string.cojin_jesusito);
					categoria = CATEGORIA_ARTESANIA;
					precio = 23.95f; break;
				case 6:
					foto = R.drawable.talega01;
					nombre = cAplicacion.getString(R.string.talega_atellier_rosa);
					categoria = CATEGORIA_ARTESANIA;
					precio = 19.50f; break;
				case 7:
					foto = R.drawable.talega03;
					nombre = cAplicacion.getString(R.string.talega_vichi);
					categoria = CATEGORIA_ARTESANIA;
					precio = 9.50f; break;
				case 8:
					foto = R.drawable.talega04;
					nombre = cAplicacion.getString(R.string.talega_jardin);
					categoria = CATEGORIA_ARTESANIA;
					precio = 14.50f; break;
				case 9:
					foto = R.drawable.talega06;
					nombre = cAplicacion.getString(R.string.talega_lau_school);
					categoria = CATEGORIA_ARTESANIA;
					precio = 9.50f; break;
				case 10:
					foto = R.drawable.talega07;
					nombre = cAplicacion.getString(R.string.talega_rayas);
					categoria = CATEGORIA_ARTESANIA;
					precio = 13.50f; break;
				case 11:
					foto = R.drawable.talega08;
					nombre = cAplicacion.getString(R.string.talega_lunar);
					categoria = CATEGORIA_ARTESANIA;
					precio = 13.50f; break;
				case 12:
					foto = R.drawable.chupete_con_nombre;
					nombre = cAplicacion.getString(R.string.chupete_nombre);
					categoria = CATEGORIA_MATERNIDAD;
					precio = 7.50f; break;
				case 13:
					foto = R.drawable.chupete_quiero_mama;
					nombre = cAplicacion.getString(R.string.chupete_quiero_mama);
					categoria = CATEGORIA_MATERNIDAD;
					precio = 7.50f; break;
				case 14:
					foto = R.drawable.chupete_quiero_papa;
					nombre = cAplicacion.getString(R.string.chupete_quiero_papa);
					categoria = CATEGORIA_MATERNIDAD;
					precio = 7.50f; break;
				case 15:
					foto = R.drawable.chupete_love_mama;
					nombre = cAplicacion.getString(R.string.chupete_love_mama);
					categoria = CATEGORIA_MATERNIDAD;
					precio = 7.50f; break;
				case 16:
					foto = R.drawable.chupete_love_papa;
					nombre = cAplicacion.getString(R.string.chupete_love_papa);
					categoria = CATEGORIA_MATERNIDAD;
					precio = 7.50f; break;
				case 17:
					foto = R.drawable.chupete_mejor_papa;
					nombre = cAplicacion.getString(R.string.chupete_mejor_papa);
					categoria = CATEGORIA_MATERNIDAD;
					precio = 7.50f; break;
				case 18:
					foto = R.drawable.biberon;
					nombre = cAplicacion.getString(R.string.varios_biberon);
					categoria = CATEGORIA_VARIOS;
					precio = 8.75f; break;
				case 19:
					foto = R.drawable.cepillo_dientes;
					nombre = cAplicacion.getString(R.string.varios_cepillo_dientes);
					categoria = CATEGORIA_VARIOS;
					precio = 3.50f; break;
				case 20:
					foto = R.drawable.cepillo_peine;
					nombre = cAplicacion.getString(R.string.varios_cepillo_peine);
					categoria = CATEGORIA_VARIOS;
					precio = 9.50f; break;
				case 21:
					foto = R.drawable.portachupete;
					nombre = cAplicacion.getString(R.string.varios_portachupete);
					categoria = CATEGORIA_VARIOS;
					precio = 6.95f; break;
				case 22:
					foto = R.drawable.sc01;
					nombre = cAplicacion.getString(R.string.varios_sc);
					categoria = CATEGORIA_VARIOS;
					precio = 7.50f; break;
				case 23:
					foto = R.drawable.sonajero;
					nombre = cAplicacion.getString(R.string.varios_sonajero);
					categoria = CATEGORIA_VARIOS;
					precio = 6.95f; break;
			}

			nextQuery += "(" + i + ", " + foto + ", '" + nombre + "', '" + categoria + "', '" + precio + "')";
			nextQuery += (i == NUMELEM-1) ? ";" : ", ";
		}

		database.execSQL(nextQuery);
	}

	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion)
	{
		String query;
		query = "DROP TABLE IF EXISTS articulos";
		database.execSQL(query);
		onCreate(database);
	}

	public ArrayList<Articulo> listadoArticulos(String categoria)
	{
		SQLiteDatabase db = getWritableDatabase();
		ArrayList<Articulo> articulos = new ArrayList<>();

		if(db!=null)
		{
			Cursor c = (categoria.equals(CATEGORIA_TODOS)) ?
					db.query("articulos", null, null, null, null, null, null) :
					db.query("articulos", null, "categoria LIKE '%" + categoria + "%'", null, null, null, null);

			if(c.moveToFirst())
			{
				do
				{
					articulos.add(new Articulo(
							c.getInt(0),
							c.getInt(1),
							c.getString(2),
							c.getString(3),
							c.getFloat(4)));
				} while (c.moveToNext());
			}

			c.close();
		}

		return articulos;
	}
}
