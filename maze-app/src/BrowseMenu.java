import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BrowseMenu implements IMenu, ActionListener {
    public final static String TITLE = "Maze Browser";
    public JPanel browsePanel;
    public boolean createReturn;

    public BrowseMenu() {
        browsePanel = new JPanel(new GridBagLayout());
        browsePanel.setVisible(false);
        Main.frame.add(browsePanel);

        //panelLayout(JPanel containerPanel, Color c, int gridX, int gridY)
        int newHeight = (int) Math.round((Frame.HEIGHT) * 0.05);
        //creating panels for layout inside the container panel
        JPanel headerPanel = GUIHelper.panelLayout(browsePanel, Main.createMenu.headerGreen, 0,0, newHeight); //Header
        JPanel searchPanel = GUIHelper.panelLayout(browsePanel, Color.GRAY, 0,1, (int) Math.round(Frame.HEIGHT*0.15)); //sidebar
        JPanel contentPanel = GUIHelper.panelLayout(browsePanel, Color.LIGHT_GRAY, 0,2,(int) Math.round(Frame.HEIGHT*0.63)); // where the maze goes
        JPanel footerPanel = GUIHelper.panelLayout(browsePanel, Main.createMenu.headerGreen, 0,3,newHeight); //footer

        //the dimension of the panels
      //  int newHeight = (int) Math.round((Frame.HEIGHT) * 0.1);
       // headerPanel.setPreferredSize(new Dimension(Frame.WIDTH, newHeight));
       // searchPanel.setPreferredSize(new Dimension((int) Math.round((Frame.WIDTH)*0.30), (Frame.HEIGHT) - (newHeight * 2)));
       // contentPanel.setPreferredSize(new Dimension((int) Math.round((Frame.WIDTH)*0.68), (Frame.HEIGHT) - (newHeight * 2)));
       // footerPanel.setPreferredSize(new Dimension(Frame.WIDTH, newHeight));

        //Create labels
        JLabel labelTitle = GUIHelper.createLabel(TITLE, headerPanel, 0,0);

        //Label formatting for the Header
        //Label formatting for the Header
        labelTitle.setFont(new Font("Century Gothic", Font.BOLD, 40));
        labelTitle.setForeground(Color.WHITE);

        //for loop to format the JLabels in the SideBar
       // for (JLabel  text: labelList) {
       //     text.setFont(new Font("Century Gothic", Font.BOLD, 14));
        // }

        JButton back = new JButton("Back");
        searchPanel.add(back);
        JButton foo = new JButton("Back");
        searchPanel.add(foo);
        back.addActionListener(this);
    }

    public void openMenu() {
        createReturn = false;
        Main.frame.setTitle(Frame.TITLE_PREFIX + TITLE);
        browsePanel.setVisible(true);
    }

    public void openMenu(boolean fromCreate) {
        createReturn = fromCreate;
        Main.frame.setTitle(Frame.TITLE_PREFIX + TITLE);
        browsePanel.setVisible(true);
    }

    public void closeMenu() {
        browsePanel.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Back":
                closeMenu();
                if (createReturn) {
                    Main.createMenu.openMenu();
                }
                else {
                    Main.mainMenu.openMenu();
                }

                break;
        }
        /*if (e.getSource() == back) {

        }*/
    }
}
