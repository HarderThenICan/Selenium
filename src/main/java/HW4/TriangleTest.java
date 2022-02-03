package HW4;

public class TriangleTest {


    public static double triangleArea(int a, int b, int c) throws Exception {
        if (a + b < c || b + c < a || c + a < b) {
            throw new Exception("Одна из сторон больше суммы двух других");
        }

        if (a <= 0 || b <= 0 || c <= 0) {
            throw new Exception("Введите корректные данные");
        }


        double s = (a + b + c) / 2;
        double square = (s * (s - a) * (s - b) * (s - c));
        return Math.sqrt(square);
    }
}