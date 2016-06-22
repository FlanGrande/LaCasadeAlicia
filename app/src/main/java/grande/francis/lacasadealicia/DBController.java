package grande.francis.lacasadealicia;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBController extends SQLiteOpenHelper
{
	public static Context cAplicacion;
	public static final int NUMELEM = 24;

	public DBController(Context applicationcontext)
	{
		super(applicationcontext, "androidsqlite.db", null, 1);
		cAplicacion = applicationcontext;
	}

	public void onCreate(SQLiteDatabase database)
	{
		String nextQuery = "";

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
					categoria = cAplicacion.getString(R.string.ayb_cojines);
					precio = 22.50f; break;
				case 1:
					foto = R.drawable.cojin11;
					nombre = cAplicacion.getString(R.string.cojin_nombre_personalizado);
					categoria = cAplicacion.getString(R.string.ayb_cojines);
					precio = 22.95f; break;
				case 2:
					foto = R.drawable.cojin13;
					nombre = cAplicacion.getString(R.string.cojin_cuadrado_angel);
					categoria = cAplicacion.getString(R.string.ayb_cojines);
					precio = 19.95f; break;
				case 3:
					foto = R.drawable.cojin15;
					nombre = cAplicacion.getString(R.string.cojin_personalizado_angel);
					categoria = cAplicacion.getString(R.string.ayb_cojines);
					precio = 23.95f; break;
				case 4:
					foto = R.drawable.cojin17;
					nombre = cAplicacion.getString(R.string.cojin_nino_luna);
					categoria = cAplicacion.getString(R.string.ayb_cojines);
					precio = 28.95f; break;
				case 5:
					foto = R.drawable.cojin21;
					nombre = cAplicacion.getString(R.string.cojin_jesusito);
					categoria = cAplicacion.getString(R.string.ayb_cojines);
					precio = 23.95f; break;
				case 6:
					foto = R.drawable.talega01;
					nombre = cAplicacion.getString(R.string.talega_atellier_rosa);
					categoria = cAplicacion.getString(R.string.ayb_talegas);
					precio = 19.50f; break;
				case 7:
					foto = R.drawable.talega03;
					nombre = cAplicacion.getString(R.string.talega_vichi);
					categoria = cAplicacion.getString(R.string.ayb_talegas);
					precio = 9.50f; break;
				case 8:
					foto = R.drawable.talega04;
					nombre = cAplicacion.getString(R.string.talega_jardin);
					categoria = cAplicacion.getString(R.string.ayb_talegas);
					precio = 14.50f; break;
				case 9:
					foto = R.drawable.talega06;
					nombre = cAplicacion.getString(R.string.talega_lau_school);
					categoria = cAplicacion.getString(R.string.ayb_talegas);
					precio = 9.50f; break;
				case 10:
					foto = R.drawable.talega07;
					nombre = cAplicacion.getString(R.string.talega_rayas);
					categoria = cAplicacion.getString(R.string.ayb_talegas);
					precio = 13.50f; break;
				case 11:
					foto = R.drawable.talega08;
					nombre = cAplicacion.getString(R.string.talega_lunar);
					categoria = cAplicacion.getString(R.string.ayb_talegas);
					precio = 13.50f; break;
				case 12:
					foto = R.drawable.chupete_con_nombre;
					nombre = cAplicacion.getString(R.string.chupete_nombre);
					categoria = cAplicacion.getString(R.string.com_chupetes);
					precio = 7.50f; break;
				case 13:
					foto = R.drawable.chupete_quiero_mama;
					nombre = cAplicacion.getString(R.string.chupete_quiero_mama);
					categoria = cAplicacion.getString(R.string.com_chupetes);
					precio = 7.50f; break;
				case 14:
					foto = R.drawable.chupete_quiero_papa;
					nombre = cAplicacion.getString(R.string.chupete_quiero_papa);
					categoria = cAplicacion.getString(R.string.com_chupetes);
					precio = 7.50f; break;
				case 15:
					foto = R.drawable.chupete_love_mama;
					nombre = cAplicacion.getString(R.string.chupete_love_mama);
					categoria = cAplicacion.getString(R.string.com_chupetes);
					precio = 7.50f; break;
				case 16:
					foto = R.drawable.chupete_love_papa;
					nombre = cAplicacion.getString(R.string.chupete_love_papa);
					categoria = cAplicacion.getString(R.string.com_chupetes);
					precio = 7.50f; break;
				case 17:
					foto = R.drawable.chupete_mejor_papa;
					nombre = cAplicacion.getString(R.string.chupete_mejor_papa);
					categoria = cAplicacion.getString(R.string.com_chupetes);
					precio = 7.50f; break;
				case 18:
					foto = R.drawable.biberon;
					nombre = cAplicacion.getString(R.string.varios_biberon);
					categoria = cAplicacion.getString(R.string.varios);
					precio = 0f; break;
				case 19:
					foto = R.drawable.cepillo_dientes;
					nombre = cAplicacion.getString(R.string.varios_cepillo_dientes);
					categoria = cAplicacion.getString(R.string.varios);
					precio = 0f; break;
				case 20:
					foto = R.drawable.cepillo_peine;
					nombre = cAplicacion.getString(R.string.varios_cepillo_peine);
					categoria = cAplicacion.getString(R.string.varios);
					precio = 0f; break;
				case 21:
					foto = R.drawable.portachupete;
					nombre = cAplicacion.getString(R.string.varios_portachupete);
					categoria = cAplicacion.getString(R.string.varios);
					precio = 0f; break;
				case 22:
					foto = R.drawable.sc01;
					nombre = cAplicacion.getString(R.string.varios_sc);
					categoria = cAplicacion.getString(R.string.varios);
					precio = 0f; break;
				case 23:
					foto = R.drawable.sonajero;
					nombre = cAplicacion.getString(R.string.varios_sonajero);
					categoria = cAplicacion.getString(R.string.varios);
					precio = 0f; break;
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

	public ArrayList<Articulo> listadoTodosArticulos()
	{
		SQLiteDatabase db = getWritableDatabase();
		ArrayList<Articulo> articulos = new ArrayList<>();

		if(db!=null)
		{
			Cursor c = db.query("articulos", null, null, null, null, null, null);

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
