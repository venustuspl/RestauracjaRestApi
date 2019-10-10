package pl.akademiakodu.AK_Spring_Exercise_RestaurantTODO.models.services.dao;

/**
 * Imports section
 */
import org.springframework.stereotype.Service;
import pl.akademiakodu.AK_Spring_Exercise_RestaurantTODO.models.Meal;
import pl.akademiakodu.AK_Spring_Exercise_RestaurantTODO.models.OrderR;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Class responsible for order logic
 */
@Service
public class OrderDaoImpl implements OrderDao {

    /**
     * Order list stored all created orders (individual)
     */
    private List<OrderR> orderList;

    /**
     * Constructor
     */
    public OrderDaoImpl() {
        orderList = new ArrayList<>();
    }

    @Override
    public List<OrderR> getAllOrders() {
        return orderList;
    }

    @Override
    public void addOrder(OrderR order) {
        orderList.add(order);
    }

    @Override
    public void removeOrder(OrderR order) {
        for (OrderR order1 : orderList) {
            if (order1.equals(order)){
                orderList.remove(order);
                break;
            }
        }
    }

    @Override
    public void addMealToOrder(OrderR order, Meal meal) {

        Set<Meal> ourMeals = (Set<Meal>) order.getMealList();
        ourMeals.add(meal);
        order.setMealList((List<Meal>)ourMeals);
/*

List <Meal> ourMeals = new ArrayList<>();
 gdyby nie można było powtórzyć zamówienia
if      (   !checkIfMealAppearInOurOrder(order,meal)) {
     ourMeals.add(meal);
        order.setMealList(ourMeals);
    }

 */
          order.getMealList().add(meal);



    }

    @Override
    public void removeMealFromOrder(OrderR order, Meal meal) {
        //todo implement
        order.getMealList().remove(meal);
    }

    @Override
    public boolean checkIfMealAppearInOurOrder(OrderR order, Meal meal){
        //todo repair
       /* for (int i = 0; i > order.getMealList().size(); i++) {
            if (order.getMealList().get(i).equals(meal)){
                return true;
            }
        }
        return false;

        */
       if (order.getMealList().contains(meal)){
           return true;}
       else {
           return false;
       }
    }
}
