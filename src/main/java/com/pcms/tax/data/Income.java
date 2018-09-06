/**
 * Created on Sep 6, 2018, 6:15:36 PM
 *
 * Copyright(c) 2018 ShadowOfLies. All Rights Reserved.
 * The code from this class and all associated code, with the exception of third
 * party library code, is the proprietary information of ShadowOfLies.
 */
package com.pcms.tax.data;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @version 1
 * @author Gavin Boshoff
 */
public class Income {

    private BigDecimal incomeAmount;
    private Country country;
    private Period period;

    public Income() {
    }

    public Income(BigDecimal incomeAmount, Country country, Period period) {
        this.incomeAmount = incomeAmount;
        this.country = country;
        this.period = period;
    }

    public BigDecimal getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(BigDecimal incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.incomeAmount);
        hash = 97 * hash + Objects.hashCode(this.country);
        hash = 97 * hash + Objects.hashCode(this.period);
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
        final Income other = (Income) obj;
        if (!Objects.equals(this.incomeAmount, other.incomeAmount)) {
            return false;
        }
        if (this.country != other.country) {
            return false;
        }
        return this.period == other.period;
    }

    @Override
    public String toString() {
        StringBuilder toStringBuilder;

        toStringBuilder = new StringBuilder("Income{");
        toStringBuilder.append("incomeAmount=").append(this.incomeAmount);
        toStringBuilder.append(",country=").append(this.country);
        toStringBuilder.append(",period=").append(this.period);
        toStringBuilder.append('}');

        return toStringBuilder.toString();
    }
}