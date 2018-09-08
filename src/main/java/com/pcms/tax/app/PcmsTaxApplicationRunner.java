/**
 * Created on Sep 05, 2018, 8:28:48 PM
 *
 * Copyright(c) 2018 ShadowOfLies. All Rights Reserved.
 * The code from this class and all associated code, with the exception of third
 * party library code, is the proprietary information of ShadowOfLies.
 */
package com.pcms.tax.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @version 1
 * @author Gavin Boshoff
 */
@SpringBootApplication(scanBasePackages = {"com.pcms"})
@EnableJpaRepositories("com.pcms")
@EntityScan("com.pcms")
public class PcmsTaxApplicationRunner {

}