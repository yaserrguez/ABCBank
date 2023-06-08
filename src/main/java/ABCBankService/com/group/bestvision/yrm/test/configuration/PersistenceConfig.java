
/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/8/23, 1:04 PM
 *
 */

package ABCBankService.com.group.bestvision.yrm.test.configuration;

import ABCBankService.com.group.bestvision.yrm.test.component.AuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class PersistenceConfig
{
    @Bean
    public AuditorAware<String> auditorAware()
    {
        return new AuditorAwareImpl();
    }
}
