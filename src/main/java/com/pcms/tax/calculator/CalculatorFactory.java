/**
 * Created on Sep 6, 2018, 6:06:32 PM
 *
 * Copyright(c) 2018 ShadowOfLies. All Rights Reserved.
 * The code from this class and all associated code, with the exception of third
 * party library code, is the proprietary information of ShadowOfLies.
 */
package com.pcms.tax.calculator;

import com.pcms.tax.data.Country;
import java.util.Objects;

/**
 * @version 1
 * @author Gavin Boshoff
 */
public class CalculatorFactory {

    public static IncomeTaxCalculator getIncomeTaxCalculator(Country country) {
        Objects.requireNonNull(country);

        switch (country) {
            case ZA:
            case UK:
                return initTieredCalculator();
            default:
                // Alternatively we could raise an error, but
                return new DummyIncomeTaxCalculator();
        }
    }

    private static TieredIncomeTaxCalculator initTieredCalculator() {
        TieredIncomeTaxCalculator calculator;

        calculator = TieredIncomeTaxCalculator.getInstance();
        calculator.initialize();

        return calculator;
    }

    // Private constructor prevents instantiation of factory class
    private CalculatorFactory() {}
}