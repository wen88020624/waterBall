package s2.v2;

public abstract class SearchTemplate<Result> {

    protected Result search(String[] messages) {
        Result result = defaultSearchResult();
        for (int index=0; index<messages.length; index++) {
            System.out.println(messages[index]);
            result = updateSearchResult(index, messages[index]);
            if (searchEnd(index, messages)) {
                break;
            }
        }
        return result;
    }

    protected Result defaultSearchResult() {
        return null; // Hook，預設若傳空的則回傳null
    };

    protected boolean searchEnd(int messageIndex, String[] messages) {
        return false; // Hook，預設是走訪所有元素才結束
    }

    protected abstract Result updateSearchResult(int messageIndex, String message);

    // 提取樣板方法
    // 走訪每個字串i=0...n-1，(預設直到走訪終止條件)
    //   印出第i個字串
    //   (更新搜尋結果)
    // 回傳(搜尋結果，預設為null)
}
