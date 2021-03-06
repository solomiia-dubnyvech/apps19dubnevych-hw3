package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {

    private MyPredicate predicate;

    public FilterDecorator(SmartArray smartArray, MyPredicate predicate) {
        super(smartArray);
        this.predicate = predicate;
    }

    @Override
    public Object[] toArray() {
        return Arrays.stream(smartArray.toArray()).filter(predicate).toArray();
    }

    @Override
    public String operationDescription() {
        return "Filter " + smartArray.operationDescription();
    }

    @Override
    public int size() {
        return this.toArray().length;
    }
}
