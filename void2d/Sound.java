// Sound.java - Part of Void2D.

package void2d;

import java.io.File;

import java.io.FileNotFoundException;

import java.io.IOException;

import javax.sound.sampled.Clip;

import javax.sound.sampled.AudioSystem;

import javax.sound.sampled.AudioInputStream;

import javax.sound.sampled.UnsupportedAudioFileException;

import javax.sound.sampled.LineUnavailableException;

/**
 * <h1>Class for working with sounds.</h1>
 * Sounds.
 */
public class Sound {
    protected final String soundPath;

    protected final Clip soundClip;

    protected int framePos = -1;

    /**
     * Is paused?
     */
    public boolean paused = false;

    /**
     * Looped?
     */
    public boolean looped = false;

    /**
     * Initialize new sound.
     *
     * @param _soundPath Sound path.
     */
    public Sound(String _soundPath) throws FileNotFoundException {
        soundPath = _soundPath;

        File soundFile = new File(_soundPath);

        if(!soundFile.exists()) {
            throw new FileNotFoundException("Sound is not exist.");
        }

        AudioInputStream audioInput;

        try {
            audioInput = AudioSystem.getAudioInputStream(soundFile);
        } catch(UnsupportedAudioFileException unsupported_audio_file_exc) {
            throw new UnsupportedOperationException("Audio file is not supported.");
        } catch (IOException io_exc) {
            throw new RuntimeException(String.format("An IOException raised while reading audio input stream. (%s).", io_exc.getMessage()));
        }

        Clip audioClip;

        try {
            audioClip = AudioSystem.getClip();

            audioClip.open(audioInput);
        } catch(LineUnavailableException line_unavailable_exc) {
            throw new RuntimeException("Line un-available.");
        } catch (IOException io_exc) {
            throw new RuntimeException(String.format("An IOException raised while working with clip. (%s).", io_exc.getMessage()));
        }

        soundClip = audioClip;
    }

    /**
     * Set looped.
     *
     * @param _looped Looped?
     */
    public void setLooped(boolean _looped) {
        looped = _looped;
    }

    /**
     * Get is sound looped.
     */
    public boolean isLooped() {
        return looped;
    }

    /**
     * Play sound.
     */
    public void play() {
        soundClip.start();

        if(looped) {
            soundClip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    /**
     * Stop sound.
     */
    public void stop() {
        soundClip.stop();
    }

    /**
     * Pause sound.
     */
    public void pause() {
        framePos = soundClip.getFramePosition();

        stop();

        paused = true;
    }

    /**
     * Resume sound.
     */
    public void resume() {
        if(!isPaused()) {
            return;
        }

        soundClip.setFramePosition(framePos);

        play();

        paused = false;
    }

    /**
     * Is paused?
     */
    public boolean isPaused() {
        return paused;
    }
}
