package Sort;

import Koszyk.Product;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortList {
    public static Map<String,Comparator<Product>> SortList = new HashMap<>();
    static {
        SortList.put("NameDown", new SortByName());
        SortList.put("NameUp", new SortByName().reversed());
        SortList.put("PriceDown", new SortByPrice());
        SortList.put("PriceUp", new SortByPrice().reversed());
    }

    public SortList(){

    }
    public static void  addSort(String sortName, Comparator<Product> sort){
        if(!(SortList.containsKey(sortName))){
            SortList.put(sortName,sort);
        }else {
            throw new IllegalArgumentException("exist");
        }
    }
    public static void  deleteSort (String sortName){
        if(SortList.containsKey(sortName)){
            SortList.remove(sortName);
        }else {
            throw new IllegalArgumentException("not exist");
        }
    }

    public static Comparator<Product> getSort(String sortName){
            if(SortList.containsKey(sortName)){
                return SortList.get(sortName);
            }else{
                throw new IllegalArgumentException("Not in Sort.SortList");
            }
    }

}
