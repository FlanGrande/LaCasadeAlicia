package grande.francis.lacasadealicia;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HomeScreenActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener, ArticulosFragmentListView.OnListFragmentInteractionListener
{
	public static DBController db;
	private String[] categorias;
	private DrawerLayout mDrawerLayout;
	private ActionBarDrawerToggle mDrawerToggle;
	private ListView mDrawerList;
	private Fragment homeFragment = new HomeFragment();

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_screen);
		Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(myToolbar);

		if(getSupportActionBar() != null)
		{
			getSupportActionBar().setLogo(R.drawable.ic_launcher);
			getSupportActionBar().setDisplayShowTitleEnabled(false);
			getSupportActionBar().setDisplayHomeAsUpEnabled(true);
			getSupportActionBar().setHomeButtonEnabled(true);
		}

		categorias = getResources().getStringArray(R.array.menu_izq);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerToggle = new ActionBarDrawerToggle(
				this,                  	/* host Activity */
				mDrawerLayout,         	/* DrawerLayout object */
				myToolbar,  		   	/* toolbar used */
				R.string.drawer_open,  	/* "open drawer" description */
				R.string.drawer_close  	/* "close drawer" description */
		) {

			/** Called when a drawer has settled in a completely closed state. */
			public void onDrawerClosed(View view) {
				super.onDrawerClosed(view);
			}

			/** Called when a drawer has settled in a completely open state. */
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
			}
		};

		mDrawerToggle.setDrawerIndicatorEnabled(true);
		mDrawerToggle.syncState();
		mDrawerLayout.addDrawerListener(mDrawerToggle);

		mDrawerList = (ListView) findViewById(R.id.left_drawer);
		mDrawerList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, categorias));
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager.beginTransaction().replace(R.id.content_frame, homeFragment).commit();
		db = new DBController(this);
	}

	//<editor-fold desc="onCreateOptionsMenu, onOptionsItemSelected and DrawerItemClickListener">
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.toolbar_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch(item.getItemId())
		{
			case R.id.action_search:
				// User chose the "Settings" item, show the app settings UI...
				return true;

			case R.id.action_cart:
				// User chose the "Favorite" action, mark the current item
				// as a favorite...
				return true;

			default:
				// If we got here, the user's action was not recognized.
				// Invoke the superclass to handle it.
				return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public void onFragmentInteraction(Uri uri)
	{

	}

	@Override
	public void onListFragmentInteraction(Articulo item)
	{

	}

	private class DrawerItemClickListener implements ListView.OnItemClickListener
	{
		@Override
		public void onItemClick(AdapterView parent, View view, int position, long id)
		{
			selectItem(position);
		}
	}

	//</editor-fold>

	private void selectItem(int position)
	{
		Fragment fragment;

		// Create a new fragment and specify the planet to show based on position
		switch(position)
		{
			case 0: fragment = new HomeFragment(); break;
			default: fragment = new ArticulosFragmentListView();
		}


		// Insert the fragment by replacing any existing fragment
		FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

		// Highlight the selected item, update the title, and close the drawer
		mDrawerList.setItemChecked(position, true);
		mDrawerLayout.closeDrawer(mDrawerList);

	}
}
