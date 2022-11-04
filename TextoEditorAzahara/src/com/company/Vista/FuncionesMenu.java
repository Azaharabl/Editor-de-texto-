package com.company.Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.*;
import java.net.URI;

public class FuncionesMenu {


    public String doNuevo(String path){

     return "";

    }

    public void doImprimir(JTextArea text) {

        System.out.println(" no se como hacerlo");

        try{
            PrinterJob printer = PrinterJob.getPrinterJob();
            printer.print();
        } catch (PrinterException e) {
            throw new RuntimeException(e);

        }

    }

    public void doDeshacer() {
        System.out.println(" no se como hacerlo");
    }



    public void doEliminar(JTextArea  texto) {

        texto.replaceSelection("");
    }

    public void doBarraEstado() {
    }

    public void doAcercaDe() {
        JOptionPane.showMessageDialog(null,"Realizado por: Azahara blanco Rodriguez." +
                "\nCursando segundo ciclo de Dam en el ies Luis Vives " +
                "\n Año de realizacion 2022");


    }

    public void doSubAyuda() {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(URI.create("https://www.google.es/"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Error: Error de compatibilidad en la plataforma actual. No se puede abrir enlaces web.");
        }
    }


    public String doGuardarComo(JTextArea texto1, String path) {
        String texto = texto1.getText();

            JFileChooser selector =new JFileChooser();
            int opcion = selector.showSaveDialog(texto1);
            File archivo = selector.getSelectedFile();
            try (FileWriter escritor = new FileWriter(archivo)) {
                if (opcion == JFileChooser.APPROVE_OPTION)
                    if(archivo !=null)
                        escritor.write(texto);
            } catch(Exception e) {
                System.out.println("Error: "+e.getMessage());

            }
            return archivo.toString();

    }

    public String doGuardar(JTextArea texto, String path) {
        if(path.trim().isEmpty()){
            return doGuardarComo(texto, path);
        }else{
            File file = new File(path);
            try (FileWriter escritor = new FileWriter(file)) {
                        escritor.write(texto.getText());
            } catch(Exception e) {
                System.out.println("Error: "+e.getMessage());

            }
            return file.getAbsolutePath().toString();

        }
    }

    public String doAbrir(JTextArea texto, String path) {

        JFileChooser selector =new JFileChooser();
        int opcion = selector.showSaveDialog(texto);

        if(selector.isAcceptAllFileFilterUsed()){
            File file = selector.getSelectedFile();

            StringBuilder s = new StringBuilder();
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));

                String line;
                while ((line = br.readLine()) != null) {
                    s.append(line);
                }

            }catch (Exception e ){
                e.printStackTrace();
            }
            texto.setText(s.toString());
        }



        return selector.getSelectedFile().toString();
    }

    public String clear(JTextArea texto) {
        return "";
    }

    public String doCopiar(JTextArea texto, String selecionado) {
        String selecionado1 = texto.getSelectedText();
        return selecionado1;
    }

    public String doCortar(JTextArea texto, String selecionado) {
        selecionado = texto.getSelectedText();
        texto.replaceSelection("");
        return selecionado;
    }

    public void doPegar(JTextArea texto, String selecionado) {
        texto.replaceSelection(selecionado);
    }


}



