package sample;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        DateSorter dateSorter = new DateSorter();
//      random dates to check the work of program
        List<LocalDate> randomDatesList = new ArrayList<>();
        for(int i=0; i<10000;i++){
            LocalDate now = LocalDate.now();
            randomDatesList.add(now.plusMonths(now.getMonth().getValue()+i).plusDays(now.getDayOfMonth()+i).minusYears(i));
        }
//        (2004-07-01, 2005-01-02, 2007-01-01, 2032-05-03)
        List<LocalDate> test = new ArrayList<>();
        test.add(LocalDate.of(2004, 7,1));
        test.add(LocalDate.of(2005,1,2));
        test.add(LocalDate.of(2007,1,1));
        test.add(LocalDate.of(2032,5,3));
        Collection<LocalDate> localDates = dateSorter.sortDates(test);
        System.out.println(localDates);
    }
}
