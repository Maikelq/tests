package nl.maikel.nedap.game.service;

import nl.maikel.nedap.game.enumeration.EventObject;
import nl.maikel.nedap.game.model.Board;
import nl.maikel.nedap.game.model.Event;

import java.util.Random;

public class BoardService {

    private Board board;

    /**
     * Aanmaken van het bord
     * @throws Exception
     */
    public void startPlaying() throws Exception {
        if (this.board != null && !this.board.isFinished()) {
            throw new Exception("A game is already in progress. Please finish first.");
        }

        this.board = new Board();
        System.out.printf("Started playing, current position %s\n", this.board.getPlayerPos());
    }

    /**
     * Starten van volgende beurt
     * @throws Exception
     */
    public void playNextTurn() throws Exception {
        int tempPos = getNewDiceRoll();
        System.out.printf("New position: %s%n", board.getPlayerPos());
        handleEvent(tempPos);
    }

    /**
     * Dobbelsteen gooien en verwerken
     * @return
     * @throws Exception
     */
    private int getNewDiceRoll() throws Exception {
        if (this.board == null || this.board.isFinished()) {
            throw new Exception("Please start a game first");
        }

        int diceRoll = new Random().nextInt(6) + 1;
        System.out.printf("Player rolled: %s%n", diceRoll);

        return this.board.processDiceRoll(diceRoll);
    }

    /**
     * Mogelijke events verwerken
     * @param tempPos
     */
    private void handleEvent(int tempPos) {
        Event modifier = this.board.getEvents().getOrDefault(tempPos, new Event(EventObject.NONE, 0));
        this.board.setPlayerPos(tempPos + modifier.getMovement());

        if (!modifier.getEventObject().equals(EventObject.NONE)) {
            System.out.printf("Event encountered: %s%n", modifier.getEventObject().getDisplayName());
            System.out.printf("New position after event: %s%n", board.getPlayerPos());
        }
    }

    /**
     * Ophalen van huidig bord
     * @return
     */
    public Board getBoard() {
        return this.board;
    }
}
