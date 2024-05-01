package s2.v1;

public class SearchLongestMessage extends SearchTemplate<String> {

    @Override
    protected String declareParam() {
        return "";
    }

    @Override
    protected String handleMessage(String maxLengthMessage, String message) {
        if (message.length() > maxLengthMessage.length()) {
            maxLengthMessage = message;
        }
        return maxLengthMessage;
    }
    // 輸入: Ｎ個字串
    // 走訪每個字串 i=0...n-1，直到遍歷完所有字串:
    //    更新最大長度字串
    //    印出第i個字串
    // 回傳最大長度字串，預設為null
}