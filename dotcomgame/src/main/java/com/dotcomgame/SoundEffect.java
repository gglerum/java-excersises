package com.dotcomgame;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public enum SoundEffect {
    HIT("hit.wav"),
    MISS("miss.wav"),
    KILL("miss.wav");

    private Clip clip;

    SoundEffect(String file) {

        URL url = this.getClass().getResource(file);

        try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url)) {
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void play() {
        clip.setFramePosition(0);
        clip.start();
    }
}
