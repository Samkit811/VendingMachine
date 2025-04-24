public interface UpdateState {
    public void next(State state);
    public Boolean isStateValid(State state);
    default void throwAccessDeniedError(){
        throw new AccessDenied("You are not allowed to access this state.");
    }
}
