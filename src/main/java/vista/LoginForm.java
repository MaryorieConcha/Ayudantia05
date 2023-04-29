package vista;

import controller.GestorDatos;

import javax.swing.*;
import java.awt.event.*;

public class LoginForm extends JFrame implements ActionListener {
    private JLabel usernameLabel, passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, registerButton;

    public LoginForm() {
        // Configurar la ventana
        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear los componentes
        usernameLabel = new JLabel("Nombre:");
        passwordLabel = new JLabel("Contraseña:");
        usernameField = new JTextField(10);
        passwordField = new JPasswordField(10);
        loginButton = new JButton("Iniciar sesión");
        registerButton = new JButton("Registrarse");

        // Configurar los botones para escuchar eventos
        loginButton.addActionListener(this);
        registerButton.addActionListener(this);

        // Agregar los componentes a la ventana
        JPanel panel = new JPanel();
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(registerButton);
        add(panel);

        // Mostrar la ventana
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e, String username, String password) {
        GestorDatos gestorDatos = new GestorDatos();
        if (e.getSource() == loginButton) {
            // Aquí iría el código para iniciar sesión
            gestorDatos.login(username, password);
        } else if (e.getSource() == registerButton) {
            VentanaRegistrar ventanaRegistrar = new VentanaRegistrar();
        }
    }



    public static void main(String[] args) {
        LoginForm loginForm = new LoginForm();
    }

    public void actionPerformed(ActionEvent e) {

    }
}
