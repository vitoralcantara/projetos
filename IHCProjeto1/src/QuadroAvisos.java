/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 

/*
 * CardLayoutDemo.java
 *
 */
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.BrokenBarrierException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class QuadroAvisos {
    
	/**
	 * Frame no qual estará o formulário de adição de nova mensagem.
	 */
	JFrame jFrameAdicionarMensagem;
    
	private JLabel jLabelInserirNovaMensagem;
	
	private JLabel jLabelDataInicio;
	//private JTextField jTextFieldDataInicio;
	private JFormattedTextField jTextFieldDataInicio;
	private JLabel jLabelDataTermino;
	//private JTextField jTextFieldDataTermino;
	private JFormattedTextField jTextFieldDataTermino;
	private JLabel jLabelLocal;
	private JTextField jTextFieldLocal;
	private JLabel jLabelAutor;
	private JTextField jTextFieldAutor;
	private JLabel jLabelAssunto;
	private JTextField jTextFieldAssunto;
	private JLabel jLabelMensagem;
	private JTextArea jTextAreaMesagem;	
	private JButton jButtonAdicionarMensamgem;
	private JButton jButtonCancelarMensamgem;
	private JTable jTableAvisos;
	private JButton jButtonCriarNovaMensagem;
	private JTextArea jt;
	//private JFrame mainFrame;
	
	JPanel cards;

	private static JMenuBar jMenuBar1;

	private JMenu jMenu1;

	private JMenu jMenu2;

	private JMenu jMenu3;

	private JMenuItem jMenuItem1;

	private JMenuItem jMenuItem2;

	private JMenuItem jMenuItem3;

	private JMenuItem jMenuItemSair;
	
    final static String BUTTONPANEL = "";
    
    
      
    /**
     * Método que inicializa todas as variáveis de <code>jFrameAdicionarMensagem</code> onde estará o formulário de
     * inserir nova mensagem, assim como adicionar essas variáveis ao <code>jFrameAdicionarMensagem</code>. 
     * Também inicializa o próprio frame acima, e faz a vinculação das variáveis necessárias a <code>mainFrame</code>
     * o frame
     * @param pane
     */
    public void addComponentToPane(Container pane) {
    	//Nesta seção insere-se menus para poder embelezar melhor o programa
    	
    	jMenuBar1 = new javax.swing.JMenuBar();
    	jMenu1 = new javax.swing.JMenu();
    	jMenu1.setText("Mensagens");
    	jMenuItem1 = new javax.swing.JMenuItem();
    	jMenuItem1.setText("Criar nova Mensagem");
    	jMenuItem3 = new javax.swing.JMenuItem();
    	jMenuItem3.setText("Deletar Mensagens");
    	jMenu1.add(jMenuItem3);
    	jMenu1.add(jMenuItem1);
    	jMenu3 = new javax.swing.JMenu();
    	jMenu3.setText("Arquivo");
    	jMenuItemSair = new JMenuItem("Sair");
    	jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });
    	jMenu3.add(jMenuItemSair);    	
    	jMenuBar1.add(jMenu3);
    	jMenuBar1.add(jMenu1);
    	
    	//Adicionando listeners para quando o usuário aperta nas opções do menu, acontecer o mesmo
    	//que apertando um botão
    	jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCriarNovaMensagemActionPerformed(evt);
                
            }
        });
    	
    	jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeletarMensagemActionPerformed(evt);
            }
        });
    	    	
    	
    	//Inicialização das variáveis de jFrameAdicionarMensagem
    	jFrameAdicionarMensagem = new JFrame("Adicionar Nova Mensagem");
    	jFrameAdicionarMensagem.setLayout(new FlowLayout(FlowLayout.LEFT));
    	jFrameAdicionarMensagem.setSize(280, 600);
    	jFrameAdicionarMensagem.setLocationRelativeTo(null);
    	jFrameAdicionarMensagem.setResizable(false);
    	
    	jLabelInserirNovaMensagem = new JLabel("Inserir nova Mensagem           ");
    	jLabelDataInicio = new JLabel("Data Início:");
		//jTextFieldDataInicio = new JTextField(30);
    	jTextFieldDataInicio = new JFormattedTextField(new Date());
    	jTextFieldDataInicio.setColumns(23);
		jLabelDataTermino = new JLabel("Data Término:");
		jTextFieldDataTermino = new JFormattedTextField(new Date());
		jTextFieldDataTermino.setColumns(22);
		jLabelLocal = new JLabel("Local:");
		jTextFieldLocal = new JTextField(30);
		jLabelAutor = new JLabel("Autor:");
		jTextFieldAutor = new JTextField(30);
		jLabelAssunto = new JLabel("Assunto:");
		jTextFieldAssunto = new JTextField(30);
		jLabelMensagem = new JLabel("Mensagem:");
		jTextAreaMesagem = new JTextArea(15,30);
		jButtonAdicionarMensamgem = new JButton("Adicionar");
		jButtonAdicionarMensamgem.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	//jButtonCriarNovaMensagemActionPerformed(evt);
		    	jButtonAdicionarMensagemActionPerformed(evt);
		    }
		});
		
		
		jButtonCancelarMensamgem = new JButton("Cancelar");
		jButtonCancelarMensamgem.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	jFrameAdicionarMensagem.setVisible(false);
		    }
		});
		
		//Adicionando as variáveis criadas acima a jFrameAdicionarMensagem
		JPanel panel0 = new JPanel(new FlowLayout(FlowLayout.LEADING));
		panel0.setMinimumSize(new Dimension(280, 100));
		panel0.setSize(300, 300);
		panel0.add(jLabelInserirNovaMensagem);
		
		JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel1.setMinimumSize(new Dimension(280, 100));
		panel1.setSize(280, 100);
		panel1.add(jLabelDataInicio);
		panel1.add(jTextFieldDataInicio);
		
		jFrameAdicionarMensagem.add(panel0);
		//jFrameAdicionarMensagem.add(jLabelInserirNovaMensagem);
		//jFrameAdicionarMensagem.add(jLabelDataInicio);
		//jFrameAdicionarMensagem.add(jTextFieldDataInicio);
		jFrameAdicionarMensagem.add(panel1);
		jFrameAdicionarMensagem.add(jLabelDataTermino);
		jFrameAdicionarMensagem.add(jTextFieldDataTermino);
		jFrameAdicionarMensagem.add(jLabelLocal);
		jFrameAdicionarMensagem.add(jTextFieldLocal);
		jFrameAdicionarMensagem.add(jLabelAutor);
		jFrameAdicionarMensagem.add(jTextFieldAutor);
		jFrameAdicionarMensagem.add(jLabelAssunto);
		jFrameAdicionarMensagem.add(jTextFieldAssunto);
		jFrameAdicionarMensagem.add(jLabelMensagem);
		jFrameAdicionarMensagem.add(jTextAreaMesagem);
		jFrameAdicionarMensagem.add(jButtonAdicionarMensamgem);
		jFrameAdicionarMensagem.add(jButtonCancelarMensamgem);
    	jFrameAdicionarMensagem.setVisible(false); 	
    	    	
    	//Definindo a tabela onde estará as mensagens.
    	jTableAvisos = new javax.swing.JTable();
    	jTableAvisos.setModel(new javax.swing.table.DefaultTableModel(
    	    new Object [][] {

    	    },
    	    new String [] {
    	        "Data Inicio", "Data Término", "Autor", "Titulo", "Local", "Mensagem"
    	    }
    	));
    	JScrollPane scrollpane = new JScrollPane(jTableAvisos);
    	
    	//Definindo os botões de criar mensagem e deletar mensagem que estarão no mainFrame
    	jButtonCriarNovaMensagem = new javax.swing.JButton();
    	jButtonCriarNovaMensagem.setText("Criar nova Mensagem");
    	jButtonCriarNovaMensagem.addActionListener(new java.awt.event.ActionListener() {
    	    public void actionPerformed(java.awt.event.ActionEvent evt) {
    	    	jButtonCriarNovaMensagemActionPerformed(evt);
    	    }
    	});
    	
    	JButton jButtonDeletarMensagem = new javax.swing.JButton();
    	jButtonDeletarMensagem.setText("Deletar Mensagem");
    	jButtonDeletarMensagem.addActionListener(new java.awt.event.ActionListener() {
    	    public void actionPerformed(java.awt.event.ActionEvent evt) {
    	    	jButtonDeletarMensagemActionPerformed(evt);
    	    }
    	});
        
       //Criando os painéis e pondo os botões neles para depois inserir-los em mainFrame
        JPanel card1 = new JPanel();
        card1.add(jButtonCriarNovaMensagem);
        card1.add(jButtonDeletarMensagem);
 
        cards = new JPanel(new CardLayout());
        cards.add(card1, BUTTONPANEL);
        
        pane.add(scrollpane, BorderLayout.NORTH);
        jt = new JTextArea(10,40);
        
        
        
        JPanel p = new JPanel(new FlowLayout());
        p.add(new JLabel("Mensagem selecionada:"));
        p.add(jt);
        pane.add(p,BorderLayout.CENTER);
        pane.add(cards, BorderLayout.SOUTH);
        pane.setBounds(0, 0, 300, 300);
       
        jTableAvisos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTableAvisosFocusGained(evt);
            }
        });
    }
    

	protected void jTableAvisosFocusGained(FocusEvent evt) {
		// TODO Auto-generated method stub
		if(jTableAvisos.getSelectedRow() != -1)
		{
			DefaultTableModel t = (DefaultTableModel)jTableAvisos.getModel();
			jt.setText((String)t.getValueAt(jTableAvisos.getSelectedRow(),5));
		}
		
		
		
		
	}


	/**
     * Metodo disparado quando se aperta o botão de criar nova mensagem. Ele apenas
     * torna visível jFrameAdicionarMensagem
     * @param evt O evento disparado
     */
    protected void jButtonCriarNovaMensagemActionPerformed(ActionEvent evt) {
    	jFrameAdicionarMensagem.setVisible(true);
		
	}

    /**
     * Metodo disparado quando se aperta o botão de deletar mensagem. Se alguma linha
     * da tabela das mensagens (jTableAvisos) estiver selecionado, esta linha é então deletada.
     * Caso contrário, apenas um aviso é mostrado ao usuário.
     * @param evt O evento disparado
     */
	protected void jButtonDeletarMensagemActionPerformed(ActionEvent evt) {
		DefaultTableModel dm = (DefaultTableModel)jTableAvisos.getModel();
        if(jTableAvisos.getSelectedRow() != -1)
        {
        	dm.removeRow(jTableAvisos.getSelectedRow());
        }       
        else
        {
        	JOptionPane.showMessageDialog(jFrameAdicionarMensagem,"É necessário escolher uma linha para poder ser deletada");
        }
	}

	/**
	 * 
	 * @param evt
	 */
	protected void jButtonAdicionarMensagemActionPerformed(ActionEvent evt) {
		
		salvarNovaMensagem();
	}
    
    /**Método que obtém os valores nos campos do formulário de adicionar nova mensagem, e depois adiciona em jTableAvisos.
	 * Depois disso, o método zera os campos preenchidos com o novo aviso, e torna
	 * invisível o frame com o formulário das novas mensagens.     * 
     */
    private void salvarNovaMensagem() {
		// TODO Auto-generated method stub
    	Aviso aviso = new Aviso();
        aviso.setAssunto(jTextFieldAssunto.getText());
        aviso.setDataInicio(jTextFieldDataInicio.getText());
        aviso.setDataTermino(jTextFieldDataTermino.getText());
        aviso.setLocal(jTextFieldLocal.getText());
        aviso.setMensagem(jTextAreaMesagem.getText());
        aviso.setAutor(jTextFieldAutor.getText());
        
        DefaultTableModel tm = (DefaultTableModel)jTableAvisos.getModel();
        tm.addRow(new Object[]{aviso.getDataInicio().toString(),
                                aviso.getDataFim().toString(),aviso.getAutor().toString(),
                                aviso.getAssunto().toString(),
                                aviso.getLocal().toString(),
                                aviso.getMensagem().toString()}
        );
        jTableAvisos.setModel(tm);
        jTextFieldAssunto.setText("");
        jTextFieldAutor.setText("");
        jTextFieldDataTermino.setText("");
        jTextFieldDataInicio.setText("");
        jTextFieldLocal.setText("");
        jTextAreaMesagem.setText("");
        jFrameAdicionarMensagem.setVisible(false);
	}

	/**
     * Cria o GUI e exibe-o na tela.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame mainFrame = new JFrame("Painel de Mensagens");
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Create and set up the content pane.
        QuadroAvisos demo = new QuadroAvisos();
        demo.addComponentToPane(mainFrame.getContentPane());
        mainFrame.setJMenuBar(jMenuBar1);
        
        //Display the window.
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
    
    /**
     * Inicializando o programa. Primeiro setando o loofk and feel, e depois inicializando o swing.
     * 
     * @param args
     */
    public static void main(String[] args) {
        /* Usa um Look and Feel apropriado */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
                
        /**
         *	Criando e mostrando esta aplicação 
         */
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}