package pro.sky.mk2homework4calculator;

import org.springframework.stereotype.Service;

@Service
public class CalcService {

    public double plus (double numA, double numB) {
        return numA + numB;
    }

    public double minus (double numA, double numB) {
        return numA - numB;
    }

    public double multiply (double numA, double numB) {
        return numA * numB;
    }

    public double divide (double numA, double numB) {
        return numA / numB;
    }
}
