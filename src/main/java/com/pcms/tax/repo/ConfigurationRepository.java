/**
 * Created on Sep 6, 2018, 8:51:42 PM
 *
 * Copyright(c) 2018 ShadowOfLies. All Rights Reserved.
 * The code from this class and all associated code, with the exception of third
 * party library code, is the proprietary information of ShadowOfLies.
 */
package com.pcms.tax.repo;

import com.pcms.tax.repo.data.TierConfiguration;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @version 1
 * @author Gavin Boshoff
 */
@Repository
public interface ConfigurationRepository extends CrudRepository<TierConfiguration, String> {

    @Override
    public List<TierConfiguration> findAll();
}