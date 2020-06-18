package javacore;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * 打印一个当月的日历，并用*标记今天
 *
 * @author white
 * @version 1.0 2019-07-20
 */
public class CalendarTest {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();//构造一个表示当前日期的对象
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();

        date = date.minusDays(today - 1);//生成当前日期之后或者之前的n天
        DayOfWeek weekday = date.getDayOfWeek();//得到当前日期是星期几
        int value = weekday.getValue();//1 = Monday, ... 7 = Sunday

        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 1; i < value; i++) {
            System.out.print("    ");
        }
        while (date.getMonthValue() == month) {
            System.out.printf("%3d", date.getDayOfMonth());
            if (date.getDayOfMonth() == today) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 1) {
                System.out.println();
            }
        }
        if (date.getDayOfWeek().getValue() != 1) {
            System.out.println();
        }
    }
}
