import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class PizzaGUIFrame extends JFrame {
    public PizzaGUIFrame() {
        // window sizing
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        setLocation(screenSize.width / 4, screenSize.height / 4);
        setSize(400, 400);

        // panels
        JPanel container = new JPanel(new BorderLayout());
        JPanel orderForm = new JPanel(new BorderLayout());
        JPanel northMenu = new JPanel(new BorderLayout());
        JPanel southMenu = new JPanel(new BorderLayout());
        JPanel crustHeaderContainer = new JPanel();
        JPanel crustMenu = new JPanel();
        JPanel crustButtons = new JPanel(new BorderLayout());
        crustButtons.setBorder(BorderFactory.createLoweredBevelBorder());

        // elements
        // - crust
        JLabel crustHeader = new JLabel("CRUST");
        JRadioButton crustSelectThinButton = new JRadioButton("Thin");
        JRadioButton crustSelectRegularButton = new JRadioButton("Regular");
        JRadioButton crustSelectDeepButton = new JRadioButton("Deep-dish");
        ButtonGroup crustSelectionGroup = new ButtonGroup();
        crustHeader.setHorizontalAlignment(SwingConstants.LEFT);
        crustSelectionGroup.add(crustSelectThinButton);
        crustSelectionGroup.add(crustSelectRegularButton);
        crustSelectionGroup.add(crustSelectDeepButton);

        // - size
        JLabel sizeHeader = new JLabel("SIZE");

        // add to panels
        /*
        container.add(orderForm, BorderLayout.CENTER);
        orderForm.add(northHeaders);
        orderForm.add(northMenu);
        northHeaders.add(crustHeader);
        northHeaders.add(sizeHeader);
        northMenu.add(crustSelectThinButton);
        northMenu.add(crustSelectRegularButton);
        northMenu.add(crustSelectDeepButton);

         */
        container.add(orderForm, BorderLayout.CENTER);
        orderForm.add(northMenu, BorderLayout.NORTH);
        northMenu.add(crustMenu, BorderLayout.WEST);
        crustHeaderContainer.add(crustHeader);         // wtf??
        crustMenu.add(crustHeaderContainer, BorderLayout.NORTH);
        crustMenu.add(crustButtons, BorderLayout.CENTER);
        crustButtons.add(crustSelectThinButton, BorderLayout.NORTH);
        crustButtons.add(crustSelectRegularButton, BorderLayout.CENTER);
        crustButtons.add(crustSelectDeepButton, BorderLayout.SOUTH);

        add(container);
        // meta
        setVisible(true);
        setTitle("Pizza Order Form");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
