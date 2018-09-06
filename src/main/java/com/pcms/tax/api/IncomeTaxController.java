/**
 * Created on Sep 05, 2018, 8:28:48 PM
 *
 * Copyright(c) 2018 ShadowOfLies. All Rights Reserved.
 * The code from this class and all associated code, with the exception of third
 * party library code, is the proprietary information of ShadowOfLies.
 */
package com.pcms.tax.api;

import com.pcms.tax.data.Country;
import com.pcms.tax.data.Income;
import com.pcms.tax.data.Period;
import com.pcms.tax.data.TaxBreakdown;
import com.pcms.tax.service.IIncomeTaxService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 4
 * @author Gavin Boshoff
 */
@CrossOrigin(
        allowedHeaders = {"content-type"},
        origins = {"*"}, // TODO: GBO -  Restrict origins
        methods = {RequestMethod.GET})
@RestController
@RequestMapping(path = "/api/{country}/income-tax",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class IncomeTaxController {

    @Autowired
    private IIncomeTaxService incomeTaxService;

    @GetMapping("/{period}")
    public TaxBreakdown calculatePerAnnum(
            @PathVariable("country") Country country,
            @PathVariable("period") Period period,
            @RequestParam("income") BigDecimal incomeAmount) {

        // In this case, out controller definition already completes all of our
        // validation and will raise a bad request if necessary. In the future
        // this could be changed if we require improved feedback

        return this.incomeTaxService
                .calculate(new Income(incomeAmount, country, period));
    }
}