package DAY4.G2048;

import java.awt.HeadlessException;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class MainFrame extends JFrame implements KeyListener{
    // int[][] datas = {
    //     {2,4,8,16},
    //     {4,8,16,32},
    //     {8,16,32,64},
    //     {16,32,64,2}
    // };
    int[][] datas = new int[4][4];
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
        this.addKeyListener(this);
        
    }
    /**
     * 此方法用于绘制游戏界面
    */
    public void ShowGame(){
        getContentPane().removeAll();

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

        getContentPane().repaint();
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
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.printf("%2d ",datas[i][j]);

        }
        System.out.println("");}
        System.out.println();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
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
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(datas[i][j]==2048){return true;}
            }
        }
        return false;
    }
    boolean CheckLose(){
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
}
