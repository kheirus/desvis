package com.phlacheux.animation;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SpringLayout;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import com.phlacheux.vue.Fenetre;
import com.phlacheux.vue.RoundedBorder;
import com.phlacheux.vue.RoundButton;
public class VisioPanel extends JPanel {

	
	private JButton play;
	private JButton pause;
	private JButton stop;
	private JButton fastR;
	private JButton fastL;
	private JSlider slide;
	
	

	public JSlider getSlide() {
		return slide;
	}


	public void setSlide(JSlider slide) {
		this.slide = slide;
	}


	public VisioPanel(JPanel panel,SpringLayout l){
		
		super();
		
		setPreferredSize(new Dimension(600, 60));
		setBackground(new Color(90, 94, 107));
		//setBorder(new RoundedBorder(Color.BLUE, 0, 0));
		
		l.getClass();
		ImageIcon iconPlay = createImageIcon("button_play_blue.png", "Play");
		ImageIcon iconFastR = createImageIcon("button_fastforward_blue.png", "Fast forward");
		ImageIcon iconFastL = createImageIcon("button_rewind_blue.png", "Rewind");
		ImageIcon iconStop = createImageIcon("button_stop_blue.png", "Stop");
		ImageIcon iconPause = createImageIcon("button_pause_blue.png", "Pause");
		
		play = new JButton(iconPlay);
		fastR = new JButton(iconFastR);
		fastL = new JButton(iconFastL);
		stop = new JButton(iconStop);
		slide = new JSlider(0,0,4,0);
		pause = new JButton(iconPause);
		
		play.setPreferredSize(new Dimension(iconPlay.getIconWidth(), iconPlay.getIconHeight()));
		fastR.setPreferredSize(new Dimension(iconFastR.getIconWidth(), iconFastR.getIconHeight()));
		fastL.setPreferredSize(new Dimension(iconFastL.getIconWidth(), iconFastL.getIconHeight()));
		stop.setPreferredSize(new Dimension(iconStop.getIconWidth(), iconStop.getIconHeight()));
		pause.setPreferredSize(new Dimension(iconPause.getIconWidth(), iconPause.getIconHeight()));
		
		play.setBackground(this.getBackground());
		play.setBorderPainted(false);
		pause.setBackground(this.getBackground());
		pause.setBorderPainted(false);
		fastR.setBackground(this.getBackground());
		fastR.setBorderPainted(false);
		fastL.setBackground(this.getBackground());
		fastL.setBorderPainted(false);
		stop.setBackground(this.getBackground());
		stop.setBorderPainted(false);
		slide.setBackground(getBackground());
		
		
		

		
		l.putConstraint(SpringLayout.NORTH, this,
				10,
				SpringLayout.SOUTH,panel);

		l.putConstraint(SpringLayout.HORIZONTAL_CENTER, this,
				-70,
				SpringLayout.VERTICAL_CENTER,panel);
		
		
		this.add(fastL);
		this.add(play);
		this.add(fastR);
		this.add(slide);
		this.add(stop);
		
		

		
	}
	
	
	public JButton getPlay() {
		return play;
	}


	public void setPlay(JButton play) {
		this.play = play;
	}


	public JButton getPause() {
		return pause;
	}


	public void setPause(JButton pause) {
		this.pause = pause;
	}


	public JButton getStop() {
		return stop;
	}


	public void setStop(JButton stop) {
		this.stop = stop;
	}


	public JButton getFastR() {
		return fastR;
	}


	public void setFastR(JButton fastR) {
		this.fastR = fastR;
	}


	public JButton getFastL() {
		return fastL;
	}


	public void setFastL(JButton fastL) {
		this.fastL = fastL;
	}


	private static ImageIcon createImageIcon(String path , String description) {
		java.net.URL imgURL = Fenetre.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
	
}
