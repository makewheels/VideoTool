package util;

import java.io.File;
import java.io.IOException;

/**
 * 网盘工具类
 *
 * @date 2019-05-17 23:35
 */
public class NetdiskUtil {

    /**
     * 上传单个文件
     *
     * @param localFile   本地文件
     * @param netdiskPath 网盘的保存路径
     */
    public static void uploadSingleFile(File localFile, String netdiskPath) throws IOException {
        //使用bypy上传
        RuntimeUtil.execute("bypy upload  " + localFile.getPath() + netdiskPath);
    }

}
