package grande.francis.lacasadealicia;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBController extends SQLiteOpenHelper
{
	public DBController(Context applicationcontext)
	{
		super(applicationcontext, "androidsqlite.db", null, 1);
	}

	public void onCreate(SQLiteDatabase database)
	{
		database.execSQL("CREATE TABLE articulos(IDARTICULO INT, " +
				"IDFOTO INT, " +
				"NOMBRE TEXT, " +
				"PRECIO REAL);");

		database.execSQL("INSERT INTO `articulos` (`IDARTICULO`, `IDFOTO`, `NOMBRE`, `PRECIO`) VALUES\n" +
				"('1', '0', 'Cojin', '19.95'),\n" +
				"('2', '0', 'Talega', '23.95');");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		String query;
		query = "DROP TABLE IF EXISTS users";
		db.execSQL(query);
		onCreate(db);
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
							c.getFloat(3)));
				} while (c.moveToNext());
			}

			c.close();
		}

		return articulos;
	}
}
