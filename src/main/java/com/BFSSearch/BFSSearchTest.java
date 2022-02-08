package com.BFSSearch;

public class BFSSearchTest {

    public static int numIslands(int island [][],int visit[][] ) {
        int count=0;
        for(int i=0;i<island.length;i++){
            for(int j=0;j<island[0].length;j++){
                if(visit[i][j] != 1){
                    if(island[i][j]==1){
                        count++;
                    }
                    BFSVisit(island,visit,i,j);
                }
            }
        }
        return count;
    }

    public static void BFSVisit(int island[][],int visit[][],int i,int j){
        if(i<0||j<0||i>island.length-1||j>island[0].length-1){
            return;
        }
        if(island[i][j]==0){
            return;
        }
        if(visit[i][j]==1){
            return;
        }else{
            visit[i][j]=1;
            System.out.println(i);
            System.out.println(j);
            System.out.println("*************");
            BFSVisit(island,visit,i-1,j);
            BFSVisit(island,visit,i+1,j);
            BFSVisit(island,visit,i,j-1);
            BFSVisit(island,visit,i,j+1);

        }

    }


    public static void main(String args[]){
        int [][] island={
                {1,1,0,1,1},
                {1,1,0,0,0},
                {0,0,1,0,0},
                {1,0,0,1,1}
        };
        int[][] visit =new int [island.length][island[0].length];
//        System.out.println(island[0][5]);
        System.out.println(numIslands(island,visit));

    }
}
