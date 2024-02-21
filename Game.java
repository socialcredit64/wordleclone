
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.event.*; 


public class Game  extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener{

	
	private BufferedImage back; 
	private int key;
	private char typedLetter;
	private Word[][] board;
	private Word[] answer;
	private int SIZE;
	private int column;
	private int row;



	
	public Game() {
		new Thread(this).start();	
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		key =-1; 
		SIZE = 100;
		row = 0;
		column = 0;

		answer = new Word[5];

		answer[0] = new Word(' ',40,40,40);
		answer[1] = new Word(' ',40,40,40);
		answer[2] = new Word(' ',40,40,40);
		answer[3] = new Word(' ',40,40,40);
		answer[4] = new Word(' ',40,40,40);

		board = new Word[5][6];

		for(int j = 0; j<5; ++j){
			for(int i = 0; i<6; ++i){
				board[j][i] = new Word(' ',40,40,40);
			}
		}

	}

	
	
	public void run()
	   {
	   	try
	   	{
	   		while(true)
	   		{
	   		   Thread.currentThread().sleep(5);
	            repaint();
	         }
	      }
	   		catch(Exception e)
	      {
	      }
	  	}
	

	
	
	
	public void paint(Graphics g){
		
		Graphics2D twoDgraph = (Graphics2D) g; 
		if( back ==null)
			back=(BufferedImage)( (createImage(getWidth(), getHeight()))); 
		

		Graphics g2d = back.createGraphics();
	
		g2d.clearRect(0,0,getSize().width, getSize().height);
	
		g2d.setFont( new Font("Broadway", Font.BOLD, 50));
		
		//set board


		
		
		
		
		
		
		
		
		
		//draw 
		for (int j = 0; j<5; ++j){
			for(int i = 0; i<6; ++i){
				//g2d.setColor(board[j][i].getColor());
				g2d.setColor(Color.GRAY);
				g2d.fillRect(j*(SIZE+10)+10, i*(SIZE+10)+10, SIZE, SIZE);
				g2d.setColor(Color.white);
				g2d.drawString(""+board[j][i].getLetter(),j*(SIZE+10)+50, i*(SIZE+10)+50);
			}
		}
		
		
		
		twoDgraph.drawImage(back, null, 0, 0);

	}

	



	//DO NOT DELETE
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}




//DO NOT DELETE
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		key = e.getKeyCode();
		typedLetter = e.getKeyChar();
		System.out.println(typedLetter);
		
		if(typedLetter!='?' || typedLetter!=' '){
			if(row<6){
				if(column<5){
				board[row][column].setLetter(typedLetter);
				++column;
			}
			else{
				++row;
			}
			
		}
			
			
		}
		 
		
	
	}


	//DO NOT DELETE
	@Override
	public void keyReleased(KeyEvent e) {
		
		
		
		
	}



	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}



	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//store symbol then switch char
		
		
			
		
		
	}



	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("entered");
	}



	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("exited");
	}



	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		System.out.println("you clicked at"+arg0.getX()+", "+arg0.getY());

		
		
	}



	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	

	
}
