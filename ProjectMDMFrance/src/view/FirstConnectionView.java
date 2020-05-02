package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

import model.Install;

/**
 * Cette fenetre permet au SuperAdmin de donner l'emplacement et le mot de passe de la BD.
 * @author Alexis Debourdieu
 *
 */
public class FirstConnectionView extends JFrame{
	
	private JPanel contentPane;
	private JTextField textFieldEmplacement;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldConfirmation;
	JTextArea txtrError;
	private ActionListener al = new ButtonsListener();
	private Install inst = new Install();

	public FirstConnectionView() {
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel buttons = new JPanel();
		contentPane.add(buttons, BorderLayout.SOUTH);
		buttons.setLayout(new BorderLayout(0, 0));
		
		JButton btnExit = new JButton("Quitter");
		btnExit.addActionListener(al);
		buttons.add(btnExit, BorderLayout.WEST);
		
		JButton btnNext = new JButton("Valider");
		btnNext.addActionListener(al);
		buttons.add(btnNext, BorderLayout.EAST);
		
		JPanel title = new JPanel();
		contentPane.add(title, BorderLayout.NORTH);
		title.setLayout(new BoxLayout(title, BoxLayout.X_AXIS));
		
		JLabel titleLabel = new JLabel("Veuiller remplir les champs suivants concernant la BD :");
		title.add(titleLabel);
		
		JPanel centerPanel = new JPanel();
		contentPane.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(0, 0));
		
		Panel forms = new Panel();
		centerPanel.add(forms);
		GridBagLayout gbl_forms = new GridBagLayout();
		gbl_forms.columnWidths = new int[] {207, 233};
		gbl_forms.rowHeights = new int[] {25, 25};
		gbl_forms.columnWeights = new double[]{0.0, 1.0};
		gbl_forms.rowWeights = new double[]{0.0, 0.0, 0.0};
		forms.setLayout(gbl_forms);
		
		JLabel lblEmplacement = new JLabel("Emplacement :");
		GridBagConstraints gbc_lblEmplacement = new GridBagConstraints();
		gbc_lblEmplacement.anchor = GridBagConstraints.EAST;
		gbc_lblEmplacement.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmplacement.gridx = 0;
		gbc_lblEmplacement.gridy = 0;
		forms.add(lblEmplacement, gbc_lblEmplacement);
		
		textFieldEmplacement = new JTextField();
		GridBagConstraints gbc_textFieldEmplacement = new GridBagConstraints();
		gbc_textFieldEmplacement.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldEmplacement.anchor = GridBagConstraints.WEST;
		gbc_textFieldEmplacement.gridx = 1;
		gbc_textFieldEmplacement.gridy = 0;
		forms.add(textFieldEmplacement, gbc_textFieldEmplacement);
		textFieldEmplacement.setColumns(10);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		GridBagConstraints gbc_lblMotDePasse = new GridBagConstraints();
		gbc_lblMotDePasse.anchor = GridBagConstraints.EAST;
		gbc_lblMotDePasse.insets = new Insets(0, 0, 5, 5);
		gbc_lblMotDePasse.gridx = 0;
		gbc_lblMotDePasse.gridy = 1;
		forms.add(lblMotDePasse, gbc_lblMotDePasse);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.anchor = GridBagConstraints.WEST;
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 1;
		forms.add(passwordField, gbc_passwordField);
		
		JLabel lblConfirmerMotDe = new JLabel("Confirmer Mot de passe :");
		GridBagConstraints gbc_lblConfirmerMotDe = new GridBagConstraints();
		gbc_lblConfirmerMotDe.anchor = GridBagConstraints.EAST;
		gbc_lblConfirmerMotDe.insets = new Insets(0, 0, 0, 5);
		gbc_lblConfirmerMotDe.gridx = 0;
		gbc_lblConfirmerMotDe.gridy = 2;
		forms.add(lblConfirmerMotDe, gbc_lblConfirmerMotDe);
		
		passwordFieldConfirmation = new JPasswordField();
		passwordFieldConfirmation.setColumns(10);
		GridBagConstraints gbc_passwordFieldConfirmation = new GridBagConstraints();
		gbc_passwordFieldConfirmation.anchor = GridBagConstraints.WEST;
		gbc_passwordFieldConfirmation.gridx = 1;
		gbc_passwordFieldConfirmation.gridy = 2;
		forms.add(passwordFieldConfirmation, gbc_passwordFieldConfirmation);
		
		JPanel errorPanel = new JPanel();
		centerPanel.add(errorPanel, BorderLayout.SOUTH);
		
		txtrError = new JTextArea();
		txtrError.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		txtrError.setRows(2);
		txtrError.setColumns(43);
		txtrError.setWrapStyleWord(true);
		txtrError.setLineWrap(true);
		txtrError.setEditable(false);
		txtrError.setVisible(false);
		txtrError.setForeground(new Color(255, 0, 0));
		txtrError.setBackground(UIManager.getColor("Panel.background"));
		txtrError.setText("En attente");
		errorPanel.add(txtrError);
	}
	
	class ButtonsListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			String commande = e.getActionCommand();
			if (commande.equals("Quitter")){
				System.exit(0);
			}
			if (commande.equals("Valider")){
				String pswd=new String(passwordField.getPassword());
				String confirmationPswd= new String(passwordFieldConfirmation.getPassword());
				int err;
				if(textFieldEmplacement.getText().compareTo("")==0){
					txtrError.setText("Vous n'avez entré aucun emplacement.");
					txtrError.setVisible(true);
					passwordField.setText("");
					passwordFieldConfirmation.setText("");
				}
				else if(pswd.compareTo(confirmationPswd)!=0){
					txtrError.setText("Votre Mot de passe de confirmation est différent de votre premier Mot de passe.");
					txtrError.setVisible(true);
					passwordField.setText("");
					passwordFieldConfirmation.setText("");
				}
				else if((err=inst.passwordVerification(pswd))!=0){
					if(err==1){
						txtrError.setText("Votre Mot de passe est trop court. "+String.valueOf(Install.MIN_LENGHT_PASSWORD)+" caractères minimum.");
					}
					else if(err==2){
						txtrError.setText("Votre Mot de passe est trop long. "+String.valueOf(Install.MAX_LENGHT_PASSWORD)+" caractères maximum.");
					}
					else if(err==3){
						txtrError.setText("Votre Mot de passe utilise des caractères non autorisés.");
					}
					txtrError.setVisible(true);
					passwordField.setText("");
					passwordFieldConfirmation.setText("");
				}
				else{
					inst.saveInfoDB(textFieldEmplacement.getText(),pswd);
				}
			}
		}
	}

}
