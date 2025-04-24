public class MoneyAccept implements UpdateState {
    private Integer money;
    private Integer startMoney;

    public MoneyAccept(Integer money){
        this.money = money;
        this.startMoney = money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getMoney() {
        return money;
    }

    public Integer getStartMoney() {
        return startMoney;
    }

    @Override
    public void next(State state){
        if(this.isStateValid(state)) {
            state.setCurrentState(StateType.PRODUCT_SELECTION);
        }
    }

    @Override
    public Boolean isStateValid(State state) {
        if(state.getCurrentState() != StateType.MONEY_ACCEPTING){
            this.throwAccessDeniedError();
            return false;
        }
        return true;
    }

}
