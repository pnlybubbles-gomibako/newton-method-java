class NewtonMethod2 {
  public static void newtonmethod(int n,double[] x0,double[] f,double[][] A,double epsilon,int Max){
    double[] x = new double[n];
    for(int i = 0; i < Max;i++){
      // System.out.println("x0: ");
      // Calc.printVec(x0);
      f = f(x0[0],x0[1],x0[2],x0[3],x0[4]);
      A = J(x0[0],x0[1],x0[2],x0[3],x0[4]);
      // Calc.printMatWolfram(A);
      // System.out.println("A: ");
      // Calc.printMat(A);
      A = Gauss.getA(Gauss.pivotForwardElimination(A, f)); //JとfについてPivotGaussをした後のJを取り出す
      // Calc.printMatWolfram(A);
      // System.out.println("A (pivot): ");
      // Calc.printMat(A);
      // System.out.println("A^-1: ");
      // Calc.printMat(InverseMatrix.getInverseMatrix(A));
      x = Calc.subVec(x0, Calc.matVec(InverseMatrix.getInverseMatrix(A), f)); //Aの逆関数(Jの逆関数)とfの内積
      double[] xsub = Calc.subVec(x, x0); //xとx0の差分
      double xNorm = Calc.vecNormInf(xsub); //xsubの∞ノルム
      if ( xNorm < epsilon) {// 収束判定
        // 反復回数と解を書く
        System.out.println("x =");
        System.out.printf("反復回数 N=%d,\t x[0]=%.10e x[1]=%.10e x[2]=%.10e x[3]=%.10e x[4]=%.10e \n",
                i + 1, x[0], x[1],x[2],x[3],x[4]);
        break;
      }else{
        x0 = Calc.copyVec(x);
      }
    }
  }

  public static double[][] J(double x1, double x2,double x3,double x4,double x5) {
    double[][] J = new double[5][5];
    J[0][0] = 2*x1;
    J[0][1] = 2*x2;
    J[0][2] = 2*x3;
    J[0][3] = 2*x4;
    J[0][4] = 2*x5;
    J[1][0] = 1 + 200*Math.pow(x3, 2)*x1;
    J[1][2] = 1 + 200*Math.pow(x1, 2)*x3;
    J[2][1] = 100*Math.pow(x4, 3) + 1;
    J[2][3] = 300*x2*Math.pow(x4, 2) + 1;
    J[3][2] = 90*x5;
    J[3][4] = 90*x3 + 1;
    J[4][0] = 2*x4;
    J[4][3] = 2*x1 - 1;
    return J;
  }

  public static double[] f(double x1, double x2,double x3,double x4,double x5) {
    double f1 = Math.pow(x1, 2) + Math.pow(x2, 2) + Math.pow(x3, 2) + Math.pow(x4, 2) + Math.pow(x5, 2) - 1;
    double f2 = x1 + x3 + 100*Math.pow(x1, 2)*Math.pow(x3, 2) - 1;
    double f3 = 100*x2*Math.pow(x4, 3) + x2 + x4 + 1;
    double f4 = 90*x3*x5 + x5 + 1;
    double f5 = 2*x1*x4 - x4 + 1;
    double[] f = {f1,f2,f3,f4,f5};
    return f;
  }
}
