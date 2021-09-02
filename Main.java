// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void inout(){
        try {
            System.setIn(new FileInputStream("input.txt"));
            System.setOut(new PrintStream(new FileOutputStream("output.txt")));
        } catch (Exception e) {
            System.err.println("Error");
        }
    }


    public static void main(String[] args) {
        inout();
        
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine().trim());
            while(T-->0)
            {
                int n = Integer.parseInt(br.readLine().trim());
                int[][] grid = new int[n][n];
                for(int i = 0; i < n; i++){
                    String[] S = br.readLine().trim().split(" ");
                    for(int j = 0; j < n; j++){
                        grid[i][j] = Integer.parseInt(S[j]);
                    }
                }
                Solution obj = new Solution();
                boolean ans = obj.is_Possible(grid);
                if(ans)
                    System.out.println("1");
                else 
                    System.out.println("0");
            }
        }catch(Exception e){
            System.err.println(e);
        }
    }
}




class Solution
{
    //Function to return list containing vertices in Topological order. 



    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
    
        static int[] arr = new int[V];
        boolean visited[] = new boolean[V];

        Stack<Integer> stack  = new Stack<>();

        for(int i =0;i<V;i++)
        {
            if(!visited[i]){
                dfs(i,visited,adj,stack);
            }
        }
        int i=0;

        while(!stack.isEmpty())
        {
            arr[i] = stack.pop();
            i++; 
        }
        return arr;

    }
    staic void dfs(int i,int[] visited,ArrayList<ArrayList<Integer>> adj,Stack<Integer> stack){
        visited[i] = true;

        Iterator<Integer> li = adj.get(i).listIterator();
        while(li.hasNext()){
            int j = li.next();
            if(!visited[j]){
                dfs(j,visited,adj,stack);
            } 
        }

        stack.push(i);
    }
}
