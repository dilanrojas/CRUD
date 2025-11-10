package modelo.dao.archivoJSON;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.json.JSONArray;
import org.json.JSONObject;

import modelo.Usuario;
import modelo.dataset.ListaUsuarios;

/**
 
@author Sebastian Castro Ulate
@date Nov 7, 2025
@version 1.0
@description description*/

public class LectorJSON {
    private ListaUsuarios dataset;
    private final String fileName;

    public LectorJSON(ListaUsuarios dataset,String fileName) {
        this.dataset = dataset;
        this.fileName = fileName;
    }

    public void readAll() throws IOException {
        dataset.clear();

        File file = new File(fileName);

        if(!file.exists()) {
            throw new IOException("Archivo no encontrado: " + file.getAbsolutePath());
        }

        try {
            FileInputStream input = new FileInputStream(file);
            String contenido = new String(input.readAllBytes(), StandardCharsets.UTF_8);

            JSONObject jsonObj = new JSONObject(contenido);
            JSONArray jsonArray = jsonObj.getJSONArray("usuarios");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject elemento = jsonArray.getJSONObject(i);
                Usuario usuario = new Usuario(
                        elemento.getString("nombre"),
                        elemento.getString("contrasena"),
                        elemento.getInt("nivel"),
                        elemento.getInt("puntaje"),
                        elemento.getInt("ID")
                    );
                dataset.agregar(usuario);
            }
            System.out.println("JSON cargado desde " + file.getAbsolutePath());
            input.close();
        }catch(IOException e) {
            System.err.println("Error al leer JSON " + e.getMessage());
            e.printStackTrace();
        }
    }
    public String imprimir() {
        return dataset.imprimir();
    }
}