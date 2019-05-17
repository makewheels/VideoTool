import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 下载工具
 * <p>
 * Windows cmd修改utf-8：
 * https://blog.csdn.net/qq_35038153/article/details/78430359
 *
 * @date 2019-05-17 21:59
 */
public class DownloadTool {

    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        //获取操作系统
        String osName = System.getProperty("os.name");
        boolean isWindows;
        if (osName.startsWith("Windows")) {
            isWindows = true;
        } else {
            isWindows = false;
        }
        //根据操作系统决定字符集
        String charset = null;
        if (isWindows) {
            charset = "gbk";
        } else {
//            charset = null;
        }
        //根据操作系统决定执行runtime命令
        String command;
        if (isWindows) {
            command = "youtube-dl --proxy socks5://127.0.0.1:1080 " +
                    "https://www.youtube.com/watch?v=kwE7frQOjfE";
        } else {
            command = "";
        }
        //使用youtube-dl下载
        Process process = runtime.exec(command);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(), charset));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        System.out.println("下载完成了。");
        //使用bypy上传
        runtime.exec("bypy upload C:\\Users\\Administrator\\Desktop\\新建文件夹\\a.webm " +
                "/youtube/a.webbbb");
    }

}
