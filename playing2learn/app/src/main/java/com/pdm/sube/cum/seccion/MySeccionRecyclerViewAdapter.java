package com.pdm.sube.cum.seccion;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pdm.sube.cum.DB.models.Seccion;
import com.pdm.sube.cum.R;
import com.pdm.sube.cum.seccion.SeccionFragment.OnListFragmentInteractionListener;

import java.util.List;


public class MySeccionRecyclerViewAdapter extends RecyclerView.Adapter<MySeccionRecyclerViewAdapter.ViewHolder> {

    private final List<Seccion> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MySeccionRecyclerViewAdapter(List<Seccion> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_seccion, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.nombre_seccion.setText(holder.mItem.getNombre());
        holder.imagen_seccion.setImageResource(holder.mItem.getImagen());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
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
        public final View mView;
        public final TextView nombre_seccion;
        public final ImageView imagen_seccion;

        public Seccion mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            nombre_seccion = (TextView) view.findViewById(R.id.nombre_seccion);
            imagen_seccion = (ImageView) view.findViewById(R.id.imagen_seccion);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + nombre_seccion.getText() + "'";
        }
    }
}
