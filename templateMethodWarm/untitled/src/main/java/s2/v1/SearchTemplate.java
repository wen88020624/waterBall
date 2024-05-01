package s2.v1;

public abstract class SearchTemplate<T> {

    protected T search(String[] messages) {
        T param = declareParam();
        for (String message : messages) {
            System.out.println(message);
            param = handleMessage(param, message);
        }
        return param;
    }

    protected abstract T declareParam();

    protected abstract T handleMessage(T param, String message);
}
