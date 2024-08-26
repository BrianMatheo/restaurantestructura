package com.mycompany.restaurante;

import javax.swing.JOptionPane;

public class Menu {
    String platos[];
    int datos[][];
    String dias[] = new String[]{"lunes", "martes", "miercoles", "jueves", "viernes", "sabado"};
    double sumatotal = 0;
    double promtotal = 0;
    
    public void crearMenu(int cantidad){
        platos = new String[cantidad];
        int i=0;
        while(i<cantidad){
            platos[i] = JOptionPane.showInputDialog("Diga el nombre del plato " + (i+1));
            i++;
        }
    }
    public void consultarMenu(){
        for(int i=0;i<platos.length;i++){
        JOptionPane.showMessageDialog(null, "Platos: " + platos[i]);
        }
    }
    public void ingresarDatos(){
        
        datos = new int[6][platos.length];
        for(int f=0;f<6;f++){
            for(int c = 0; c<platos.length;c++){
                datos[f][c] = Integer.parseInt(JOptionPane.showInputDialog("Ventas para el día: " + dias[f] + " plato: " + platos[c]));
            }
        }
        
    }
    
    public void analizarInformacion(){
        for(int f=0;f<platos.length;f++){
            int sumador = 0;
            int promedio = 0;
            int diamenos = 0;
            String diamen = "";
            int diasmas = 0;
            String diamas = "";
            for(int c = 0; c<6;c++){
                sumatotal += datos[c][f];
                promtotal = sumatotal/6;
                sumador += datos[c][f];
                promedio = (sumador/6);
                if(c==0){
                    diamenos = sumador;
                    diasmas = sumador;
                    diamas = dias[c];
                }
                
                if(diasmas<datos[c][f]){
                diasmas = datos[c][f];
                diamas = dias[c];
                }
                
                if(diasmas==datos[c][f] && c!=0){
                diamas += " y " + dias[c];
                }
                
                if(diamenos==datos[c][f] && c!=0){
                diamen += " y " + dias[c];
                }
                
                if(diamenos>datos[c][f]){
                    diamenos=datos[c][f];
                    diamen = dias[c];
                }
            }
            JOptionPane.showMessageDialog(null, "venta del plato " + platos[f] + " es de " + sumador + "\nel dia que menos vendio fue " + diamen + "\nel dia que mas vendio fue " + diamas + "\nel promedio de ventas al dia es de: " + promedio);
        }
        JOptionPane.showMessageDialog(null,"La cantidad de platos vendidos en la semana es de: " + sumatotal + "\nel promedio de ventas al dia de todos los platos es de: " + promtotal);
    }
}
