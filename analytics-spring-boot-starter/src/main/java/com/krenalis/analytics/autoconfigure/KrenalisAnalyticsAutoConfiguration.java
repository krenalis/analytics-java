package com.krenalis.analytics.autoconfigure;

import com.krenalis.analytics.Analytics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring Boot autoconfiguration class for Krenalis Analytics.
 *
 * @author Christopher Smith
 */
@Configuration
@EnableConfigurationProperties(KrenalisProperties.class)
@ConditionalOnProperty("krenalis.analytics.writeKey")
public class KrenalisAnalyticsAutoConfiguration {

  @Autowired private KrenalisProperties properties;

  @Bean
  public Analytics krenalisAnalytics() {
    return Analytics.builder(properties.getWriteKey()).build();
  }
}
