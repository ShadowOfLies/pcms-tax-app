/**
 * Created on Sep 8, 2018, 6:42:47 PM
 *
 * Copyright(c) 2018 ShadowOfLies. All Rights Reserved.
 * The code from this class and all associated code, with the exception of third
 * party library code, is the proprietary information of ShadowOfLies.
 */
package com.pcms.tax.repo.data;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

/**
 * @version 1
 * @author Gavin Boshoff
 */
@Embeddable
public class TierConfigId implements Serializable {

    private static final long serialVersionUID = -8584104394717946256L;

    @Column(name = "country")
    @Size(max = 20)
    private String country;

    @Column(name = "band_lower_bound")
    private int bandLowerBound;

    public TierConfigId() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getBandLowerBound() {
        return bandLowerBound;
    }

    public void setBandLowerBound(int bandLowerBound) {
        this.bandLowerBound = bandLowerBound;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.country);
        hash = 97 * hash + this.bandLowerBound;
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
        final TierConfigId other = (TierConfigId) obj;
        if (this.bandLowerBound != other.bandLowerBound) {
            return false;
        }
        return Objects.equals(this.country, other.country);
    }

    @Override
    public String toString() {
        StringBuilder toStringBuilder;

        toStringBuilder = new StringBuilder("TierConfigId{");
        toStringBuilder.append("country=").append(this.country);
        toStringBuilder.append(",bandLowerBound=").append(this.bandLowerBound);
        toStringBuilder.append('}');

        return toStringBuilder.toString();
    }
}