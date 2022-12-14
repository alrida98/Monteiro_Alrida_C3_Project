import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();
   // public static Restaurant findRestaurantByName;

//    public RestaurantService()
//    {
//        LocalTime openingTime = LocalTime.parse("10:30:00");
//        LocalTime closingTime = LocalTime.parse("22:00:00");
//        restaurants.add(new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime));
//    }
    public Restaurant findRestaurantByName(String restaurantName) {

        for (Restaurant restaurant : restaurants) {
            if (restaurantName != restaurant.getName()) {
                throw new restaurantNotFoundException(restaurantName);
            } else if ( restaurant.getName().equals(restaurantName)) {
                return restaurant;
            }
        }

        return null;

    }







    //
    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
