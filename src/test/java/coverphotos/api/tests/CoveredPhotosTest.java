package coverphotos.api.tests;

import com.fasterxml.jackson.databind.json.JsonMapper;
import coverphotos.api.tests.dto.CoverPhoto;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CoveredPhotosTest {
    String url = "https://fakerestapi.azurewebsites.net/api/v1";
    OkHttpClient client = new OkHttpClient();
    JsonMapper mapper = new JsonMapper();

    @Test
    public void getCoverPhotosReturnBookID1forFirstElement() {
        try {
            var endpoint = url + "/CoverPhotos";
            Request request = new Request.Builder()
                    .url(endpoint)
                    .get()
                    .build();
            try (Response response = client.newCall(request).execute()) {
                Assert.assertTrue(response.isSuccessful());
                var body = response.body().string();
                var jsonBody = new JSONArray(body);
                var bookId = jsonBody.getJSONObject(0).get("idBook");
                Assert.assertEquals(bookId, 1);
            }
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Test
    public void postNewItemIntoCoverPhotos() {
        try {
            var endpoint = url + "/CoverPhotos";
            var coverPhoto = new CoverPhoto();
            coverPhoto.setId(809);
            coverPhoto.setIdBook(990);
            coverPhoto.setUrl("https://placeholdit.imgix.net/~text?txtsize=33&txt=Book 990&w=250&h=350");
            var dtoData = mapper.writeValueAsString(coverPhoto);
            var requestBody = RequestBody.create(dtoData, MediaType.get("application/json"));
            Request request = new Request.Builder()
                    .url(endpoint)
                    .post(requestBody)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                Assert.assertTrue(response.isSuccessful());
                var body = response.body().string();
                var dto = mapper.readValue(body, CoverPhoto.class);
                Assert.assertEquals(dto.getId(), 809);
            }
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Test
    public void putItemIntoCoverPhotos() {
        try {
            var endpoint = url + "/CoverPhotos";
            var coverPhoto = new CoverPhoto();
            coverPhoto.setId(810);
            coverPhoto.setIdBook(991);
            coverPhoto.setUrl("https://placeholdit.imgix.net/~text?txtsize=33&txt=Book 990&w=250&h=350");
            var dtoCreate = mapper.writeValueAsString(coverPhoto);
            var requestBodyCreate = RequestBody.create(dtoCreate, MediaType.get("application/json"));

            Request request = new Request.Builder()
                    .url(endpoint)
                    .post(requestBodyCreate)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                Assert.assertTrue(response.isSuccessful());
            }
            coverPhoto.setIdBook(992);
            var dtoUpdate = mapper.writeValueAsString(coverPhoto);
            var requestUpdatedData = RequestBody.create(dtoUpdate, MediaType.get("application/json"));
            Request requestUpdate = new Request.Builder()
                    .url(endpoint + "/810")
                    .put(requestUpdatedData)
                    .build();

            try (Response response = client.newCall(requestUpdate).execute()) {
                Assert.assertTrue(response.isSuccessful());
                var body = response.body().string();
                var dto = mapper.readValue(body, CoverPhoto.class);
                Assert.assertEquals(dto.getIdBook(), 992);
            }
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Test
    public void deleteItemIntoCoverPhotos() {
        try {
            var endpoint = url + "/CoverPhotos";
            var coverPhoto = new CoverPhoto();
            coverPhoto.setId(810);
            coverPhoto.setIdBook(991);
            coverPhoto.setUrl("https://placeholdit.imgix.net/~text?txtsize=33&txt=Book 990&w=250&h=350");
            var dtoCreate = mapper.writeValueAsString(coverPhoto);
            var requestBodyCreate = RequestBody.create(dtoCreate, MediaType.get("application/json"));

            Request request = new Request.Builder()
                    .url(endpoint)
                    .post(requestBodyCreate)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                Assert.assertTrue(response.isSuccessful());
            }
            var dtoUpdate = mapper.writeValueAsString(coverPhoto);
            var deleteData = RequestBody.create(dtoUpdate, MediaType.get("application/json"));
            Request requestUpdate = new Request.Builder()
                    .url(endpoint + "/810")
                    .delete(deleteData)
                    .build();

            try (Response response = client.newCall(requestUpdate).execute()) {
                Assert.assertTrue(response.isSuccessful());
            }
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}

