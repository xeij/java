package datas.src;
import java.util.Random;

public class SkipList<T extends Comparable<? super T>> {
    private static final int maxLevel = 5;
    private final SkipNode<T> head = new SkipNode<>(null, maxLevel);
    private final Random random = new Random();

    private static class SkipNode<N extends Comparable<? super N>> {
        N value;
        SkipNode<N>[] forward;

        @SuppressWarnings("unchecked")
        SkipNode(N value, int level) {
            this.value = value;
            this.forward = new SkipNode[level + 1];
        }
    }
