package com.example.buscadorfiltradorsqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorTrabajadores extends RecyclerView.Adapter<AdaptadorTrabajadores.ViewHolder> {

    Context context;
    List<Trabajador> listaTrabajadores;

    public AdaptadorTrabajadores(Context context, List<Trabajador> listaTrabajadores) {
        this.context = context;
        this.listaTrabajadores = listaTrabajadores;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_trabajadores, null, false);
        return new AdaptadorTrabajadores.ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvUsuario.setText(listaTrabajadores.get(position).getUsuario());
        holder.tvNombre.setText(listaTrabajadores.get(position).getNombre());
        holder.tvArea.setText(listaTrabajadores.get(position).getArea());
    }

    @Override
    public int getItemCount() {
        return listaTrabajadores.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvUsuario, tvNombre, tvArea;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvUsuario = itemView.findViewById(R.id.tvUsuario);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvArea = itemView.findViewById(R.id.tvArea);
        }
    }

    public void filtrar(ArrayList<Trabajador> filtroTrabajadores) {
        this.listaTrabajadores = filtroTrabajadores;
        notifyDataSetChanged();
    }
}
