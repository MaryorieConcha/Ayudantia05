package controller;


import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import model.Usuario;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestorDatos {
    private List<Usuario> users; // Lista de usuarios
    private File userFile; // Archivo CSV donde se almacenarán los datos de usuario

    public GestorDatos() {
            users = new ArrayList<>();
            userFile = new File("users.csv");

            // Cargar la lista de usuarios desde el archivo CSV
            try {
                CSVReader reader = new CSVReader(new FileReader(userFile));
                String[] line;
                while ((line = reader.readNext()) != null) {
                    String username = line[0];
                    String password = line[1];
                    Usuario user = new Usuario(username, password);
                    users.add(user);
                }
            } catch (IOException | CsvValidationException e) {
                e.printStackTrace();
            }
        }

        public boolean login(String username, String password) {
            // Buscar el usuario en la lista de usuarios
            for (Usuario user : users) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    return true;
                }
            }
            // Si no se encuentra el usuario, devolver falso
            return false;
        }

        public void register(String username, String password) {
            // Crear un nuevo usuario
            Usuario user = new Usuario(username, password);

            // Agregar el usuario a la lista de usuarios y al archivo CSV
            users.add(user);
            try {
                CSVWriter writer = new CSVWriter(new FileWriter(userFile, true));
                writer.writeNext(new String[]{username, password});
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}