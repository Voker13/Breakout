import javax.swing.JFrame;

public class Main {
    
    static JFrame f;
    static Gamepanel gamepanel;
    static Optionpanel optionpanel;
    static final int OptionBarHeight = 40;
    static final int f_width = 400;
    static final int f_height = 600 + OptionBarHeight;
    
    public static void main(String[] args) {
        
        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(300, 100, f_width, f_height);
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
        
        optionpanel = new Optionpanel();
        gamepanel = new Gamepanel();
        f.add(optionpanel);
        f.add(gamepanel);
    }
    
}