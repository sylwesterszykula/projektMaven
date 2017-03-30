package com.dateConverting;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DataConverting {
    private Date date;


    public Date convertingFromBrithLocalDate(int year, int month, int dayOfMonth) {
        LocalDate localDate1 = LocalDate.of(year, month, dayOfMonth);
        date = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return date;
    }

    public Date convertingFromLocalLocalDate(){
        LocalDate localDate = LocalDate.now();
        date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return date;
    }
}
