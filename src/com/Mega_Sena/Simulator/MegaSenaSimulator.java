package com.Mega_Sena.Simulator;

import java.awt.EventQueue;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;

import javax.swing.JEditorPane;
import javax.swing.JScrollPane;

public class MegaSenaSimulator extends JFrame {

	private JPanel contentPane;
	private String versão = "1.0.0";
	private JTextField txtExemplo;
	private JButton btnJogar;
	static String palpite;
	private String compResult;
	private MaskFormatter mascara;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
		      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    } catch (ClassNotFoundException e) {
		      e.printStackTrace();
		    } catch (InstantiationException e) {
		      e.printStackTrace();
		    } catch (IllegalAccessException e) {
		      e.printStackTrace();
		    } catch (UnsupportedLookAndFeelException e) {
		      e.printStackTrace();
		    }
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MegaSenaSimulator frame = new MegaSenaSimulator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MegaSenaSimulator() {
		setIconImage(new ImageIcon(MegaSenaSimulator.class.getResource("img/mega-sena-icon.png")).getImage());
		setResizable(false);
		setTitle("Mega-Sena Simulator 2016 - Versão " + versão);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MegaSenaSimulator.class.getResource("img/mega-sena.png")));
		label.setBounds(120, 0, 263, 50);
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Insira aqui o seu jogo:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 56, 464, 41);
		contentPane.add(panel);
		panel.setLayout(null);
		
		try {
			mascara = new MaskFormatter();
			mascara.setMask("## - ## - ## - ## - ## - ##");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		txtExemplo = new JFormattedTextField(mascara);
		
		txtExemplo.setBounds(5, 17, 454, 19);
		panel.add(txtExemplo);
		txtExemplo.setHorizontalAlignment(SwingConstants.CENTER);
		txtExemplo.setText("00 - 00 - 00 - 00 - 00 - 00");
		txtExemplo.setColumns(10);
		
		btnJogar = new JButton("Jogar!");
		
		btnJogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sorteio.main(null);
				compResult = Sorteio.resultado;
				palpite = txtExemplo.getText();
				Comparar.main(null);
				
				if (palpite.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, insira um palpite e clique no botão 'Jogar!'.");
				}
				else if (palpite.equals("00 - 00 - 00 - 00 - 00 - 00")) {
					JOptionPane.showMessageDialog(null, "Erro! O jogo atual é inválido! \nPor favor, insira um palpite como mostra o exemplo e clique no botão 'Jogar!'.");
				}
				else if (palpite.equals("   -    -    -    -    -   ")) {
					JOptionPane.showMessageDialog(null, "Erro! O jogo atual é inválido! \nPor favor, insira um palpite como mostra o exemplo e clique no botão 'Jogar!'.");
				}
				else if (palpite.length() != 27) {
					JOptionPane.showMessageDialog(null, "Erro! O jogo não possui 6 números! \nPor favor, insira um palpite como mostra o exemplo e clique no botão 'Jogar!'.");
				}
				else if (Comparar.jogoValido == false) {
					JOptionPane.showMessageDialog(null, "Erro! O jogo atual é inválido! O palpite jogado possui o número 00 ou número maior que 60! \nPor favor, insira um palpite como mostra o exemplo e clique no botão 'Jogar!'.");
				}
				else if (Comparar.palpiteValido == false) {
					JOptionPane.showMessageDialog(null, "Erro! O jogo atual é inválido! O palpite jogado possui um número repetido! \nPor favor, insira um palpite como mostra o exemplo e clique no botão 'Jogar!'.");
				}
				else {
					if (Comparar.acertos == 6) {
						JOptionPane.showMessageDialog(null, "Seu jogo foi: " + Comparar.sumarizando + "\nO jogo sorteado foi: " + compResult + "\n\nNúmeros acertados foram: " + Comparar.acertos + "\n\nParabéns! Você ganhou o maior prêmio da Mega-Sena! Agora você é um milionário!");
					}
					else if (Comparar.acertos == 5) {
						JOptionPane.showMessageDialog(null, "Seu jogo foi: " + Comparar.sumarizando + "\nO jogo sorteado foi: " + compResult + "\n\nNúmeros acertados foram: " + Comparar.acertos + "\n\nParabéns! Você ganhou o prêmio da quina!");
					}
					else if (Comparar.acertos == 4) {
						JOptionPane.showMessageDialog(null, "Seu jogo foi: " + Comparar.sumarizando + "\nO jogo sorteado foi: " + compResult + "\n\nNúmeros acertados foram: " + Comparar.acertos + "\n\nLegal! Você ganhou o prêmio da quadra!");
					}
					else {
						JOptionPane.showMessageDialog(null, "Seu jogo foi: " + Comparar.sumarizando + "\nO jogo sorteado foi: " + compResult + "\n\nNúmeros acertados foram: " + Comparar.acertos + "\n\nSinto muito, tente novamente!");
					}
				}
				Comparar.acertos = 0;
				Comparar.jogoValido = true;
				Comparar.palpiteValido = true;
			}
		});
		btnJogar.setBounds(12, 109, 464, 25);
		contentPane.add(btnJogar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 146, 464, 137);
		contentPane.add(scrollPane);
		
		JEditorPane dtrpnMegasenaSimulator = new JEditorPane();
		scrollPane.setViewportView(dtrpnMegasenaSimulator);
		dtrpnMegasenaSimulator.setContentType("text/html");
		dtrpnMegasenaSimulator.setText("<center>Mega-Sena Simulator 2016 - Versão 1.0.0<br>\n=================================<br>\n<br>\nPara jogar, basta colocar os números que deseja em ordem crescente\ne separados por um hífen como no exemplo abaixo:<br>\n<b>01 - 02 - 19 - 39 - 45 - 60</b><br>\n<br>\nO número 00 como palpite não é válido!<br>\nNúmeros maiores que 60 não são válidos!</center>");
		dtrpnMegasenaSimulator.setEditable(false);
	}
}
