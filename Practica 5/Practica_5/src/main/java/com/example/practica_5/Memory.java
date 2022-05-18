package com.example.practica_5;

import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.Collections;

public class Memory {
    private int fila;
    private int columna;
    int[][] img=new int[4][4];

    public Memory(){
        inicializar();
    }

    public int getImg(int f, int c) {
        return img[f][c];

    }
    public void inicializar(){
        for (int i = 0; i <16 ; i++) {
            img[i /4][ i %4]=i+1;
        }
    }

    public void Desordenar(){
        ArrayList<Integer> num=new ArrayList<>();
        int cont=1;
        for (int i=0;i<16;i++){
            num.add(cont);
            if (i%2!=0){
                cont++;
            }
        }
        Collections.shuffle(num);
        int i;
        for ( i=0;i<16;i++){
            img[i / 4][ i %4 ]=num.get(i);
        }

    }

    public int devolverImagen(int fila, int columna){
        return img[fila][columna];
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
}
