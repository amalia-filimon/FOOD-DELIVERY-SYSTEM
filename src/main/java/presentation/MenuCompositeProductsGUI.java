package presentation;

import businessLogic.BaseProduct;
import businessLogic.CompositeProduct;
import businessLogic.MenuItem;
import model.Administrator;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MenuCompositeProductsGUI extends JFrame{
    private JTable table;
    private JScrollPane scrollPane;

    public MenuCompositeProductsGUI(Administrator admin){
        setTitle("MENU");
        setSize(800, 400);

        String[] columns = {"Title", "The base products it is made of", "Final price"};
        int sizeColumns = columns.length;

        List<CompositeProduct> data = admin.getListCompositeProducts();

        int sizeRows = data.size();
        String[][] rows = new String[sizeRows][sizeColumns];
        int i = 0;
        for(CompositeProduct c : data) {
            if (i < sizeRows) {
                rows[i][0] = c.getTitle();
                rows[i][1] = c.getProducts();
                rows[i][2] = String.valueOf(c.computePrice());
               i++;
            }
        }

        table = new JTable(rows,columns);
        scrollPane = new JScrollPane(table);
        add(scrollPane);
        setVisible(true);
    }
}
