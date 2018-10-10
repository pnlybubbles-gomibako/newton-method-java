class InverseMatrix {
  //Aの逆行列を返すメソッド
  public static double[][] getInverseMatrix(double[][] A) {
    int n = A.length;
    double[][] LU = Lu.luDecomposition(A);
    double[][] L = Lu.getL(LU);
    double[][] U = Lu.getU(LU);
    // Calc.printMat(U);
    // System.out.println();

    double[][] X = new double[n][n];

    for (int i = 0; i < n; i++) {
      double[] ei = new double[n];

      for (int j = 0; j < n; j++) {
        if (i == j)
          ei[j] = 1;
        else
          ei[j] = 0;
      }

      double[] xi = Lu.solveUsingLU(L, U, ei);

      for (int j = 0; j < n; j++) {
        X[j][i] = xi[j];
      }
    }
    return X;
  }
}
