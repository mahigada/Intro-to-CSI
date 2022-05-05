package threemensmorris;
/*
Mahi Gada
Professor Kappleau
CS113 H02
4 May 2019
*/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
public class ThreeMensMorris extends JFrame {
    /**
     * @param args the command line arguments
     */
  private class GameButton extends JButton {
        private GameButton(int id) {
            this.id = id;
            setFont(new Font(getFont().getClass().getName(), Font.BOLD, 128));
        }
        private int id;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ThreeMensMorris();
            }
        });
    }
    private ThreeMensMorris() {
        super("Three Men's Morris");
        launch();
    }
    private boolean isWin() {
         return board[0][0] == player && board[0][1] == player && board[0][2] == player ||
               board[1][0] == player && board[1][1] == player && board[1][2] == player ||
               board[2][0] == player && board[2][1] == player && board[2][2] == player ||
               board[0][0] == player && board[1][0] == player && board[2][0] == player ||
               board[0][1] == player && board[1][1] == player && board[2][1] == player ||
               board[0][2] == player && board[1][2] == player && board[2][2] == player ||
               board[0][0] == player && board[1][1] == player && board[2][2] == player ||
               board[0][2] == player && board[1][1] == player && board[2][0] == player;
    }
    private boolean isLegal(int row, int col) {
		return legalM[row][col];
	}
	private void clearLegal() {
		legalM = new boolean[3][3];
	}
	private void setLegal(int row,int col) {
		legalM[row][col] = true;
	}
	private void setAdjacentsLegal(int row, int col){
		if ((row<=1) && (board[row+1][col]==0)){
			legalM[row+1][col]=true;
                }
		if ((row>=1) && (board[row-1][col]==0)){
			legalM[row-1][col]=true;
		}
		if ((col<=1) && (board[row][col+1]==0)){
			legalM[row][col+1]=true;
		}
		if ((col>=1) && (board[row][col-1]==0)){
			legalM[row][col-1]=true;
		}
		if((((row==0) && (col==0))||((row==0) && (col==2))||((row==2) && (col==0))||((row==2) 
                        && (col==2))) && (board[1][1]==0)){
			legalM[1][1]=true;
		}
		if((row == 1 && col == 1)) {
			if (board[0][0]==0) legalM[0][0] = true;
			if (board[0][2]==0) legalM[0][2] = true;
			if (board[2][0]==0) legalM[2][0] = true;
			if (board[2][2]==0) legalM[2][2] = true;
		}
	}
	private boolean hasLegal(int row, int col){
		if ((row<=1) && (board[row+1][col]==0)){
			return true;
		}
		if ((row>=1) && (board[row-1][col]==0)){
			return true;
		}
		if ((col<=1) && (board[row][col+1]==0)){
			return true;
		}
		if ((col>=1) && (board[row][col-1]==0)){
			return true;
		}
		if((((row==0) && (col==0))||((row==0) && (col==2))||((row==2) && (col==0))||((row==2) && (col==2))) && (board[1][1]==0)){
			return true;
		}
		if((row == 1 && col == 1)) {
			if (board[0][0]==0) return true;
			if (board[0][2]==0) return true;
			if (board[2][0]==0) return true;
			if (board[2][2]==0) return true;
		}
		return false;
	}
    private JMenu createGameJMenu() {
        JMenu m = new JMenu("Game");
        m.setMnemonic(KeyEvent.VK_G);
        m.add(createGameNewJMenuItem());
        m.addSeparator();
        m.add(createGameQuitJMenuItem());
        return m;
    }
    private JMenuItem createGameNewJMenuItem() {
        JMenuItem mi = new JMenuItem("New");

        mi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                performNewAction();
            }
        });
        mi.setMnemonic(KeyEvent.VK_N);
        mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));
        return mi;
    }
    private JMenuItem createGameQuitJMenuItem() {
        JMenuItem mi = new JMenuItem("Quit");
        mi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                performQuitAction();
            }
        });
        mi.setMnemonic(KeyEvent.VK_Q);
        mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_MASK));

        return mi;
    }
    private JMenu createHelpJMenu() {
        JMenu m = new JMenu("Help");
        m.setMnemonic(KeyEvent.VK_H);
        m.add(createHelpAboutJMenuItem());
        return m;
    }
    private JMenuItem createHelpAboutJMenuItem() {
        JMenuItem mi = new JMenuItem("About");
        mi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                performAboutAction();
            }
        });
        mi.setMnemonic(KeyEvent.VK_A);
        return mi;
    }
    private JMenuBar createJMenuBar() {
        JMenuBar mb = new JMenuBar();
        mb.add(createGameJMenu());
        mb.add(createHelpJMenu());
        return mb;
    }
    private void launch() {
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        int width  = Toolkit.getDefaultToolkit().getScreenSize().width ;
        setBounds(width / 2 - 300, height / 2 - 300, 600, 600);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setJMenuBar(createJMenuBar());
        setLayout(new GridLayout(3, 0));
        setResizable(false);
        for (int i = 0; i < 9; ++i) {
            add(grid[i] = new GameButton(i));
            grid[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    performGameAction((GameButton)ae.getSource());
                }
            });
        }
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                performQuitAction();
            }
        });
		for (int i = 0; i<legalM.length; i++) {
			for (int j =0; j<legalM[i].length; j ++){
				legalM[i][j] = true;
			}
		}
        setVisible(true);
    }
    private void performAboutAction() {

        JOptionPane.showMessageDialog(this, "Three Men's Morris\nAuthor: Mahi\nVersion: 5.0.1a\nDate: 11-NOV-2010", "About", JOptionPane.INFORMATION_MESSAGE);
    }
    private void performGameAction(GameButton gb) {
         int row = gb.id%3;
        int col = (int) gb.id/3;
        if (! isLegal(row,col)){
        	if (gb.getText().equals("X") && player !=1 || gb.getText().equals("O") && player != -1){
        		JOptionPane.showMessageDialog(this, "It's not your turn!");
        	}
        	else {
        		JOptionPane.showMessageDialog(this, "That is an illegal move!");
        	}
        }
 if (gb.getText().equals("") && tokens!=0 && isLegal(row,col)) {
            gb.setText(player == 1 ? "X" : "O");
            board[row][col] = player;
            legalM[row][col] = false;
            tokens--;
            if (isWin()) {
                for (GameButton b : grid) {
                    b.setEnabled(false);
                }
                int choice = JOptionPane.showConfirmDialog(this, (player == 1 ? x : o) + " wins! Play again?", "Play again? (Y/N)", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (choice == JOptionPane.YES_OPTION) {
                    performNewAction();
                    return;
                }
            }
            player = -player;
            if (tokens ==0){
            	clearLegal();
            	String a  = player == 1 ? "X" : "O";
            	for (int i =0; i<grid.length; i++){ 
            		if (grid[i].getText().equals(a)) {
            			int nrow = grid[i].id%3;
            	        int ncol = (int) grid[i].id/3;
            	        setLegal(nrow,ncol); 
            		}
            	}
            }
        }
        else if (gb.getText().equals("X") && player == 1 && tokens==0 && isLegal(row,col)){
        	if (! hasLegal(row,col)){
        		JOptionPane.showMessageDialog(this, "That piece is blocked!");
        		return;
        	}
        	gb.setText("");
        	tokens++;
        	board[row][col] = 0;
        	legalM[row][col] = false;
        	setAdjacentsLegal(row,col);
        }
        else if (gb.getText().equals("O") && player == -1 && tokens==0 && isLegal(row,col)){
        	if (! hasLegal(row,col)){
        		JOptionPane.showMessageDialog(this, "That piece is blocked!");
        		return;
        	}
        	gb.setText("");
        	tokens++;
        	board[row][col] = 0;
        	legalM[row][col] = false;
        	setAdjacentsLegal(row,col);
        }
    }
    private void performNewAction() {
        player = 1;
        board = new int[3][3];
        tokens = 6;
        for (GameButton gb : grid) {
            gb.setText("");
            gb.setEnabled(true);
       }
         for (int i = 0; i<legalM.length; i++) {
			for (int j =0; j<legalM[i].length; j ++){
				legalM[i][j] = true;
			}
         }}
   private void performQuitAction() {
        int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to quit?", "Quit (Y/N)", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (choice == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
    private GameButton[] grid = new GameButton[9];
     private int[][] board = new int[3][3];
     private boolean[][] legalM = new boolean[3][3];
     private int player = 1;
    private int tokens = 6;
    private String x = "Player X";
    private String o = "Player O";
}