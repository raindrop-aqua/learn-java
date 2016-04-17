package com.practice.calc.server;

import com.practice.calc.thrift.Calc;
import org.apache.thrift.TException;

public class CalcHandler implements Calc.Iface {
    @Override
    public int add(int op1, int op2) throws TException {
        return op1 + op2;
    }
}
