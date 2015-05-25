package com.phlacheux.vue;





import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
//import javax.swing.text.Segment;






import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.metal.MetalLookAndFeel;

import com.phlacheux.animation.VisioPanel;
import com.phlacheux.figures.AbstractFigure;
import com.phlacheux.figures.Carre;
import com.phlacheux.figures.Cercle;
import com.phlacheux.figures.Ellipse;
import com.phlacheux.figures.Hexagone;
import com.phlacheux.figures.Ligne;
import com.phlacheux.figures.Losange;
import com.phlacheux.figures.Rectangle;
import com.phlacheux.figures.Segment;
import com.phlacheux.figures.Triangle;



public class Fenetre extends JFrame implements Runnable, ActionListener, MouseListener, MouseMotionListener {


	private Toile toile;
	private JPanel monPanel;
	
	private JTextArea info;
	private Border border = BorderFactory.createLineBorder(Color.blue);
	private JRadioButton monSegment;
	private JRadioButton monTriangle;
	private JRadioButton monCercle;
	private JRadioButton monEllipse;
	private JRadioButton monRectangle;
	private JRadioButton monCarre;
	private JRadioButton monHexagone;
	private JRadioButton monLosange;
	private JRadioButton monLibre;
	private JRadioButton monDessiner;
	private JRadioButton monSupprimer;
	private JRadioButton monDeplacer;
	private JRadioButton monRedimensionner;
	private JCheckBox monRempli;
	private JButton annuler;
	private JButton toutEffacer;
	
	/*Boutons visionneuses*/
	private JButton monPlay;
	private JButton monFastR;
	private JButton monFastL;
	private JButton monStop;
	//private JButton monPause;
	/*fin boutons visionneuse*/
	
	private Vector<AbstractFigure> vector = new Vector<AbstractFigure>();
	private Color color=new Color(38, 97, 156);
	private Color select = Color.PINK;
	private Color colorStroke;
	private Ligne ligne;
	private int x1,x2,y1,y2;
	private int xDeplacer,yDeplacer;
	private int num=-1;
	private float x3,y3;
	private int [] pos = new int[2];
	private AbstractFigure maFigure;
	private AbstractFigure maNvlFigure;
	private Point point1,point2;
	private boolean changeIcon;
	private VisioPanel visio;
	private JPanel couleurFond; /*Add*/
	private JPanel couleurStroke;
	/*Bouton couleur et trait*/
	
	private JButton monButtonCouleur;
	private JButton monButtonStrokeCouleur;

	private JSlider monEpaisseurTrait;
	private JPanel monPanCouleur;
	
	float tailleTrait;
	int position = -1 ;
	
	



	private Graphics2D graphics2d;
	private BufferedImage bufferedImage;
	/* Menu bar*/
	private MenuBar menuBar;
	private JMenuItem quitter;
	private JMenuItem enregistrer;
	private JMenuItem enregistrerSous;
	
	private JFileChooser save;
	int optionSelectionner;
	
