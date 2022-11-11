package application.gui.panels;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    public MainPanel(JFrame mainFrame) {

        buildPanel();

        mainFrame.add( this );

    }

    private void buildPanel() {

        this.setLayout( new BoxLayout( this, BoxLayout.Y_AXIS ) );

        this.add( buildNorthPanel() );

        this.add( buildSouthPanel() );

    }

    private JPanel buildNorthPanel() {

        JPanel northPanel = new JPanel();

        northPanel.setBackground( Color.RED );

        return northPanel;

    }

    private JPanel buildSouthPanel() {

        JPanel southPanel = new JPanel();

        southPanel.setBackground( Color.BLUE );

        return southPanel;
    }


}
