class Calc {
  // ベクトル同士の減算を計算する
	public static double[] addVec(double x[], double y[]) {
		int N = x.length;
		double[] z = new double[N];
		if (x.length != y.length) {
			System.out.println("x.length!=y.length");
			return z;
		}
		for (int i = 0; i < x.length; i++) {
			z[i] = x[i] + y[i];
		}
		return z;
  }

  // ベクトル同士の減算を計算する
	public static double[] subVec(double x[], double y[]) {
		int N = x.length;
		double[] z = new double[N];
		if (x.length != y.length) {
			System.out.println("x.length!=y.length");
			return z;
		}
		for (int i = 0; i < x.length; i++) {
			z[i] = x[i] - y[i];
		}
		return z;
  }

  // 行列Aとベクトルxの積を計算する
	public static double[] matVec(double A[][], double x[]) {
		double[] z = new double[A.length];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				z[i] += A[i][j] * x[j];
			}
		}
		return z;
  }

  // ベクトルの∞ノルムを計算する
	// 絶対値の中で一番値が大きいもの
	public static double vecNormInf(double x[]) {
		double z = 0;
		for (int i = 0; i < x.length; i++) {
			if (z < Math.abs(x[i])) {
				z = Math.abs(x[i]);
			}
		}
		return z;
  }

  public static double[] copyVec(double[] vec) {
    int n = vec.length;
    double[] copy = new double[n];
    for (int i = 0; i < n; i++) {
      copy[i] = vec[i];
    }
    return copy;
  }

  public static double[][] copyMat(double[][] mat) {
    double[][] copy = new double[mat.length][mat[0].length];
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length; j++) {
        copy[i][j] = mat[i][j];
      }
    }
    return copy;
  }

  public static void printMat(double[][] mat) {
    int n = mat.length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.printf("%10.2e  ", mat[i][j]);
      }
      System.out.println();
    }
  }

  public static void printVec(double[] vec) {
    int n = vec.length;
    for (int i = 0; i < n; i++) {
      System.out.printf("%10.2e  ", vec[i]);
    }
    System.out.println();
  }

  public static void printMatWolfram(double[][] mat) {
    int n = mat.length;
    System.out.print("[");
    for (int i = 0; i < n; i++) {
      System.out.print("[");
      for (int j = 0; j < n; j++) {
        System.out.printf("%.2f", mat[i][j]);
        if (j != n - 1) {
          System.out.print(",");
        }
      }
      System.out.print("]");
      if (i != n - 1) {
        System.out.print(",");
      }
    }
    System.out.print("]");
    System.out.println();
  }
}
