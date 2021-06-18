package com.dazhi.baseimage.filter;

import com.sun.javafx.geom.Vec4d;
import org.bytedeco.javacpp.opencv_core;
import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static org.bytedeco.javacpp.opencv_imgproc.CV_BGR2GRAY;
import static org.opencv.core.Core.addWeighted;
import static org.opencv.highgui.HighGui.imshow;
import static org.opencv.highgui.HighGui.waitKey;
import static org.opencv.imgcodecs.Imgcodecs.imread;
import static org.opencv.imgproc.Imgproc.*;

/**
 * 素描
 */
public class Sketch {
    public static Mat execute(Mat src) {
        Mat dst = new Mat();
        Mat temp = new Mat();

//        opencv_core.RNG rng = new opencv_core.RNG();

        //去色
        cvtColor(src,dst,CV_BGR2GRAY);
        // 模糊
        blur(dst,temp, new Size(3,3));

        Canny(temp,temp,50,150,10);
        Mat temp1 = temp.clone();
        List<MatOfPoint> contours = new ArrayList<>();
        Mat hiergrchy = new Mat();
        findContours(temp1, contours,hiergrchy,RETR_TREE,CHAIN_APPROX_SIMPLE,new Point(0,0));
        Mat zeros = Mat.zeros(temp1.size(), CvType.CV_8UC3);
        for(int i = 0;i<contours.size();i++) {
            Scalar scalar = new Scalar(200,200,200);
            drawContours(zeros,contours,i,scalar,2,8,hiergrchy,0,new Point());
        }
        //反色
        addWeighted(temp,-1, dst,0,255,temp);
        //高斯模糊,高斯核的Size与最后的效果有关
//        GaussianBlur(temp,temp,new Size(11,11),0);
//        Mat dst1 = new Mat();
//        Imgproc.Canny(dst, dst1, 30, 160, 3, false);
        //融合：颜色减淡
//        Mat img = new Mat(dst.size(),CvType.CV_8UC1);
        /*for (int y=0; y<src.height(); y++)
        {
            Mat P0 = dst.row(y);
            Mat P1  = temp.row(y);
            Mat P  = img.row(y);
            for (int x=0; x<src.width(); x++)
            {
                long tmp0=P0.col(x).nativeObj;
                long tmp1=P1.col(x).nativeObj;
                P.col(x).setTo(new Mat(Math.min((tmp0+(tmp0*tmp1)/(256-tmp1)),255)));
            }

        }*/

        return temp;
    }

    public static void main(String[] args) throws Exception {
        // 解决awt报错问题
        System.setProperty("java.awt.headless", "false");
        System.out.println(System.getProperty("java.library.path"));
        // 加载动态库
        URL url = ClassLoader.getSystemResource("static/opencv_java340/opencv_java340-x64.dll");
        System.load(url.getPath());
//        System.load(JmxGenerate.COMMON_PATH + "opencv_java340\\opencv_java340-x64.dll");
        // 读取图像
//        Mat image = imread("C:\\Users\\Administrator\\Pictures\\2222.jpg");
        Mat image = imread("C:\\Users\\Administrator\\Pictures\\1111.jpg");
//        Mat image = imread("C:\\Users\\Administrator\\Pictures\\rocket.png");
        if (image.empty()) {
            throw new Exception("image is empty");
        }
//        imshow("Original Image", image);
        Mat execute = execute(image);
        imshow("Processed Image", execute);
        waitKey();
    }
}
