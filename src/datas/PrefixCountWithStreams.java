package datas;
import java.util.Arrays;
import java.util.List;

public class PrefixCountWithStreams {
    public static void main(String[] args) {
        List<String> str = Arrays.asList("apk", "app", "apple", "arp", "array");
        String pre = "ap";

        long count = str.stream()
                .filter(word -> word.startsWith(pre))
                .count();

        System.out.println("Number of words with prefix \"" + pre + "\": " + count);
    }
}

    