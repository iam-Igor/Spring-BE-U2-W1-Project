package ygorgarofalo.SpringBeU2w1Project.Exceptions;

public class ItemNotFoundExc extends RuntimeException {

    public ItemNotFoundExc(long id) {
        super("Il dato con id: " + id + " non è stato trovato!");
    }
}
