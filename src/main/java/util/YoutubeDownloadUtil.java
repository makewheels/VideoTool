package util;

import org.apache.commons.lang3.SystemUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * youtube下载工具类
 *
 * @date 2019-05-17 23:19
 */
public class YoutubeDownloadUtil {

    /**
     * 从url中解析出视频id
     *
     * @param url
     * @return
     */
    public static String getVideoIdFromUrl(String url) {
        return UrlUtil.parseParametersFromUrl(url).get("v");
    }

    /**
     * 通过youtube-dl，根据url，获取下载视频的文件名
     *
     * @param url
     * @return
     */
    public static String getFilenameByYoutubeDl(String url) throws IOException {
        String command = "youtube-dl ";
        //如果是Windows，加代理
        if (RuntimeUtil.isWindows()) {
            command += "--proxy socks5://127.0.0.1:1080 ";
        }
        command += "--get-filename " + url;
        Runtime runtime = Runtime.getRuntime();
        //根据操作系统决定字符集
        String charset;
        if (RuntimeUtil.isWindows()) {
            charset = "gbk";
        } else {
            charset = "utf-8";
        }
        Process process = runtime.exec(command);
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(process.getInputStream(), charset));
        return bufferedReader.readLine();
    }

    /**
     * 下载单个视频
     *
     * @param url      视频路径或id
     * @param filepath 保存路径
     */
    public static void downloadSingleVideo(String url, String filepath) throws IOException {
        //使用youtube-dl下载
        String command = "youtube-dl ";
        //如果是Windows，加代理
        if (RuntimeUtil.isWindows()) {
            command += "--proxy socks5://127.0.0.1:1080 ";
        }
        //设置音频质量
        command += "--audio-quality 0 ";
        //设置保存路径
        command += "-o " + filepath + " ";
        //视频url
        if (RuntimeUtil.isWindows()) {
            command += "\"" + url + "\"";
        } else {
            command += url;
        }
        //开始下载
        RuntimeUtil.execute(command);
        //下载完成
    }


}
