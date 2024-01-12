package ygorgarofalo.SpringBeU2w1Project.Exceptions;

import java.util.UUID;

public class ItemNotFoundExc extends RuntimeException {

    public ItemNotFoundExc(long id) {
        super("Il dato con id: " + id + " non è stato trovato!");
    }

    public ItemNotFoundExc(UUID id) {
        super("Il dato con id: " + id + " non è stato trovato!");
    }
}
