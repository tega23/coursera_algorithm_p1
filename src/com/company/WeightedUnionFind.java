package com.company;

import java.util.Scanner;

/**
 * Created by Otega on 7/5/2017.
 */

/*Social network connectivity. Given a social network containing n members and a log file containing m
timestamps at which times pairs of members formed friendships, design an algorithm to determine the
earliest time at which all members are connected (i.e., every member is a friend of a friend of a friend ... of a friend).
 Assume that the log file is sorted by timestamp and that friendship is an equivalence relation. The running time of your
 algorithm should be mlogn or better and use extra space proportional to n.
 */

/*Implemenatation of weighted union find*/
public class WeightedUnionFind {
    /*id is the size of the objects */
    private int[] id;
    /*size is going to keep track of the size of each components*/
    private int[] size;

    public WeightedUnionFind(int N)
    {
        id = new int[N];
        size = new int[N];
        for(int i=0; i< N; i++) id[i] = i;
        for(int i=0; i< N; i++) size[i]=1;
    }
    /*connected is going to check if p and q have the same root*/
    public boolean connected(int p, int q) {
        return root(p)== root(q);
    }
    public int root(int i)
    {
        while(i != id[i]){
            id[i]= id[id[i]];
            id[i]= i;
        }
        return i;
    }
    public void union(int p, int q)
    {
        int i= root(p);
        int j= root(q);
        if(i==j) return ;
        if(size[i]< size[j]){
            id[i]= j;
            size[j]+= size[i];
        }
        else
        {
            id[j]= i;
            size[i]+= size[j];
        }
    }
}
class SocialNetworkConnectivity{
    WeightedUnionFind uf;
    private int connectedComponents ;
    public SocialNetworkConnectivity(int N)
    {
        uf = new WeightedUnionFind(N);
        connectedComponents= N;
    }
    public void addFriendShip(int p, int q)
    {
        if(!uf.connected(p,q)){
            uf.union(p,q);
            connectedComponents--;
        }
    }
    public boolean fullyConnected()
    {
        /*Returns true if the number of connected components is equal to 1...All the individuals are fully connected*/
        return (connectedComponents== 1);
    }


}
