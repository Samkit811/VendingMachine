public class Item {
    private String name;
    private Integer id;
    private Integer row;
    private Integer column;
    private Integer quantity;
    private Integer price;
    private Integer capacity;

    public Item(String name, Integer id, Integer quantity, Integer price, Integer capacity){
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.capacity = capacity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public void setColumn(Integer column) {
        this.column = column;
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

    public Integer getCapacity() {
        return capacity;
    }

    public boolean checkSpace(Integer newQuantity){
        return newQuantity + this.quantity > this.capacity;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Item item = (Item) obj;
        return id != null && id.equals(item.getId());
    }
}
