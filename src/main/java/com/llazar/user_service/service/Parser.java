package com.llazar.user_service.service;

import org.jetbrains.annotations.NotNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

public class Parser {

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private static final char[] OLD_DATE_CHAR_SEP = new char[]{'/',':','.',';'};
    private static final char NEW_DATE_CHAR_SEP = '-';


    public static Date parseDate(String dateString) throws ParseException {
        // If we get a date using slashes, convert it to using dashes.
        dateString = replaceOldString(dateString);
        return DATE_FORMAT.parse(dateString);
    }

    @NotNull
    private static String replaceOldString(String dateString) {
        for (int i = 0; i < OLD_DATE_CHAR_SEP.length; i++ ){
            char oldChar = OLD_DATE_CHAR_SEP[i];
            char newChar = NEW_DATE_CHAR_SEP;
            if (dateString.contains(String.valueOf(oldChar)))
            {
                dateString = dateString.replace(oldChar, newChar);
                break;
            }
        }
        return dateString;
    }

}
