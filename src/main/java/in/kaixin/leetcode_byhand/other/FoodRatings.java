package in.kaixin.leetcode_byhand.other;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FoodRatings {

    Map<String, Integer> ratingMap = new HashMap<>();
    Map<String, PriorityQueue<Info>> map = new HashMap<>();
    Map<String, String> foodcuisineMap = new HashMap<>();

    public PriorityQueue<Info> getPriorityQueue() {
        PriorityQueue<Info> priorityQueue = new PriorityQueue<>((a, b) -> {
            if (b.rating == a.rating) {
                return a.food.compareTo(b.food);
            } else {
                return b.rating - a.rating;
            }
        });
        return priorityQueue;
    }

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            PriorityQueue<Info> infoQueue = map.get(cuisines[i]);
            if (infoQueue == null) {
                infoQueue = getPriorityQueue();
                map.put(cuisines[i], infoQueue);
            }
            Info info = new Info();
            info.setFood(foods[i]);
            info.setRating(ratings[i]);
            infoQueue.add(info);
            foodcuisineMap.put(foods[i], cuisines[i]);
            ratingMap.put(foods[i], ratings[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        ratingMap.put(food, newRating);
        PriorityQueue<Info> infoQueue = map.get(foodcuisineMap.get(food));
        Info info = new Info();
        info.setFood(food);
        info.setRating(newRating);
        infoQueue.add(info);
    }

    public String highestRated(String cuisine) {
        PriorityQueue<Info> queue = map.get(cuisine);
        while (!queue.isEmpty()) {
            Info info = queue.peek();
            if (info.getRating() == ratingMap.get(info.getFood())) {
                return info.getFood();
            } else {
                queue.remove();
            }
        }
        return "";
    }
}

class Info {
    String food;
    int rating;
    int idx;

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
