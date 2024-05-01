package s2.v1;

public class CountNumberOfWaterballs extends SearchTemplate<Integer> {

    @Override
    protected Integer declareParam() {
        return 0;
    }

    @Override
    protected Integer handleMessage(Integer count, String message) {
        if ("Waterball".equals(message)) {
            count ++;
        }
        return count;
    }
    // 輸入: Ｎ個字串
    // 遍歷每個字串i=0...n-1
    //   若有Waterball字串則count++
    //   印出第i個字串
    // 回傳count
}
