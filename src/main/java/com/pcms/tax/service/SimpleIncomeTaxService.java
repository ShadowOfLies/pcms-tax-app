/**
 * Created on Sep 05, 2018, 8:28:48 PM
 *
 * Copyright(c) 2018 ShadowOfLies. All Rights Reserved.
 * The code from this class and all associated code, with the exception of third
 * party library code, is the proprietary information of ShadowOfLies.
 */
package com.pcms.tax.service;

import com.pcms.tax.calculator.CalculatorFactory;
import com.pcms.tax.calculator.IncomeTaxCalculator;
import com.pcms.tax.data.Income;
import com.pcms.tax.data.TaxBreakdown;
import org.springframework.stereotype.Service;

/**
 * @version 1
 * @author Gavin Boshoff
 */
@Service
public class SimpleIncomeTaxService implements IIncomeTaxService {

    public SimpleIncomeTaxService() {}

    @Override
    public TaxBreakdown calculate(Income income) {
        IncomeTaxCalculator incomeTaxCalculator;

        incomeTaxCalculator = CalculatorFactory.getIncomeTaxCalculator(income.getCountry());

        switch (income.getPeriod()) {
            case ANNUALLY:
                return incomeTaxCalculator.calculateByAnnualIncome(income.getCountry(), income.getIncomeAmount());
            case MONTHLY:
                return incomeTaxCalculator.calculateByMonthlyIncome(income.getCountry(), income.getIncomeAmount());
            default:
                throw new IllegalArgumentException("Period not supported");
        }
    }
}