package modelo.dao.archivoJSON;

/**
 * @author Ana Gonzalez C5F593
 * @date Nov 7, 2025
 * @version 1.0
 * @description Clase escritor 
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.json.JSONArray;
import org.json.JSONObject;

import modelo.Usuario;
import modelo.dataset.ListaUsuarios;

public class EscritorJSON {
  // Componentes
	private ListaUsuarios dataset;
	private final String fileName;

  // Constructor
	public EscritorJSON(ListaUsuarios dataset, String fileName) {
		this.dataset = dataset;
		this.fileName = fileName;
	}

  // Escibir en .json
	public void writeAll() throws IOException {
		File file = new File(fileName);

		if (file.getParentFile() == null) {
			file.getParentFile().mkdirs();
		}

		JSONArray jsonArray = new JSONArray();

		for (int i = 0; i < dataset.getSize(); i++) {
			Usuario usuario = dataset.getElemento(i);
			if (usuario != null) {
				 JSONObject elemento_json = new JSONObject();
				 	elemento_json.put("nombre", usuario.getNombre());
          elemento_json.put("nickname", usuario.getNickname());
				 	elemento_json.put("contrasena", usuario.getContrasena());
				 	elemento_json.put("nivel", usuario.getNivel());
				 	elemento_json.put("puntaje", usuario.getPuntaje());
	                elemento_json.put("ID", usuario.getID());
	                jsonArray.put(elemento_json);
	            }
	        }

	        JSONObject root = new JSONObject();
	        root.put("usuarios", jsonArray);

	        try (FileOutputStream output = new FileOutputStream(file)) {
	            output.write(root.toString(4).getBytes(StandardCharsets.UTF_8));
	            System.out.println("Archivo JSON guardado en: " + file.getAbsolutePath());
	        } catch (IOException e) {
	            System.err.println("Error al guardar JSON: " + e.getMessage());
	            e.printStackTrace();
	        }
	}
}
