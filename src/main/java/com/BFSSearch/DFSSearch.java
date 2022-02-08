package com.BFSSearch;

public class DFSSearch {

/**
 * https://blog.csdn.net/qq_35556504/article/details/80169872
 * 岛屿的个数
 * 给定'1'(陆地) 和'0'(水) 的二维网格图，计算岛屿的数量。
 * 一个岛被水包围，并且通过水平或垂直连接相邻的陆地而形成。你可以假设网格的四个边均被水包围。
 * 示例1:
 * 11110
 * 11010
 * 11000
 * 00000
 * 答案: 1
 * 示例2:
 * 11000
 * 11000
 * 00100
 * 00011
 * 答案: 3
 */


    public static int bfsSearch(int island[][],int vistBFS [][]){

        int count =0;
        for (int i =0;i<island.length;i++){
            for(int j=0;j<island[0].length;j++){
                if(vistBFS[i][j] !=1){
                    if(island[i][j]==1){//表示第一个1 进行+1
                        count ++;
                    }
                   //进行深度优先搜索
                    disBFSearch(island,vistBFS,i,j);
                }
            }
        }
        return count;
    }

    public static void disBFSearch(int island[][],int vistBFS[][],int i,int j){
        if(i<0||j<0||i>island.length-1|j>island[0].length-1){//判断数组是否越界
            return;
        }
        if(island[i][j]==0){//表示不是岛屿
            return;
        }
        if(vistBFS[i][j]==1){//表示已经遍历过了
            return;
        }else{
            //表示没遍历过，四周遍历
            vistBFS[i][j]=1;
            System.out.println("i"+i + "j"+j);
            disBFSearch(island,vistBFS,i-1,j);//上
            disBFSearch(island,vistBFS,i+1,j);//下
            disBFSearch(island,vistBFS,i,j-1);//左
            disBFSearch(island,vistBFS,i,j+1);//右

        }





    }

    public static void main(String[] args) {
        //岛屿的数量
        int[][] island = {{1, 1, 0, 1, 1},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {1, 0, 0, 1, 1}};
        //isvisit表示是否遍历过
        int[][] isvisit = new int[island.length][island[0].length];
        System.out.println(bfsSearch(island, isvisit));

    }

}
