package sample;

import com.krenalis.analytics.Analytics;
import com.krenalis.analytics.messages.TrackMessage;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

public class Main {
  // Use your write key and endpoint.
  private static final String WRITE_KEY = "";
  private static final String ENDPOINT = "";

  public static void main(String... args) throws Exception {
    final BlockingFlush blockingFlush = BlockingFlush.create();

    final Analytics analytics =
        Analytics.builder(WRITE_KEY)
            .endpoint(ENDPOINT)
            .plugin(blockingFlush.plugin())
            .plugin(new LoggingPlugin())
            .client(createClient())
            .build();

    final String userId = System.getProperty("user.name");
    final String anonymousId = UUID.randomUUID().toString();

    Map<String, Object> properties = new LinkedHashMap<>();
    properties.put("foo", "bar");
    analytics.enqueue(
        TrackMessage.builder("Java Test")
            .properties(properties)
            .anonymousId(anonymousId)
            .userId(userId));

    analytics.flush();
    blockingFlush.block();
    analytics.shutdown();
  }

  /**
   * By default, the analytics client uses an HTTP client with sane defaults. However you can
   * customize the client to your needs. For instance, this client is configured to automatically
   * gzip outgoing requests.
   */
  private static OkHttpClient createClient() {
    return new OkHttpClient.Builder()
        .connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(15, TimeUnit.SECONDS)
        .writeTimeout(15, TimeUnit.SECONDS)
        .addInterceptor(new GzipRequestInterceptor())
        .build();
  }
}
