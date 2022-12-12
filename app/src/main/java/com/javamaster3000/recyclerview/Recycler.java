package com.javamaster3000.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

public class Recycler extends AppCompatActivity implements RecyclerAdapter.ListItemClick {
//Miguel Urdaneta

    private RecyclerView mRvListaNumeros;

    private static final int LISTA_NUMEROS=25 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        mRvListaNumeros= findViewById(R.id.rvNumeros);

        mRvListaNumeros.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRvListaNumeros.setLayoutManager(linearLayoutManager);

        //Le mandamos al RecyclerAdapter la lista
        RecyclerAdapter myAdapter = new RecyclerAdapter(LISTA_NUMEROS,this);

        mRvListaNumeros.setAdapter(myAdapter);

    }

    @Override
    public void onListItemClick(int clickedItem) {
        //Controlamos la interacción del usuario


        String mensajeToast = "Item #" + clickedItem + "clicado";
        Toast mToast = Toast.makeText(this, mensajeToast, Toast.LENGTH_LONG);
        mToast.show();


    }
}