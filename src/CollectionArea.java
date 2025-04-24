public class CollectionArea implements UpdateState {
    Item item;

    public CollectionArea(Item item){
        this.item = item;
    }

    public void collectItem(State state){
        System.out.println("Collect the purchased Item: " + this.item.getName());
        this.isStateValid(state);
        this.next(state);
    }

    @Override
    public void next(State state){
        this.isStateValid(state);
        state.setCurrentState(StateType.MONEY_COLLECTION);

    }

    @Override
    public void isStateValid(State state) {
        if(state.getCurrentState() != StateType.PRODUCT_COLLECTION){
            this.throwAccessDeniedError();
        }
    }
}
