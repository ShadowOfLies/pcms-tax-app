/**
 * Created on Sep 6, 2018, 7:07:11 PM
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
public interface IncomeTaxCalculator {

    void initialize();

    TaxBreakdown calculateByAnnualIncome(Country country, BigDecimal annualIncome);

    TaxBreakdown calculateByMonthlyIncome(Country country, BigDecimal monthlyIncome);
}