package de.christian2003.budgetplan.models.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.UUID;
import de.christian2003.budgetplan.models.Identifiable;


@Entity
public class FinanceTransaction implements Identifiable {

    /**
     * Attribute stores an ID with which the transaction can be identified.
     */
    @PrimaryKey
    @NonNull
    private UUID id;

    /**
     * Attribute stores the name of the transaction.
     */
    @ColumnInfo(name = "name")
    private String name;

    /**
     * Attribute stores an optional description for the transaction.
     */
    @ColumnInfo(name = "description")
    private String description;


    /**
     * Constructor instantiates a new empty transaction.
     */
    public FinanceTransaction() {
        this.id = UUID.randomUUID();
    }


    /**
     * Method returns the ID of the transaction.
     *
     * @return  ID of the transaction.
     */
    @Override
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) throws NullPointerException {
        if (id == null) {
            throw new NullPointerException();
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws NullPointerException {
        if (name == null) {
            throw new NullPointerException();
        }
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * Method compares the passed item with the instance based on their IDs.
     *
     * @param item                  Item to be compared to this instance.
     * @return                      Whether the IDs of both items are identical.
     * @throws NullPointerException The passed item is {@code null}.
     */
    @Override
    public boolean equals(Identifiable item) throws NullPointerException {
        if (item == null) {
            throw new NullPointerException();
        }
        return item.getId().equals(id);
    }

}
