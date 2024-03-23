
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.awt.event.*; 


public class Game  extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener{

	
	private BufferedImage back; 
	private int key;
	private char typedLetter;
	private Word[][] board;
	private int SIZE;
	private int column;
	private int row;
	private String answer;
	private File filename;
	private ArrayList<String> inputList;
	private ArrayList<String> answerList;
	private boolean win;
	Random random;



	
	public Game() {
		new Thread(this).start();	
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		key =-1; 
		SIZE = 100;
		row = 0;
		column = 0;
		answer = Select();
		filename = new File("sgb-words.txt");
		inputList = new ArrayList<String>();
		answerList = new ArrayList<String>();
		win = false;
		random = new Random();


		board = new Word[5][6];

		for(int j = 0; j<5; ++j){
			for(int i = 0; i<6; ++i){
				board[j][i] = new Word(' ',40,40,40);
			}
		}

		readFile();
		pickAnswer();
	}

	public void readFile(){
	 	try {
	 		Scanner sc = new Scanner(filename); //"Resource Leak"-🤓
	 		while(sc.hasNext()){
				inputList.add(sc.nextLine());
	 		}
			sc.close();
	 	} catch (FileNotFoundException e) {
	 		e.printStackTrace();
	 	}
	 }

	public void pickAnswer(){
		try {
			Scanner sca = new Scanner(new File("shuffled_real_wordles.txt")); //"Resource Leak"-🤓
			while(sca.hasNext()){
			   answerList.add(sca.nextLine());
			}
		   sca.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public String Select(){
		
        
		return answerList.get(random.nextInt(2316) + 1);
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
		if(back == null)
			back=(BufferedImage)( (createImage(getWidth(), getHeight()))); 
		

		Graphics g2d = back.createGraphics();
	
		g2d.clearRect(0,0,getSize().width, getSize().height);
	
		g2d.setFont(new Font("Broadway", Font.BOLD, 50));

		//System.out.println(column);
		
		//set board


		
		
		
		
		
		
		
		
		
		//draw 
		for (int j = 0; j<5; ++j){
			for(int i = 0; i<6; ++i){
				g2d.setColor(new Color(board[j][i].getR(), board[j][i].getG(), board[j][i].getB()));
				g2d.fillRect(j*(SIZE+10)+10, i*(SIZE+10)+10, SIZE, SIZE);
				g2d.setColor(Color.white);
				g2d.drawString((board[j][i].getLetter()+"").toUpperCase(),j*(SIZE+10)+50, i*(SIZE+10)+75);
			}
		}
		
		//win sequence
		if
		Select();
		
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
		System.out.println(key);
		System.out.println(row+" "+column);
		if(key>=65 && key<=90){
			if(column<5){ //typing letters
				board[column][row].setLetter(typedLetter);
				++column;
			}
			
			
		}
		if(key==10 && column==5){ //pressing enter

			System.out.println(""+board[0][row].getLetter()+board[1][row].getLetter()+board[2][row].getLetter()+board[3][row].getLetter()+board[4][row].getLetter());

			for(String word : inputList){ //check for valid input word
				if((word).equals(""+board[0][row].getLetter()+board[1][row].getLetter()+board[2][row].getLetter()+board[3][row].getLetter()+board[4][row].getLetter())){
					for(int i = 0; i<5; ++i){
						board[i][row].checkLetter(answer,i);
					}
					//board[0][0].checkLetter(answer, 0);
					++row;
					column=0;
					System.out.println("enter pressed");
					break;

				}
				
			}
			
			
			
			
			
		}

		if(key==8&&column>0){ //pressing backspace
			--column;
			board[column][row].setLetter(' ');
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
