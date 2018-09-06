/**
 * Created on Sep 6, 2018, 7:09:24 PM
 *
 * Copyright(c) 2018 ShadowOfLies. All Rights Reserved.
 * The code from this class and all associated code, with the exception of third
 * party library code, is the proprietary information of ShadowOfLies.
 */
package com.pcms.tax.calculator;

import com.pcms.component.SpringSingularity;
import com.pcms.tax.data.Country;
import com.pcms.tax.data.TaxBreakdown;
import com.pcms.tax.repo.ConfigurationRepository;
import com.pcms.tax.repo.data.TierConfiguration;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @version 1
 * @author Gavin Boshoff
 */
public class TieredIncomeTaxCalculator implements IncomeTaxCalculator {

    static TieredIncomeTaxCalculator getInstance() {
        return TieredIncomeTaxCalculatorHolder.INSTANCE;
    }

    private final Map<Country, TaxTiers> tierConfiguration;

    private boolean initialized = false;

    public TieredIncomeTaxCalculator() {
        this.tierConfiguration = new HashMap<>();
    }

    @Override
    public void initialize() {
        if (this.initialized) {
            throw new IllegalStateException("Cannot call initialize when already initialized.");
        }

        ConfigurationRepository configRepo;

        configRepo = SpringSingularity.getSingletonBean(ConfigurationRepository.class);

        for (TierConfiguration tierConfig : configRepo.findAll()) {
            // TODO: GBO - Add mapping to populate the tierConfiguration map using the
            // data entries retrieved from the repository
        }

        this.initialized = true;
    }

    @Override
    public TaxBreakdown calculateByAnnualIncome(Country country, BigDecimal annualIncome) {
        checkInitialized();
        throw new UnsupportedOperationException();
    }

    @Override
    public TaxBreakdown calculateByMonthlyIncome(Country country, BigDecimal monthlyIncome) {
        checkInitialized();
        throw new UnsupportedOperationException();
    }

    private void checkInitialized() {
        if (!this.initialized) {
            throw new IllegalStateException("Calculator has not been initialized.");
        }
    }

    private static class TaxTiers extends ArrayList<TaxTier> {

    }

    private static class TaxTier {

    }

    private static final class TieredIncomeTaxCalculatorHolder {
        private static final TieredIncomeTaxCalculator INSTANCE = new TieredIncomeTaxCalculator();
        private TieredIncomeTaxCalculatorHolder() {}
    }
}