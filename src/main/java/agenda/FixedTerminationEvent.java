package agenda;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Description : A repetitive event that terminates after a given date, or after
 * a given number of occurrences
 */
public class FixedTerminationEvent extends RepetitiveEvent {

    
    /**
     * Constructs a fixed terminationInclusive event ending at a given date
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     * @param terminationInclusive the date when this event ends
     */
    public LocalDate terminationInclusive;
    public long numberOfOccurrences;
    public FixedTerminationEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency, LocalDate terminationInclusive) {
         super(title, start, duration, frequency);
         this.terminationInclusive = terminationInclusive;

    }

    /**
     * Constructs a fixed termination event ending after a number of iterations
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     * @param numberOfOccurrences the number of occurrences of this repetitive event
     */
    public FixedTerminationEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency, long numberOfOccurrences) {
        super(title, start, duration, frequency);
        this.numberOfOccurrences = numberOfOccurrences;

    }

    /**
     *
     * @return the termination date of this repetitive event
     */
    public LocalDate getTerminationDate() {
        LocalDate terminationDate = this.getStart().plus(numberOfOccurrences-1, this.getFrequency()).toLocalDate();
        return terminationDate;
      /* on ajoute ?? la date de d??part le nombre d'occurences dont l'unit?? est la fr??quence
        (par exemple si le nb d'occurence est 10 et la fr??quence est semaine on ajoute 10
         semaines a la date de d??part). On enl??ve 1 car la date de d??part est deja compt??e.*/
    }

    public long getNumberOfOccurrences() {
        LocalDate dateDebut, dateFin;
        dateDebut = this.getStart().toLocalDate();
        dateFin = this.terminationInclusive;
        numberOfOccurrences = 0;

        while(dateFin.isAfter(dateDebut)){
            numberOfOccurrences += 1;
            dateFin = dateFin.minus(1, this.getFrequency());
        }
        return numberOfOccurrences;
    }


}
