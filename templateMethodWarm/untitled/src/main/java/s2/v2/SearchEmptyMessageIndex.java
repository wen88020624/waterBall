package s2.v2;

public class SearchEmptyMessageIndex extends SearchTemplate<Integer> {

    @Override
    protected Integer updateSearchResult(int messageIndex, String message) {
        if (!message.isEmpty()) {
            messageIndex ++;
        }
        return messageIndex;
    }

    @Override
    protected boolean searchEnd(int messgeIndex, String[] messages) {
        return messages[messgeIndex].isEmpty();
    }
    // 輸入: Ｎ個字串
    // 走訪每個字串i=0...n-1，(直到走訪到空字串)
    //   印出第i個字串
    //   (更新index)
    // 回傳(index，預設為null)
}

