package com.example.reciclerview.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.reciclerview.R;

import java.util.List;

public class UsuarioAdaptador extends RecyclerView.Adapter<UsuarioAdaptador.ViewHolder>{

    private List<Usuario> usuarioList;
    private Context context;

    public UsuarioAdaptador(List<Usuario> usuarioList, Context context) {
        this.usuarioList = usuarioList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjeta,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtNombre.setText(usuarioList.get(position).getNombre());
        holder.txtEmail.setText(usuarioList.get(position).getEmail());
        Glide.with(context)
                .load(usuarioList.get(position).getFoto())
                .circleCrop()
                .into(holder.imgFoto);
    }

    @Override
    public int getItemCount() {
        return usuarioList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView txtNombre;
        private TextView txtEmail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = itemView.findViewById(R.id.img_foto);
            txtNombre = itemView.findViewById(R.id.txt_nombre);
            txtEmail = itemView.findViewById(R.id.txt_email);

        }
    }
}
