package Proyecto1.DatosParty.MotherList;

/**
 * Base model for the implementation of the lists
 *
 * @param <T>
 */
public interface MotherList<T> {
    boolean isEmpty();

    void insertLast(T data);

    T accessNode(int i);

    int len();

}


