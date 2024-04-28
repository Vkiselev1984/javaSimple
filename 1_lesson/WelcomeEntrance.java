// Программа выводит текущую дату и время, воспроизводит звук и запрашивает имя пользователя
// После получения имени запрашивает пароль. Если пароль совпадает с 123456
// печатает: "Имя доступ разрешен. Добро пожаловать!"

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class WelcomeEntrance {
    public static void main(String[] args) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);

        String greeting = new String("Vault-Tec");

        System.out.println(greeting);
        System.out.println("Текущая дата и время: " + formattedDateTime);

        try {
            File audioFile = new File("C:/Users/kiselev/Desktop/MuGit/MyGeekBrainsCloud/Java/Seminar1/valtek.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

            
            System.out.print("Введите логин: ");
            Scanner scanner = new Scanner(System.in, "ibm866"); //Не забываем указать кодировку
            String name = scanner.nextLine();
            System.out.print("Введите пароль: ");
            Integer password = scanner.nextInt();
            if (password == 123456) {
                System.out.println(name + " доступ разрешен. Добро пожаловать!");
            } else {
                System.out.print("Доступ запрещен");
            }

            scanner.close();
            clip.close();
            audioStream.close();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }

        }
    }

    
