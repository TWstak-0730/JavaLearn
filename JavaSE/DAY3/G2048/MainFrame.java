package DAY3.G2048;

import java.awt.HeadlessException;
import javax.swing.*;

public class MainFrame extends JFrame{
    int[][] datas = {
        {8,2,2,4},
        {2,2,4,4},
        {8,8,2,4},
        {8,32,8,64}
    };

    public MainFrame() throws HeadlessException {
        initFrame();
        ShowGame();
        setVisible(true);
    }
    
    /**
     * 此方法用于初始化窗体，所有窗体的相关设置都在这个方法中完成
    */
    public void initFrame(){
        setTitle("2048");
        setLayout(null);
        setSize(800,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setAlwaysOnTop(true);
    }
    /**
     * 此方法用于绘制游戏界面
    */
    public void ShowGame(){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                JLabel image = new JLabel(new ImageIcon("C:\\Users\\STAK\\Desktop\\JavaLearn\\2048\\"+datas[i][j]+".png"));
                image.setBounds(50+100*j,50+100*i, 100, 100);
                getContentPane().add(image);
            }
        }

        JLabel bg = new JLabel(new ImageIcon("C:\\Users\\STAK\\Desktop\\JavaLearn\\2048\\background.png"));
        bg.setBounds(40,40,420,420);
        getContentPane().add(bg);
    }

}
