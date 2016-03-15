package control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

import model.Ball;
import model.Bar;
import model.Brick;
import model.Grid;
import model.HighscoreList;
import view.FinalFrame;
import view.Frame;
import view.ScoreFrame;

public class Controller {

	private String version = "1.2";
	private int optionpanelHeight = 40;
	private int frameHeight = 600 + optionpanelHeight;
	private int frameWidth = 400;
	private int frameX = 300;
	private int frameY = 100;
	
	private Ball ball;
	private Bar bar;
	private Grid grid;
	private int panelWidth = frameWidth-6;
	private int panelHeight = frameHeight-40;
	private int lifes = 3;
	private int level = 0;
	private int maxLevel = 1;
	private boolean running = false;
	private Frame frame;
	private GameThread thread;
	private int score = 0;
	private MusicThread backgroundMusic;
	private boolean finish = false;
	private FinalFrame finalFrame;
	private ScoreFrame scoreFrame;
	private HighscoreList highscoreList;
	private File scorefile = new File("./src/scoreboard.score");
	
	
	public Controller() {
		
	}
	
	/**
	 * Initializes the game, adding a bar, a ball and the bricks to the field.
	 */
	public void initializeGame() {
		bar = new Bar(panelWidth, panelHeight);
		ball = new Ball(panelWidth, panelHeight);
		grid = new Grid();
		grid.fill(0);
		frame = new Frame(this);
		thread = new GameThread(this);
		thread.start();
		backgroundMusic = new MusicThread();
//		backgroundMusic.start();
		finalFrame = new FinalFrame(this);
		highscoreList = new HighscoreList();
		load();
		scoreFrame = new ScoreFrame(this);
	}
	
	/**
	 * Stops the ball and resets the lives to 3.
	 */
	public void reset() {
		grid.fill(0);
		score = 0;
		lifes = 3; 
		level = 0;
		ball.setSpeed(4);
		running = false;
		finish = false;
		finalFrame.setVisible(false);
		this.getFrame().requestFocus();
		thread = new GameThread(this);
		thread.start();
	}
	
