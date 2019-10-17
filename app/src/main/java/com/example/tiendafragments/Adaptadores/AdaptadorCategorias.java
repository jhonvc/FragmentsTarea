package com.example.tiendafragments.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tiendafragments.Entidades.Categoria;
import com.example.tiendafragments.R;

import java.util.List;

public class AdaptadorCategorias extends RecyclerView.Adapter<CategoriaHolder>{
    Context context;
    CategoriaHolder.CategoriaCallback callback;
    List<Categoria> datos;

    public AdaptadorCategorias(Context context, CategoriaHolder.CategoriaCallback callback, List<Categoria> datos) {
        this.context = context;
        this.callback = callback;
        this.datos = datos;
    }

    @NonNull
    @Override
    public CategoriaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context)
                .inflate(R.layout.item_categoria, parent,false);
        return new CategoriaHolder(v,callback);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriaHolder holder, int position) {
        holder.id = datos.get(position).getId();
        Glide.with(context).load(datos.get(position).getImagen_cuadrada()).into(holder.btn_categoria);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }
}
