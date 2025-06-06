package presentation;

import businessLogic.BaseProduct;
import model.Administrator;

import javax.swing.*;
import java.util.Set;

public class MenuBaseProductsGUI extends JFrame {
    private JTable table;
    private JScrollPane scrollPane;

    public MenuBaseProductsGUI(Administrator admin){
        setTitle("MENU");
        setSize(800, 400);

        String[] columns = {"Title", "Rating", "Calories", "Protein", "Fat", "Sodium", "Price"};
        int sizeColumns = columns.length;

        Set<BaseProduct> uniqueData = admin.getListProducts();

        int sizeRows = uniqueData.size();
        String[][] rows = new String[sizeRows][sizeColumns];
        int i = 0;
        for(BaseProduct b : uniqueData) {
            if (i < sizeRows) {
                rows[i][0] = b.getTitle();
                rows[i][1] = b.getRating();
                rows[i][2] = b.getCalories();
                rows[i][3] = b.getProtein();
                rows[i][4] = b.getFat();
                rows[i][5] = b.getSodium();
                rows[i][6] = b.getPrice();

                i++;
            }
        }

        table = new JTable(rows,columns);
        scrollPane = new JScrollPane(table);
        add(scrollPane);
        setVisible(true);
    }

}
