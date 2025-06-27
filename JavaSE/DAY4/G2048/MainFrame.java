package DAY4.G2048;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class MainFrame extends JFrame implements KeyListener,ActionListener{
    // int[][] datas = {
    //     {2,4,8,16},
    //     {4,8,16,32},
    //     {8,16,32,64},
    //     {16,32,64,2}
    // };
    JMenuBar menuBar = new JMenuBar();

        JMenu menu1 = new JMenu("换肤");
        JMenu menu2 = new JMenu("关于我们");
        JMenu menu3 = new JMenu("功能");

        JMenuItem item1 = new JMenuItem("经典");
        JMenuItem item2 = new JMenuItem("科技");
        JMenuItem item3 = new JMenuItem("简约");
        JMenuItem func1 = new JMenuItem("重新开始");
    private int score = 0;
    private int[][] datas = new int[4][4];
    private boolean WinFlag = false;
    private boolean LoseFlag = false;
    public MainFrame() throws HeadlessException {
        initFrame();
        initMenu();
        GameReset();
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
        this.addKeyListener(this);

    }
    /**
     * 此方法用于绘制游戏界面
    */
    public void ShowGame(){
        getContentPane().removeAll();

        if(LoseFlag){
            JLabel losepic = new JLabel(new ImageIcon("C:\\Users\\STAK\\Desktop\\JavaLearn\\2048\\gameOver.png"));
            losepic.setBounds(90, 100, 334, 228);
            getContentPane().add(losepic);
        }



        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(datas[i][j]!=0){
                    JLabel image = new JLabel(new ImageIcon("C:\\Users\\STAK\\Desktop\\JavaLearn\\2048\\"+datas[i][j]+".png"));
                    image.setBounds(50+100*j,50+100*i, 100, 100);
                    getContentPane().add(image);
                }

            }
        }

        JLabel bg = new JLabel(new ImageIcon("C:\\Users\\STAK\\Desktop\\JavaLearn\\2048\\background.png"));
        bg.setBounds(40,40,420,420);
        getContentPane().add(bg);
        

        JLabel scorelabel = new JLabel("得分："+score);
        scorelabel.setBounds(50, 20, 100, 20);
        getContentPane().add(scorelabel);

        getContentPane().repaint();
    }

    /**
     * 此方法用于初始化菜单
    */
    public void initMenu(){
        menu1.add(item1);
        menu1.add(item2);
        menu1.add(item3);
        menu3.add(func1);
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        setJMenuBar(menuBar);
        item1.addActionListener(this);
        item2.addActionListener(this);
        item3.addActionListener(this);
        func1.addActionListener(this);
        menu2.addActionListener(this);
    }

    /**
     * 此方法用于游戏重置
    */
    public void  GameReset(){
        score = 0;
        WinFlag = false;
        LoseFlag = false;
        
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                datas[i][j] = 0;
            }
        }
        
        GenNewNum();
    }
     @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println("键盘按下了");
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //System.out.println("键盘松开了"+e.getKeyCode());
        switch (e.getKeyCode()) {
            case 38:
                System.out.println("上");
                UpMove();
                break;
            case 40:
                System.out.println("下");
                DwMove();
                break;
            case 37:
                System.out.println("左");
                LeftMove();
                break;
            case 39:
                System.out.println("右");
                RightMove();
                break;
        }
        GenNewNum();
        if(CheckWin()){
            Win();
        }
            if(CheckFull()&&CheckLose()){
            Lose();
        }
        ShowGame();
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    void printTable(){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.printf("%2d ",datas[i][j]);

        }
        System.out.println("");}
        System.out.println();
    }
    void LeftMove(){
        Stack<Integer> st = new Stack<>();
        Stack<Integer> tmp = new Stack<>();
        for(int i=0;i<4;i++){
            boolean flag = true;
            for(int j=0;j<4;j++){
                if(datas[i][j]!=0){
                    if(!st.isEmpty()){
                        if(st.peek()!=datas[i][j]){
                            st.push(datas[i][j]);
                            flag = true;
                        }
                        else if(flag){
                            st.push(st.pop()+datas[i][j]);
                            flag = false;
                            score += 10;
                        }else{
                            st.push(datas[i][j]);
                            flag = true;
                        }
                    }else{
                        st.push(datas[i][j]);
                    }
                }
            }
            while(!st.isEmpty()){
                tmp.push(st.pop());
            }
            int _j = 0;
            while(!tmp.isEmpty()){
                datas[i][_j++]=tmp.pop();
            }
            while(_j<4){
                datas[i][_j++]=0;
            }
        }


    }

    void RightMove(){
        Stack<Integer> st = new Stack<>();
        Stack<Integer> tmp = new Stack<>();
        for(int i=0;i<4;i++){
            boolean flag = true;
            for(int j=3;j>=0;j--){
                if(datas[i][j]!=0){
                    if(!st.isEmpty()){
                        if(st.peek()!=datas[i][j]){
                            st.push(datas[i][j]);
                            flag = true;
                        }
                        else if(flag){
                            st.push(st.pop()+datas[i][j]);
                            flag = false;
                            score += 10;
                        }else{
                            st.push(datas[i][j]);
                            flag = true;
                        }
                    }else{
                        st.push(datas[i][j]);
                    }
                }
            }
            while(!st.isEmpty()){
                tmp.push(st.pop());
            }
            int _j = 3;
            while(!tmp.isEmpty()){
                datas[i][_j--]=tmp.pop();
            }
            while(_j>=0){
                datas[i][_j--]=0;
            }
        }


    }

    void UpMove(){
        Stack<Integer> st = new Stack<>();
        Stack<Integer> tmp = new Stack<>();
        for(int i=0;i<4;i++){
            boolean flag = true;
            for(int j=0;j<4;j++){
                if(datas[j][i]!=0){
                    if(!st.isEmpty()){
                        if(st.peek()!=datas[j][i]){
                            st.push(datas[j][i]);
                            flag = true;
                        }
                        else if(flag){
                            st.push(st.pop()+datas[j][i]);
                            flag = false;
                            score += 10;
                        }else{
                            st.push(datas[j][i]);
                            flag = true;
                        }
                    }else{
                        st.push(datas[j][i]);
                    }
                }
            }
            while(!st.isEmpty()){
                tmp.push(st.pop());
            }
            int _j = 0;
            while(!tmp.isEmpty()){
                datas[_j++][i]=tmp.pop();
            }
            while(_j<4){
                datas[_j++][i]=0;
            }
        }

       
    }
    void DwMove(){
        Stack<Integer> st = new Stack<>();
        Stack<Integer> tmp = new Stack<>();
        for(int i=0;i<4;i++){
            boolean flag = true;
            for(int j=3;j>=0;j--){
                if(datas[j][i]!=0){
                    if(!st.isEmpty()){
                        if(st.peek()!=datas[j][i]){
                            st.push(datas[j][i]);
                            flag = true;
                        }
                        else if(flag){
                            st.push(st.pop()+datas[j][i]);
                            flag = false;
                            score += 10;
                        }else{
                            st.push(datas[j][i]);
                            flag = true;
                        }
                    }else{
                        st.push(datas[j][i]);
                    }
                }
            }
            while(!st.isEmpty()){
                tmp.push(st.pop());
            }
            int _j = 3;
            while(!tmp.isEmpty()){
                datas[_j--][i]=tmp.pop();
            }
            while(_j>=0){
                datas[_j--][i]=0;
            }
        }

    }
    boolean CheckWin(){
        WinFlag = true;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(datas[i][j]==2048){return true;}
            }
        }
        WinFlag = false;
        return false;
    }
    boolean CheckLose(){
        LoseFlag = false;
       int[][] cp = new int[4][4];
       copy(datas, cp);
        UpMove();
        if(!IsSame(datas, cp)){copy(cp, datas);return false;} 
        
        DwMove();
        if(!IsSame(datas, cp)){copy(cp, datas);return false;}
        
        RightMove();
        if(!IsSame(datas, cp)){copy(cp, datas);return false;}
        
        LeftMove();
        if(!IsSame(datas, cp)){copy(cp, datas);return false;}
        LoseFlag = true;
        return true;
    }
    void copy(int[][] src,int[][] des){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                des[i][j]=src[i][j];
            }
        }
    }
    boolean IsSame(int[][] src,int[][] des){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(des[i][j]!=src[i][j]){return false;}
            }
        }
        return true;
    }

    void Win(){
        System.out.println("You Win!");
    }
    void Lose(){
        System.out.println("You Lose!");
    }

    void GenNewNum(){
        Random rand = new Random();
        while(!CheckFull()){
        int pos = rand.nextInt(16);
        int x = pos/4;
        int y = pos%4;
        if(datas[x][y]==0){
            datas[x][y] = 2;
            break;
        }
        }
    }
    
    boolean CheckFull(){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(datas[i][j]==0)return false;
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        //System.out.println(1d);
        if(e.getSource() == func1){
            //System.out.println(111);
            GameReset();
            ShowGame();
        } else if(e.getSource() == item1){

        } else if(e.getSource() == item2){
            
        } else if(e.getSource() == item3){
            
        } else if(e.getSource() == menu2){
            
        }
    }
}
