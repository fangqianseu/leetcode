package basic.calculator.sdk.impl;


import basic.calculator.sdk.ICalculator;

import java.util.Objects;
import java.util.Stack;

/**
 * @author qianfang, at 2023/3/19, 23:28
 **/
public class SimpleCalculatorImpl implements ICalculator {
    private double val;
    private final int logLength;
    private Stack<StackPair> redoStack = new Stack<>();
    private Stack<StackPair> undoStack = new Stack<>();

    public SimpleCalculatorImpl(int logLength) {
        this.logLength = logLength;
    }

    @Override
    public SimpleCalculatorImpl init(double a) {
        this.val = a;
        System.out.printf("set %s; \n", this.val);
        return this;
    }

    @Override
    public SimpleCalculatorImpl add(double a) {
        innerAdd(a);
        logUndo(Operation.ADD, a);
        return this;
    }

    @Override
    public SimpleCalculatorImpl subtract(double a) {
        innerSubtract(a);
        logUndo(Operation.SUBTRACT, a);
        return this;
    }


    @Override
    public SimpleCalculatorImpl multiply(double a) {
        innerMultiply(a);
        logUndo(Operation.MULTIPLY, a);
        return this;
    }

    @Override
    public SimpleCalculatorImpl divide(double a) {
        innerDivide(a);
        logUndo(Operation.DIVIDE, a);
        return this;
    }

    public SimpleCalculatorImpl undo() {
        if (!undoStack.isEmpty()) {
            System.out.println("begin undo......");
            StackPair undoLog = undoStack.pop();
            redoLog(undoLog);
            switch (undoLog.getOp()) {
                case ADD:
                    innerSubtract(undoLog.getVal());
                    break;
                case SUBTRACT:
                    innerAdd(undoLog.getVal());
                    break;
                case MULTIPLY:
                    innerDivide(undoLog.getVal());
                    break;
                case DIVIDE:
                    innerMultiply(undoLog.getVal());
                    break;
            }
        } else {
            System.out.println("no undo operation.....");
        }
        return this;
    }

    public SimpleCalculatorImpl redo() {
        if (!redoStack.isEmpty()) {
            System.out.println("begin redo......");
            StackPair redo = redoStack.pop();
            switch (redo.getOp()) {
                case ADD:
                    innerAdd(redo.getVal());
                    break;
                case SUBTRACT:
                    innerSubtract(redo.getVal());
                    break;
                case MULTIPLY:
                    innerMultiply(redo.getVal());
                    break;
                case DIVIDE:
                    innerDivide(redo.getVal());
                    break;
            }
        } else {
            System.out.println("no redo operation.....");
        }
        return this;
    }

    @Override
    public double getVal() {
        if (Double.isInfinite(this.val)) {
            throw new RuntimeException("val is infinite val");
        }
        System.out.printf("val %s \n", this.val);
        return this.val;
    }

    @Override
    public void reset() {
        this.val = 0;
        this.redoStack.clear();
        this.undoStack.clear();
        System.out.println("reset to 0 \n");
    }

    private void innerAdd(double a) {
        this.val += a;
        System.out.printf("add %s; res %s \n", a, this.val);
    }

    private void innerSubtract(double a) {
        this.val -= a;
        System.out.printf("subtract %s; res %s \n", a, this.val);
    }

    private void innerMultiply(double a) {
        this.val *= a;
        System.out.printf("multiply %s; res %s \n", a, this.val);
    }

    private void innerDivide(double a) {
        if (Objects.equals(a, 0.0)) {
            throw new ArithmeticException("divide by 0 error");
        }
        this.val /= a;
        System.out.printf("divide %s; res %s \n", a, this.val);

    }

    private void logUndo(Operation op, double a) {
        if (this.undoStack.size() > this.logLength) {
            StackPair remove = this.undoStack.remove(0);
            System.out.printf("reach logLength limit %s, remove older undo log %s \n", this.logLength, remove);
        }
        this.undoStack.push(new StackPair(op, a));
    }

    private void redoLog(StackPair undoLog) {
        this.redoStack.push(undoLog);
    }

}
