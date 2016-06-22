package grande.francis.lacasadealicia;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class ArticulosFragmentListView extends Fragment
{
	public static ArrayList<Articulo> articulos;
	private ArrayList<Articulo> carritoAux;
	private MyArticulosAdapter maa;
	private String filtro;
	private boolean esCarrito = false;
	private OnListFragmentInteractionListener mListener;
	private RecyclerView recyclerView;

	public static ArticulosFragmentListView newInstance()
	{
		return new ArticulosFragmentListView();
	}

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public ArticulosFragmentListView()
	{
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		filtro = DBController.CATEGORIA_TODOS;

		if(getArguments() != null)
		{
			filtro = getArguments().getString("categoria");
			esCarrito = getArguments().getBoolean("carrito");
		}

		if(esCarrito)
		{
			carritoAux = HomeScreenActivity.carrito;
		}
		else
		{
			articulos = HomeScreenActivity.db.listadoArticulos(filtro);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.fragment_listview, container, false);
		//ListView list2=(ListView)view.findViewById(R.id.list);
		//View emptyView = view.findViewById(R.id.empty_list);
		//list2.setEmptyView(emptyView);

		// Set the adapter
		if(view instanceof RecyclerView)
		{
			recyclerView = (RecyclerView) view;
			Context context = view.getContext();
			recyclerView.setLayoutManager(new LinearLayoutManager(context));

			if(esCarrito)
			{
				maa = new MyArticulosAdapter(carritoAux, mListener, true);
				RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
				itemAnimator.setRemoveDuration(500);
				recyclerView.setItemAnimator(itemAnimator);
				recyclerView.setAdapter(maa);
			}
			else
			{
				maa = new MyArticulosAdapter(articulos, mListener, false);
				recyclerView.setAdapter(maa);
			}
		}

		return view;
	}


	@Override
	public void onAttach(Context context)
	{
		super.onAttach(context);
		if(context instanceof OnListFragmentInteractionListener)
		{
			mListener = (OnListFragmentInteractionListener) context;
		}
		else
		{
			throw new RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener");
		}
	}

	@Override
	public void onDetach()
	{
		super.onDetach();
		mListener = null;
	}

	/**
	 * This interface must be implemented by activities that contain this
	 * fragment to allow an interaction in this fragment to be communicated
	 * to the activity and potentially other fragments contained in that
	 * activity.
	 * <p/>
	 * See the Android Training lesson <a href=
	 * "http://developer.android.com/training/basics/fragments/communicating.html"
	 * >Communicating with Other Fragments</a> for more information.
	 */
	public interface OnListFragmentInteractionListener
	{
		void onListFragmentInteraction(int position, boolean esCarrito);
	}

	public void elimina(int position)
	{
		if(esCarrito)
		{
			maa.remove(position);
		}
	}
}
