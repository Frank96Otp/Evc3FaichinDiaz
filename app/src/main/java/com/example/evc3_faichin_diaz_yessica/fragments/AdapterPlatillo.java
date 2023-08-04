package com.example.evc3_faichin_diaz_yessica.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.evc3_faichin_diaz_yessica.databinding.ItemPlatilloBinding;
import com.example.evc3_faichin_diaz_yessica.model.Platillos;

import java.util.List;

import coil.Coil;
import coil.ImageLoader;
import coil.request.ImageRequest;

public class AdapterPlatillo extends RecyclerView.Adapter<AdapterPlatillo.ResumenVH> {


    private List<Platillos> platillos;

    public AdapterPlatillo(List<Platillos> platillo){
        this.platillos = platillo;
    }

    @NonNull
    @Override
    public ResumenVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemPlatilloBinding binding =  ItemPlatilloBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);


        return new ResumenVH((binding));
    }

    @Override
    public void onBindViewHolder(@NonNull ResumenVH holder, int position) {
        holder.bind(platillos.get(position));
    }

    @Override
    public int getItemCount() {
        return platillos.size();
    }

    class ResumenVH extends  RecyclerView.ViewHolder{

        private ItemPlatilloBinding binding;
        public ResumenVH(ItemPlatilloBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Platillos platillos) {


            binding.tvTittlePlatillo.setText( platillos.getName());
            binding.tvDetallePlatillo.setText( platillos.getDescription());


            ImageLoader imageLoader = Coil.imageLoader(binding.imgPlatillo.getContext());

            ImageRequest request = new ImageRequest.Builder(binding.imgPlatillo.getContext())
                    .data(platillos.getImgUrl())
                    .crossfade(true)
                    .target(binding.imgPlatillo)
                    .build();
            imageLoader.enqueue(request);

        }
    }



}
