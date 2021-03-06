package BusinessLogic;

public class Item {
    private int code;
    private String name;
    private float price;
    private int quantity;

    public Item(int code, String name, float price, int quantity) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return  code + "," + name + "," + price + "," + quantity;
    }

    public String intToString(int i) {
        return  Integer.toString(i);
    }

    public String floatToString(float f) {
        return Float.toString(f);
    }
}
