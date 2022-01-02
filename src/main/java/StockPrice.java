import java.util.*;

public class StockPrice {
    Map<Integer, List<Integer>> map = new HashMap<>();
//    https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            List<Integer> indexList = map.get(price);

            if (indexList == null) {
                indexList = new LinkedList<Integer>();
                map.put(price, indexList);
            }
            indexList.add(i);
        }
        Integer[] priceSorted = map.keySet().toArray(new Integer[]{});
        Arrays.sort(priceSorted);
        Integer profit = 0;
        for (int i = 0; i < priceSorted.length - 1; i++) {
            Integer price = priceSorted[i];
            List<Integer> minPriceIndexList = map.get(price);
            if (minPriceIndexList == null || minPriceIndexList.size() == 0) {
                continue;
            }
            Integer minindex = minPriceIndexList.get(0);
            for (int j = priceSorted.length - 1; j > i; j--) {
                Integer maxPrice = priceSorted[j];
                List<Integer> maxPriceIndexList = map.get(maxPrice);
                if (maxPriceIndexList == null || maxPriceIndexList.size() == 0) {
                    continue;
                }
                Integer maxIndex = maxPriceIndexList.get(maxPriceIndexList.size() - 1);
                if (maxIndex > minindex) {
                    profit = profit > maxPrice - price ? profit : maxPrice - price;
                    break;
                } else {
                    continue;
                }

            }



        }
        return profit;


    }

    public static void main(String... args) {
        StockPrice stockPrice = new StockPrice();
        int[] prices = new int[]{3, 2, 6, 5, 0, 3};
        System.out.println(stockPrice.maxProfit(prices));
    }
}
