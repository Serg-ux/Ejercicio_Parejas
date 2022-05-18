package com.example.practica_5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class HelloController {

    public GridPane gpPanel;

    public Button btNuevo;

    public ArrayList<Button> parejas=new ArrayList<>();
    public ArrayList<Integer> numeros=new ArrayList<>();
    public Label lbResultado;
    Memory juego=new Memory();
    int cont;

    public void initialize(){
        for (int i = 0 ; i < 16; i++){
            Button boton= new Button();
            boton.setOnAction(this:: btCarta);
            boton.setOnMouseExited(this::btSalida);
            setImagen(9,boton);
            gpPanel.add(boton, i % 4, i / 4);
            lbResultado.setText("");
        }
        juego.Desordenar();
        cont=0;
    }

    public void btCarta(ActionEvent actionEvent){
        Button boton= (Button) actionEvent.getTarget();
        int fila=gpPanel.getRowIndex(boton);
        int columna=gpPanel.getColumnIndex(boton);
        parejas.add(boton);
        setImagen(juego.devolverImagen(fila,columna),boton);
        numeros.add(juego.devolverImagen(fila,columna));
    }
    public void btSalida(MouseEvent mouseEvent){
        if (parejas.size()==2 ){
            if (numeros.get(0)!=numeros.get(1) || parejas.get(1)==parejas.get(0) ){
                setImagen(9,parejas.get(0));
                setImagen(9,parejas.get(1));
            }else {
                parejas.get(0).setDisable(true);
                parejas.get(1).setDisable(true);
                cont++;
            }
            parejas.removeAll(parejas);
            numeros.removeAll(numeros);
            if (cont==8){
                lbResultado.setText("¡Has ganado!");
            }
        }else if (parejas.size()>2){
            setImagen(9,parejas.get(0));
            setImagen(9,parejas.get(1));
            parejas.removeAll(parejas);
            numeros.removeAll(numeros);
        }
    }

    public void setImagen(int i, Button boton){
        Image imagen = new Image(getClass().getResourceAsStream("imagenes/"+i+".jpg"));
        ImageView img= new ImageView(imagen);
        img.setFitHeight(126);/*Alto*/
        img.setFitWidth(141);/*Ancho*/
        boton.setGraphic(img);
        boton.setStyle("-fx-padding: 2; -fx-border-width: 2; -fx-background-color: transparent;");
        boton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    }

    public boolean comprobar(){

        return true;
    }

    @FXML
    private void btNuevo(ActionEvent actionEvent){
        gpPanel.getChildren().clear();
        initialize();
    }

}

/*@FXML
    private Label welcomeText;*/




    /*@FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }*/
