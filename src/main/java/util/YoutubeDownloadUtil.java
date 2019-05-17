package util;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * youtube下载工具类
 *
 * @date 2019-05-17 23:19
 */
public class YoutubeDownloadUtil {

    public static void main(String[] args) {
        Map<String, String> map = UrlUtil.parseParametersFromUrl("https://www.youtube.com/watch?v=NI9Miz8uXk8");
        System.out.println(map.get("v"));
    }

    /**
     * 下载单个视频
     *
     * @param url  视频路径或id
     * @param file 保存的文件
     */
    public static void downloadSingleVideo(String url, File file) throws IOException {
        //使用youtube-dl下载
        String command = "youtube-dl ";
        //如果是Windows，加代理
        if (RuntimeUtil.isWindows()) {
            command += "--proxy socks5://127.0.0.1:1080 ";
        }

        command += url;

        //准备文件名
//        YoutubeApiUtil.getVideoTitleById()
        //开始下载
        RuntimeUtil.execute(command);
        //下载完成
    }

}
