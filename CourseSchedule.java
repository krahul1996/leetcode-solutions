package com.company.programs;

import java.util.ArrayDeque;
import java.util.ArrayList;


public class CourseSchedule {
  ArrayList<ArrayList<Integer>> rgraph;
  int[] inDegree;
  boolean[] visited;
  ArrayDeque<Integer> queue;
  ArrayList<Integer> result;

  public boolean canFinish(int numCourses, int[][] prerequisites) {

    rgraph = new ArrayList<>();
    result = new ArrayList<>();
    visited = new boolean[numCourses];
    inDegree = new int[numCourses];
    queue = new ArrayDeque<>();

    for(int i=0; i<numCourses; i++) {
      rgraph.add(new ArrayList<>());
    }

    for(int i=0; i<prerequisites.length; i++) {
      rgraph.get(prerequisites[i][0]).add(prerequisites[i][1]);
//      System.out.println(prerequisites[i][1] + " " + prerequisites[i][0] + "\n" + inDegree[prerequisites[i][1]]);
      inDegree[prerequisites[i][1]] = inDegree[prerequisites[i][1]] + 1;
    }

    for(int i=0; i<numCourses; i++) {
      if(inDegree[i] == 0) {
        queue.add(i);
      }
    }
    while(!queue.isEmpty()) {
      int element = queue.peekFirst();
      result.add(element);
      visited[element] = true;
//      System.out.println(element + "\n");
      for(int i=0; i<rgraph.get(element).size(); i++) {

        int vertex = rgraph.get(element).get(i);
/*
        System.out.println(vertex);
*/
        if(inDegree[vertex] > 0)
          inDegree[vertex]--;
        if(inDegree[vertex] == 0 && !visited[vertex]) {
          queue.add(vertex);
        }
      }
      queue.removeFirst();
    }

//    System.out.println(result);
    return result.size() == numCourses;
  }
}
