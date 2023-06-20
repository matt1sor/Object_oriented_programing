package StackExample.Operations;

public class Sum implements Operation {


    @Override
    public Integer calculate(int x, int y) {
        return x+y;
    }
}
