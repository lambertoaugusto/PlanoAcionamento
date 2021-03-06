import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.Random;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;


public class TelaPrincipal extends JFrame {

	
	private JPanel contentPane;	
	public JScrollPane scrollPane = new JScrollPane();
	public JMenu menuUsuario = new JMenu("Usu\u00E1rio");
	public JMenu menuMilitar = new JMenu("Militar");
	public JMenu menuPlano = new JMenu("Plano");
	public TelaPrincipal tela = this;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Gerador de Plano de Reuni�o");
		
		//pegando resolu��o da tela
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
				
		setBounds(d.width/4, d.height/4, d.width/2, d.height/2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);		
		
		//parte que gera o plano		
				
		/*Militar[] militares = {new Militar("Cap. Pedro","(81)91111-1111"),new Militar("Ten. Ednei","(81)91111-1111"),
							   new Militar("Ten. Edson","(81)91111-1111"),new Militar("Ten. Klesons","(81)91111-1111"),
							   new Militar("2S Lamberto","(81)91111-1111"),new Militar("2S Paula","(81)91111-1111"),
							   new Militar("3S Wanessa","(81)91111-1111"),new Militar("1S Williams","(81)91111-1111"),
							   new Militar("3S Graziele","(81)91111-1111"),new Militar("3S Rafael","(81)91111-1111"),
							   new Militar("3S Ranyer","(81)91111-1111"),new Militar("3S Ammanda Mayara","(81)91111-1111"),
							   new Militar("3S Cleiton","(81)91111-1111")};
		
		Militar[] mil_random = new Militar[13];
		mil_random[0] = militares[0];
		mil_random[1] = militares[1];
		mil_random[2] = militares[2];
		mil_random[3] = militares[3];
		
		Vector pos = new Vector();
		for(int i = 4; i < 13; i++){
			pos.addElement(militares[i]);
		}
				
		Random r = new Random();
		int i = 4;
		while(pos.size()>0){			
			int j = r.nextInt(pos.size());
			mil_random[i] = ((Militar)pos.elementAt(j));
			pos.remove(j);
			i++;
		}
		
		
		PlanoDeAcionamento plano = new PlanoDeAcionamento(mil_random);
		plano.gerarPlano();	
		*/
		//Telas		 
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu mnPrincipal = new JMenu("Principal");
		menuBar.add(mnPrincipal);
		
		JMenuItem mntmLogin = new JMenuItem("Entrar");
		mnPrincipal.add(mntmLogin);
		
		mnPrincipal.add(mntmLogin);
		
		JMenuItem mntmSair = new JMenuItem("Sair");	
		mnPrincipal.add(mntmSair);		
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(menuBar, BorderLayout.NORTH);
				
		menuUsuario.setEnabled(false);
		menuBar.add(menuUsuario);
		
		JMenuItem mntmCadastar = new JMenuItem("Cadastrar");		
		menuUsuario.add(mntmCadastar);
		
		JMenuItem mntmModificar = new JMenuItem("Modificar");
		menuUsuario.add(mntmModificar);
		
		JMenuItem mntmExcluir = new JMenuItem("Excluir");
		menuUsuario.add(mntmExcluir);
		
		
		menuMilitar.setEnabled(false);
		menuBar.add(menuMilitar);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		menuMilitar.add(mntmCadastrar);
		
		JMenuItem mntmModificar_1 = new JMenuItem("Modificar");
		menuMilitar.add(mntmModificar_1);
		
		JMenuItem mntmExcluir_1 = new JMenuItem("Excluir");
		menuMilitar.add(mntmExcluir_1);
				
		menuPlano.setEnabled(false);
		menuBar.add(menuPlano);
		
		JMenuItem mntmGerar = new JMenuItem("Gerar");		
		menuPlano.add(mntmGerar);
		
		JMenuItem mntmVerificarGeral = new JMenuItem("Verificar Geral");		
		menuPlano.add(mntmVerificarGeral);
		
		JMenuItem mntmVerificarIndividual = new JMenuItem("Verificar Individual");
		menuPlano.add(mntmVerificarIndividual);
		
		mntmLogin.addActionListener(new TelaLogin(this));
		mntmCadastar.addActionListener(new CadastrarUsuario(this));
		mntmCadastrar.addActionListener(new CadastrarMilitar(this));
		mntmGerar.addActionListener(new TelaGerarPlano(this));		
		mntmVerificarGeral.addActionListener(new TelaVerifGeral(this));
		mntmSair.addActionListener(new TelaSair(this));
		mntmModificar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub				
				new TelaModUsuario(tela);
			}
		});
		
		mntmExcluir.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new TelaExcluirUsuario(tela);
			}
		});
		
		mntmModificar_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub				
				new TelaModMilitar(tela);
			}
		});
		
		mntmExcluir_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new TelaExcluirMilitar(tela);
			}
		});
				
		scrollPane.setViewportView(new TelaLogin(this));		
		//scrollPane.setViewportView(new TelaImprimirTodos(this, "Plano 2015"));
		contentPane.add(scrollPane);
		
		/*try{
		File caminho = new File("Usuario");
		FileReader fr = new FileReader(caminho);
		BufferedReader arq_rd = new BufferedReader(fr);
		while(arq_rd.ready()){
			System.out.println(arq_rd.readLine());
		}
		fr.close();
		arq_rd.close();
		}catch(Exception e){}*/
		
		//contentPane.add(new JPanel(), BorderLayout.WEST);
		//contentPane.add(new JPanel(), BorderLayout.EAST);
		//contentPane.add(new CadastrarMilitar(plano), BorderLayout.CENTER);
	}
}
