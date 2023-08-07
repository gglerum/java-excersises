package lesson3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Utils {

    private Utils() {

    }

    /**
     * Extract and join items from a parent collection
     * 
     * @param <T>        type of original parent collection
     * @param <R>        type of new collection
     * @param collection that has the items we want to extract and join
     * @param fnMap      lambda expression for mapping the collection items
     * @return the new collection of extracted sub items
     */
    public static <T, R> List<R> joinSubLists(List<T> collection, Function<T, List<R>> fnMap) {
        return collection.stream().map(fnMap).reduce(new ArrayList<>(),
                (completeList, list) -> {
                    completeList.addAll(list);
                    return completeList;
                });
    }

}
