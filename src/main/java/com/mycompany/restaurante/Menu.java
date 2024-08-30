package com.mycompany.restaurante;

import javax.swing.JOptionPane;

public class Menu{
    String platos[];
    int datos[][];
    String dias[] = new String[]{"lunes", "martes", "miercoles", "jueves", "viernes", "sabado"};
    double sumatotal = 0;
    double promtotal = 0;
    String nombre;
    int precio;
    int costo;
    Platos obj[];
    int gantotal = 0;
    
    public void crearMenu(int cantidad){
    obj = new Platos[cantidad];
        int i=0;
        while(i<cantidad){
            nombre = JOptionPane.showInputDialog("ingresa el nombre del plato " + (i+1));
            precio = Integer.parseInt(JOptionPane.showInputDialog("ingrese el precio para vender del plato " + nombre + " entero sin espacios"));
            costo = Integer.parseInt(JOptionPane.showInputDialog("ingrese su costo de produccion del plato " + nombre + " entero sin espacios"));
            obj[i] = new Platos(nombre, precio, costo);
            if(precio>costo){
            i++;
            }
            if(precio<costo){
            JOptionPane.showMessageDialog(null, "el precio es mayor al costo de produccion, vuelva a ingresar los datos");
            }
        }
    }
    public void consultarMenu(){
        for(int i=0;i<obj.length;i++){
        JOptionPane.showMessageDialog(null, "Platos: " + obj[i].getNombre() + " precio: " + obj[i].getPrecio() + " costo: " + obj[i].getCosto());
        }
    }
    public void ingresarDatos(){
        
        datos = new int[6][obj.length];
        for(int f=0;f<6;f++){
            for(int c = 0; c<obj.length;c++){
                datos[f][c] = Integer.parseInt(JOptionPane.showInputDialog("Ventas para el día: " + dias[f] + " plato: " + obj[c].getNombre()));
            }
        }
        
    }
    
    public void analizarInformacion(){
        for(int f=0;f<obj.length;f++){
            int sumador = 0;
            double promedio = 0;
            int diamenos = 0;
            String diamen = "";
            int diasmas = 0;
            String diamas = "";
            int ganancia = 0;
            for(int c = 0; c<6;c++){
                sumatotal += datos[c][f];
                promtotal = sumatotal/6;
                sumador += datos[c][f];
                if(c==5){
                promedio = (sumador/6);
                ganancia = (obj[f].getPrecio()*sumador) - (obj[f].getCosto()*sumador);
                }
                gantotal += ganancia;
                
                if(c==0){
                    diamen = dias[c];
                    diamenos = sumador;
                    diasmas = sumador;
                    diamas = dias[c];
                }
                                
                if(diasmas==datos[c][f] && c!=0){
                diamas += " y " + dias[c];
                }
                
                if(diasmas<datos[c][f]){
                diasmas = datos[c][f];
                diamas = dias[c];
                }
                
                
                if(diamenos==datos[c][f] && c!=0){
                diamen += " y " + dias[c];
                }
                
                if(diamenos>datos[c][f]){
                    diamenos=datos[c][f];
                    diamen = dias[c];
                }
            }
            JOptionPane.showMessageDialog(null, "venta del plato " + obj[f].getNombre() + " es de " + sumador + "\nel dia que menos vendio fue " + diamen + "\nel dia que mas vendio fue " + diamas + "\nel promedio de ventas al dia es de: " + promedio + "\n su ganancia es de: " + ganancia);
        }
        double desviacion = sumatotal - (promtotal * obj.length);
        double coefivari = desviacion / promtotal;
        JOptionPane.showMessageDialog(null,"La cantidad de platos vendidos en la semana es de: " + sumatotal + "\nel promedio de ventas al dia de todos los platos es de: " + promtotal + "\nsu desviacion es de: " + desviacion + "\nsu coeficiente de variacion es de: " + coefivari + "%" + "\nganancia total: " + gantotal);
    }
}
