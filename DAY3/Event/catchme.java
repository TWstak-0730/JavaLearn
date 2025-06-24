package DAY3.Event;

import java.awt.event.*;
import java.util.Random;
import javax.swing.*;


public class catchme extends JFrame implements MouseListener {
    Random a;
    JButton bt;

    public static void main(String[] args) {
        catchme tmp = new catchme();
        tmp.init();
    }

    public void init(){
       setSize(514,538);
       setLocationRelativeTo(null);
       setLayout(null);
       setDefaultCloseOperation(3);

       bt = new JButton("bt");
       bt.setBounds(0, 0, 100, 100);
       getContentPane().add(bt);

        bt.addMouseListener(this);
        a= new Random();
       setVisible(true);

    }
    int abs(int x,int y){
        return x>y?x-y:y-x;
    }
    @Override
    public void mouseClicked(MouseEvent e){

    }

    @Override
    public void mouseEntered(MouseEvent e){
        int x = a.nextInt(414);
        int y = a.nextInt(438);
        while(abs(x, bt.getLocation().x)<100&&abs(y, bt.getLocation().y)<100){
            x = a.nextInt(414);
            y = a.nextInt(438);
        }
        bt.setBounds(x, y, 100, 100);
        System.out.println(bt.getLocation());
    }

    @Override
    public void mouseExited(MouseEvent e){
        
    }

    @Override
    public void mousePressed(MouseEvent e){
        
    }

    @Override
    public void mouseReleased(MouseEvent e){
        
    }

}
