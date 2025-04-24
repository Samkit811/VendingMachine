public class CollectionArea implements UpdateState {
    Item item;

    public CollectionArea(Item item){
        this.item = item;
    }

    public void collectItem(State state){
        if(this.isStateValid(state)){
            this.next(state);
        }
    }

    @Override
    public void next(State state){
        if(this.isStateValid(state)){
            state.setCurrentState(StateType.MONEY_COLLECTION);
        }
    }

    @Override
    public Boolean isStateValid(State state) {
        if(state.getCurrentState() != StateType.PRODUCT_COLLECTION){
            this.throwAccessDeniedError();
            return false;
        }
        return true;
    }
}
