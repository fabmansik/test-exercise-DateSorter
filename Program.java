package sample;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        DateSorter dateSorter = new DateSorter();
//      random dates to check the work of program
        List<LocalDate> dateList = new ArrayList<>();
        for(int i=0; i<20;i++){
            LocalDate now = LocalDate.now();
            dateList.add(now.plusMonths(now.getMonth().getValue()+i).plusDays(now.getDayOfMonth()+i).minusYears(i));
        }
//        2004-07-01, 2005-01-02, 2007-01-01, 2032-05-03
        List<LocalDate> localDatesTestInfo = new ArrayList(){{
            add(LocalDate.of(2004, 7,01));
            add(LocalDate.of(2005, 1,02));
            add(LocalDate.of(2007, 1,01));
            add( LocalDate.of(2032, 5,03));

        }};
        Collection<LocalDate> localDates = dateSorter.sortDates(localDatesTestInfo);
        System.out.println(localDates);
    }
}
