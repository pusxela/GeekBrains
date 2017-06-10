/*
 * Java 1. Lesson 8. Game Tic Tac Toe
 * Class: Main-Class
 *
 * @author Sergey Iryupin
 * @version 0.3 dated May 30, 2017
 * modified by Alexey Krylov - June 3, 2017
 * - background set to green
 * - added sounds to human turn & game over
 * - added icon to message
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TicTacToe extends JFrame {

    final String TITLE_OF_PROGRAM = "Tic Tac Toe";
    final int START_POSITION = 500;
    final int WINDOW_SIZE = 500;
    final int WINDOW_DX = 9;
    final int WINDOW_DY = 57;
    final int FIELD_SIZE = 3;
    final int CELL_SIZE = WINDOW_SIZE / FIELD_SIZE;
    final String BTN_INIT = "New game";
    final String BTN_EXIT = "Exit";

    Canvas canvas = new Canvas();
    Field field = new Field(FIELD_SIZE, CELL_SIZE);
    Human human = new Human(field.getHumanDot());
    AI ai = new AI(field.getAIDot());
	Icon icon = new ImageIcon("i.jpg");	// icon for message

    public static void main(String args[]) {
        new TicTacToe();
    }

    TicTacToe() {
        setTitle(TITLE_OF_PROGRAM);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(START_POSITION, START_POSITION, WINDOW_SIZE + WINDOW_DX, WINDOW_SIZE + WINDOW_DY);

        canvas.setBackground(Color.white);
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
				human.turn(e.getX()/CELL_SIZE, e.getY()/CELL_SIZE, field, ai);
                canvas.repaint();
				Sound.playSound("sounds/done.wav").join(); // sound human turn
                if (field.isGameOver()) {
                    JOptionPane.showMessageDialog(TicTacToe.this, field.getGameOverMsg(),"Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE, icon);
					Sound.playSound("sounds/game.wav").join(); // game over sound
				}
            }
        });
        JButton init = new JButton(BTN_INIT);
        init.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                field.init();
                canvas.repaint();
			}
        });
        JButton exit = new JButton(BTN_EXIT);
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel bp = new JPanel();
		
        bp.setLayout(new GridLayout()); // for button panel
        bp.add(init);
        bp.add(exit);
		
		
        setLayout(new BorderLayout()); // for main window
        add(bp, BorderLayout.SOUTH);
        add(canvas, BorderLayout.CENTER);
		canvas.setBackground(Color.GREEN);	// set background green		
		
        setVisible(true);
    }

		
    class Canvas extends JPanel { // for painting
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            field.paint(g);
        }
    }
}