package s2.v2;

public class SearchLongestMessage extends SearchTemplate<String> {
    private String maxLengthMessage = "";

    @Override
    protected String updateSearchResult(int messageIndex, String message) {
        if (message.length() > maxLengthMessage.length()) {
            maxLengthMessage = message;
        }
        return maxLengthMessage;
    }
    // 輸入: Ｎ個字串
    // 走訪每個字串 i=0...n-1，(直到遍歷完所有字串)
    //    (更新最大長度字串)
    //    印出第i個字串
    // 回傳(最大長度字串，預設為null)
}