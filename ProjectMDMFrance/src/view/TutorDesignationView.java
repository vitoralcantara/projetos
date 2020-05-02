package view;


import java.awt.*;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import model.Install;
import model.Nature;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


/**
 * 
 * @author GROUPE INSTALLATION -- Paul GAVOILLE
 * 
 *
 */
public class TutorDesignationView extends JFrame{
	private JList<String> natureList;
	private JList<String> userList;
	
	
	public JList<String> getNatureList() {
		return natureList;
	}


	public JList<String> getUserList() {
		return userList;
	}


	public TutorDesignationView() {
		
		this.setSize(1024,768);
		BorderLayout borderLayout = (BorderLayout) getContentPane().getLayout();
		borderLayout.setVgap(30);
		
		JPanel buttonPan = new JPanel();
		getContentPane().add(buttonPan, BorderLayout.SOUTH);
		buttonPan.setLayout(new FlowLayout(FlowLayout.CENTER, 150, 5));
		
		JButton quitButton = new JButton("Quitter");
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				System.exit(0);
			}
		});
		buttonPan.add(quitButton);
		
		JButton validateButton = new JButton("Valider");
		validateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String natureSelected = getNatureList().getSelectedValue();
				String userSelected = getUserList().getSelectedValue();
				//TODO: Définir userSelected comme responsable de la communauté nature natureSelected.
			}
		});
		buttonPan.add(validateButton);
		
		JPanel centerPan = new JPanel();
		getContentPane().add(centerPan, BorderLayout.CENTER);
		centerPan.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 5));
		
		JPanel userListPan = new JPanel();
		centerPan.add(userListPan);
		userListPan.setLayout(new BoxLayout(userListPan, BoxLayout.Y_AXIS));
		
		JLabel userListLabel = new JLabel("Utilisateurs");
		userListLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		userListPan.add(userListLabel);
		
		//TODO: remplir la userList
		
		userList = new JList<String>();
		
		userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		userListPan.add(userList);
		
		JLabel centerLabel = new JLabel("Tuteur de :");
		centerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		centerPan.add(centerLabel);
		
		JPanel natureListPan = new JPanel();
		centerPan.add(natureListPan);
		natureListPan.setLayout(new BoxLayout(natureListPan, BoxLayout.Y_AXIS));
		
				//Creation de la liste des communautés natures.
		JLabel natureListLabel = new JLabel("Natures");
		natureListLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		natureListPan.add(natureListLabel);
				//On recupere la liste des Communautés natures.
		ArrayList<Nature> natures = Install.getAllNatureWithoutTuteur();
				//Création de la Jliste comprennant les nom des communautés natures.
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for (int i=0; i<natures.size(); i++){
			listModel.addElement(natures.get(i).getType());
		}
		natureList = new JList<>(listModel);
		natureList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		natureListPan.add(natureList);
		
		JPanel menuPan = new JPanel();
		getContentPane().add(menuPan, BorderLayout.NORTH);
		
		JButton designTutorButton = new JButton("Designer un Tuteur");
		menuPan.add(designTutorButton);
		
		JButton designRespButton = new JButton("Designer un Responsable");
		designRespButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RespDesignationView respView = new RespDesignationView();
				dispose();
			}
		});
		menuPan.add(designRespButton);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}