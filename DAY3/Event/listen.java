package DAY3.Event;

import java.awt.event.*;
import javax.swing.*;

/**
 * 事件源：按钮 图片 窗体
 * 事件：鼠标点击 键盘点击...
 * 绑定监听：当事件源上发生了某个事件，则触发执行某代码
 * 接口：ActionListener MouseListener KeyListener
*/
public class listen {
    public static void main(String[] args) {
       JFrame frame = new JFrame();

       frame.setSize(514,538);
       frame.setLocationRelativeTo(null);
       frame.setLayout(null);
       frame.setDefaultCloseOperation(3);

       JButton bt = new JButton("bt");
       bt.setBounds(0, 0, 100, 100);
       frame.getContentPane().add(bt);

        bt.addMouseListener(new Mouseex());




       frame.setVisible(true);
    }
}

class Act implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        System.err.println("hhhhh");
    }
}

class Mouse implements MouseListener{
    
    @Override
    public void mouseClicked(MouseEvent e){

    }

    @Override
    public void mouseEntered(MouseEvent e){
        
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

class Mouseclk extends Mouse{
    @Override
    public void mouseClicked(MouseEvent e){
        System.out.println("Clicked!");
    }
}

class Mouseen extends Mouse{
    @Override
    public void mouseEntered(MouseEvent e){
        System.out.println("Entered!");
    }
}

class Mouseex extends Mouse{
    @Override
    public void mouseExited(MouseEvent e){
        System.out.println("Exited!");
    }
}

class Key implements KeyListener{
    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}