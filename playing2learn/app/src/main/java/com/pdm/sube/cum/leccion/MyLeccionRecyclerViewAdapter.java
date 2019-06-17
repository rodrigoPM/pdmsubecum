package com.pdm.sube.cum.leccion;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pdm.sube.cum.DB.models.Leccion;
import com.pdm.sube.cum.R;
import com.pdm.sube.cum.leccion.LeccionFragment.OnListFragmentInteractionListener;

import java.util.List;


public class MyLeccionRecyclerViewAdapter extends RecyclerView.Adapter<MyLeccionRecyclerViewAdapter.ViewHolder> {

    private final List<Leccion> mValues;
    private final OnListFragmentInteractionListener mListener;
    private Context context;

    public MyLeccionRecyclerViewAdapter(List<Leccion> items, OnListFragmentInteractionListener listener, Context context) {
        mValues = items;
        mListener = listener;
        this.context = context;
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
        int resId = context.getResources().getIdentifier(holder.mItem.getImagen(),"drawable",context.getPackageName());
        holder.imagen_leccion.setImageResource(resId);

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
        public Leccion mItem;

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
