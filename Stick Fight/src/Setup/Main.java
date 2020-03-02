package Setup;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Main implements ActionListener, KeyListener, MouseListener, MouseMotionListener{

	private JFrame f;
	private Panel p;
	private Timer timer;
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public Main() {
		
	}
	
	public void makeFrame() {
		f = new JFrame();
		f.setTitle("Stick Fight");
		f.setResizable(false);
		f.setFocusable(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setPreferredSize(screenSize);
		makePanel();
		addToPanel();
		addToFrame();
		f.pack();
		f.setVisible(true);
	}
	
	public void addToFrame() {
		f.add(p);
	}
	
	public void addToPanel() {

	}
	
	public void makePanel() {
		p = new Panel();
	}
	
	public void start() {
		//1000/(desired FPS)
		timer = new Timer(1000/60, this);
		timer.start();
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.makeFrame();
		main.start();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
