class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] needed = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            needed[course]++;
        }

        int finishedCourses = 0;
        boolean foundCourse = true;

        while (foundCourse) {
            foundCourse = false;

            for (int course = 0; course < numCourses; course++) {
                if (needed[course] == 0) {
                    needed[course] = -1;
                    finishedCourses++;
                    foundCourse = true;

                    for (int i = 0; i < prerequisites.length; i++) {
                        if (prerequisites[i][1] == course) {
                            int nextCourse = prerequisites[i][0];
                            needed[nextCourse]--;
                        }
                    }
                }
            }
        }

        return finishedCourses == numCourses;
    }
}
