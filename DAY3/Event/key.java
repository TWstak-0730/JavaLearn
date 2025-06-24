package DAY3.Event;

import java.awt.event.*;
import javax.swing.*;

public class key extends JFrame implements KeyListener{
    public static void main(String[] args) {
        key a = new key();
        a.init();
    }

    public void init(){
        
        setSize(514,538);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(3);
        this.addKeyListener(this);
        
        
        setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("键盘按下了"+e.getKeyCode()+e.getKeyChar());
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("键盘松开了"+e.getKeyCode()+e.getKeyChar());
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}
