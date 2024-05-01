package s2.v1;

public class SearchEmptyMessageIndex extends SearchTemplate<Integer> {

    @Override
    protected Integer declareParam() {
        return 0;
    }

    @Override
    protected Integer handleMessage(Integer index, String message) {
        if (!message.isEmpty()) {
            index ++;
        }
        return index;
    }
    // 輸入: Ｎ個字串
    // 遍歷每個字串i=0...n-1，直到找到空字串
    //   印出第i個字串
    //   index++
    // 回傳index 若大於等於N長度回傳-1
}

