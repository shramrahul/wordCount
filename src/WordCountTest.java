
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;


class WordCountTest {

    WordCount wordCount;

    @BeforeEach
    public void setUp(){
        wordCount = new WordCount();
    }

    @Test
    public void testWordCount_givenAString(){
        String str = "i am a boy i";

        Map<String, Integer> expectedOutput =
                new LinkedHashMap<String, Integer>(){{
                    put("i", 2);
                    put( "a", 1);
                    put("am", 1);
                    put("boy", 1);
                }};

        Map<String, Long> sortedWordCountMap = wordCount.getSortedWordCountMap(str);
        Assertions.assertEquals(expectedOutput.toString(), sortedWordCountMap.toString());
    }

    @Test
    public void testWordCount_givenAnEmptyString_expectAnEmptyMap(){
        String str = null;

        Map<String, Long> sortedWordCountMap = wordCount.getSortedWordCountMap(str);
        Assertions.assertEquals(new LinkedHashMap<String, Long>(){}.toString(), sortedWordCountMap.toString());
    }

    @Test
    public void testWordCount_givenAnActualString(){
        String str = "the cat is in the bag";

        Map<String, Integer> expectedOutput =
                new LinkedHashMap<String, Integer>(){{
                    put("the", 2);
                    put("in", 1);
                    put("cat", 1);
                    put("bag", 1);
                    put("is", 1);
                }};

        Map<String, Long> sortedWordCountMap = wordCount.getSortedWordCountMap(str);
        Assertions.assertEquals(expectedOutput.toString(), sortedWordCountMap.toString());
    }

}