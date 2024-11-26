import java.util.List;

public class CalculateAverage {
    public static String calculateAverageString(List<String> dataValueList, List<String> weightList) {
        double numbersSum = 0;
        double weightSum = 0;
        for (int i = 0; i < dataValueList.size(); i++) {
            numbersSum += (Double.parseDouble(dataValueList.get(i)) * Double.parseDouble(weightList.get(i)));
            weightSum += Double.parseDouble(weightList.get(i));
        }
        return Double.toString(numbersSum / weightSum);
    }
}
