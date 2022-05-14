package com.example.project;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class MusicPlayer {

    public static void main(String[] args) throws Exception {
        File file=new File("C:\\Users\\agenda\\IdeaProjects\\project\\src\\main\\resources\\music\\起风了.mp3");
        FileInputStream stream=new FileInputStream(file);
        Player player=new Player(stream);
        while(true) {
            player.play();
        }
    }

}
