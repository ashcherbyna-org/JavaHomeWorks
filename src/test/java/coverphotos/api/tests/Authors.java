package coverphotos.api.tests;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class Authors {
    String url = "https://fakerestapi.azurewebsites.net/api/v1";
    OkHttpClient client = new OkHttpClient();


    @Test
    public void getAuthors() {
        try {
            var endpoint = url + "/Authors";
            Request request = new Request.Builder()
                    .url(endpoint)
                    .get()
                    .build();

            try (Response response = client.newCall(request).execute()) {
                Assert.assertEquals(response.code(), 200);

                var body = response.body().string();
                var jsonBody = new JSONArray(body);
                var firstName = jsonBody.getJSONObject(0).getString("firstName");
                Assert.assertEquals(firstName, "First Name 1");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            Assert.fail("Test failed with exception: " + e.getMessage());
        }
    }

    @Test
    public void deleteAuthors() throws IOException {
        int authorIdToDelete = 1;
        var endpoint = url + "/Authors/" + authorIdToDelete;
        Request request = new Request.Builder()
                .url(endpoint)
                .delete()
                .build();
        try (Response response = client.newCall(request).execute()) {
            Assert.assertEquals(response.code(), 200);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


