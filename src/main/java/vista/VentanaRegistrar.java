package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaRegistrar extends JFrame implements ActionListener {
    private JLabel usernameLabel, passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton backButton, registerButton;

    public VentanaRegistrar(){
        // Configurar la ventana
        setTitle("Registrar");
        setSize(300,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear los componentes
        usernameLabel = new JLabel("Nombre:");
        passwordLabel = new JLabel("Contraseña:");
        usernameField = new JTextField(10);
        passwordField = new JPasswordField(10);
        backButton = new JButton("Regresar");
        registerButton = new JButton("Registrarse");

        // Configurar los botones para escuchar eventos
        backButton.addActionListener(this);
        registerButton.addActionListener(this);

        // Agregar los componentes a la ventana
        JPanel panel = new JPanel();
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(backButton);
        panel.add(registerButton);
        add(panel);

        // Mostrar la ventana
        setVisible(true);
    }



    public void actionPerformed(ActionEvent e) {

    }
}
