package com.javamaster3000.recyclerview;

import android.app.LauncherActivity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.NumerosViewHolder> {
    private int mNumerosItems;

    final private ListItemClick mOnClickListener;

    public RecyclerAdapter(int numeroDeItems, ListItemClick listener){

        mNumerosItems = numeroDeItems;
        mOnClickListener = listener;


    }

    public interface ListItemClick{
        void onListItemClick(int clickedItem);


    }

    @NonNull
    @Override
    public NumerosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Aqui se infla, se llama y se llena la lista
        Context mContext = parent.getContext();
        int layoutIdParaListItem = R.layout.lista_numeros_row;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        boolean attachToParentFast= false;

        View view = inflater.inflate(layoutIdParaListItem,parent,attachToParentFast);

        NumerosViewHolder viewHolder= new NumerosViewHolder(view);




        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NumerosViewHolder holder, int position) {

        holder.bind(position);

    }

    @Override
    public int getItemCount() {
        return mNumerosItems;
    }

    class NumerosViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        //Este adapter busca la lista de numeros

        TextView mTvListaNumerosView;

        public NumerosViewHolder(@NonNull View itemView) {
            super(itemView);

            mTvListaNumerosView= itemView.findViewById((R.id.tv_lista_numeros));
            itemView.setOnClickListener(this);
        }
        void bind (int listaIndex){
            mTvListaNumerosView.setText(String.valueOf(listaIndex));


        }

        @Override
        public void onClick(View view) {
            int clickedItem= getAdapterPosition();

            mOnClickListener.onListItemClick(clickedItem);




        }
    }
}
