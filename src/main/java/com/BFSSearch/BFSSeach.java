package com.BFSSearch;

import java.util.*;

public class BFSSeach {

    private int rows;
    private int cols;

    public  int bfsSearch(char [][] island){
        int count=0;
        rows=island.length;
        cols=island[0].length;
        boolean [][] mark =new boolean[rows][cols];
        if(rows==0){
            return 0;
        }
        int[][] direction = {{1,0},{-1,0},{0,-1},{0,1}};
        for (int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(!mark[i][j]&&island[i][j]=='1'){
                    count++;
                    LinkedList<Integer> queue = new LinkedList();
                    queue.addLast(cols*i+j);
                    mark[i][j]=true;
                    while(!queue.isEmpty()){
                        int newcur=queue.removeFirst();
                        //寻找坐标点
                        int newrows=newcur/cols;
                        int newcols=newcur%cols;
                        //得四个方向坐标
                        for(int k=0;k<4;k++){
                            int newrowcur=newrows+direction[k][0];
                            int newcolcur=newcols+direction[k][1];
                            if(inAera(newrowcur,newcolcur)&& island[newrowcur][newcolcur]=='1' && !mark[newrowcur][newcolcur]){
                                queue.addLast(cols*newrowcur+newcolcur);
                                mark[newrowcur][newcolcur]=true;

                            }


                        }


                    }

                }


            }
        }

        return count;

    }

    private boolean inAera(int newx,int newy){
        return newx>=0&&newx<rows&&newy>=0&&newy<cols;

    }

    public static void main(String[] args) {
        BFSSeach bfsSeach = new BFSSeach();
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        int numIslands1 = bfsSeach.bfsSearch(grid1);
        System.out.println(numIslands1);

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        int numIslands2 = bfsSeach.bfsSearch(grid2);
        System.out.println(numIslands2);


//        int[][] direction = {{1,0},{-1,0},{0,-1},{0,1}};
//        for(int k=0;k<4;k++){
//            System.out.println(direction[k][0]);
//            System.out.println(direction[k][1]);
//            System.out.println("******************");
//        }
    }
}
