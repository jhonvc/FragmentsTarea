package com.example.tiendafragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tiendafragments.Adaptadores.AdaptadorCategorias;
import com.example.tiendafragments.Adaptadores.CategoriaHolder;
import com.example.tiendafragments.Entidades.Categoria;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListaCategoriaFragment extends Fragment implements CategoriaHolder.CategoriaCallback {
    RecyclerView recyclerView;
    CallbackCategoria callbackCategoria;

    public ListaCategoriaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://viveyupi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ServicioTienda s = retrofit.create(ServicioTienda.class);
        Call<List<Categoria>> call = s.ObtenerCategoriasPorNivel(1);
        View v  = inflater.inflate(R.layout.fragment_lista_categoria, container, false);
        recyclerView = v.findViewById(R.id.recycler_categorias);
        call.enqueue(new Callback<List<Categoria>>() {
            @Override
            public void onResponse(Call<List<Categoria>> call, Response<List<Categoria>> response) {
                AdaptadorCategorias adapter =
                        new AdaptadorCategorias(getContext(), ListaCategoriaFragment.this, response.body());
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
            }
            @Override
            public void onFailure(Call<List<Categoria>> call, Throwable t) {
                Log.e("Error", t.toString());
            }
        });

        return v;
    }

    @Override
    public void CategoriaSeleccionada(int id) {
        callbackCategoria.CategoriaSeleccionada(id);
    }

    public interface CallbackCategoria{
        void CategoriaSeleccionada(int codigo);
    }
}
