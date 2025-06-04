package Task1;

import javax.swing.*;

public class DrawFrameMain extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel areaDrawPanel;

    private DrawPanel dp;

    public DrawFrameMain() {

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        dp = new DrawPanel(600, 800, 10);
        areaDrawPanel.add(dp);

    }

    public static void main(String[] args) {
        DrawFrameMain dialog = new DrawFrameMain();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
