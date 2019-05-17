package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Runtime执行类
 *
 * @date 2019-05-17 23:25
 */
public class RuntimeUtil {

    /**
     * 获取当前操作系统，是不是Windows
     *
     * @return
     */
    public static boolean isWindows() {
        String osName = System.getProperty("os.name");
        if (osName.startsWith("Windows")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 执行一条命令
     *
     * @param command
     * @throws IOException
     */
    public static void execute(String command) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        //根据操作系统决定字符集
        String charset;
        if (isWindows()) {
            charset = "gbk";
        } else {
            charset = "utf-8";
        }
        Process process = runtime.exec(command);
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(process.getInputStream(), charset));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
    }

}
