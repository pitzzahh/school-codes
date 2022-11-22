package calendar;

import io.github.pitzzahh.util.utilities.Print;

import static io.github.pitzzahh.util.utilities.Print.*;
import static java.lang.String.format;
import static java.lang.String.valueOf;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;

public class Application {

    private static Calendar calendar;

    public static void main(String[] args) {
        input(new Scanner(System.in));
        printCalendar(calendar);
    }

    private static void input(Scanner scanner) {
        System.out.print("Enter the month: ");
        int month = scanner.nextInt();
        System.out.print("Enter the year: ");
        int year = scanner.nextInt();

        YearMonth yearMonth = YearMonth.of(year, month); // Year, Month
        LocalDate firstOfMonth = yearMonth.atDay(1);

        calendar = new Calendar(yearMonth, firstOfMonth.getDayOfWeek());

    }

    private static void printCalendar(Calendar calendar) {

        int year = calendar.yearMonth().getYear();
        String month = calendar.yearMonth().getMonth().name();
        int days = calendar.yearMonth().lengthOfMonth();
        DayOfWeek dayOfWeekName = calendar.dayOfWeek();

        Map<DayOfWeek, Integer> spaces = Map.of(
                DayOfWeek.SUNDAY, 1,        // 7
                DayOfWeek.MONDAY,  3,       // 1
                DayOfWeek.TUESDAY,  7,      // 2
                DayOfWeek.WEDNESDAY, 10,    // 3
                DayOfWeek.THURSDAY, 13,     // 4
                DayOfWeek.FRIDAY, 16,       // 5
                DayOfWeek.SATURDAY, 19         // 6
        );

        Map<DayOfWeek, List<List<String>>> daysOfWeek = new HashMap<>();
        List<List<String>> val = new ArrayList<>();

        for (int weekName = dayOfWeekName.ordinal(), day = 1; weekName <= DayOfWeek.values().length && day <= days; weekName++, day++) {
            if (weekName == DayOfWeek.values().length) weekName = 1;
            if (day == 1) {
                println("DAY START: " + DayOfWeek.of(weekName));
                val.add(List.of("-".repeat(spaces.get(dayOfWeekName)), valueOf(day)));
                daysOfWeek.put(
                        dayOfWeekName,
                        val
                );
            }
            else {
                DayOfWeek of = DayOfWeek.of(weekName);
                println("DAY: " + of);
                val.add(List.of("-".repeat(2), valueOf(day)));
                daysOfWeek.put(of, val);
            }
        }

        println();
        println(format("%s %d", month, year));
        println("Su Mo Tu We Th Fr Sa");

        daysOfWeek.get(DayOfWeek.MONDAY).forEach(Print::println);

    }

}
