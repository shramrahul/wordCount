import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class WordCount {
    public static void main(String[] args) {
        String str = "the cat is in the bag";
        WordCount wordCount = new WordCount();
        wordCount.getSortedWordCountMap(str)
                .forEach((key, value) -> System.out.println(value + " " + key));
    }
    public Map<String, Long> getSortedWordCountMap(String str){
        if(str == null || str.equals(""))
            return new LinkedHashMap<String, Long>(){};

        return Arrays.stream(str.split(" "))
                .collect(Collectors.groupingBy(a -> a, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
}