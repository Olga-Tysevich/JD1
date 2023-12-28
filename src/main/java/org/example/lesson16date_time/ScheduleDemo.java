package org.example.lesson16date_time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScheduleDemo {
    private static final int MEETING_TIME_IN_HOURS = 13;
    private static final int MEETING_TIME_IN_MINUTES = 0;
    private static final int DURATION_IN_MONTHS = 2;
    private static final int DAYS_UNTIL_NEXT_MEETING = 7;
    private static final String DATE_TIME_PATTERN = "dd::MMMM::yyyy HH:mm";

    public static void main(String[] args) {
        /*От текущей даты вывести расписание всех встреч, которые происходят еженедельно
         * в 13:00 в течении 2 месяцев*/
        LocalDateTime meetingDate = LocalDateTime.now().withHour(MEETING_TIME_IN_HOURS).withMinute(MEETING_TIME_IN_MINUTES);
        LocalDateTime finishDate = meetingDate.plusMonths(DURATION_IN_MONTHS).minusDays(DAYS_UNTIL_NEXT_MEETING);
        do {
            System.out.println(meetingDate.format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)));
            meetingDate = meetingDate.plusDays(DAYS_UNTIL_NEXT_MEETING);
        } while (meetingDate.isBefore(finishDate));
    }
}
