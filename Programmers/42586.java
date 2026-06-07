import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        Deque<Integer> queue = new ArrayDeque<>();
        Deque<Integer> s = new ArrayDeque<>();
        for (int p : progresses) queue.addLast(p);
        for (int sp : speeds) s.addLast(sp);

        int time = 0;
        int cnt = 0;
        while (!queue.isEmpty()) {
            time++;
            while (!queue.isEmpty() && queue.peekFirst() + s.peekFirst() * time >= 100) {
                cnt++;
                queue.pollFirst();
                s.pollFirst();
            }
            if (cnt > 0) {
                answer.add(cnt);
                cnt = 0;
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
