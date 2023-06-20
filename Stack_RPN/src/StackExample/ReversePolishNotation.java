package StackExample;

import StackExample.Operations.Operation;
import StackExample.Operations.OperationFactory;


public class ReversePolishNotation {

    public int calcualte(String x) {

        String[] arr = x.split("\\s+"); // x.replaceAll("\\s+","").split("(?!^)");
        StackExample<String> stack = new StackExample<String>(x.length());

        int z;
        int y;
        int value = 0;
        String s = "";
        String result;


        for (String item : arr) {

            if (!(OperationFactory.isSupported(item))){
                stack.push(item);

            } else {

                z = Integer.parseInt(stack.pop());
                y = Integer.parseInt(stack.pop());

               Operation opr = OperationFactory.getOperation(item);

                value = opr.calculate(y,z);

                result = s + value;

                stack.push(result);


            }


        }

        return Integer.parseInt(stack.pop());



    }

//    public static void main(String[] x){
//        int wynik = new ReversePolishNotation().calcualte("");
//        System.out.println(wynik);
//    }


}







