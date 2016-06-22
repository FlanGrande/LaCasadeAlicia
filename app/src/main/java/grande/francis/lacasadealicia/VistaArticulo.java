package grande.francis.lacasadealicia;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link VistaArticulo.OnVistaFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link VistaArticulo#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class VistaArticulo extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARTICULO = "articulo";

    private Articulo articulo;

    private OnVistaFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param idArticulo Articulo.
     * @return A new instance of fragment VistaArticulo.
     */
    // TODO: Rename and change types and number of parameters
    public static VistaArticulo newInstance(int idArticulo)
    {
        VistaArticulo fragment = new VistaArticulo();
        Bundle args = new Bundle();
        args.putInt(ARTICULO, idArticulo);
        fragment.setArguments(args);
        return fragment;
    }
    public VistaArticulo() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        if (getArguments() != null)
        {
            articulo = ArticulosFragmentListView.articulos.get(getArguments().getInt(ARTICULO));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vista_articulo, container, false);

        TextView titulo = (TextView) view.findViewById(R.id.titulo_nombre);
        ImageView img = (ImageView) view.findViewById(R.id.img);
        TextView precio = (TextView) view.findViewById(R.id.vPrecio);

        titulo.setText(articulo.getNombre());
        Picasso.with(view.getContext()).load(articulo.getFoto()).into(img);
        precio.setText(String.format("%.2f %s", articulo.getPrecio(), view.getResources().getString(R.string.simbolo_moneda)));

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnVistaFragmentInteractionListener) {
            mListener = (OnVistaFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void add()
    {
        if (mListener != null) {
            mListener.onVistaFragmentInteraction(articulo);
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnVistaFragmentInteractionListener {
        // TODO: Update argument type and name
        void onVistaFragmentInteraction(Articulo articulo);
    }
}
