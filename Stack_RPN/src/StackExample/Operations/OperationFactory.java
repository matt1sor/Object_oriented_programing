package StackExample.Operations;

import java.util.HashMap;
import java.util.Map;

public class OperationFactory{

    private static final Map<String,Operation> operationMap = new HashMap<>();

    static {
        operationMap.put("+", new Sum());
        operationMap.put("-", new Sub());
        operationMap.put("*", new Multiply());
        operationMap.put("/", new Divide());

    }

    public static Boolean isSupported(String sign){
        return operationMap.containsKey(sign);
    }


    public static Operation getOperation(String sign){
        if (isSupported(sign)) {
            return operationMap.get(sign);

        }
        throw new IllegalArgumentException("Not supported operation");
    }


}
