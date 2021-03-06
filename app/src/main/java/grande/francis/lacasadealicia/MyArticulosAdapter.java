package grande.francis.lacasadealicia;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import grande.francis.lacasadealicia.ArticulosFragmentListView.OnListFragmentInteractionListener;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Articulo} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: add image.
 */
public class MyArticulosAdapter extends RecyclerView.Adapter<MyArticulosAdapter.ViewHolder> {

    //private LruCache<String, Bitmap> mMemoryCache;
    private final ArrayList<Articulo> mValues;
    private final OnListFragmentInteractionListener mListener;
    private boolean esCarrito;
    private int eliminados = 0;
    protected Context con;

    public MyArticulosAdapter(ArrayList<Articulo> items, OnListFragmentInteractionListener listener, boolean esCarrito)
    {
        con = DBController.cAplicacion;
        mValues = items;
        mListener = listener;
        this.esCarrito = esCarrito;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.articulo_individual_lista, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mItem = mValues.get(position);
        Picasso.with(con).load(mValues.get(position).getFoto()).placeholder(R.drawable.ic_launcher).into(holder.mFotoArticulo);
        holder.mNombreArticulo.setText(mValues.get(position).getNombre());

        float precio = mValues.get(position).getPrecio();
        String moneda = con.getResources().getString(R.string.simbolo_moneda);

        if(precio != 0)
        {
            if(moneda.equals("€"))
            {
                holder.mPrecioArticulo.setText(String.format("%.2f %s", precio, moneda));
            }
            else
            {
                holder.mPrecioArticulo.setText(String.format("%.2f %s", precio*0.76f, moneda));
            }
        }
        else
        {
            holder.mPrecioArticulo.setText(R.string.tbd);
        }

        holder.mViewArticulo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(null != mListener)
                {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(position, esCarrito);
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
        public final ImageView mFotoArticulo;
        public final TextView mNombreArticulo;
        public final TextView mPrecioArticulo;
        public Articulo mItem;

        public ViewHolder(View view) {
            super(view);
            mViewArticulo = view;
            mFotoArticulo = (ImageView) view.findViewById(R.id.foto_aticulo);
            mNombreArticulo = (TextView) view.findViewById(R.id.nombre_articulo);
            mPrecioArticulo = (TextView) view.findViewById(R.id.precio);
        }
    }

    public void remove(int position)
    {
        if(mValues.size() > 0 && position < mValues.size())
        {
            mValues.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, getItemCount());
        }
    }
}
