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

    public void insert(T value) {
        @SuppressWarnings("unchecked")
        SkipNode<T>[] update = new SkipNode[maxLevel + 1];
        SkipNode<T> current = head;
        for (int i = maxLevel; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].value.compareTo(value) < 0) {
                current = current.forward[i];
            }
            update[i] = current;
        }
        current = new SkipNode<>(value, randomLevel());
        for (int i = 0; i <= current.forward.length - 1; i++) {
            current.forward[i] = update[i].forward[i];
            update[i].forward[i] = current;
        }
    }

    public void displayList() {
        System.out.println("Skip List:");
        for (int i = maxLevel; i >= 0; i--) {
            System.out.print("L" + i + ": ");
            SkipNode<T> node = head.forward[i];
            while (node != null) {
                System.out.print(node.value + " ");
                node = node.forward[i];
            }
            System.out.println();
        }
    }

    private int randomLevel() {
        int lvl = 0;
        while (lvl < maxLevel && random.nextDouble() < 0.5) {
            lvl++;
        }
        return lvl;
    }
}
