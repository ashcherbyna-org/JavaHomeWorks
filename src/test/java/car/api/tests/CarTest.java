package car.api.tests;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;

public class CarTest {

    private OkHttpClient client = new OkHttpClient.Builder().build();
   private WireMockServer wireMockServer = new WireMockServer(new WireMockConfiguration().port(port));
   private static int port = 993;

    @BeforeClass
    public void beforeClass() {
        wireMockServer.start();
        WireMock.configureFor("localhost", port);
        WireMock.stubFor(
                WireMock.get(WireMock.urlEqualTo("/get-cars"))
                        .withHeader("content-type", WireMock.containing("text/html"))
                        .willReturn(WireMock.aResponse()
                                .withStatus(561)
                                .withFixedDelay(3606)));
    }

    @Test
    public void getCars() {
        try {
            var endpoint = "http://localhost:" + port +"/get-cars";
            Request request = new Request.Builder()
                    .url(endpoint)
                    .get()
                    .addHeader("content-type", "text/html")
                    .build();
            try (Response response = client.newCall(request).execute()) {
                Assert.assertEquals(response.code(), 561);
                var responseStart = response.sentRequestAtMillis();
                var responseEnd = response.receivedResponseAtMillis();
                var timeDuration = responseEnd - responseStart;
                Assert.assertEquals(timeDuration, 3606, 50);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    public void afterClass() {
        wireMockServer.stop();
    }
}
