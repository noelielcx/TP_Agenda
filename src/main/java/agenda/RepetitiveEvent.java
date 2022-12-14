package agenda;

import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Description : A repetitive Event
 */
public class RepetitiveEvent extends Event {
    /**
     * Constructs a repetitive event
     *
     * @param title the title of this event
     * @param start the start of this event
     * @param duration myDuration in seconds
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     */
    public ChronoUnit frequency;
    private final ArrayList<LocalDate> lesExceptions = new ArrayList<>();

    public RepetitiveEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency) {
        super(title, start, duration);
        this.frequency = frequency;

    }

    /**
     * Adds an exception to the occurrence of this repetitive event
     *
     * @param date the event will not occur at this date
     */
    public void addException(LocalDate date) {

        lesExceptions.add(date);
    }

    /**
     *
     * @return the type of repetition
     */
    public ChronoUnit getFrequency() {
        // TODO : implémenter cette méthode
        // throw new UnsupportedOperationException("Pas encore implémenté");
        return frequency;
    }

    @Override
    public boolean isInDay(LocalDate aDay) {
        LocalDate dayRepet =  this.getStart().toLocalDate();
        if (lesExceptions.contains(aDay)){
            return false;
        }
        if (aDay.isAfter(dayRepet) || aDay.equals(dayRepet)){
           while (aDay.isAfter(dayRepet) || aDay.equals(dayRepet)){
               if (dayRepet.equals(aDay) && (!lesExceptions.contains(aDay))){
                   return true;
               }
               dayRepet=dayRepet.plus(1, frequency);
           }

        }
        return false;
    }

}
