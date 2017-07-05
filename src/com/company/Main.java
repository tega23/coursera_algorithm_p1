package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        /*Sample of a log file
        /*0 1 2015-08-14 17:00:00
        1 9 2015-08-14 17:01:00
        0 2 2015-08-14 18:02:00
        0 3 2015-08-14 18:04:00
        0 4 2015-08-14 18:05:00
        0 5 2015-08-14 18:06:00
        0 6 2015-08-14 18:07:00
        0 7 2015-08-14 18:08:00
        0 8 2015-08-14 18:14:00
        1 2 2015-08-14 18:16:00
        1 3 2015-08-14 18:28:00
        1 4 2015-08-14 18:30:00
        1 5 2015-08-14 18:42:00
        2 1 2015-08-14 18:44:00
        2 3 2015-08-14 18:46:00
        2 4 2015-08-14 18:58:00
        5 5 2015-08-14 19:30:00
        */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SocialNetworkConnectivity socialN = new SocialNetworkConnectivity(n);
        String date, time;
        //timestamps are sorted ascending
        while (!sc.hasNext()) {
            int p = sc.nextInt();
            int q = sc.nextInt();
            date = sc.next();
            time = sc.next();


            socialN.addFriendShip(p, q);

            System.out.println("[" + p + "," + q + "]");

            if (socialN.fullyConnected()) {
                System.out.println("All members were connected at: " + date + time);
                break;
            }
        }
    }
}