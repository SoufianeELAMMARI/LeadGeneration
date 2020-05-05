package com.project.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    public static String getIdYoutubeVideo(String url) {
        Pattern compiledPattern = Pattern.compile("(?<=watch\\?v=|/videos/|embed\\/|youtu.be\\/|\\/v\\/|\\/e\\/|watch\\?v%3D|watch\\?feature=player_embedded&v=|%2Fvideos%2F|embed%\u200C\u200B2F|youtu.be%2F|%2Fv%2F)[^#\\&\\?\\n]*");
        Matcher matcher = compiledPattern.matcher(url); //url is youtube url for which you want to extract the id.
        if (matcher.find()) {
            return matcher.group();
        }
        return null;

    }

    public static String getEmailFromText(String text) {
        Pattern p = Pattern.compile("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}");
        Matcher m = p.matcher(text);
        while (m.find()) {
            String mail = m.group();
            return mail;

        }
        return null;
    }

    public static String getPhoneFromText(String text) {
        Pattern p1 = Pattern.compile("\\d{10}");
        Pattern p2 = Pattern.compile("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}");
        Pattern p3 = Pattern.compile("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}");
        Matcher m1 = p1.matcher(text);
        Matcher m2 = p2.matcher(text);
        Matcher m3 = p3.matcher(text);

        while (m1.find()) {
            String phone1 = m1.group();
            if (phone1 != null) {
                return phone1;
            }
        }
        while (m2.find()) {
            String phone2 = m2.group();
            if (phone2 != null) {
                return phone2;
            }
        }
        while (m3.find()) {
            String phone3 = m3.group();
            if (phone3 != null) {
                return phone3;
            }

        }
        return null;

    }

}
