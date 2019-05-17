package servlet;

import org.apache.commons.lang3.SystemUtils;
import util.YoutubeDownloadUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * 指定url，并推送到百度网盘
 *
 * @date 2019-05-17 20:55
 */
@WebServlet("/downloadAndPush")
public class DownloadAndPushServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //url
        String url = request.getParameter("url");
        //文件名
        String filename = YoutubeDownloadUtil.getFilenameByYoutubeDl(url);
        //响应客户端
        response.getWriter().write(filename);
        //保存路径
        String filepath = SystemUtils.USER_HOME + "/youtube/" + filename;
        //执行下载
        YoutubeDownloadUtil.downloadSingleVideo(url, filepath);
        //上传到百度网盘
        File file = new File(filepath);
//        NetdiskUtil.uploadSingleFile(file, "/youtube/" + filename);
        //任务全部完成，发送邮件通知
    }

}
