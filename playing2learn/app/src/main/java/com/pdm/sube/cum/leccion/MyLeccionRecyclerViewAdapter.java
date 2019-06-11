package com.pdm.sube.cum.leccion;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pdm.sube.cum.R;
import com.pdm.sube.cum.leccion.LeccionFragment.OnListFragmentInteractionListener;

import java.util.List;


public class MyLeccionRecyclerViewAdapter extends RecyclerView.Adapter<MyLeccionRecyclerViewAdapter.ViewHolder> {

    private final List<LeccionItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyLeccionRecyclerViewAdapter(List<LeccionItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_leccion, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.nombre_leccion.setText(holder.mItem.getNombre());
        holder.imagen_leccion.setImageResource(holder.mItem.getImagen());

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
        public final TextView nombre_leccion;
        public final ImageView imagen_leccion;
        public LeccionItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            nombre_leccion = (TextView) view.findViewById(R.id.nombre_leccion);
            imagen_leccion = (ImageView) view.findViewById(R.id.imagen_leccion);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + nombre_leccion.getText() + "'";
        }
    }
}
