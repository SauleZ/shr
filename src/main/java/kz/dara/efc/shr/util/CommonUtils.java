package kz.dara.efc.shr.util;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class CommonUtils {
    public static String makePeriod(Date d1, Date d2) {
        if (d1 != null && d2 != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(d1);
            int begYear = cal.get(Calendar.YEAR);
            cal.setTime(d2);
            return begYear + " - " + cal.get(Calendar.YEAR);
        }
        return null;
    }

    public static boolean isEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }

    public static Date beginOfYear(Long year) {
        ZonedDateTime day = LocalDate.of(year.intValue(), Month.JANUARY, 1).atStartOfDay(ZoneId.systemDefault());
        return Date.from(day.toInstant());
    }

    public static Date endOfYear(Long year) {
        ZonedDateTime day = LocalDate.of(year.intValue(), Month.DECEMBER, 31).atTime(23, 59).atZone(ZoneId.systemDefault());
        return Date.from(day.toInstant());
    }
}
