import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {

        List<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] e : edge) {
            int num1 = e[0];
            int num2 = e[1];

            graph.get(num1).add(num2);
            graph.get(num2).add(num1);
        }

        int[] visit = new int[n + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visit[1] = 1;

        while(!queue.isEmpty()) {
            int node = queue.poll();

            for(int next : graph.get(node)) {
                if(visit[next] == 0) {
                    queue.offer(next);
                    visit[next] = visit[node] + 1;
                }
            }
        }
        int maxDistance = 0;

        for(int i = 1; i <= n; i++) {
            maxDistance = Math.max(maxDistance, visit[i]);
        }
        int answer = 0;

        for(int i = 1; i <= n; i++) {
            if(visit[i] == maxDistance) {
                answer++;
            }
        }

        return answer;
    }
}
