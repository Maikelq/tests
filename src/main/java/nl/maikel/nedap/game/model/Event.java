package nl.maikel.nedap.game.model;

import nl.maikel.nedap.game.enumeration.EventObject;

public class Event {
    private final EventObject eventObject;
    private final int movement;

    public Event(EventObject eventObject, int movement) {
        this.movement = movement;
        this.eventObject = eventObject;
    }

    public EventObject getEventObject() {
        return eventObject;
    }

    public int getMovement() {
        return movement;
    }
}
