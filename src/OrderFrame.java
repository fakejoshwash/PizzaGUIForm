import javax.swing.*;
import java.awt.*;

public class OrderFrame extends JFrame {
    public OrderFrame() {
        int subTotal = 0;
        subTotal += PizzaGUIFrame.userChoices.getBaseCost();
        String thickSpacer = "========================================\n";
        String thinSpacer = "\n----------------------------------------\n";
        // window sizing
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        setLocation(screenSize.width / 3, screenSize.height / 3); // making sure it's in a different spot than the main window
        setSize(400, 400);

        // panels
        JPanel container = new JPanel(new BorderLayout());
        JPanel receiptView = new JPanel();

        // elements
        Font receiptFont = new Font("Courier New", Font.PLAIN, 14);
        JScrollPane scrollPane = new JScrollPane();
        JTextArea receipt = new JTextArea(20, 41);
        scrollPane.setViewportView(receipt);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        receipt.setFont(receiptFont);


        // add to panels
        container.add(receiptView);
        receiptView.add(receipt);
        add(container);

        // meta
        setVisible(true);
        setTitle("Pizza Order Receipt");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // receipt operations
        receipt.append(thickSpacer);
        if (PizzaGUIFrame.userChoices.getCrustSelection().equals("deep-dish")  && PizzaGUIFrame.userChoices.getSizeSelection().equals("Medium") ) {
            receipt.append(PizzaGUIFrame.userChoices.getSizeSelection() + " " + PizzaGUIFrame.userChoices.getCrustSelection() + "\t\t$" + subTotal + ".00\n\n");
        } else {
            receipt.append(PizzaGUIFrame.userChoices.getSizeSelection() + " " + PizzaGUIFrame.userChoices.getCrustSelection() + "\t\t\t$" + subTotal + ".00\n\n");
        }
        if (PizzaGUIFrame.userChoices.isCheeseSelected()) {
            receipt.append("Extra Cheese\t\t\t$1.00");
            subTotal++;
        }
        if (PizzaGUIFrame.userChoices.isPepperoniSelected()) {
            receipt.append("\nPepperoni\t\t\t$1.00");
            subTotal++;
        }
        if (PizzaGUIFrame.userChoices.isMushroomSelected()) {
            receipt.append("\nMushrooms\t\t\t$1.00");
            subTotal++;
        }
        if (PizzaGUIFrame.userChoices.isAnchoviesSelected()) {
            receipt.append("\nAnchovies\t\t\t$1.00");
            subTotal++;
        }
        if (PizzaGUIFrame.userChoices.isPineappleSelected()) {
            receipt.append("\nPineapple\t\t\t$1.00");
            subTotal++;
        }
        if (PizzaGUIFrame.userChoices.isAluminumFoilSelected()) {
            receipt.append("\nAluminum Foil Coating\t\t$1.00");
            subTotal++;
        }
        receipt.append("\n\nSub-total\t\t\t$" + subTotal + ".00");
        receipt.append("\nTax\t\t\t\t$" + String.format("%.2f", (subTotal*0.07)));
        receipt.append(thinSpacer);
        receipt.append("Total\t\t\t\t$" + String.format("%.2f", subTotal + (subTotal*0.07)));
        receipt.append("\n" + thickSpacer);
    }
}
