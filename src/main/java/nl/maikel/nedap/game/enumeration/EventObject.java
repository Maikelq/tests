package nl.maikel.nedap.game.enumeration;

public enum EventObject {
    NONE(""),
    LADDER("ladder"),
    SNAKE("snake");

    private String displayName;

    EventObject(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
