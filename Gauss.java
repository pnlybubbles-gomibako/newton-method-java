class Gauss {
  //ピボット選択付きGauss消去法をするメソッド
	public static double[][] pivotForwardElimination(double A[][],double[] b) {
		double[][] Ab = makeAb(A,b);
		double[][] A2 = Calc.copyMat(Ab);

		for (int i = 0; i < A2.length; i++) {
			int maxj = i;

			for (int j = i + 1; j < A2.length; j++) {
				if (Math.abs(A2[j][i]) > Math.abs(A2[maxj][i])) {
					maxj = j;
				}
			}

			double[] c = A2[i];
			A2[i] = A2[maxj];
			A2[maxj] = c;

			for (int j = i + 1; j < A2.length; j++) {
				double m = A2[j][i] / A2[i][i];
				for (int k = i + 1; k < A2[j].length; k++) {
					A2[j][k] -= m * A2[i][k];
				}
			}
		}
		return A2;
  }

  //makeAbによってくっついたAを返すメソッド
	public static double[][] getA(double[][] Ab) {
		double[][] A = new double[Ab.length][Ab[0].length - 1];

		for(int i = 0;i < A.length;i++) {
			for(int j = 0;j < A[i].length;j++) {
				A[i][j] = Ab[i][j];
			}
		}
		return A;
  }

  //Aとbをくっつけた行列を返すメソッド
	public static double[][] makeAb(double[][] A ,double[] b){
		double[][] Ab = new double[A.length][A[0].length + 1];

		for(int i = 0;i < A.length;i++) {
			for(int j = 0;j < A[i].length;j++) {
				Ab[i][j] = A[i][j];
			}
		}

		for(int i = 0;i < A.length;i++) {
			Ab[i][A[0].length] = b[i];
		}

		return Ab;
	}
}
