package util;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.model.VideoListResponse;

import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * YoutubeApi工具类
 *
 * @date 2019-05-17 23:41
 */
public class YoutubeApiUtil {
    private static YouTube youtubeService;
    private static final String DEVELOPER_KEY = "AIzaSyDKA_arHLwnXi3Fs16uxBvttFapA26Fy9A";
    private static final String APPLICATION_NAME = "API code samples";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

    static {
        if (RuntimeUtil.isWindows()) {
            System.setProperty("http.proxyHost", "127.0.0.1");
            System.setProperty("http.proxyPort", "1080");
            System.setProperty("https.proxyHost", "127.0.0.1");
            System.setProperty("https.proxyPort", "1080");
        }
        try {
            youtubeService = getService();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static YouTube getService() throws GeneralSecurityException, IOException {
        final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        return new YouTube.Builder(httpTransport, JSON_FACTORY, null)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    /**
     * 根据id获取视频信息
     *
     * @param videoId
     * @return
     */
    public static VideoListResponse getVideoById(String videoId) {
        YouTube.Videos.List request = null;
        try {
            request = youtubeService.videos()
                    .list("snippet,contentDetails,statistics");
            return request.setKey(DEVELOPER_KEY).setId(videoId).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据id获取视频标题
     *
     * @param videoId
     * @return
     */
    public static String getVideoTitleById(String videoId) {
        VideoListResponse videoListResponse = getVideoById(videoId);
        Video video = videoListResponse.getItems().get(0);
        return video.getSnippet().getTitle();
    }

}
