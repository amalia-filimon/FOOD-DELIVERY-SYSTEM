package presentation;

import businessLogic.BaseProduct;
import businessLogic.DeliveryService;
import model.Administrator;
import model.Client;

import javax.swing.*;
import java.util.List;

public class SearchByCriteriaTable extends JFrame {
    private JTable table;
    private JScrollPane scrollPane;

    public SearchByCriteriaTable(Administrator admin, String title, String rating, String calories, String protein, String fat, String sodium, String price){
        setTitle("Products Searched");
        setSize(800, 400);

        String[] columns = {"Title", "Rating", "Calories", "Protein", "Fat", "Sodium", "Price"};
        int sizeColumns = columns.length;
        Client client = new Client();
        List<BaseProduct> list = client.searchByCriteria(admin, title, rating, calories, protein, fat, sodium, price);
        int sizeRows = list.size();
        String[][] rows = new String[sizeRows][sizeColumns];
        int i = 0;
        for(BaseProduct b : list){
            if (i < sizeRows) {
                rows[i][0] = b.getTitle();
                rows[i][1] = String.valueOf(b.getRating());
                rows[i][2] = String.valueOf(b.getCalories());
                rows[i][3] = String.valueOf(b.getProtein());
                rows[i][4] = String.valueOf(b.getFat());
                rows[i][5] = String.valueOf(b.getSodium());
                rows[i][6] = String.valueOf(b.getPrice());

                i++;
            }
        }

        table = new JTable(rows,columns);
        scrollPane = new JScrollPane(table);
        add(scrollPane);
        setVisible(true);
    }
}
