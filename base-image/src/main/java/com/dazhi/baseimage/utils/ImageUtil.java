package com.dazhi.baseimage.utils;

import org.opencv.core.*;
import java.net.URL;

import static org.opencv.highgui.HighGui.imshow;
import static org.opencv.highgui.HighGui.waitKey;
import static org.opencv.imgcodecs.Imgcodecs.imread;
import static org.opencv.imgcodecs.Imgcodecs.imwrite;
import static org.opencv.imgproc.Imgproc.COLOR_RGB2GRAY;
import static org.opencv.imgproc.Imgproc.cvtColor;

public class ImageUtil {

    public static void main(String[] args) throws Exception {
        // 解决awt报错问题
        System.setProperty("java.awt.headless", "false");
        System.out.println(System.getProperty("java.library.path"));
        // 加载动态库
        URL url = ClassLoader.getSystemResource("static/opencv_java340/opencv_java340-x64.dll");
        System.load(url.getPath());
//        System.load(JmxGenerate.COMMON_PATH + "opencv_java340\\opencv_java340-x64.dll");
        // 读取图像
        Mat image = imread("C:\\Users\\Administrator\\Pictures\\2222.jpg");
        if (image.empty()) {
            throw new Exception("image is empty");
        }
        int height = image.height();
        int width = image.width();
//        imshow("Original Image", image);

        // 创建输出单通道图像
        Mat grayImage = new Mat(image.rows(), image.cols(), CvType.CV_8SC1);

        // 进行图像色彩空间转换
        cvtColor(image, grayImage, COLOR_RGB2GRAY);

        Mat res = image.clone();
        // 模糊效果
//        Imgproc.blur(res, res,new Size(25.0,25.0));
//        截取子矩阵
//        Mat submat = res.submat(new Rect(50,50,300,300));
//        Mat submat = res.submat(new Range(150, 250), new Range(200, 400));
//        Mat submat = res.submat(250, 650, 600, 1000);
//        imwrite("D://submat.jpg", submat);
//        submat.setTo(new Scalar(255,0,0));

//        imshow("submat Image", submat);

        Mat mat = new Mat(200, 300, CvType.CV_8UC3);
        setColors(mat,true,0);
        setColors(mat,false,1);

//        Mat submat = mat.submat(0, 200, 0, 300);
//        submat.setTo(new Scalar(0,0,255));
        imshow("Processed Image", mat);

//        imshow("Processed Image", res);
        imwrite("D://hello.jpg", res);
        waitKey();
    }
    static Scalar RED = new Scalar(0,0,255);
    static Scalar GREEN = new Scalar(0,255,0);
    static Scalar BLUE = new Scalar(255,0,0);

    public static void setColors(Mat mat, boolean comp, int row) {
        for (int i = 0;i<3;i++) {
            Mat submat = mat.submat(row * 100, row * 100 + 100, i * 100, i * 100 + 100);
            if (comp) {
                if (i == 0) submat.setTo(RED);
                if (i == 1) submat.setTo(GREEN);
                if (i == 2) submat.setTo(BLUE);
            }else {
                if (i == 0) submat.setTo(GREEN);
                if (i == 1) submat.setTo(BLUE);
                if (i == 2) submat.setTo(RED);
            }
        }
    }
}
