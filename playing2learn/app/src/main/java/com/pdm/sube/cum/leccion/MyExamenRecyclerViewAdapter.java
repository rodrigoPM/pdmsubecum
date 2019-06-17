package com.pdm.sube.cum.leccion;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pdm.sube.cum.DB.models.Examen;
import com.pdm.sube.cum.R;
import com.pdm.sube.cum.leccion.ExamenFragment.OnListFragmentInteractionListener;


import java.util.List;


public class MyExamenRecyclerViewAdapter extends RecyclerView.Adapter<MyExamenRecyclerViewAdapter.ViewHolder> {

    private final List<Examen> mValues;
    private final OnListFragmentInteractionListener mListener;

    private Context context;

    public MyExamenRecyclerViewAdapter(List<Examen> items, OnListFragmentInteractionListener listener, Context context) {
        mValues = items;
        mListener = listener;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_examen, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.texto_examen.setText(holder.mItem.getNombre());
        int resId = context.getResources().getIdentifier(holder.mItem.getImagen(),"drawable",context.getPackageName());
        holder.imagen_examen.setImageResource(resId);

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
        public final TextView texto_examen;
        public final ImageView imagen_examen;
        public Examen mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            texto_examen = (TextView) view.findViewById(R.id.texto_examen);
            imagen_examen = view.findViewById(R.id.imagen_examen);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + texto_examen.getText() + "'";
        }
    }
}
