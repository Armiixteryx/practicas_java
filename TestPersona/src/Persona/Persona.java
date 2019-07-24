/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persona;
import java.util.Random;

/**
 *
 * @author armiixteryx
 */
public class Persona {
    // Atributos de una persona
    private String nombre;
    private int edad;
    private String dni;
    private float peso;
    private String sexo;
    private float altura;

    // Constantes de género sexual
    public final String SEXO_MASCULINO = "H"; // Hombre
    public final String SEXO_FEMENINO = "M";  // Mujer
    public final String SEXO_DEFAULT = SEXO_MASCULINO;
    
    // Constantes para calcular el IMC
    final static int PESO_BAJO = -1;
    final static int PESO_IDEAL = 0;
    final static int PESO_ALTO = 1;

    public Persona() {
        this.nombre = "";
        this.edad = 0;
        this.dni = Persona.generaDNI();
        this.peso = 0.0f;
        this.sexo = this.SEXO_DEFAULT;
        this.altura = 0.0f;
    }

    public Persona(String nombre, int edad, String sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = 0.0f;
        this.sexo = sexo;
        this.altura = 0.0f;
        this.dni = Persona.generaDNI();
    }

    public Persona(String nombre, int edad, float peso, String sexo,
            float altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.sexo = sexo;
        this.altura = altura;
        this.dni = Persona.generaDNI();
    }
    
    public int calcularIMC() {
        float imc = (float) (this.peso / Math.pow(this.altura, 2));
        
        if (imc < 20) {
            return PESO_BAJO;
        } else if (imc > 20 && imc < 25) {
            return PESO_IDEAL;
        } else {
            return PESO_ALTO;
        }
    }
    
    public boolean esMayorDeEdad() {
        return this.edad > 18;
    }
    
    private void comprobarSexo(String sexo) {
        if (sexo.compareToIgnoreCase(SEXO_FEMENINO) == 0) {
            this.sexo = SEXO_FEMENINO;
        } else {
            this.sexo = SEXO_MASCULINO;
        }
    }

    @Override
    public String toString() {
        String data = "Nombre: " + this.nombre;
        data += "\nEdad: " + this.edad;
        data += "\nDNI: " + this.dni;
        data += "\nPeso: " + this.peso;
        
        if (this.sexo.compareToIgnoreCase(SEXO_MASCULINO) == 0) {
            data += "\nSexo: masculino";
        } else {
            data += "\nSexo: femenino";
        }
        
        data += "\nAltura: " + this.altura;
        
        return data;
    }
    
    public static String generaDNI() {
        // Esta función genera un DNI español
        // Info: https://es.wikipedia.org/wiki/DNI_(Espa%C3%B1a)
        
        Random rand = new Random();
        // Todos los números de ocho cifras
        int randDNI = rand.nextInt(99999999) + 1;
        
        // La letra que va en la última posición del DNI
        String sequenciaLetras = "TRWAGMYFPDXBNJZSQVHLCKE";
        
        // Número del DNI
        int divisionDNI = randDNI / 23;
        
        // Letra final del DNI
        int residuoDNI = randDNI % 23;
        
        // Tomo el resultado de la división de randDNI y le sumo la letra
        // correspondiente
        return Integer.toString(divisionDNI) +
                sequenciaLetras.charAt(residuoDNI);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setSexo(String sexo) {
        comprobarSexo(sexo);
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }
    
}
