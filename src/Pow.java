public class Pow {
  private double pow(double x, long n) {
    if (n == 0) return 1;
    if (n == 1) return x;
    return x * pow(x, n - 1);
  }

  public double myPow(double x, int n) {
    if (n < 0) {
      return 1 / pow(x, Math.abs(n));
    } else {
      return pow(x, n);
    }
  }
}
