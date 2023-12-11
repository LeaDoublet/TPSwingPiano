package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.sound.midi.*;

public class Main extends JFrame {

    private static final int[] MIDI_NOTES = {60, 62, 64, 65, 67, 69, 71, 72}; // Corresponding to C4 to C5

    public Main() {
        super("Piano App");
        setSize(800, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JFrame fenetre= new MaFrame();
        JPanel pianoPanel = new JPanel();
        pianoPanel.setLayout(new GridLayout(1, MIDI_NOTES.length));
        Container fenCont = fenetre.getContentPane();
        fenCont.setLayout(new BorderLayout());
        JLabel label1 = new JLabel("ceci n'est pas un piano");
        JLabel label2 = new JLabel();
        fenCont.add(label1,BorderLayout.NORTH);
        fenCont.add(label2,BorderLayout.SOUTH);

        for (int i = 0; i < MIDI_NOTES.length; i++) {
            Touche key = new Touche(String.valueOf(i + 1), MIDI_NOTES[i]);
            key.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    playNote(key.getMidiNote(), 0);
                }
            });
            pianoPanel.add(key);
        }
        fenetre.add(pianoPanel);
        fenetre.setVisible(true);

    }

    public static void main(String[] args) {
        new Main();
    }


    public void playNote(int finalNote, int finalInstrument) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Synthesizer synth = MidiSystem.getSynthesizer();
                    synth.open();

                    MidiChannel[] channels = synth.getChannels();
                    channels[1].programChange(finalInstrument);
                    channels[1].noteOn(finalNote, 100);
                    Thread.sleep(500); // Adjust as needed
                    channels[1].noteOff(finalNote);

                    synth.close();
                } catch (MidiUnavailableException | InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
    }
}
