/**
 * Created on Sep 5, 2018, 8:33:45 PM
 *
 * Copyright(c) 2018 ShadowOfLies. All Rights Reserved.
 * The code from this class and all associated code, with the exception of third
 * party library code, is the proprietary information of ShadowOfLies.
 */
package com.pcms.tax.service;

import com.pcms.tax.data.Income;
import com.pcms.tax.data.TaxBreakdown;

/**
 * @version 1
 * @author Gavin Boshoff
 */
public interface IIncomeTaxService {

    TaxBreakdown calculate(Income income);
}