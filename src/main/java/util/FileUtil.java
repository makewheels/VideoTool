package util;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 文件工具类
 *
 * @date 2019-04-26 23:39
 */
public class FileUtil {
    /**
     * 替换文件名中的非法字符
     *
     * @param originalFileName
     * @param replacement
     * @return
     */
    public static String replaceIllegalFileName(String originalFileName, String replacement) {
        Pattern pattern = Pattern.compile("[\\s\\\\/:\\*\\?\\\"<>\\|]");
        Matcher matcher = pattern.matcher(originalFileName);
        if (replacement == null) {
            replacement = "";
        }
        return matcher.replaceAll(replacement);
    }

    /**
     * 文件大小：字节数转可读的字符串
     *
     * @param size
     * @return
     */
    public static String getSizeString(long size) {
        int GB = 1024 * 1024 * 1024;
        int MB = 1024 * 1024;
        int KB = 1024;
        DecimalFormat df = new DecimalFormat("0.0");
        String resultSize = "";
        if (size / GB >= 1) {
            resultSize = df.format(size / (float) GB) + "GB";
        } else if (size / MB >= 1) {
            resultSize = df.format(size / (float) MB) + "MB";
        } else if (size / KB >= 1) {
            resultSize = df.format(size / (float) KB) + "KB";
        } else {
            resultSize = size + "b";
        }
        return resultSize;
    }
}
