package com.krenalis.analytics.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Configuration properties for the Krenalis Analytics client. Since the client only supports writes
 * at this point, the write key is the only (and required) property.
 *
 * @author Christopher Smith
 */
@ConfigurationProperties("krenalis.analytics")
public class KrenalisProperties {

  private String writeKey;

  public String getWriteKey() {
    return writeKey;
  }

  public void setWriteKey(String writeKey) {
    this.writeKey = writeKey;
  }
}
