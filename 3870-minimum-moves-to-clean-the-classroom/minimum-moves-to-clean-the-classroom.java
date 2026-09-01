import java.util.*;

class Solution {

    static class State {
        int r, c;
        int mask;
        int energy;
        int moves;

        State(int r, int c, int mask, int energy, int moves) {
            this.r = r;
            this.c = c;
            this.mask = mask;
            this.energy = energy;
            this.moves = moves;
        }
    }

    public int minMoves(String[] classroom, int energy) {

    int m = classroom.length;
    int n = classroom[0].length();

    int startR = -1;
    int startC = -1;
    
    
        int[][] litterBit = new int[m][n];

        for (int[] row : litterBit) {
            Arrays.fill(row, -1);
        }

        int litterCount = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                char ch = classroom[r].charAt(c);

                if (ch == 'S') {
                    startR = r;
                    startC = c;
                }

                if (ch == 'L') {
                    litterBit[r][c] = litterCount;
                    litterCount++;
                }
            }
        }

        int allMask = (1 << litterCount) - 1;
        int[][][] visited =
                new int[m][n][1 << litterCount];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                Arrays.fill(visited[r][c], -1);
            }
        }

        Queue<State> queue = new ArrayDeque<>();

        // Initial state
        queue.offer(
                new State(startR, startC, 0, energy, 0)
        );

        visited[startR][startC][0] = energy;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            State curr = queue.poll();
            if (curr.mask == allMask) {
                return curr.moves;
            }

            if (curr.energy == 0) {
                continue;
            }

            for (int d = 0; d < 4; d++) {

                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];
                if (nr < 0 || nr >= m ||
                    nc < 0 || nc >= n) {
                    continue;
                }

                char cell = classroom[nr].charAt(nc);

                if (cell == 'X') {
                    continue;
                }

                int newEnergy = curr.energy - 1;

                int newMask = curr.mask;

                if (cell == 'L') {

                    int bit = litterBit[nr][nc];

                    newMask = newMask | (1 << bit);
                }
                if (cell == 'R') {

                    newEnergy = energy;
                }
                if (visited[nr][nc][newMask] >= newEnergy) {
                    continue;
                }

                visited[nr][nc][newMask] = newEnergy;

                queue.offer(
                        new State(
                                nr,
                                nc,
                                newMask,
                                newEnergy,
                                curr.moves + 1
                        )
                );
            }
        }

        return -1;
    }
}