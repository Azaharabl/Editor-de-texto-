package com.company;

import com.company.Vista.Ventana;

import javax.swing.*;

public class Main {

    /**
     * Espero que le sea de ayuda a quien le pueda interesar
     Azahara Blanco Rodríguez
     */

    public static void main(String[] args) {

        //para que tenga una bonita visualización
        try{
            //para añadir estilo
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        }catch (Exception e ){}

        //para que tenga una visualización parecida al sistema donde se use pero un poco vieja
        try{
            //para añadir estilo
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch (Exception e ){}

        //de este modo las pantalla van en un hilo independiente
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ventana().setVisible(true);


            }
        });

    }
}
