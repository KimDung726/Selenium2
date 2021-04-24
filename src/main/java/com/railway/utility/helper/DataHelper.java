package com.railway.utility.helper;

import com.github.javafaker.Faker;
import com.railway.utility.Constants;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataHelper {
    public static Faker faker = new Faker();

    /***
     * Random data for Username
     * @return : String
     */
    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    /***
     * Random data for Password
     * @return : String
     */
    public static String getRandomPassword() {
        return faker.internet().password(Constants.MIN_PASSWORD_LENGTH, Constants.MAX_PASSWORD_LENGTH);
    }

    /***
     * Random data for PID
     * @return : String
     */
    public static String getRandomPID() {
        return faker.internet().password(Constants.MIN_PID_LENGTH, Constants.MAX_PID_LENGTH, true);
    }

    /***
     * Random date based on current date
     * @param time : distance from the current date
     * @return : date
     */
    public static String getDate(String time) {
        DateFormat dateFormat = new SimpleDateFormat(Constants.DAY_FORMAT);
        Date currentDate = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DATE, Integer.parseInt(time));

        return dateFormat.format(calendar.getTime());
    }

    /***
     * Random number between range from min to max
     * @param min : int
     * @param max : int
     * @return : int
     */
    public static int getRandomNumberFromTo(int min, int max) {
        return faker.number().numberBetween(min, max);
    }

}
