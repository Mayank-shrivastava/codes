package stackqueue;

import java.util.ArrayDeque;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        ArrayDeque<Pair> st = new ArrayDeque<>();
        int[] answers = new int[n];
        answers[n-1] = 0;
        st.push(new Pair(temperatures[n-1], n-1));

        for (int i = n-2; i >= 0; i--) {

            while (!st.isEmpty() && st.peek().temperature <= temperatures[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                answers[i] = 0;
            } else {
                int days = st.peek().index - i; 
                answers[i] = days;
            }

            st.push(new Pair(temperatures[i], i));
        }

        return answers;
    }

    static class Pair {
        int temperature;
        int index;

        Pair(int temperature, int index) {
            this.temperature = temperature;
            this.index = index;
        }
    }
}
