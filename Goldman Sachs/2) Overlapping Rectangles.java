/*
    https://practice.geeksforgeeks.org/problems/overlapping-rectangles1924/1/#
*/

class Solution {
    int doOverlap(int L1[], int R1[], int L2[], int R2[]) {
        int width1=R1[0]-L1[0],width2=R2[0]-L2[0];
        int height1=L1[1]-R1[1],height2=L2[1]-R2[1];

        if(L2[1]-L1[1]>=0&&height2>=L2[1]-L1[1]){
            if(R2[0]-R1[0]>=0&&width2>=R2[0]-R1[0]){
                return 1;
            }else if(R1[0]-R2[0]>=0&&width1>=R1[0]-R2[0]){
                return 1;
            }
        }else if(L1[1]-L2[1]>=0&&height1>=L1[1]-L2[1]){
            if(R2[0]-R1[0]>=0&&width2>=R2[0]-R1[0]){
                return 1;
            }else if(R1[0]-R2[0]>=0&&width1>=R1[0]-R2[0]){
                return 1;
            }
        }
        return 0;
    }
};
