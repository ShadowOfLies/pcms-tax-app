/**
 * Created on Sep 6, 2018, 10:28:24 PM
 *
 * Copyright(c) 2018 ShadowOfLies. All Rights Reserved.
 * The code from this class and all associated code, with the exception of third
 * party library code, is the proprietary information of ShadowOfLies.
 */
package com.pcms.tax.repo.data;

import com.pcms.tax.data.Country;
import java.util.Objects;
import javax.persistence.Entity;

/**
 * @version 1
 * @author Gavin Boshoff
 */
@Entity
public class TierConfiguration {

    private Country country;
    private int bandLowerBound;
    private Integer bandUpperBound;
    private int bandPercenta;

    public TierConfiguration() {
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public int getBandLowerBound() {
        return bandLowerBound;
    }

    public void setBandLowerBound(int bandLowerBound) {
        this.bandLowerBound = bandLowerBound;
    }

    public Integer getBandUpperBound() {
        return bandUpperBound;
    }

    public void setBandUpperBound(Integer bandUpperBound) {
        this.bandUpperBound = bandUpperBound;
    }

    public int getBandPercenta() {
        return bandPercenta;
    }

    public void setBandPercenta(int bandPercenta) {
        this.bandPercenta = bandPercenta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.country);
        hash = 71 * hash + this.bandLowerBound;
        hash = 71 * hash + Objects.hashCode(this.bandUpperBound);
        hash = 71 * hash + this.bandPercenta;
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

        final TierConfiguration other = (TierConfiguration) obj;
        if (this.bandLowerBound != other.bandLowerBound) {
            return false;
        }
        if (this.bandPercenta != other.bandPercenta) {
            return false;
        }
        if (this.country != other.country) {
            return false;
        }
        return Objects.equals(this.bandUpperBound, other.bandUpperBound);
    }

    @Override
    public String toString() {
        StringBuilder toStringBuilder;

        toStringBuilder = new StringBuilder("TierConfiguration{");
        toStringBuilder.append("country=").append(this.country);
        toStringBuilder.append(",bandLowerBound=").append(this.bandLowerBound);
        toStringBuilder.append(",bandUpperBound=").append(this.bandUpperBound);
        toStringBuilder.append(",bandPercenta=").append(this.bandPercenta);
        toStringBuilder.append('}');

        return toStringBuilder.toString();
    }
}
