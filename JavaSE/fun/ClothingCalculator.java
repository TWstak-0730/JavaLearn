package JavaSE.fun;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClothingCalculator extends JFrame {
    private JTextField temperatureField;
    private JButton calculateButton;
    
    public ClothingCalculator() {
        initializeUI();
    }
    
    private void initializeUI() {
        setTitle("26℃穿衣法则计算器");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // 设置布局
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        // 标题
        JLabel titleLabel = new JLabel("26℃穿衣法则计算器");
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
        titleLabel.setForeground(new Color(51, 102, 153));
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 10, 20, 10);
        add(titleLabel, gbc);
        
        // 温度输入标签
        JLabel tempLabel = new JLabel("请输入当前温度（℃）：");
        tempLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        tempLabel.setBounds(5, 20, 20, 5);
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.gridwidth = 1;
    
        gbc.insets = new Insets(10, 20, 10, 10);
        add(tempLabel, gbc);
        
        // 温度输入框
        temperatureField = new JTextField(10);
        temperatureField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        gbc.gridx = 1; gbc.gridy = 1;
        gbc.insets = new Insets(10, 10, 10, 20);
        add(temperatureField, gbc);
        
        // 计算按钮
        calculateButton = new JButton("计算穿衣建议");
        calculateButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
        calculateButton.setBackground(new Color(51, 102, 153));
        calculateButton.setForeground(Color.WHITE);
        calculateButton.setFocusPainted(false);
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 20, 20, 20);
        add(calculateButton, gbc);
        
        // 添加事件监听器
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateClothing();
            }
        });
        
        // 回车键触发计算
        temperatureField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateClothing();
            }
        });
    }
    
    private void calculateClothing() {
        try {
            String input = temperatureField.getText().trim();
            if (input.isEmpty()) {
                JOptionPane.showMessageDialog(this, "请输入温度！", "提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            double temperature = Double.parseDouble(input);
            String clothingAdvice = getClothingAdvice(temperature);
            
            // 创建自定义对话框
            JOptionPane.showMessageDialog(this, 
                clothingAdvice, 
                "穿衣建议", 
                JOptionPane.INFORMATION_MESSAGE);
                
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "请输入有效的数字！", "错误", JOptionPane.ERROR_MESSAGE);
            temperatureField.selectAll();
        }
    }
    
    private String getClothingAdvice(double temperature) {
        double targetTemp = 26.0;
        double tempDiff = targetTemp - temperature;
        
        StringBuilder advice = new StringBuilder();
        advice.append("当前温度：").append(temperature).append("℃\n");
        advice.append("与舒适温度(26℃)差值：").append(String.format("%.1f", tempDiff)).append("℃\n\n");
        advice.append("穿衣建议：\n");
        
        if (tempDiff <= 0) {
            // 温度高于或等于26℃
            if (temperature >= 30) {
                advice.append("🌞 非常热 - 建议穿着：\n");
                advice.append("• 短袖T恤 + 短裤/短裙\n");
                advice.append("• 凉鞋或透气运动鞋\n");
                advice.append("• 注意防晒和补水");
            } else if (temperature >= 26) {
                advice.append("☀️ 温暖舒适 - 建议穿着：\n");
                advice.append("• 短袖衬衫/T恤\n");
                advice.append("• 长裤或短裤\n");
                advice.append("• 休闲鞋");
            }
        } else {
            // 温度低于26℃
            if (tempDiff <= 5) {
                advice.append("🌤️ 微凉 - 建议穿着：\n");
                advice.append("• 长袖衬衫 + 薄外套\n");
                advice.append("• 长裤\n");
                advice.append("• 休闲鞋");
            } else if (tempDiff <= 10) {
                advice.append("🌥️ 凉爽 - 建议穿着：\n");
                advice.append("• 毛衣/卫衣 + 外套\n");
                advice.append("• 长裤\n");
                advice.append("• 运动鞋或靴子");
            } else if (tempDiff <= 15) {
                advice.append("❄️ 寒冷 - 建议穿着：\n");
                advice.append("• 厚毛衣 + 棉服/羽绒服\n");
                advice.append("• 厚裤子 + 保暖内衣\n");
                advice.append("• 保暖鞋 + 围巾");
            } else {
                advice.append("🥶 严寒 - 建议穿着：\n");
                advice.append("• 多层保暖：内衣+毛衣+厚外套\n");
                advice.append("• 羽绒服或厚棉服\n");
                advice.append("• 保暖裤 + 厚袜子\n");
                advice.append("• 保暖鞋 + 手套 + 帽子 + 围巾");
            }
        }
        
        return advice.toString();
    }
    
    public static void main(String[] args) {
        // 设置系统外观
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClothingCalculator().setVisible(true);
            }
        });
    }
}
