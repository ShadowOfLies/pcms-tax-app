/**
 * Created on Sep 05, 2018, 8:28:48 PM
 *
 * Copyright(c) 2018 ShadowOfLies. All Rights Reserved.
 * The code from this class and all associated code, with the exception of third
 * party library code, is the proprietary information of ShadowOfLies.
 */
package com.pcms.tax.service;

import com.pcms.tax.data.Income;
import com.pcms.tax.data.TaxBreakdown;
import org.springframework.stereotype.Service;

/**
 * @version 4
 * @author Gavin Boshoff
 */
@Service
public class SimpleIncomeTaxService implements IIncomeTaxService {

    public SimpleIncomeTaxService() {}

    @Override
    public TaxBreakdown calculate(Income income) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}