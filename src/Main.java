public class Main {
    public static void main(String[] args) {

        int row = 7, column = 5;
        VendingMachine vendingMachine = new VendingMachine(row, column);

        Item pepsi = new Item("pepsi", 1, 10, 100, 20);
        Item sprite = new Item("sprite", 1, 10, 100, 20);
        Item limca = new Item("limca", 1, 10, 100, 20);
        Item slice = new Item("slice", 1, 10, 100, 20);
        Item sting = new Item("sting", 1, 10, 100, 20);
        Item monster = new Item("monster", 1, 10, 100, 20);

        vendingMachine.AddItem(pepsi, 5, 4);
        vendingMachine.AddItem(sprite, 4, 4);
        vendingMachine.AddItem(limca, 5, 2);
        vendingMachine.AddItem(slice, 4, 3);
        vendingMachine.AddItem(sting, 5, 1);
        vendingMachine.AddItem(monster, 2, 4);

        vendingMachine.start();

    }
}