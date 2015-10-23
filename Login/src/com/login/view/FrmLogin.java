package com.login.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.login.dao.UsuarioDAO;
import com.login.model.Usuario;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmLogin {

	private JFrame frame;
	private JTextField txtLogin;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin window = new FrmLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrmLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 644, 455);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 628, 417);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Login:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(39, 242, 46, 14);
		panel.add(lblNewLabel);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSenha.setBounds(39, 281, 46, 14);
		panel.add(lblSenha);

		txtLogin = new JTextField();
		txtLogin.setBounds(95, 240, 472, 20);
		panel.add(txtLogin);
		txtLogin.setColumns(10);

		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(95, 279, 472, 20);
		panel.add(txtSenha);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			/**
			 * Evento do Botão Entrar, ------SE PUDER NÃO USE ESSA MERd@@ de
			 * Window Builder, só da bug. Estude JavaFX ou vá para JavaWeb
			 */
			public void actionPerformed(ActionEvent arg0) {
				/** Instanciamos o usuarioDAO */
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				/**
				 * Instanciamos o usuário que irá receber os dados do usuário
				 * logado
				 */
				Usuario usuario = new Usuario();
				/**
				 * A variavel de referencia usuario recebe o retorno do metodo
				 * Acesso que também é do tipo Usuario
				 */
				usuario = usuarioDAO.Acesso(txtLogin.getText(), txtSenha.getText());

				/**
				 * Para chamar uma variavel estatica não precisamos instanciar a
				 * classe, enfim se o acesso == true então estamos logados Caso
				 * Contrário algo está incorreto
				 */
				if (UsuarioDAO.acesso) {
					JOptionPane.showMessageDialog(null, "Usuario Logado: " + usuario.getNomeUsuario());
					// Chama uma tela
					
				} else {
					JOptionPane.showMessageDialog(null, "Login ou Senha Incorretos");
				}

			}
		});
		btnEntrar.setBounds(163, 332, 304, 23);
		panel.add(btnEntrar);

		JLabel lblNewLabel_1 = new JLabel("New label");
		//Imagenzinha bonitinha que coloquei
		lblNewLabel_1.setIcon(new ImageIcon("nature.jpg"));
		lblNewLabel_1.setBounds(0, 0, 638, 429);
		panel.add(lblNewLabel_1);
	}
}
