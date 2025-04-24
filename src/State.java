public class State {
    private StateType currentState;

    public State(){
        this.currentState = StateType.IDEAL;
    }

    public void setCurrentState(StateType currentState) {
        this.currentState = currentState;
    }

    public StateType getCurrentState() {
        return currentState;
    }
}
