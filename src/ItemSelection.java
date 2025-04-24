public class ItemSelection implements UpdateState {
    Item item;

    public ItemSelection(Item item){
        this.item = item;
    }

    public void itemPurchase(State state, MoneyAccept moneyAccept){
        if(!this.isStateValid(state)){
            return;
        }
        if(moneyAccept.getMoney() < this.item.getPrice()){
            System.out.println("Please Enter Sufficient Money to Buy item: " + item.getName());
            state.setCurrentState(StateType.MONEY_COLLECTION);
            return;
        }
        if(this.item.getQuantity() == 0){
            System.out.println("Item is currently Out Of Stock, Sorry For Your Inconvenience");
            state.setCurrentState(StateType.MONEY_COLLECTION);
            return;
        }
        System.out.println("Thanks for purchasing the item: " + item.getName());
        Integer currentQuantity = this.item.getQuantity();
        this.item.setQuantity(currentQuantity - 1);
        Integer itemPrice = this.item.getPrice();
        Integer userMoney = moneyAccept.getMoney();
        userMoney = userMoney - itemPrice;
        moneyAccept.setMoney(userMoney);
        this.next(state);
    }


    @Override
    public void next(State state) {
        if(this.isStateValid(state)){
            state.setCurrentState(StateType.PRODUCT_COLLECTION);
        }
    }

    @Override
    public Boolean isStateValid(State state) {
        if(state.getCurrentState() != StateType.PRODUCT_SELECTION){
            this.throwAccessDeniedError();
            return false;
        }
        return true;
    }
}
