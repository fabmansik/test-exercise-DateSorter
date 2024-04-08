package sample;

import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.util.*;

/**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 * <p>
 * <p>
 * package sample;
 * <p>
 * import java.time.LocalDate;
 * import java.util.Collection;
 * import java.util.List;
 * <p>
 * /**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 * <p>
 * Implement in single class. Don't chane constructor and signature method.
 */
public class DateSorter {
    // january, february, march, april, may, june, july, august, september, october, november, december
    //01 r, 02 r, 03 r, 04 r, 05 no r, 06 no r, 07 no r, 08 no r, 09 r, 10 r, 11 r, 12 r
    /**
     * The implementation of this method should sort dates.
     * The output should be in the following order:
     * Dates with an 'r' in the month,
     * sorted ascending (first to last),
     * then dates without an 'r' in the month,
     * sorted descending (last to first).
     * For example, October dates would come before May dates,
     * because October has an 'r' in it.
     * thus: (2004-07-01, 2005-01-02, 2007-01-01, 2032-05-03)
     * would sort to
     * (2005-01-02, 2007-01-01, 2032-05-03, 2004-07-01)
     *
     * @param unsortedDates - an unsorted list of dates
     * @return the collection of dates now sorted as per the spec
     */

    //first implementation
    //all dates are sorted in this order: dates with "r" first going and sorted ascending and then dates without "r" sorted descending
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        List<Integer> rMonths = new ArrayList<>();
        //        if you need only English dates language, use this:
        DateFormatSymbols dfs = new DateFormatSymbols(Locale.ENGLISH);
//        if you need to use Locale.getDefault() values, use this then:
//        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();
        for (int i = 1; i < months.length; i++) {
            if(months[i].contains("r")){
                rMonths.add(i);
            }
        }
        List<LocalDate> sortedDates = new ArrayList<>();
        List<LocalDate> rDatesList = new ArrayList<>();
        List<LocalDate> noRDatesList = new ArrayList<>();


        for (LocalDate unsortedDate : unsortedDates) {
            boolean contains = !rMonths.contains(unsortedDate.getMonth().getValue()) ? noRDatesList.add(unsortedDate) : rDatesList.add(unsortedDate);
        }
        noRDatesList.sort(Collections.reverseOrder());
        Collections.sort(rDatesList);
        sortedDates.addAll(rDatesList);
        sortedDates.addAll(noRDatesList);
        return sortedDates;
    }



}