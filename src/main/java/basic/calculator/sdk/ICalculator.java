package basic.calculator.sdk;

/**
 * @author qianfang, at 2023/3/19, 23:27
 **/
public interface ICalculator {
    /**
     * 计算器类初始化
     *
     * @param a 设置的初始的值
     * @return
     */
    ICalculator init(double a);

    /**
     * 加上一个数a
     *
     * @param a
     * @return
     */
    ICalculator add(double a);

    /**
     * 减去一个数a
     *
     * @param a
     * @return
     */
    ICalculator subtract(double a);

    /**
     * 乘上一个数a
     *
     * @param a
     * @return
     */
    ICalculator multiply(double a);

    /**
     * 除以一个数a
     * 如果a为0 抛出异常
     *
     * @param a
     * @return
     */
    ICalculator divide(double a);

    /**
     * 取消上一步操作
     *
     * @return
     */
    ICalculator undo();

    /**
     * 重做上一次undo的操作
     *
     * @return
     */
    ICalculator redo();

    /**
     * 返回计算器的计算结果
     *
     * @return
     */
    double getVal();

    /**
     * 重置计算器状态
     */
    void reset();
}
