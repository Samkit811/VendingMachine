import java.util.Scanner;

public class VendingMachine {
    private Item[][] vendingMachine;
    private State state;
    private MoneyAccept moneyAccept;
    private Item item;

    public VendingMachine(Integer row, Integer column, State state){
        this.vendingMachine = new Item[row][column];
        this.state = state;
    }

    public void AddItem(Item item, Integer row, Integer column){
        if(this.checkItem(item, row, column)){
            Item placedItem = this.vendingMachine[row][column];
            if(placedItem == null){
                placedItem = item;
                this.vendingMachine[row][column] = item;
            } else {
                this.addQuantity(placedItem, item);
            }
        }
    }

    private Boolean checkItem(Item item, Integer row, Integer column){
        Item placedItem = this.vendingMachine[row][column];
        if(placedItem == null){
           return true;
        }
        return placedItem.equals(item) && item.checkSpace(placedItem.getQuantity());
    }

    private void addQuantity(Item placedItem, Item newItem){
        Integer placedQuantity = placedItem.getQuantity();
        Integer updatedQuantity = placedQuantity + newItem.getQuantity();
        System.out.println("Item: " + placedItem + " Quantity is Updated and new Quantity is: " + updatedQuantity);
        placedItem.setQuantity(updatedQuantity);
    }

    public void start(){
        this.state.setCurrentState(StateType.MONEY_ACCEPTING);

        while(this.state.getCurrentState() == StateType.IDEAL){
            switch (this.state.getCurrentState()){
                case MONEY_ACCEPTING : {
                    this.enterMoney();
                    this.moneyAccept.next(this.state);
                    break;
                }

                case PRODUCT_SELECTION: {
                    this.selectItem();
                    ItemSelection itemSelection = new ItemSelection(this.item);
                    itemSelection.itemPurchase(this.state, this.moneyAccept);
                    break;
                }

                case PRODUCT_COLLECTION: {
                    CollectionArea collectionArea = new CollectionArea(this.item);
                    collectionArea.collectItem(this.state);
                    break;
                }

                case MONEY_COLLECTION: {
                    Integer remainingMoney = this.moneyAccept.getStartMoney() - this.moneyAccept.getMoney();
                    MoneyCollection moneyCollection = new MoneyCollection(remainingMoney);
                    moneyCollection.dispatchMoney(this.state);
                    break;
                }
            }
        }
        System.out.println("Thanks for visit!!");
    }

    private void enterMoney(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Money: ");
        int money = scanner.nextInt();
        this.moneyAccept = new MoneyAccept(money);
    }

    private void selectItem(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Row Value: ");
        int row = scanner.nextInt();
        System.out.print("Enter Column Value: ");
        int column = scanner.nextInt();

        this.item = this.vendingMachine[row][column];
        System.out.println("Selected Item: " + this.item.getName());

    }
}
