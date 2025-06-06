package businessLogic;

public interface MenuItem {
    int getQuantity();
    void setQuantity(int quantity);
    String getTitle();
    int computePrice();
}
