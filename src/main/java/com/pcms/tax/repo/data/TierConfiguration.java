/**
 * Created on Sep 6, 2018, 10:28:24 PM
 *
 * Copyright(c) 2018 ShadowOfLies. All Rights Reserved.
 * The code from this class and all associated code, with the exception of third
 * party library code, is the proprietary information of ShadowOfLies.
 */
package com.pcms.tax.repo.data;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @version 1
 * @author Gavin Boshoff
 */
@Entity
@Table(name = "tier_configuration")
public class TierConfiguration implements Serializable {

    private static final long serialVersionUID = -4176572555629121769L;

    @EmbeddedId
    private TierConfigId id;
    @Column(name = "band_upper_bound")
    private Integer bandUpperBound;
    @Column(name = "band_percentage")
    private int bandPercentage;

    public TierConfiguration() {
    }

    public TierConfigId getId() {
        return id;
    }

    public void setId(TierConfigId id) {
        this.id = id;
    }

    public Integer getBandUpperBound() {
        return bandUpperBound;
    }

    public void setBandUpperBound(Integer bandUpperBound) {
        this.bandUpperBound = bandUpperBound;
    }

    public int getBandPercentage() {
        return bandPercentage;
    }

    public void setBandPercentage(int bandPercentage) {
        this.bandPercentage = bandPercentage;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.bandUpperBound);
        hash = 71 * hash + this.bandPercentage;
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
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.bandPercentage != other.bandPercentage) {
            return false;
        }
        return Objects.equals(this.bandUpperBound, other.bandUpperBound);
    }

    @Override
    public String toString() {
        StringBuilder toStringBuilder;

        toStringBuilder = new StringBuilder("TierConfiguration{");
        toStringBuilder.append("id=").append(this.id);
        toStringBuilder.append(",bandUpperBound=").append(this.bandUpperBound);
        toStringBuilder.append(",bandPercentage=").append(this.bandPercentage);
        toStringBuilder.append('}');

        return toStringBuilder.toString();
    }
}
