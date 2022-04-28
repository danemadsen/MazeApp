import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BrowseMenu implements IMenu, ActionListener {
    public final static String TITLE = "Maze Browser";
    public JPanel browsePanel;

    public BrowseMenu() {
        browsePanel = new JPanel();
        browsePanel.setVisible(false);
        Main.frame.add(browsePanel);
        JButton back = new JButton("Back");
        browsePanel.add(back);
        back.addActionListener(this);

        openMenu();
    }

    public void openMenu() {
        Main.frame.setTitle(Frame.TITLE_PREFIX + TITLE);

        // Code that should be executed whenever a menu is opened
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        browsePanel.setVisible(false);
        // Insert action events here
        Main.mainMenu.openMenu();
    }
}
