package org.example;

public abstract class Template {
    public void templateMethod(int[] k) {
        int n = k.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sortCondition(k[j], k[j + 1])) {
                    int ppp = k[j];
                    k[j] = k[j + 1];
                    k[j + 1] = ppp;
                }
            }
        }
    }

    public abstract boolean sortCondition(int current, int next);
}
