package com.example.tiendafragments.Adaptadores;


import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tiendafragments.R;


public class CategoriaHolder extends RecyclerView.ViewHolder {
    public ImageButton btn_categoria;
    public int id;
    public CategoriaCallback callback;

    public CategoriaHolder(@NonNull View itemView, CategoriaCallback c) {
        super(itemView);
        this.callback = c;
        btn_categoria = itemView.findViewById(R.id.img_categoria);
        btn_categoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.CategoriaSeleccionada((id));
            }
        });
    }

    public interface CategoriaCallback{
        void CategoriaSeleccionada(int id);
    }
}
