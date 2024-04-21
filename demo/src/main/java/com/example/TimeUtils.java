package com.example;

public class TimeUtils {

    public static int timeToSec(String time) {
        String[] part = time.split(":");
        int hh = Integer.parseInt(part[0]);
        int mm = Integer.parseInt(part[1]);
        int ss = Integer.parseInt(part[2]);

        return 3600 * hh + 60 * mm + ss;
    }

    public static String secToTime(int a) {
        int maxSeconds = 24 * 60 * 60;  // Maksimiarvo sekunteina

        if (a < 0 || a > maxSeconds) {
            return "Error";  // Palauta "Error" negatiivisille arvoille
        }

        int hours = a / 3600;  // Laske tunnit
        int remainingSeconds = a % 3600;  // Laske jäljellä olevat sekunnit tunneista
        int minutes = remainingSeconds / 60;  // Laske minuutit
        int seconds = remainingSeconds % 60;  // Laske jäljellä olevat sekunnit minuuteista

        // Muodosta paluuarvo. Tunti voi olla yhden numeron mittainen alle 10 tunnin arvoille.
        String hourString = String.valueOf(hours);
        String minuteString = (minutes < 10) ? "0" + minutes : String.valueOf(minutes);
        String secondString = (seconds < 10) ? "0" + seconds : String.valueOf(seconds);

        return hourString + ":" + minuteString + ":" + secondString;
    }
}