/**
 * Created on Sep 6, 2018, 6:15:49 PM
 *
 * Copyright(c) 2018 ShadowOfLies. All Rights Reserved.
 * The code from this class and all associated code, with the exception of third
 * party library code, is the proprietary information of ShadowOfLies.
 */
package com.pcms.tax.data;

import java.math.BigDecimal;
import java.util.Objects;
import javax.validation.constraints.NotNull;

/**
 * @version 1
 * @author Gavin Boshoff
 */
public class TaxBreakdown {

    @NotNull
    private BigDecimal monthlyTaxPaid;
    @NotNull
    private BigDecimal annualTaxPaid;
    @NotNull
    private BigDecimal grossMonthly;
    @NotNull
    private BigDecimal grossAnnual;
    @NotNull
    private BigDecimal netMonthly;
    @NotNull
    private BigDecimal netAnnual;

    public TaxBreakdown() {
    }

    public BigDecimal getMonthlyTaxPaid() {
        return monthlyTaxPaid;
    }

    public void setMonthlyTaxPaid(BigDecimal monthlyTaxPaid) {
        this.monthlyTaxPaid = monthlyTaxPaid;
    }

    public BigDecimal getAnnualTaxPaid() {
        return annualTaxPaid;
    }

    public void setAnnualTaxPaid(BigDecimal annualTaxPaid) {
        this.annualTaxPaid = annualTaxPaid;
    }

    public BigDecimal getGrossMonthly() {
        return grossMonthly;
    }

    public void setGrossMonthly(BigDecimal grossMonthly) {
        this.grossMonthly = grossMonthly;
    }

    public BigDecimal getGrossAnnual() {
        return grossAnnual;
    }

    public void setGrossAnnual(BigDecimal grossAnnual) {
        this.grossAnnual = grossAnnual;
    }

    public BigDecimal getNetMonthly() {
        return netMonthly;
    }

    public void setNetMonthly(BigDecimal netMonthly) {
        this.netMonthly = netMonthly;
    }

    public BigDecimal getNetAnnual() {
        return netAnnual;
    }

    public void setNetAnnual(BigDecimal netAnnual) {
        this.netAnnual = netAnnual;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.monthlyTaxPaid);
        hash = 89 * hash + Objects.hashCode(this.annualTaxPaid);
        hash = 89 * hash + Objects.hashCode(this.grossMonthly);
        hash = 89 * hash + Objects.hashCode(this.grossAnnual);
        hash = 89 * hash + Objects.hashCode(this.netMonthly);
        hash = 89 * hash + Objects.hashCode(this.netAnnual);
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

        final TaxBreakdown other = (TaxBreakdown) obj;
        if (!Objects.equals(this.monthlyTaxPaid, other.monthlyTaxPaid)) {
            return false;
        }
        if (!Objects.equals(this.annualTaxPaid, other.annualTaxPaid)) {
            return false;
        }
        if (!Objects.equals(this.grossMonthly, other.grossMonthly)) {
            return false;
        }
        if (!Objects.equals(this.grossAnnual, other.grossAnnual)) {
            return false;
        }
        if (!Objects.equals(this.netMonthly, other.netMonthly)) {
            return false;
        }
        return Objects.equals(this.netAnnual, other.netAnnual);
    }

    @Override
    public String toString() {
        StringBuilder toStringBuilder;

        toStringBuilder = new StringBuilder("TaxBreakdown{");
        toStringBuilder.append("monthlyTaxPaid=").append(this.monthlyTaxPaid);
        toStringBuilder.append(",annualTaxPaid=").append(this.annualTaxPaid);
        toStringBuilder.append(",grossMonthly=").append(this.grossMonthly);
        toStringBuilder.append(",grossAnnual=").append(this.grossAnnual);
        toStringBuilder.append(",netMonthly=").append(this.netMonthly);
        toStringBuilder.append(",netAnnual=").append(this.netAnnual);
        toStringBuilder.append('}');

        return toStringBuilder.toString();
    }
}