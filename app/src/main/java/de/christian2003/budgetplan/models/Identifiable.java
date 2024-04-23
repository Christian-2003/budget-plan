package de.christian2003.budgetplan.models;

import java.util.UUID;


/**
 * Interface requires it's implementing classes to contain a unique ID with which it can be identified.
 *
 * @author  Christian-2003
 * @version 0.0.1
 */
public interface Identifiable {

    /**
     * Method requires a class to return a UUID on demand.
     *
     * @return  UUID of the instance.
     */
    UUID getId();

    /**
     * Method compares the passed item with the instance based on their IDs.
     *
     * @param item                  Item to be compared to this instance.
     * @return                      Whether the IDs of both items are identical.
     * @throws NullPointerException The passed item is {@code null}.
     */
    boolean equals(Identifiable item) throws NullPointerException;

}
