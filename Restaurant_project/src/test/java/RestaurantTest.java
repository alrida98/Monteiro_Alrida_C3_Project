import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {
    Restaurant restaurant;
    @ExtendWith(MockitoExtension.class)
    //REFACTOR ALL THE REPEATED LINES OF CODE
    @BeforeEach
    public void before_each()
    {

        LocalTime openingTime = LocalTime.parse("10:30:00");
        LocalTime closingTime = LocalTime.parse("22:00:00");
        restaurant = new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime);
        restaurant.addToMenu("Sweet corn soup",119);
        restaurant.addToMenu("Vegetable lasagne", 269);
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>OPEN/CLOSED<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    //-------FOR THE 2 TESTS BELOW, YOU MAY USE THE CONCEPT OF MOCKING, IF YOU RUN INTO ANY TROUBLE
    @Test
    public void is_restaurant_open_should_return_true_if_time_is_between_opening_and_closing_time(){


        Restaurant spiderest = Mockito.spy(restaurant);
        Mockito.when(spiderest.getCurrentTime()).thenReturn(LocalTime.parse("12:30:00"));
       assertTrue(spiderest.isRestaurantOpen());

    }

    @Test
    public void is_restaurant_open_should_return_false_if_time_is_outside_opening_and_closing_time(){

        Restaurant spiderest = Mockito.spy(restaurant);
        Mockito.when(spiderest.getCurrentTime()).thenReturn(LocalTime.parse("23:30:00"));
        assertFalse(spiderest.isRestaurantOpen());
        //WRITE UNIT TEST CASE HERE

    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<OPEN/CLOSED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


    //>>>>>>>>>>>>>>>>>>>>>>>>>>>MENU<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Test
    public void adding_item_to_menu_should_increase_menu_size_by_1(){
        //LocalTime openingTime = LocalTime.parse("10:30:00");
       // LocalTime closingTime = LocalTime.parse("22:00:00");
       // restaurant =new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime);
        restaurant.addToMenu("Sweet corn soup",119);
        restaurant.addToMenu("Vegetable lasagne", 269);

        int initialMenuSize = restaurant.getMenu().size();
        restaurant.addToMenu("Sizzling brownie",319);
        assertEquals(initialMenuSize+1,restaurant.getMenu().size());
    }
    @Test
    public void removing_item_from_menu_should_decrease_menu_size_by_1() throws itemNotFoundException {
      //  LocalTime openingTime = LocalTime.parse("10:30:00");
       // LocalTime closingTime = LocalTime.parse("22:00:00");
       // restaurant =new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime);
       // restaurant.addToMenu("Sweet corn soup",119);
       // restaurant.addToMenu("Vegetable lasagne", 269);

        int initialMenuSize = restaurant.getMenu().size();
        restaurant.removeFromMenu("Vegetable lasagne");
        assertEquals(initialMenuSize-1,restaurant.getMenu().size());
    }
    @Test
    public void removing_item_that_does_not_exist_should_throw_exception() {

        assertThrows(itemNotFoundException.class,
                ()->restaurant.removeFromMenu("French fries"));
    }






//when selecting items - price and items should be displayed
        //user should be able to add items
        //Find total they are spending

@Test
    public void when_selecting_items_total_price_gets_added()
{
    //List<Item> Item = new ArrayList<Item>();

   // Item

//int total =0;
int price1 = restaurant.get_price("Sweet corn soup");
    int price2 = restaurant.get_price("Vegetable lasagne");
    //int total = price1+price2;
   int total = restaurant.get_total(price1)+restaurant.get_total(price2);
    assertNotNull(total);


}
    }

//    }<<<<<<<<<<<<<<<<<<<<<<<MENU>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
