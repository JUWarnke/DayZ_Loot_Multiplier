package application.gui.mainWindow;

import application.gui.panels.MainPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {

        super( "DayZ Item Multiplier" );

        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        setSize( 500, 500 );

        addMainPanel();

        setLocationRelativeTo( null );

        setVisible( true );

    }

    private void addMainPanel() {

        MainPanel mainPanel = new MainPanel( this );

    }


}
