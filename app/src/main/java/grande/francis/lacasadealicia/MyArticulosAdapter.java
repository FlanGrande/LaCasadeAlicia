package grande.francis.lacasadealicia;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import grande.francis.lacasadealicia.ArticulosFragmentListView.OnListFragmentInteractionListener;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Articulo} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyArticulosAdapter extends RecyclerView.Adapter<MyArticulosAdapter.ViewHolder> {

    private final ArrayList<Articulo> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyArticulosAdapter(ArrayList<Articulo> items, OnListFragmentInteractionListener listener)
    {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.articulo_individual_lista, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mNombreArticulo.setText(mValues.get(position).getNombre());
        holder.mPrecioArticulo.setText(Float.toString(mValues.get(position).getPrecio()));

        holder.mViewArticulo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(null != mListener)
                {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mViewArticulo;
        public final TextView mNombreArticulo;
        public final TextView mPrecioArticulo;
        public Articulo mItem;

        public ViewHolder(View view) {
            super(view);
            mViewArticulo = view;
            mNombreArticulo = (TextView) view.findViewById(R.id.nombre_articulo);
            mPrecioArticulo = (TextView) view.findViewById(R.id.precio);
        }
    }
}
