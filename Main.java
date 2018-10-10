public class Main {
  public static void main(String[] args) {
    int n = 5;
    double[] x0 = { 1, 1, 1, 1, 1 };
    double[][] J = new double[n][n];
    double[] f = new double[n];
    double epsilon = 1e-10;
    int M = 10;
    // int M = 1;
    NewtonMethod2.newtonmethod(n, x0, f, J, epsilon, M);
  }
}