	public Fenetre () 
	{
		
		super();
		menuBar = new MenuBar();
		this.setJMenuBar(menuBar);
		super.setTitle("DesVis");
		super.setSize(1200,800);
		super.setResizable(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	public void construit () throws IOException
	{
		
//		try {
//			UIManager.setLookAndFeel(new MetalLookAndFeel());
//		} catch (UnsupportedLookAndFeelException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
		setContentPane(buildContentPanel());
		setVisible(true);
		/*Ecouteur Bar */
		EcouteurMenuBar ecouteurMenuBar = new EcouteurMenuBar();
		/* Initialisation Item*/
		
		quitter = menuBar.getQuitter();
		quitter.addActionListener(ecouteurMenuBar);
		
		enregistrer = menuBar.getEnregistrer();
		enregistrer.addActionListener(ecouteurMenuBar);
		
		enregistrerSous = menuBar.getEnregisteSous();
		enregistrerSous.addActionListener(ecouteurMenuBar);
		
		//play.addActionListener(this);
		//rotate.addActionListener(this);
		toile.addMouseListener(this);
		toile.addMouseMotionListener(this);
		//mon.addActionListener(this);
		monButtonCouleur.addActionListener(this);
		monButtonStrokeCouleur.addActionListener(this);
		
		monEpaisseurTrait.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				if(position == -1){
					JOptionPane.showMessageDialog(toile,"Selectionnez une figure s'il vous plaît");
					//flag = true;
				}else{
					((AbstractFigure)(vector.elementAt(position))).setBacisStroke((float)monEpaisseurTrait.getValue());
					repaint();
				}
				
			}


		});


	}
	
	public BufferedImage getBufferedImage() {
		return bufferedImage;
	}


	public void setBufferedImage(BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}

	public JPanel buildContentPanel() throws IOException
	{
		
		toile = new Toile();
		
		/*Ceulain*/
//		roti = new JButton("Poulet Roti");
//		buttonCouleur = new JButton("Couleur");
//		epaisseurTrait = new JSlider(0,30,10);
//		buttonStrokeCouleur = new JButton("Stroke Couleur");
//		
//		epaisseurTrait.setMajorTickSpacing(5);
//		epaisseurTrait.setMinorTickSpacing(1);
//		epaisseurTrait.setPaintLabels(true);
//		epaisseurTrait.setPaintTicks(true);
		/*fin ceulain*/
		
		
		SpringLayout layout=new SpringLayout();
		changeIcon = false;
		monPanel = new JPanel();
		

		
		visio = new VisioPanel(toile, layout);
		point1= point2 =null;

		
		monPanel.setLayout(layout);
		monPanel.setBackground(new Color(90, 94, 107));
		
		
		monPanel.add(toile);
		//panelForButton.add(animation);
		
		layout.putConstraint(SpringLayout.WEST, toile,
				1,
				SpringLayout.WEST,monPanel);
		layout.putConstraint(SpringLayout.NORTH, toile,
				80,
				SpringLayout.NORTH, monPanel);



		/*Panneau de choix de figures*/
		ChoixFigure cf = new ChoixFigure(monPanel);
		ChoixTransformations ct = new ChoixTransformations(monPanel);
		ChoixCoulEp cce = new ChoixCoulEp();

		monPanel.add(cf);
//		layout.putConstraint(SpringLayout.WEST, cf,
//				1,
//				SpringLayout.WEST,monPanel);

		

		/* On récupere nos bouton de la classe ChoixFigure */
		monSegment = cf.getSegment();
		monTriangle = cf.getTriangle();
		monCercle = cf.getCercle();
		monRectangle = cf.getRectangle();
		monEllipse = cf.getEllipse();
		monCarre = cf.getCarre();
		monHexagone = cf.getHexagone();
		monRempli = cf.getRempli();
		monLibre = cf.getLibre();
		monLosange = cf.getLosange();


		/*On récupere nos bouton de la classe ChoixTransformations*/
		monDessiner = ct.getDessiner();
		monSupprimer= ct.getSupprimer();
		monDeplacer = ct.getDeplacement();

		/*On récupere nos bouton de la classe VisioPanel*/
		monPlay =  visio.getPlay();
		monFastR = visio.getFastR();
		monFastL = visio.getFastL();
		monStop = visio.getStop();
		


		/*Boutons de la fenetre*/
		monPanCouleur = cce.getPanCouleur();
		monButtonCouleur = cce.getButtonCouleur();
		monButtonStrokeCouleur = cce.getButtonStrokeCouleur();
		monEpaisseurTrait = cce.getEpaisseurTrait();
		monPanCouleur = cce.getPanCouleur();
		
		
//		panCouleur.setSize(30,30);
//		//panelForButton = new JPanel();
//		panelForButton.add(roti);
//		panelForButton.add(epaisseurTrait);
//		panelForButton.add(buttonCouleur);
//		panelForButton.add(panCouleur);
//		panelForButton.add(buttonStrokeCouleur);
		
		
		
		
		
		
		
		info = new JTextArea(8,17);

		info.setBorder(
				BorderFactory.createTitledBorder(
						BorderFactory.createDashedBorder(new Color(38, 97, 156), 3, 1)));


		info.setForeground(toile.getForeground());
		info.setBackground(new Color(237, 237, 237));
		info.setPreferredSize(new Dimension(80, 20));
		info.setEditable(false);

		
	

		layout.putConstraint(SpringLayout.SOUTH, cce,
				-2,
				SpringLayout.NORTH,toile);

		layout.putConstraint(SpringLayout.WEST, cce,
				0,
				SpringLayout.WEST,toile);



		/* Panneau de choix de transformations*/
		layout.putConstraint(SpringLayout.SOUTH, ct,
				-3,
				SpringLayout.NORTH,toile);
		
		

		layout.putConstraint(SpringLayout.WEST, ct,
				1,
				SpringLayout.EAST,cce);
		
		layout.putConstraint(SpringLayout.NORTH, cf,
				0,
				SpringLayout.NORTH,toile);

		layout.putConstraint(SpringLayout.WEST, cf,
				10,
				SpringLayout.EAST,toile);




		layout.putConstraint(SpringLayout.VERTICAL_CENTER, info,
				10,
				SpringLayout.VERTICAL_CENTER,cf);

		layout.putConstraint(SpringLayout.WEST, info,
				10,
				SpringLayout.EAST,cf);
		
		
		/*Panel : changement couleur de fond*/
		couleurFond = new JPanel();
		JLabel textCouleurFond = new JLabel("Couleur Fond");
		couleurFond.setPreferredSize(new Dimension(100, 20));
		couleurFond.add(textCouleurFond);
		
		
		layout.putConstraint(SpringLayout.SOUTH,couleurFond,30,SpringLayout.SOUTH, info);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,couleurFond ,-52,SpringLayout.HORIZONTAL_CENTER,info);
		
		/*Panel : changement couleur du Stroke*/
		couleurStroke = new JPanel();
		JLabel textCouleurStroke = new JLabel("Couleur Stroke");
		couleurStroke.setPreferredSize(new Dimension(100,20));
		couleurStroke.add(textCouleurStroke);
		
		
		layout.putConstraint(SpringLayout.SOUTH,couleurStroke,30,SpringLayout.SOUTH, info);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,couleurStroke ,53,SpringLayout.HORIZONTAL_CENTER,info);
		
		
		monPanel.add(couleurStroke);
		monPanel.add(couleurFond);
		monPanel.add(visio);
		monPanel.add(info);
		monPanel.add(ct);
		monPanel.add(cce);
		

		return monPanel;
	}

	@Override
	public void run() {
		Fenetre f = new Fenetre();
		try {
			f.construit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		pos[0]=e.getX();
		pos[1]=e.getY();      
		repaint();

		x2=e.getX();
		y2=e.getY();


		if (monDeplacer.isSelected())
		{   
			if(num!=-1) 
				if (((AbstractFigure)(vector.elementAt(num))).isLigne())//deplacement d'une ligne
					ligne.deplacer(x2-xDeplacer,y2-yDeplacer,0,0,0,0);
				else//deplacement d'une forme autre qu'une ligne
					((AbstractFigure)(vector.elementAt(num))).deplacer(x1,y1,x2,y2,x3,y3);

		}

		//Pour dessiner un objet à la souris 	
		else if (vector.size()!=0)
		{
			((AbstractFigure)(vector.lastElement())).modifier(x1,y1,x2,y2);
		}		

		else if (monRedimensionner.isSelected())
		{   
			if(num!=-1) ((AbstractFigure)(vector.elementAt(num))).modifier(x1,y1,x2,y2);
		}

		/*
		 else if (monRedimensionner.isSelected()||monCercle.isSelected()||monEllipse.isSelected()
				 ||monRectangle.isSelected()||monCarre.isSelected()||monLibre.isSelected())
         {
          if (vector.size()!=0)
                     ((AbstractFigure)(vector.lastElement())).modifier(x1,y1,x2,y2);
         }
		 */
		repaint();
	}




	@Override
	public void mousePressed(MouseEvent e) {
		position = -1;
		x1=e.getX();
		y1=e.getY();
		repaint();



		if (monEllipse.isSelected() && monDessiner.isSelected())
		{
			maFigure=new Ellipse(x1,y1,monRempli.isSelected());
			vector.addElement(maFigure);
			((Ellipse)(vector.lastElement())).setColor(color);


		}
		
		else if(monCercle.isSelected() && monDessiner.isSelected())
		{
			maFigure =new Cercle(x1,y1,monRempli.isSelected());
			vector.addElement(maFigure);
			((Cercle)(vector.lastElement())).setColor(color);
			repaint();
		}else if(monLosange.isSelected() && monDessiner.isSelected()){
			maFigure = new Losange(x1, y1, monRempli.isSelected());
			vector.addElement(maFigure);
		}


		else if (monRectangle.isSelected() && monDessiner.isSelected() )
		{
			maFigure=new Rectangle(x1,y1,monRempli.isSelected());
			vector.addElement(maFigure);
			((Rectangle)(vector.lastElement())).setColor(color);
		} 


		else if(monCarre.isSelected() && monDessiner.isSelected())
		{
			maFigure = new Carre(x1,y1,monRempli.isSelected());
			vector.addElement(maFigure);
			((Carre)(vector.lastElement())).setColor(color);
 
		}   
		else if(monTriangle.isSelected() && monDessiner.isSelected()){
		
		maFigure = new Triangle(x1, y1,monRempli.isSelected());
		//maFigure.epaisseur(tailleTrait);
		vector.addElement(maFigure);
		
	}
		
		else if (monHexagone.isSelected() && monDessiner.isSelected())
		{
			
			maFigure = new Hexagone(x1,y1,monRempli.isSelected());
			vector.addElement(maFigure);
			((Hexagone)(vector.lastElement())).setColor(color);
			
		}
		

		else if(monLibre.isSelected() && monDessiner.isSelected())//action a appliquer si on a choisi le bouton radio courbe
		{
			maFigure= new Ligne(x1,y1,false);
			vector.addElement(maFigure);//creation d'une nouvelle courbe
			((Ligne)(vector.lastElement())).setColor(color);


		}
		
		else if(monSegment.isSelected() && monDessiner.isSelected()){
			
			if(point1 == null){
				point1 = new Point(e.getX(), e.getY());
			}else{
				point2 = new Point(e.getX(), e.getY());
				maFigure = new Segment(point1, point2);
				vector.addElement(maFigure);
				point1 = null;
				point2 = null;
			}
			
			//System.out.println(e.getClickCount());
		}
		
		
		
		else if(monSupprimer.isSelected())
		{
			//monSupprimer.setBorderPainted(true);
			int tmpVector= vector.size(); 
			for(int i=(tmpVector-1); i>=0; i--)
			{  
				if (((AbstractFigure)vector.get(i)).contient(x1,y1)==true)
				{
					vector.removeElementAt(i);
					break;
				}
			}                
		}

		else if(monDeplacer.isSelected()||monRedimensionner.isSelected())//action a appliquer si on a choisi le bouton deplacer
		{


			int tmpVector= vector.size();   
			for(int i=(tmpVector-1); i>=0; i--)
			{


				AbstractFigure af =((AbstractFigure)vector.get(i));


				if (af.contient(x1,y1)==true)//on cherche la forme selectionnee
				{	
					num=i;
					if (position ==-1)
							position=i;
					//select = ((AbstractFigure)(vector.get(i))).getColor();


//					//changer de couleur lors de la selection
//					vector.addElement(maFigure);
//					((AbstractFigure)(vector.get(i))).setColor(Color.GREEN);
					info.setText((vector.get(i)).toString());
					info.repaint();


					if ((af).isLigne())
					{
						ligne=(Ligne)vector.get(i); 
						xDeplacer=x1-(int)ligne.x;
						yDeplacer=y1-(int)ligne.y;
					}

					else
					{
						//ici on applique la selection


						x3=((AbstractFigure)vector.get(i)).x;
						y3=((AbstractFigure)vector.get(i)).y;
						break;
					}
				} 
			} 
		}
		

			repaint();

	}


	@Override
	public void mouseMoved(MouseEvent e) {
		pos[0]=e.getX();
		pos[1]=e.getY();      
		repaint();

	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
//		if (monDeplacer.isSelected())
//		{
//			//rendre la couleur d'origine lors du relachement de la souris
//			//((AbstractFigure)(vector.get(num))).setColor(select);
//			repaint();
//		}
		//num=-1;
		//repaint();
	}


	@Override
	public void mouseEntered(MouseEvent e) {repaint();}

	@Override
	public void mouseExited(MouseEvent e) {repaint();}


	@Override
	public void mouseClicked(MouseEvent e)
	{
		if(monDeplacer.isSelected()){
			((AbstractFigure)(vector.get(num))).setColor(color);
			((AbstractFigure)(vector.get(num))).setStrokeColor(colorStroke);
			repaint();
		}
		num=-1;
		repaint();
		
	}



	@Override
	public void actionPerformed(ActionEvent e) 
	{


		Object source=e.getSource();
		if(source==annuler)
		{

			if (vector.size()!=0)
				vector.removeElementAt(vector.size()-1);//on enlève de la collection et du dessin la dernière forme cree
		}

		else if (source==monPlay)
		{
			
		}
		
		else if (source==monFastR)
		{
			
		}
		
		else if (source==monFastL)
		{
			
		}
		
		else if (source==monStop)
		{
			
		}
		/*action a appliquer si on appuie sur le bouton Tout Effacer*/
		else if(source==toutEffacer)
		{
			if (vector.size()!=0)
				vector.removeAllElements();//on enlève de la collection et du dessin toutes les forme crees

		}
		
		else if(source == monButtonCouleur){
			color = JColorChooser.showDialog(this,"Couleur", Color.BLACK);
			//monPanCouleur.setBackground(color);
			couleurFond.setBackground(color);
			//buttonCouleur.setBackground(color);
		
		}else if(source == monButtonStrokeCouleur){
			colorStroke = JColorChooser.showDialog(this,"Stroke Couleur", Color.BLACK);
			couleurStroke.setBackground(colorStroke);
		}

//		else if (source ==rotate) {
//
//			int tmpVector= vector.size();   
//			for(int i=(tmpVector-1); i>=0; i--)
//			{
//
//
//				AbstractFigure af =((AbstractFigure)vector.get(i));
//
//
//				if (af.contient(x1,y1)==true)//on cherche la forme selectionnee
//				{	
//					num=i;
//
//					maFigure=af;
//					//maNvlFigure=null;
//					Graphics2D g2;
//					g2=(Graphics2D)toile.getGraphics();
//					
//					maFigure.rotation(g2);
//					
//					vector.addElement(maFigure);
//					//vector.removeElement(maFigure);
//					
//					
//					
//
//					//repaint();
//
//				}
//			}
//			try{
//				Thread.sleep(1000);
//			}catch(Exception ex){}
//			
//			
//			
//		}
		repaint();
	} 


	/** on paint ici **/
	public class Toile extends JPanel {
	
		// Ce panel nous sert à visualiser nos dessin	

		public Toile()
		{


			super();
			setPreferredSize(new Dimension(700,550));
			setBackground(Color.WHITE);
			setBorder(
					BorderFactory.createTitledBorder(
							BorderFactory.createEtchedBorder(new Color(15, 157, 232),
									new Color(15, 157, 232))));

		}
		public void paintComponent(Graphics g){

			

			super.paintComponent(g);
			graphics2d = (Graphics2D)g;
			/*if(bufferedImage == null){
				bufferedImage = new BufferedImage(this.getWidth(),this.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
				graphics2d = bufferedImage.createGraphics();
			}*/
			//g.drawImage(bufferedImage, 0, 0, null);
			Color col;
			Iterator<AbstractFigure> it =  vector.iterator();//utilisation d'un iterateur car on parcourt la collection à l'endroit en utilisant uniquement la forme courante
			while(it.hasNext())
			{ 
				AbstractFigure figure = (AbstractFigure) it.next();
				//figure.setBufferedImage(bufferedImage);
				col=figure.color; //on recupère la couleur de la forme 

				figure.afficher(graphics2d); //on affiche la forme avec sa couleur

				//ne pas afficher lorsque le bouton deplacer est selectionné
				if(!monDeplacer.isSelected())
					info.setText(maFigure.toString());

			} 


		}

	}


	public class EcouteurMenuBar implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object source = e.getSource();
			if(source == quitter){
				System.exit(1);
			}else if(source == enregistrer){
				System.out.println("J'ai appuyé sur enregister");
				save = new JFileChooser();
				optionSelectionner = save.showSaveDialog(null);
				if(optionSelectionner == JFileChooser.APPROVE_OPTION){
					try{
						ImageIO.write(getBufferedImage(), "png", save.getSelectedFile());
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}
			}
			
		}
		
	}
	


	/* MAIN */
	public static void main (String argv[]){
		SwingUtilities.invokeLater(new Fenetre());

	}	


}
