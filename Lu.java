class Lu {
  //LU分解するメソッド
  public static double[][] luDecomposition(double[][] A) {
    double[][] LU = Calc.copyMat(A);
    for (int i = 0; i < LU.length; i++) {
      for (int j = i + 1; j < LU.length; j++) {
        LU[j][i] = LU[j][i] / LU[i][i];
        for (int k = i + 1; k < LU[j].length; k++) {
          LU[j][k] -= LU[j][i] * LU[i][k];
        }
      }
    }
    return LU;
  }

  //LU分解したLを返すメソッド
  public static double[][] getL(double[][] LU) {
    double[][] L = new double[LU.length][LU[0].length];

    for (int i = 0; i < L.length; i++) {
      for (int j = 0; j < L[i].length; j++) {
        if (i > j) {
          L[i][j] = LU[i][j];
        } else if (i == j) {
          L[i][j] = 1;
        } else {
          L[i][j] = 0;
        }
      }
    }

    return L;
  }

  //LU分解したUを返すメソッド
  public static double[][] getU(double[][] LU) {
    double[][] U = new double[LU.length][LU[0].length];

    for (int i = 0; i < U.length; i++) {
      for (int j = 0; j < U[i].length; j++) {
        if (i <= j) {
          U[i][j] = LU[i][j];
        } else {
          U[i][j] = 0;
        }
      }
    }

    return U;
  }

  //Ly=b,Ux=yの解を一気に返すメソッド
  public static double[] solveUsingLU(double[][] L, double[][] U, double[] b) {
    double[] y = new double[L.length];

    for (int i = 0; i < L.length; i++) {
      y[i] = b[i];
      for (int j = 0; j < i; j++) {
        y[i] -= L[i][j] * y[j];
      }
    }

    //ここまででLy=bの解yが求まった
    //ここからはUx=yの解xを求める

    double[] x = new double[L.length];

    for (int i = U.length - 1; i >= 0; i--) {
      x[i] = y[i];
      for (int j = i + 1; j < U[0].length; j++) {
        x[i] -= U[i][j] * x[j];
      }
      x[i] /= U[i][i];
    }

    return x;
  }

  //Ly=bの解yを求めるメソッド
  public static double[] calcY(double[][] L,double[] b) {
    double[] y = new double[L.length];

    for (int i = 0; i < L.length; i++) {
      y[i] = b[i];
      for (int j = 0; j < i; j++) {
        y[i] -= L[i][j] * y[j];
      }
    }

    return y;
  }
}
