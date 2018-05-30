package View;

import Model.ArcMap;
import java.awt.BorderLayout;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;


public class GameFrame extends JFrame {

    private GameCanvas canvas;
    //CanvasThread updateScreenThread = new CanvasThread(canvas); 
    private ArcMap archive;
    private int width;
    private int hight;
    public static final int AREA = 60;

    
    public GameFrame(ArcMap archve) {
    this.archive = archve;
    this.width = archve.getArcWidth();
    this.hight = archive.getArcHeight();
    
    canvas = new GameCanvas(archive);    
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    setLayout(new BorderLayout());
    setTitle("Stellar Battle");
    add(BorderLayout.CENTER, canvas);
    setResizable(false);

    // Define largura e altura da janela principal
    setSize(AREA * width, canvas.AREA * hight);
    setLocationRelativeTo(null);

    //setVisible(true);

    // Inicia Thread com timer para redesenhar a tela.
    //updateScreenThread.start();

    canvas.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {
            int x=e.getX();
            int y=e.getY();

            int x_pos = x/canvas.AREA;
            int y_pos = y/canvas.AREA;

            canvas.setShot(x_pos, y_pos);

            }

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

    });
    }

}