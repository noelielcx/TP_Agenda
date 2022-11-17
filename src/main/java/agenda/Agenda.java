package agenda;

import com.sun.org.apache.xpath.internal.operations.Equals;
import sun.security.util.Cache;

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

    public List<Event> findByTitle(String title){
        ArrayList theTitles = new ArrayList<>();
        for (Event e : lesEvents){
          if (e.getTitle().equals(title)){
              theTitles.add(e);
          }
        }
        return theTitles;
    }

    public boolean isFree(Event e){
        LocalDate day = e.getStart().toLocalDate();
        if (lesEventsDuJour.contains(e)){
            return false;
        }
        else{
            return true;
        }
    }

}
