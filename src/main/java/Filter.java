import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    protected int threshold;

    public Filter(int threshold) {
        this.threshold = threshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        for (Integer num : source){
            if (num >= threshold){
                logger.log("Элемент \"" + num + "\" подходит");
                result.add(num);
            } else{
                logger.log("Элемент \"" + num + "\" не подходит");
            }
        }
        logger.log("Прошло фильтр " + result.size() + " из " + source.size() + " элементов");
        return result;
//        return source.stream().filter(x -> x >= threshold).collect(Collectors.toList());
    }
}
