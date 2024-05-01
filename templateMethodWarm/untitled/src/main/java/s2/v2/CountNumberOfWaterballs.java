package s2.v2;

public class CountNumberOfWaterballs extends SearchTemplate<Integer> {
    private int count = 0;

    @Override
    protected Integer defaultSearchResult() {
        return 0;
    }

    @Override
    protected Integer updateSearchResult(int messageIndex, String message) {
        if ("Waterball".equals(message)) {
            count ++;
        }
        return count;
    }


    // 輸入: Ｎ個字串
    // 走訪每個字串i=0...n-1，(直到所有遍歷完所有字串)
    //   (若有Waterball字串則更新count)
    //   印出第i個字串
    // 回傳(count，預設為0)
}
