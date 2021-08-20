package 发送邮件;

import javax.swing.text.html.HTML;
import java.io.*;

/**
 * @Description: 用于转换发送图片附件html格式。
 * @author: LinQin
 * @date: 2018/11/14
 */
public class ReportToHtml {


    public static void main(String[] args) {
        ReportToHtml toHtml = new ReportToHtml();
        toHtml.toHtml("D:\\IDEAWorkspace\\Java基础知识\\基础知识2\\src\\main\\java\\发送邮件\\report.html",
                "C:/Users/LinQin/Desktop/q.png", "D:\\IDEAWorkspace\\Java基础知识\\基础知识2\\src\\main\\java\\发送邮件\\newReport.html");

    }

    /**
     *
     * @param filePath 模版html路径
     * @param picPath 替换图片路径
     * @param toPath 保存修改的html模版路径
     * @return
     */
    public boolean toHtml(String filePath, String picPath, String toPath) {
        FileInputStream is = null;//读取模块文件
        String str = "";
        try {
            String tempStr = "";
            is = new FileInputStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            // todo 目录不存在就创建
            File f = new File(toPath);
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));

            while ((tempStr = br.readLine()) != null) {
                tempStr = tempStr.replaceAll("######", picPath);
                bw.write(tempStr);
                bw.newLine();
            }


            br.close();
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return true;
    }
}