	/**
	 * This method is called each tick to move the ball and check for any collisions.
	 */
	public void doLogicBall() {
		
		//Bounce on the left border?
		if (ball.getX() <= 0) {
			ball.setX(ball.getX() + ball.getSpeed());
			doRightLeftBounceLogic();
		}
		//Bounce on the right border?
		else if (ball.getX() +ball.getSize() >= panelWidth) {
			ball.setX(ball.getX() - ball.getSpeed());
			doRightLeftBounceLogic();
		}
		//Bounce on the top border?
		else if (ball.getY() <= 0) {
			ball.setY(ball.getY() + ball.getSpeed());
			doTopBottomBounceLogic();
		}
		//Bounce on the bar?
		else if (ball.intersects(bar)) {
			ball.setY(ball.getY() - ball.getSpeed());
			doBarBounceLogic(bar);
		}
		//Bounce on the bottom border?
		else if (ball.getY()+ball.getSize() >= panelHeight) {
			lifes --;
			running = false;
		}
		//Collides with an brick?
		else {
			Brick brick = ball.intersects(grid); 
			Brick brick2 = ball.intersectsSecond(grid, brick);
			if (brick != null) {
				// cases for double intersect... -->>
				if (brick2 != null) {
					System.out.println("Double Intersect");
					if ((ball.getMiddleY() > brick.getY()+brick.getHeight() || ball.getMiddleY() < brick.getY()) &&
							(ball.getMiddleY() > brick2.getY()+brick2.getHeight() || ball.getMiddleY() < brick2.getY())) {
						doTopBottomBounceLogic();
					}
					else if ((ball.getMiddleX() > brick.getX()+brick.getWidth() || ball.getMiddleX() < brick.getX()) &&
							(ball.getMiddleX() > brick.getX()+brick.getWidth() || ball.getMiddleX() < brick.getX())) {
						doRightLeftBounceLogic();
					}
					else {
						ball.setAngle(ball.getAngle()+180);
					}
					
				}
				 //Brick and Ball intersecting at an edge
				else if (ball.getMiddleX() > brick.getX() && ball.getMiddleX() < brick.getX()+brick.getWidth()) {
					doTopBottomBounceLogic();
					System.out.println("Collision @ Brick("+brick.getPositionArrayX()+":"+brick.getPositionArrayY() +") mirroring @ the x-axis");
					
				}
				else if (ball.getMiddleY() > brick.getY() && ball.getMiddleY() < brick.getY()+brick.getHeight()) {
					doRightLeftBounceLogic();
					System.out.println("Collision @ Brick("+brick.getPositionArrayX()+":"+brick.getPositionArrayY() +") mirroring @ the y-axis");
				}
				
				 //Brick and Ball intersecting at a corner
				else {
					 //LinksOben
					if (ball.getMiddleX() < brick.getX() && ball.getMiddleY() < brick.getY()) {
						System.out.print("Collision TopLeftCorner @ Brick("+brick.getPositionArrayX()+":"+brick.getPositionArrayY() +")");
						doBottomRightCornerBouncingLogic(brick.getX(), brick.getY());
					}
					 //LinksUnten
					else if (ball.getMiddleX() < brick.getX() && ball.getMiddleY() > brick.getY()+brick.getHeight()) {
						System.out.print("Collision BottomLeftCorner @ Brick("+brick.getPositionArrayX()+":"+brick.getPositionArrayY() +")");
						doBottomLeftCornerBouncingLogic(brick.getX(), brick.getY()+brick.getHeight());
					}
					 //RechtsOben
					else if (ball.getMiddleX() > brick.getX()+brick.getWidth() && ball.getMiddleY() < brick.getY()) {
						System.out.print("Collision TopRightCorner @ Brick("+brick.getPositionArrayX()+":"+brick.getPositionArrayY() +")");
						doBottomLeftCornerBouncingLogic(brick.getX()+brick.getWidth(), brick.getY());
					}
					 //RechtsUnten
					else if (ball.getMiddleX() > brick.getX()+brick.getWidth() && ball.getMiddleY() > brick.getY()+brick.getHeight()) {
						System.out.print("Collision BottomRightCorner @ Brick("+brick.getPositionArrayX()+":"+brick.getPositionArrayY() +")");
						doBottomRightCornerBouncingLogic(brick.getX()+brick.getWidth(), brick.getY()+brick.getHeight());
					}
				}
				brick.setAlpha(brick.getAlpha() / 2);
				brick.setHardiness(brick.getHardiness() - 1);
				if (brick.getHardiness() == 0) {
					brick.setVisible(false);
					score += brick.getScore();
					ball.setSpeed(ball.getSpeed()*ball.getAcceleration());
				}
				if (brick2 != null) {
					brick2.setAlpha(brick2.getAlpha() / 2);
					brick2.setHardiness(brick2.getHardiness() - 1);
					if (brick2.getHardiness() == 0) {
						brick2.setVisible(false);
						score += brick2.getScore();
						ball.setSpeed(ball.getSpeed()*ball.getAcceleration());
					}
				}
			}
		}
		
		ball.setAngle(ball.getAngle() % 360);
	}
	//bin auch eben essen
	public void save() {
		try {
			// make sure the file ends with .ocean
			File selectedFile = scorefile;
			// open File Stream
			FileOutputStream os = new FileOutputStream(selectedFile);
			// open object stream
			ObjectOutputStream oos = new ObjectOutputStream(os);
			// write the ocean to the file
			oos.writeObject(highscoreList);
			// close the stream
			oos.close();
			// inform user about success
//			final JOptionPane optionPane = new JOptionPane();
//			JOptionPane.showMessageDialog(optionPane, "Succesfully saved.", "Success", JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception ex) {
			// inform user about failed save process
			ex.printStackTrace();
			final JOptionPane optionPane = new JOptionPane();
			JOptionPane.showMessageDialog(optionPane, "Failed to save.", "Save failed", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void load() {
		try {
			// make sure the file ends with .ocean
			File selectedFile = scorefile;
			// open File Stream
			FileInputStream is = new FileInputStream(selectedFile);
			// open object stream
			ObjectInputStream ois = new ObjectInputStream(is);
			// write the ocean to the file
			highscoreList = (HighscoreList) ois.readObject();
			// close the stream
			ois.close();
			// inform user about success
//			final JOptionPane optionPane = new JOptionPane();
//			JOptionPane.showMessageDialog(optionPane, "Succesfully saved.", "Success", JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception ex) {
			
		}
	}

	public void doTransitionToFinish() {
		
		finalFrame.setVisible(true);
		finalFrame.requestFocus();
		finalFrame.getFinalScore().setText("Your final score: "+this.getScore());
		thread.setRunning(false);
		
	}
	
	public void doTransitionToReset() {
		finalFrame.setVisible(false);
		frame.requestFocus();
		reset();
	}
	
	/**
	 * This method sets the angel, when the ball is intersecting the BottomLeftCorner of a Brick.
	 * 
	 * @param x of the corner
	 * @param y of the corners
	 */
	public void doBottomLeftCornerBouncingLogic(int x, int y) {
		double atan = Math.toDegrees(Math.atan(absValue(ball.getMiddleY() - y) / absValue(ball.getMiddleX() - x)));
		ball.setAngle(ball.getAngle() + 2 * absValue(360 - atan - ball.getAngle()) + 180);
		ball.move();
		System.out.println(" mirroring @ an "+atan+" angle.");
	}
	/**
	 * This method sets the angel, when the ball is intersecting the BottomRightCorner of a Brick.
	 * 
	 * @param x of the corner
	 * @param y of the corners
	 */
	public void doBottomRightCornerBouncingLogic(int x, int y) {
		double atan = Math.toDegrees(Math.atan(absValue(ball.getMiddleY() - y) / absValue(ball.getMiddleX() - x)));
		ball.setAngle(ball.getAngle() - 2 * absValue(360 - atan - ball.getAngle()) + 180);
		ball.move();		
		System.out.println(" mirroring @ an "+(atan+90)+" angle.");
	}
	/**
	 * This method calculates the angle for the ball after bouncing from the sides.
	 */
	public void doRightLeftBounceLogic() {
		ball.setAngle(ball.getAngle() - (ball.getAngle()-270)*2);
	}
	/**
	 * This method calculates the angle for the ball after bouncing from the top and bottom.
	 */
	public void doTopBottomBounceLogic() {
		ball.setAngle(ball.getAngle() - (ball.getAngle()-180)*2);
	}
	/**
	 * This Method calculates the angle with the ball bounces from the bar, depending on the point hit.
	 * @param bar - The Object of the bar used.
	 */
	public void doBarBounceLogic(Bar bar) {
		double DeltaZ = (ball.getMiddleX()) - (bar.getX());
		if (DeltaZ < 0) { DeltaZ = 0;}
		else if (DeltaZ > bar.getWidth()) { DeltaZ = bar.getWidth();}
		double OnePer = (((double)bar.getWidth())/100);
		double z = OnePer * DeltaZ /100;
		ball.setAngle(210+z*120.0);
	}
	/**
	 * This method calculates and returns the absolute value of the given number.
	 * @param x
	 */
	private double absValue(double x) {
		if (x < 0) {return x*(-1);}
		return x;
	}
	
	// Getter and Setter: ...
	/**
	 * Returns the optionpanel's height.
	 * @return
	 */
	public int getOptionpanelHeight() {
		return optionpanelHeight;
	}
	/**
	 * Sets the optionpanel's height to the given value.
	 * @param optionpanelHeight
	 */
	public void setOptionpanelHeight(int optionpanelHeight) {
		this.optionpanelHeight = optionpanelHeight;
	}
	/**
	 * Returns the actual height of the frame.
	 * @return
	 */
	public int getFrameHeight() {
		return frameHeight;
	}
	/**
	 * Sets the height of the frame to the given value.
	 * @param frameHeight
	 */
	public void setFrameHeight(int frameHeight) {
		this.frameHeight = frameHeight;
	}
	/**
	 * Returns the frame's actual width.
	 * @return 
	 */
	public int getFrameWidth() {
		return frameWidth;
	}
	/**
	 * Sets the frames width to the given value.
	 * @param frameWidth
	 */
	public void setFrameWidth(int frameWidth) {
		this.frameWidth = frameWidth;
	}
	/**
	 * Returns the actually used ball.
	 * @return
	 */
	public Ball getBall() {
		return ball;
	}
	/**
	 * Sets the given ball-object to be used.
	 * @param ball
	 */
	public void setBall(Ball ball) {
		this.ball = ball;
	}
	/**
	 * Returns the actually used bar.
	 * @return
	 */
	public Bar getBar() {
		return bar;
	}
	/**
	 * Sets the given bar-object to be used.
	 * @param bar
	 */
	public void setBar(Bar bar) {
		this.bar = bar;
	}
	/**
	 * Returns the actually used Grid.
	 * @return
	 */
	public Grid getGrid() {
		return grid;
	}
	/**
	 * Sets the given grid-object to be used.
	 * @param grid
	 */
	public void setGrid(Grid grid) {
		this.grid = grid;
	}
	/**
	 * Returns the panel's actual width.
	 * @return
	 */
	public int getPanelWidth() {
		return panelWidth;
	}
	/**
	 * Sets the panel's width to the given value.
	 * @param panelWidth
	 */
	public void setPanelWidth(int panelWidth) {
		this.panelWidth = panelWidth;
	}
	/**
	 * Returns the panel's actual height.
	 * @return
	 */
	public int getPanelHeight() {
		return panelHeight;
	}
	/**
	 * sets the panel's height to the given value.
	 * @param panelHeight
	 */
	public void setPanelHeight(int panelHeight) {
		this.panelHeight = panelHeight;
	}
	/**
	 * Returns the actual number of lives left.
	 * @return
	 */
	public int getLifes() {
		return lifes;
	}
	/**
	 * Sets the amount of lives to the given value.
	 * @param lifes
	 */
	public void setLifes(int lifes) {
		this.lifes = lifes;
	}
	/**
	 * Returns true, if the game is actually running and false otherwise.
	 * @return
	 */
	public boolean isRunning() {
		return running;
	}
	/**
	 * Should be set to true as the game starts running(the ball starts moving), and false in case of the opposite event.
	 * @param running
	 */
	public void setRunning(boolean running) {
		this.running = running;
	}
	/**
	 * Returns the actually used frame.
	 * @return
	 */
	public Frame getFrame() {
		return frame;
	}
	/**
	 * Sets the given frame to be used.
	 * @param frame
	 */
	public void setFrame(Frame frame) {
		this.frame = frame;
	}
	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}
	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}
	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	/**
	 * @return the maxLevel
	 */
	public int getMaxLevel() {
		return maxLevel;
	}
	/**
	 * @param maxLevel the maxLevel to set
	 */
	public void setMaxLevel(int maxLevel) {
		this.maxLevel = maxLevel;
	}
	/**
	 * @return the finish
	 */
	public boolean isFinish() {
		return finish;
	}
	/**
	 * @param finish the finish to set
	 */
	public void setFinish(boolean finish) {
		this.finish = finish;
	}

	/**
	 * @return the frameX
	 */
	public int getFrameX() {
		return frameX;
	}

	/**
	 * @param frameX the frameX to set
	 */
	public void setFrameX(int frameX) {
		this.frameX = frameX;
	}

	/**
	 * @return the frameY
	 */
	public int getFrameY() {
		return frameY;
	}

	/**
	 * @param frameY the frameY to set
	 */
	public void setFrameY(int frameY) {
		this.frameY = frameY;
	}

	/**
	 * @return the finalFrame
	 */
	public FinalFrame getFinalFrame() {
		return finalFrame;
	}

	/**
	 * @param finalFrame the finalFrame to set
	 */
	public void setFinalFrame(FinalFrame finalFrame) {
		this.finalFrame = finalFrame;
	}

	/**
	 * @return the scoreFrame
	 */
	public ScoreFrame getScoreFrame() {
		return scoreFrame;
	}

	/**
	 * @param scoreFrame the scoreFrame to set
	 */
	public void setScoreFrame(ScoreFrame scoreFrame) {
		this.scoreFrame = scoreFrame;
	}

	/**
	 * @return the highscoreList
	 */
	public HighscoreList getHighscoreList() {
		return highscoreList;
	}

	/**
	 * @param highscoreList the highscoreList to set
	 */
	public void setHighscoreList(HighscoreList highscoreList) {
		this.highscoreList = highscoreList;
	}

	
}
