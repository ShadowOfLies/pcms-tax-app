/**
 * Created on Sep 9, 2018, 7:46:05 AM
 *
 * Copyright(c) 2018 ShadowOfLies. All Rights Reserved.
 * The code from this class and all associated code, with the exception of third
 * party library code, is the proprietary information of ShadowOfLies.
 */
package com.pcms.tax.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.pcms.tax.app.PcmsTaxApplicationRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @version 1
 * @author Gavin Boshoff
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PcmsTaxApplicationRunner.class)
@AutoConfigureMockMvc
public class IncomeTaxControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnRepositoryIndex() throws Exception {

        mockMvc.perform(
                get("/api/ZA/income-tax/ANNUALLY?income=10000")
                        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.grossAnnual").exists())
                .andExpect(jsonPath("$.grossMonthly").exists())
                .andExpect(jsonPath("$.netAnnual").exists())
                .andExpect(jsonPath("$.netMonthly").exists())
                .andExpect(jsonPath("$.annualTaxPaid").exists())
                .andExpect(jsonPath("$.monthlyTaxPaid").exists());
    }
}
