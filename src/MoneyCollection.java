public class MoneyCollection implements UpdateState  {

    private Integer remainingMoney;

    public MoneyCollection(Integer remainingMoney){
        this.remainingMoney = remainingMoney;
    }

    public void dispatchMoney(State state){
        this.isStateValid(state);
        if(this.remainingMoney > 0){
            System.out.println("Collect the remaining Money: " + this.remainingMoney);
        }
        this.next(state);
    }

    @Override
    public void next(State state){
        this.isStateValid(state);
        state.setCurrentState(StateType.IDEAL);
    }

    @Override
    public void isStateValid(State state) {
        if(state.getCurrentState() != StateType.MONEY_COLLECTION){
            this.throwAccessDeniedError();
        }
    }
}
