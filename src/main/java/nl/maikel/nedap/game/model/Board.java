package nl.maikel.nedap.game.model;

import nl.maikel.nedap.game.enumeration.EventObject;

import java.util.Map;

import static java.util.Map.entry;

public class Board {
    private int size = 25;
    private int playerPos = 0;
    private Map<Integer, Event> events = Map.ofEntries(
            entry(3, new nl.maikel.nedap.game.model.Event(EventObject.LADDER, 8)),
            entry(6, new nl.maikel.nedap.game.model.Event(EventObject.LADDER, 11)),
            entry(9, new nl.maikel.nedap.game.model.Event(EventObject.LADDER, 9)),
            entry(10, new nl.maikel.nedap.game.model.Event(EventObject.LADDER, 2)),
            entry(14, new nl.maikel.nedap.game.model.Event(EventObject.SNAKE, -10)),
            entry(19, new nl.maikel.nedap.game.model.Event(EventObject.SNAKE, -11)),
            entry(22, new nl.maikel.nedap.game.model.Event(EventObject.SNAKE, -2)),
            entry(24, new nl.maikel.nedap.game.model.Event(EventObject.SNAKE, -8))
    );

    public int getPlayerPos() {
        return playerPos;
    }

    public boolean isFinished() {
        boolean finished = playerPos >= size;

        if (finished) {
            System.out.printf("Game has finished! Current position: %s", this.playerPos);
        }

        return finished;
    }

    public int processDiceRoll(int diceRoll) {
        return this.playerPos += diceRoll;
    }

    public Map<Integer, nl.maikel.nedap.game.model.Event> getEvents() {
        return events;
    }

    public void setPlayerPos(int newPos) {
        this.playerPos = Math.min(newPos, size);
    }
}
