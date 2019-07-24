/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persona;
import java.util.Scanner;

/**
 *
 * @author armiixteryx
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int CANTIDAD_PERSONAS = 3;
        Persona[] listaPersonas = new Persona[CANTIDAD_PERSONAS];
        
        // Variables auxiliares para llamar a los constructores
        String sujetoNombre;
        int sujetoEdad;
        float sujetoPeso;
        String sujetoSexo;
        float sujetoAltura;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("---   P R O G R A M A   D E   P R U E B A   ---");
        separadorVisual();
        System.out.println("PERSONA #1");
        
        System.out.print("Introduzca el nombre: ");
        sujetoNombre = sc.nextLine();
        
        System.out.print("Introduzca la edad: ");
        sujetoEdad = sc.nextInt();
        
        cleanScanner(sc);
        
        System.out.print("Introduzca el peso: ");
        sujetoPeso = sc.nextFloat();
        
        System.out.print("Introduzca el sexo: ");
        sujetoSexo = sc.nextLine();
        
        cleanScanner(sc);
        
        System.out.print("Introduzca la altura: ");
        sujetoAltura = sc.nextFloat();
        
        cleanScanner(sc);
        
        listaPersonas[0] = new Persona(sujetoNombre, sujetoEdad, sujetoPeso,
                sujetoSexo, sujetoAltura);
        
        ////////////////////////////////////////////////////////////////////////
        
        separadorVisual();
        System.out.println("PERSONA #2");
        
        System.out.print("Introduzca el nombre: ");
        sujetoNombre = sc.nextLine();
        
        System.out.print("Introduzca la edad: ");
        sujetoEdad = sc.nextInt();
        
        cleanScanner(sc);
        
        System.out.print("Introduzca el sexo: ");
        sujetoSexo = sc.nextLine();
        
        listaPersonas[1] = new Persona(sujetoNombre, sujetoEdad,
                sujetoSexo);
        
        ////////////////////////////////////////////////////////////////////////
        
        separadorVisual();
        System.out.println("PERSONA #3");
        
        listaPersonas[2] = new Persona();
        
        System.out.print("Introduzca el nombre: ");
        listaPersonas[2].setNombre(sc.nextLine());
        
        System.out.print("Introduzca la edad: ");
        listaPersonas[2].setEdad(sc.nextInt());
        
        cleanScanner(sc);
        
        System.out.print("Introduzca el peso: ");
        listaPersonas[2].setPeso(sc.nextFloat());
        
        cleanScanner(sc);
        
        System.out.print("Introduzca el sexo: ");
        listaPersonas[2].setSexo(sc.nextLine());
        
        System.out.print("Introduzca la altura: ");
        listaPersonas[2].setAltura(sc.nextFloat());
        
        cleanScanner(sc);
        
        ////////////////////////////////////////////////////////////////////////
        
        separadorVisual();
        System.out.println("--- R E S U L T A D O S ---");
        
        for (int i = 0; i < CANTIDAD_PERSONAS; i++) {
            separadorVisual();
            System.out.println("--- PERSONA #" + i + ": ---");
            
            switch (listaPersonas[i].calcularIMC()) {
            case Persona.PESO_BAJO:
                System.out.println("El sujeto tiene BAJO PESO");
                break;
            case Persona.PESO_IDEAL:
                System.out.println("El sujeto tiene un PESO IDEAL");
                break;
            default:
                System.out.println("El sujeto tiene un PESO ALTO");
                break;
            }
        
            if (listaPersonas[i].esMayorDeEdad()) {
                System.out.println("El sujeto ES MAYOR DE EDAD");
            } else {
                System.out.println("El sujeto NO ES MAYOR DE EDAD");
            }
        
            System.out.println("Información completa del sujeto:");
            System.out.println(listaPersonas[i].toString());
            
            System.out.println("PRESIONE ENTER PARA CONTINUAR");
            sc.nextLine();
        }
    }
    
    public static void cleanScanner(Scanner sc) {
        if (sc.hasNextLine()) {
            sc.nextLine();
        }
    }
    
    public static void separadorVisual() {
        System.out.println("/////////////////////////////////////////////////");
    }
    
}
