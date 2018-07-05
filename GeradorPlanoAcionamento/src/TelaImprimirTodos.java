import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Vector;

import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;


public class TelaImprimirTodos extends JPanel{//  implements Printable{

	private TelaPrincipal tela;
	private Vector panel = new Vector();
	/**
	 * Create the panel.
	 */
	public TelaImprimirTodos(TelaPrincipal tp, String end) {		
		tela = tp;		
		setLayout(null);
		setBackground(Color.WHITE);				
		try{	
			File caminho = new File(end);
			if(caminho.exists()){
				FileReader fr2 = new FileReader(caminho);
				BufferedReader arq_rd2 = new BufferedReader(fr2);
				int x = 0; 
				int y = 0;
				//PaginaImpressao pagina = new PaginaImpressao();
				//int cont = 1;
				while(arq_rd2.ready()){					
					String linha = arq_rd2.readLine();
					String[] argum = linha.split("<>");
					//procurando os telefones dos filhos
					File caminho2 = new File("Militares");
					FileReader fr = new FileReader(caminho2);
					BufferedReader arq_rd = new BufferedReader(fr);
					int achou = 0;
					String ft1 = "";
					String ft2 = "";
					String ft3 = "";
					while(achou != 3 && arq_rd.ready()){
						String[] dados = arq_rd.readLine().split("<>");
						if(dados[0].equals(argum[4])){
							ft1 = argum[4]+"\n"+dados[1];
							achou++;
						}
						else if(dados[0].equals(argum[5])){
							ft2 = argum[5]+"\n"+dados[1];
							achou++;
						}
						else if(dados[0].equals(argum[6])){
							ft3 = argum[6]+"\n"+dados[1];
							achou++;
						}
					}
					fr.close();
					arq_rd.close();
					
					TelaImprimir ind = new TelaImprimir(tela, argum[0], ft1, ft2, ft3, true);					
					ind.setBounds(0, y, ind.getWidth(), ind.getHeight());
					y = y + ind.getHeight()+2;
					if(x < ind.getWidth()){
						x = ind.getWidth();
					}
					this.add(ind);
					//System.out.println("altura:"+ind.getPreferredSize().getHeight());
					//inserindo panels na página
					/*if(cont < 10){
						pagina.add(ind);
						cont++;
					}
					else{
						pagina.add(ind);
						this.panel.add(pagina);
						pagina = new PaginaImpressao();
						cont = 1;
					}*/
				}
				this.setPreferredSize(new Dimension(x,y));
			}			
		}		
		catch(Exception e){
			JOptionPane.showMessageDialog(tela, "Erro ao tentar acessar o arquivo de Planos de acionamento ou dos militares cadastrados!");
		}	
		
		Toolkit tk = this.getToolkit();		
		PrintJob pj = tk.getPrintJob(tela, "Plano Geral", null);
		//System.out.println(this.getPreferredSize().getHeight());
		if(pj != null){			
			int i = 0;
			while(i > (-1)*this.getPreferredSize().getHeight()){
			//while(i < this.panel.size()){
				Graphics g = pj.getGraphics();
				g.translate(0,i);
				//g.drawRect(0, i+820, 700, 990);
				//TelaImprimirTodos teste = new TelaImprimirTodos(null, "");				
				this.paintChildren(g);				
				i -= 821;
				g.dispose();
			}			
			pj.end();
		}
		
		/*try{
			PrinterJob job = PrinterJob.getPrinterJob();
			job.setPrintable(this);			
            job.printDialog();
            job.print();
        } catch (PrinterException ex) { }*/
		//this.printComponent();
	}
	
	/*public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		if (pageIndex > 0) return NO_SUCH_PAGE;
		Graphics2D g2d = (Graphics2D)graphics;
		g2d.translate(0,-20);		
		this.printChildren(g2d);		
		return PAGE_EXISTS;
	}*/
	
	/*public void printComponent(){
		PrinterJob pj = PrinterJob.getPrinterJob();
		pj.setJobName("Plano Geral");
				
		pj.setPrintable(new Printable() {			
			public int print(Graphics pg, PageFormat pf, int pageNum)
					throws PrinterException {
				if(pageNum > 0){
					return Printable.NO_SUCH_PAGE;
				}
				Graphics2D g2 = (Graphics2D) pg;
				g2.translate(pf.getImageableX(), pf.getImageableY());				
												
				panel.paintChildren(g2);				
				
				return Printable.PAGE_EXISTS;
			}
		});
		if(pj.printDialog() == false){
			return;
		}
		try{
			pj.print();
		}
		catch(PrinterException e){
			JOptionPane.showMessageDialog(panel, "Erro: não foi possível imprimir o arquivo.");
		}
	}*/
}
