package visualizealgorithms;

//Project imports
import visualizealgorithms.bll.algorithm.*;

//Java imports
import java.util.ArrayList;

/**
 * Convenience class that adds algorithms and handles inputs
 */
public class AlgorithmLoader {

    private String inputs = "";
    private ArrayList<IAlgorithm> algorithms = new ArrayList<>();

    public AlgorithmLoader() {
        //Modify default inputs
        inputs = "1000;2000;4000;8000;16000;32000;64000;";

        //Add implemented/selected algorithms here..
        algorithms.add(new SelectionSortAlgo());
        algorithms.add(new BubbleSortAlgo());
        algorithms.add(new QuickSortAlgo());
        algorithms.add(new MergeSortAlgo());

        //more algorithms here :)
    }

    public String getInputs() {
        return inputs;
    }

    public ArrayList<IAlgorithm> getAlgorithms() {
        return algorithms;
    }
}
