import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class MusicPlay {
    private Player player;

    File music;
    //构造方法  参数是一个.mp3音频文件
    public MusicPlay(File file) {
        this.music = file;
    }
    //播放方法
    public void play() throws Exception {

        BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(music));
        player = new Player(buffer);
        player.play();
    }

    public static void main(String[] args) throws Exception {
        MusicPlay musicPlay = new MusicPlay(new File("D:\\mywords\\wordlist1.mp3"));
        musicPlay.play();
        System.out.println("word");
    }
}
