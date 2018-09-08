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
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @version 1
 * @author Gavin Boshoff
 */
public class TieredIncomeTaxCalculator implements IncomeTaxCalculator {

    private static final BigDecimal BIG_100 = BigDecimal.valueOf(100L);

    static TieredIncomeTaxCalculator getInstance() {
        return TieredIncomeTaxCalculatorHolder.INSTANCE;
    }

    private final Map<Country, ArrayList<TaxTier>> tierConfiguration;

    private boolean initialized = false;

    private TieredIncomeTaxCalculator() {
        this.tierConfiguration = new HashMap<>();
    }

    @Override
    public void initialize() {
        if (this.initialized) {
            return;
        }

        ConfigurationRepository configRepo;

        configRepo = SpringSingularity.getSingletonBean(ConfigurationRepository.class);
        configRepo.findAll().forEach(this::addTier);

        this.initialized = true;
    }

    @Override
    public TaxBreakdown calculateByAnnualIncome(Country country, BigDecimal annualIncome) {
        checkInitialized();

        TaxBreakdown taxBreakdown;
        BigDecimal totalTax;

        taxBreakdown = new TaxBreakdown();
        taxBreakdown.setGrossAnnual(annualIncome);
        taxBreakdown.setGrossMonthly(annualIncome
                .divide(BigDecimal.valueOf(12L), 2, RoundingMode.HALF_DOWN));

        totalTax = BigDecimal.ZERO;
        for (TaxTier taxTier : this.tierConfiguration.get(country)) {
            if (annualIncome.compareTo(taxTier.getUpperBound()) > 0) {
                totalTax = totalTax.add(taxTier.getFullBracket());
            } else {
                totalTax = totalTax.add(
                        annualIncome.subtract(taxTier.getLowerBound())
                                .multiply(taxTier.getPercentage()
                                        .divide(BIG_100)));
                break;
            }
        }
        taxBreakdown.setAnnualTaxPaid(totalTax);
        taxBreakdown.setMonthlyTaxPaid(totalTax
                .divide(BigDecimal.valueOf(12L), 2, RoundingMode.HALF_DOWN));
        taxBreakdown.setNetAnnual(taxBreakdown.getGrossAnnual()
                .subtract(taxBreakdown.getAnnualTaxPaid()));
        taxBreakdown.setNetMonthly(taxBreakdown.getNetAnnual()
                .divide(BigDecimal.valueOf(12L), 2, RoundingMode.HALF_DOWN));

        return taxBreakdown;
    }

    @Override
    public TaxBreakdown calculateByMonthlyIncome(Country country, BigDecimal monthlyIncome) {
        return calculateByAnnualIncome(country, monthlyIncome.multiply(BigDecimal.valueOf(12L)));
    }

    private void checkInitialized() {
        if (!this.initialized) {
            throw new IllegalStateException("Calculator has not been initialized.");
        }
    }

    private void addTier(TierConfiguration tierConfig) {
        ArrayList<TaxTier> tierList;
        Country country;
        TaxTier tier;

        country = Country.valueOf(tierConfig.getId().getCountry());

        tierList = this.tierConfiguration
                .computeIfAbsent(country, c -> new ArrayList<>());

        tier = new TaxTier();
        tier.setLowerBound(
                BigDecimal.valueOf(tierConfig.getId().getBandLowerBound()));
        tier.setUpperBound(tierConfig.getBandUpperBound() == null
                ? BigDecimal.valueOf(Integer.MAX_VALUE)
                : BigDecimal.valueOf(tierConfig.getBandUpperBound()));
        tier.setPercentage(BigDecimal.valueOf(tierConfig.getBandPercentage()));

        tier.setFullBracket(
                tier.getUpperBound()
                        .subtract(tier.getLowerBound())
                .multiply(tier.getPercentage()
                        .divide(BIG_100))
        );

        tierList.add(tier);
    }

    private static class TaxTier {

        private BigDecimal fullBracket;
        private BigDecimal upperBound;
        private BigDecimal lowerBound;
        private BigDecimal percentage;

        private TaxTier() {}

        public BigDecimal getLowerBound() {
            return lowerBound;
        }

        public void setLowerBound(BigDecimal lowerBound) {
            this.lowerBound = lowerBound;
        }

        public BigDecimal getUpperBound() {
            return upperBound;
        }

        public void setUpperBound(BigDecimal upperBound) {
            this.upperBound = upperBound;
        }

        public BigDecimal getPercentage() {
            return percentage;
        }

        public void setPercentage(BigDecimal percentage) {
            this.percentage = percentage;
        }

        public BigDecimal getFullBracket() {
            return fullBracket;
        }

        public void setFullBracket(BigDecimal fullBracket) {
            this.fullBracket = fullBracket;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 59 * hash + Objects.hash(this.lowerBound);
            hash = 59 * hash + Objects.hash(this.upperBound);
            hash = 59 * hash + Objects.hash(this.percentage);
            hash = 59 * hash + Objects.hash(this.fullBracket);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }

            final TaxTier other = (TaxTier) obj;
            if (!Objects.equals(this.lowerBound, other.lowerBound)) {
                return false;
            }
            if (!Objects.equals(this.upperBound, other.upperBound)) {
                return false;
            }
            if (!Objects.equals(this.fullBracket, other.upperBound)) {
                return false;
            }
            return Objects.equals(this.percentage, other.percentage);
        }

        @Override
        public String toString() {
            StringBuilder toStringBuilder;

            toStringBuilder = new StringBuilder("TaxTier{");
            toStringBuilder.append("lowerBound=").append(this.lowerBound);
            toStringBuilder.append(",upperBound=").append(this.upperBound);
            toStringBuilder.append(",perentage=").append(this.percentage);
            toStringBuilder.append(",fullBracket=").append(this.fullBracket);
            toStringBuilder.append('}');

            return toStringBuilder.toString();
        }
    }

    private static final class TieredIncomeTaxCalculatorHolder {
        private static final TieredIncomeTaxCalculator INSTANCE = new TieredIncomeTaxCalculator();
        private TieredIncomeTaxCalculatorHolder() {}
    }
}