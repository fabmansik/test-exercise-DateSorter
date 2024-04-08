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
//        if you need only English dates language, use this:
        DateFormatSymbols dfs = new DateFormatSymbols(Locale.ENGLISH);
//        if you need to use Locale.getDefault() values, use this then:
//        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();
        for (String month : months) {
            System.out.println(month);
        }
        long start = System.currentTimeMillis();
        HashMap<String, List<LocalDate>> datesMap = new HashMap<>();
        datesMap.put("sorted", new ArrayList<>());
        datesMap.put("rDates", new ArrayList<>());
        datesMap.put("noRDates", new ArrayList<>());
        List<Integer> rMonths = new ArrayList<>();

        for (int i = 1; i < months.length; i++) {
//            if you are looking only for english states, use this
            if (months[i].contains("r")) {
                rMonths.add(i);
            }
//            if you are looking for different languages states, use this then
//            if (months[i].contains("r")) {
//                rMonths.add(i);
//            }

        }
        for (LocalDate unsortedDate : unsortedDates) {
            boolean contains = !rMonths.contains(unsortedDate.getMonth().getValue()) ? datesMap.get("noRDates").add(unsortedDate) : datesMap.get("rDates").add(unsortedDate);
        }
        datesMap.get("noRDates").sort(Collections.reverseOrder());
        Collections.sort(datesMap.get("rDates"));
        datesMap.get("sorted").addAll(datesMap.get("rDates"));
        datesMap.get("sorted").addAll(datesMap.get("noRDates"));
        long l = System.currentTimeMillis();
        System.out.println("Time: " + (l - start));
        return datesMap.get("sorted");
    }
}