import org.junit.jupiter.api.Test;
import com.example.Graph;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

public class graphTest {

    @Test
    public void AddingEdgeAndVertices() {
        Graph graph = new Graph();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);

        List<Integer> dfTraversal = graph.depthFirstTraversal(1);
        assertTrue(dfTraversal.contains(1));
        assertTrue(dfTraversal.contains(2));
        assertTrue(dfTraversal.contains(3));
    }

    @Test
    public void DepthFirstTraversal() {
        Graph graph = new Graph();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);

        List<Integer> expectedTraversal = Arrays.asList(1, 3, 5, 2, 4);
        assertEquals(expectedTraversal, graph.depthFirstTraversal(1));
    }

    @Test
    public void BreadthFirstTraversal() {
        Graph graph = new Graph();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);

        List<Integer> expectedTraversal = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(expectedTraversal, graph.breadthFirstTraversal(1));
    }
}
