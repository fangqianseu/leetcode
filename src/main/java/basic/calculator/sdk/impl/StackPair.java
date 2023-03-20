package basic.calculator.sdk.impl;

/**
 * @author qianfang, at 2023/3/20, 00:00
 **/
public class StackPair {
    private Operation op;
    private Double val;

    public StackPair() {
    }

    public StackPair(Operation op, Double val) {
        this.op = op;
        this.val = val;
    }

    public Operation getOp() {
        return op;
    }

    public void setOp(Operation op) {
        this.op = op;
    }

    public Double getVal() {
        return val;
    }

    public void setVal(Double val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "StackPair{" + "op=" + op + ", val=" + val + '}';
    }
}
