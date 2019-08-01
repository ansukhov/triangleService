package helpers;

import java.math.BigDecimal;

public class MathCalculation {

    public static float calculatePerimeter(String input, String separator) {
        String[] inputArr = input.split(separator);
        return Float.parseFloat(inputArr[0]) + Float.parseFloat(inputArr[1]) + Float.parseFloat(inputArr[2]);
    }

    public static float calculateArea(String input, String separator) {
        String[] inputArr = input.split(separator);
        float firstSide = Float.parseFloat(inputArr[0]);
        float secondSide = Float.parseFloat(inputArr[1]);
        float thirdSide = Float.parseFloat(inputArr[2]);
        float p = (firstSide + secondSide + thirdSide) / 2;
        float area = (float) Math.sqrt(p * (p - firstSide) * (p - secondSide) * (p - thirdSide));
        BigDecimal bigArea = new BigDecimal(area);
        BigDecimal roundArea = bigArea.setScale(7, BigDecimal.ROUND_HALF_UP);
        return roundArea.floatValue();
    }
}
