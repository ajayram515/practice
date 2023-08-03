package com.ajay.practice.service;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.IntStream;

@Service
public class SumService {
  public List<Integer> twoSum(List<Integer> integerList, Integer target) {
    Map<Integer, Integer> integerMap = new HashMap<>();

    return IntStream.range(0, integerList.size())
        .mapToObj(
            i -> {
              int num = integerList.get(i);
              int complement = target - num;
              if (integerMap.containsKey(complement)) {
                return List.of(integerMap.get(complement), i);
              }
              integerMap.put(num, i);
              return null;
            })
        .filter(Objects::nonNull)
        .findFirst()
        .orElse(null);
  }

  public int[] sortedTwoSum(int[] integerList, int target) {
    int start = 0;
    int end = integerList.length - 1;
    while (end > start) {
      if (integerList[start] + integerList[end] == target) {
        return new ArrayList<>(List.of(start + 1, end + 1))
            .stream().mapToInt(Integer::intValue).toArray();
      } else if (integerList[start] + integerList[end] > target) {
        end--;

      } else {
        start++;
      }
    }
    return null;
  }

  public List<List<Integer>> threeSum(int[] integerList) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(integerList);
    for (int i = 0; i < integerList.length; i++) {
      if (i != 0 && integerList[i] == integerList[i - 1]) continue;
      int[] subArray = Arrays.copyOfRange(integerList, i + 1, integerList.length);
      int[] twoResult = sortedTwoSum(subArray, -1 * integerList[i]);
      if (twoResult != null) {
        List<Integer> subList = new ArrayList<>();
        subList.add(integerList[i]);
        subList.add(subArray[twoResult[0] - 1]);
        subList.add(subArray[twoResult[1] - 1]);
        result.add(subList);
      }
    }
    return result;
  }
}
