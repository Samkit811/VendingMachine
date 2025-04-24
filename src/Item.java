public class Item {
    private String name;
    private Integer id;
    private Integer row;
    private Integer column;
    private Integer quantity;
    private Integer price;

    public Item(String name, Integer id, Integer row, Integer column, Integer quantity, Integer price){
        this.name = name;
        this.id = id;
        this.row = row;
        this.column = column;
        this.quantity = quantity;
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public Integer getRow() {
        return row;
    }

    public Integer getColumn() {
        return column;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
