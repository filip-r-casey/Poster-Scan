/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package poster.scan;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void testCollectImages() {
        App app = new App();
        app.collectImages(10);
    }

    @Test
    public void testProcessImages() throws IOException {
        App app = new App();
        app.processImages();
    }

    @Test
    public void testPostAPI() throws JsonProcessingException {
        JSONObject venue = new JSONObject()
                .put("website", "")
                .put("address", "3632 Morrison Road")
                .put("db_name", "d3_arts")
                .put("address_protected", false)
                .put("stylized_name", "D3 Arts");

        JSONArray bands = new JSONArray()
                .put(new JSONObject()
                        .put("website", "jazzmorillo.com")
                        .put("is_active", true)
                        .put("db_name", "jazz_morillo")
                        .put("genre", "")
                        .put("twitter_username", "@jazzmorillo")
                        .put("music_link", "spotify.com/jazz_morillo")
                        .put("tiktok_username", "@jazzmorillo")
                        .put("biography", "Jazz morillo is a great singer, how awesome")
                        .put("instagram_username", "@jazzmorillo")
                        .put("stylized_name", "Jazz Morillo")
                        .put("contact_email", "jazzmorillo@gmail.com"))
                .put(new JSONObject()
                        .put("website", "")
                        .put("is_active", true)
                        .put("db_name", "alex_fernandez")
                        .put("genre", "")
                        .put("twitter_username", "")
                        .put("music_link", "")
                        .put("tiktok_username", "")
                        .put("biography", "")
                        .put("instagram_username", "")
                        .put("stylized_name", "Alex Fernandez")
                        .put("contact_email", ""));

        JSONObject event = new JSONObject()
                .put("date", "2023-10-25")
                .put("venue", venue)
                .put("cost", "0.00")
                .put("doors_time", "17:00:00")
                .put("show_start_time", "17:00:00")
                .put("age_requirement", 0)
                .put("description", "Second Annual Fundraiser")
                .put("title", "")
                .put("bands", bands);
        List<JSONObject> event_list = new ArrayList<>();
        event_list.add(event);
        App app = new App();
        app.apiPost(event_list);
    }
}
