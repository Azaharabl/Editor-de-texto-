package com.company.Vista;

import javax.swing.*;
import javax.swing.text.Keymap;
import java.awt.*;
import java.awt.event.*;
import java.nio.file.Path;
import java.util.*;

import static java.awt.SystemColor.text;

public class Ventana extends JFrame {

   //componentes

    JTextArea texto = new JTextArea();
    String path = "";
    String selecionado = "";

    public  Ventana(){

        initComponents();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1000,800);




        // todo hacer el contador de linea
        //todo hacer el ckeck de el contador de linea



    }


    //no funciona porque el keyMaper captura el control c y esas convinaciones
    public boolean KeyPressed(int keyCode, KeyEvent event) {
        if(event.isControlDown() && event.getKeyCode() == KeyEvent.VK_C) {
            selecionado =  new FuncionesMenu().doCopiar(texto, selecionado);
            System.out.println("lo has conseguido ");
        }
        return true;
    }

    private void initComponents() {
        //creamos layaut y metemos el lavel y los menús
        JPanel panelPrincipal = new JPanel(new BorderLayout());

        //crear componentes
        JMenuBar menu = crearJmenuBar();





        panelPrincipal.add(menu, BorderLayout.NORTH);
      //  panelPrincipal.add(barraEstado,BorderLayout.SOUTH);
        panelPrincipal.add(texto, BorderLayout.CENTER);

        this.add(panelPrincipal);



    }

    private JMenuBar crearJmenuBar() {

        //creamos items del menú con sus subitemss

        JMenu archvo = new JMenu("Archivo");

        //sub de archivo
        JMenuItem nuevo = new JMenuItem("Nuevo");
        nuevo.addActionListener(new ActionListener(){
        @Override
            public void actionPerformed(ActionEvent e) {
            path = new FuncionesMenu().doNuevo(path);
            texto.setText( new FuncionesMenu().clear(texto));
        }});

        JMenuItem abrir = new JMenuItem("Abrir");
        abrir.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

               path =  new FuncionesMenu().doAbrir(texto, path);

        }});

        JMenuItem guardar = new JMenuItem("Guardar");
        guardar.addActionListener(new ActionListener(){
            @Override
                    public void actionPerformed(ActionEvent e) {
               path =  new FuncionesMenu().doGuardar(texto, path);
            }});


        JMenuItem guardarComo = new JMenuItem("Guardar Como");
        guardarComo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //para guardar la path del archivo
                path = new FuncionesMenu().doGuardarComo(texto, path);
            }});


        JMenuItem imprimir = new JMenuItem("Imprimir");
        imprimir.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new FuncionesMenu().doImprimir(texto);
            }});

        archvo.add(nuevo);
        archvo.add(abrir);
        archvo.add(guardar);
        archvo.add(guardarComo);
        archvo.add(imprimir);



        JMenu edición = new JMenu("Edición");

        //sub de edición
        JMenuItem deshacer = new JMenuItem("Deshacer");
        deshacer.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new FuncionesMenu().doDeshacer();
            }});

        JMenuItem copiar = new JMenuItem("Copiar");
        copiar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

               FuncionesMenu fun =  new FuncionesMenu();
                        selecionado = fun.doCopiar(texto,selecionado);
            }});


        JMenuItem cortar = new JMenuItem("Cortar");
        cortar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                FuncionesMenu fun =  new FuncionesMenu();
                selecionado = fun.doCortar(texto,selecionado);
            }});


        JMenuItem pegar = new JMenuItem("Pegar");
        pegar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new FuncionesMenu().doPegar(texto,selecionado);
            }});


        JMenuItem eliminar = new JMenuItem("Eliminar");
        eliminar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new FuncionesMenu().doEliminar(texto);
            }});


        edición.add(deshacer);
        edición.add(copiar);
        edición.add(cortar);
        edición.add(pegar);
        edición.add(eliminar);



        JMenu ver = new JMenu("Ver");

        //sub de ver
        JCheckBoxMenuItem barraEstado = new JCheckBoxMenuItem("Barra de estado");
        barraEstado.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                new FuncionesMenu().doBarraEstado();
            }});

        ver.add(barraEstado);

        JMenu ayuda = new JMenu("Ayuda");

        //sub de ayuda
        JMenuItem acercaDe = new JMenuItem("Acerca de");
        acercaDe.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new FuncionesMenu().doAcercaDe();
            }});

        JMenuItem subAyuda = new JMenuItem("Ayuda");
        subAyuda.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new FuncionesMenu().doSubAyuda();
            }});

        ayuda.add(acercaDe);
        ayuda.add(subAyuda);

        //conectamos todas las opciones

        JMenuBar menu = new JMenuBar();
        menu.add(archvo);
        menu.add(edición);
        menu.add(ver);
        menu.add(ayuda);


        return  menu;

    }


}
