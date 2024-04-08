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

        Collection<LocalDate> localDates = dateSorter.sortDates(randomDatesList);
        System.out.println(localDates);
    }
}
