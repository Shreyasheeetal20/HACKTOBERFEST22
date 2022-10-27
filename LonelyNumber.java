import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LonelyNumber {
    public List<Integer> findLonely(int[] nums) {
        Map<Integer, Integer> numberMap = new HashMap<>();
        for (int num : nums) {
            numberMap.put(num, numberMap.getOrDefault(num, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (int num : numberMap.keySet()) {
            //  for (int num : nums) {
            if ((numberMap.get(num) == 1) && (!numberMap.containsKey(num - 1)) && (!numberMap.containsKey(num + 1))) {
                result.add(num);
            }
        }
        return result;
    }
}
