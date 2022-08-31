package com.platzi.functional._02_sideeffects;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CrearSQL {
    public static void main(String[] args) throws IOException {

		//File es para leer un archivo
        File entrada = new File("C:\\proyecto_spring\\codigo_y_pais.txt"); 
		
		//FileWriter es para escribir en un archivo el true al final es para que añada la informcion sin borrar la informacion que hay
        FileWriter salida = new FileWriter("C:\\proyecto_spring\\Insert_en_tabla_lenguaje.sql", true); 

		//puedes leer en: https://www.w3schools.com/java/java_files_create.asp para mas informacion
		
        Scanner myReader = new Scanner(entrada);

        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            salida.write("INSERT INTO lenguaje (codigo, pais) VALUES (" + data + ");\n");
        }

        salida.close();
    }
}
