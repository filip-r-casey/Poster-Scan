package poster.scan;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ExpressoScraperTest {
    @Test
    public void testExtractImageUrls() {
        String mockHtml = """
            <html>
                <body>
                    <div class="itemImage">
                        <img src="/visual/IS.php?id=12345&t=md" alt="Poster 1" />
                    </div>
                    <div class="itemImage">
                        <img src="/visual/IS.php?id=67890&t=md" alt="Poster 2" />
                    </div>
                </body>
            </html>
        """;

        Document doc = Jsoup.parse(mockHtml);
        Elements images = doc.select(".itemImage img");

        assertEquals(2, images.size());
        assertEquals("/visual/IS.php?id=12345&t=md", images.get(0).attr("src"));
        assertEquals("/visual/IS.php?id=67890&t=md", images.get(1).attr("src"));
    }
}