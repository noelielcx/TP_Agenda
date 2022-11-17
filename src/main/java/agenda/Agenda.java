package agenda;

import java.time.LocalDate;
import java.util.*;

/**
 * Description : An agenda that stores events
 */
public class Agenda {
    /**
     * Adds an event to this agenda
     *
     * @param e the event to add
     */
    public List<Event> lesEvents = new ArrayList<>();
    public List<Event> lesEventsDuJour = new ArrayList<>();

    public void addEvent(Event e) {
        // TODO : implémenter cette méthode
        // throw new UnsupportedOperationException("Pas encore implémenté");
        lesEvents.add(e);
    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day toi test
     * @return and iteraror to the events that occur on that day
     */
    public List<Event> eventsInDay(LocalDate day) {
        // TODO : implémenter cette méthode
       // throw new UnsupportedOperationException("Pas encore implémenté");
        for (Event e : lesEvents){
            if (e.isInDay(day)){
                lesEventsDuJour.add(e);
            }
        }
        return lesEventsDuJour;
    }
}
