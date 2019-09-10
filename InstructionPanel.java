/**
 * Auto Generated Java Class.
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class InstructionPanel extends JPanel{
  private static final long serialVersionUID = 5055679736784226108L;
  private static final int SMALL_INSET = 20;
  private static final int LARGE_INSET = 40;
  private static final int STATS_INSET = 175;
  private static final int TEXT_STRIDE = 25;
  private static final Font SMALL_FONT = new Font("Arial", Font.BOLD, 11);
  private static final Font LARGE_FONT = new Font("Arial Black", Font.BOLD, 13);
  private static final Color DRAW_COLOR = new Color(0,0,0);
  private TetrisLauncher tetris;
  
  // Constructor for instruction panel
  public InstructionPanel(TetrisLauncher tetris) {
    this.tetris = tetris;
    setPreferredSize(new Dimension(200, GamePanel.PANEL_HEIGHT));
    setBackground(new Color (255,99,71));
  }
  
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    
    //Set the color for drawing.
    g.setColor(DRAW_COLOR);
    
   
    int offset;
    // Draws the instructions
    g.setFont(LARGE_FONT);
    g.drawString("Keys", SMALL_INSET, offset = STATS_INSET);
    g.setFont(SMALL_FONT);
    g.drawString("Arrow Left - Move Left", LARGE_INSET, offset += TEXT_STRIDE);
    g.drawString("Arrow Right - Move Right", LARGE_INSET, offset += TEXT_STRIDE);
    g.drawString("Arrow Up - Rotate Clockwise", LARGE_INSET, offset += TEXT_STRIDE);
    g.drawString("Arrow Down - Move Down", LARGE_INSET, offset += TEXT_STRIDE);
    g.drawString("Space - Drop", LARGE_INSET, offset += TEXT_STRIDE);
    g.drawString("P - Pause Game", LARGE_INSET, offset += TEXT_STRIDE);

    TileType type = tetris.getNextPieceType();
    if(!tetris.isGameOver() && type != null) {
  
    }
  }
}
