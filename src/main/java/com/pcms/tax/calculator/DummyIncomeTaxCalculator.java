/**
 * Created on Sep 6, 2018, 10:15:37 PM
 *
 * Copyright(c) 2018 ShadowOfLies. All Rights Reserved.
 * The code from this class and all associated code, with the exception of third
 * party library code, is the proprietary information of ShadowOfLies.
 */
package com.pcms.tax.calculator;

import com.pcms.tax.data.Country;
import com.pcms.tax.data.TaxBreakdown;
import java.math.BigDecimal;

/**
 * @version 1
 * @author Gavin Boshoff
 */
public class DummyIncomeTaxCalculator implements IncomeTaxCalculator {

    private static final TaxBreakdown DUMMY_BREAKDOWN;

    static {
        DUMMY_BREAKDOWN = new TaxBreakdown();
        DUMMY_BREAKDOWN.setGrossAnnual(BigDecimal.ZERO);
        DUMMY_BREAKDOWN.setGrossMonthly(BigDecimal.ZERO);
        DUMMY_BREAKDOWN.setNetAnnual(BigDecimal.ZERO);
        DUMMY_BREAKDOWN.setNetMonthly(BigDecimal.ZERO);
        DUMMY_BREAKDOWN.setAnnualTaxPaid(BigDecimal.ZERO);
        DUMMY_BREAKDOWN.setMonthlyTaxPaid(BigDecimal.ZERO);
    }

    public DummyIncomeTaxCalculator() {}

    @Override
    public void initialize() {
        // No initialization required
    }

    @Override
    public TaxBreakdown calculateByAnnualIncome(Country country, BigDecimal annualIncome) {
        return DUMMY_BREAKDOWN;
    }

    @Override
    public TaxBreakdown calculateByMonthlyIncome(Country country, BigDecimal monthlyIncome) {
        return DUMMY_BREAKDOWN;
    }
}