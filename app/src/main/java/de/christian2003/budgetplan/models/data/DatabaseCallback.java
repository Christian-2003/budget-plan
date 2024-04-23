package de.christian2003.budgetplan.models.data;

public interface DatabaseCallback<T> {

    void onComplete(Result<T> result);

}
