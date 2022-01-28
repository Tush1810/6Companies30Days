/*
    https://leetcode.com/problems/generate-random-point-in-a-circle/submissions/
*/

class Solution {
    private double r, x, y;
    Random random;
    public Solution(double radius, double x_center, double y_center) {
        this.r = radius;
        this.x = x_center;
        this.y = y_center;
        random = new Random();
    }

    public double[] randPoint() {
        double radius = (Math.sqrt(random.nextDouble()) * r);
        double theta = random.nextDouble(0, 2 * Math.PI);

        double temp1 = radius * Math.cos(theta);
        double temp2 = radius * Math.sin(theta);

        return new double[] {x + temp1, y + temp2};
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
