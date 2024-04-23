package de.christian2003.budgetplan.viewmodels.activities;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import de.christian2003.budgetplan.models.data.DatabaseCallback;
import de.christian2003.budgetplan.models.data.DatabaseWrapper;
import de.christian2003.budgetplan.models.data.FinanceTransaction;
import de.christian2003.budgetplan.models.data.Result;


public class MainViewModel extends ViewModel {

    private final DatabaseWrapper wrapper;

    private final List<FinanceTransaction> transactions;


    public MainViewModel(DatabaseWrapper wrapper) {
        this.wrapper = wrapper;
        transactions = new ArrayList<>();
    }


    public List<FinanceTransaction> getTransactions() {
        return transactions;
    }


    public void makeDataRequest() {
        wrapper.makeDataRequestAsync(result -> {
            if (result instanceof Result.Success) {
                transactions.addAll(((Result.Success<List<FinanceTransaction>>) result).getData());
            }
        });
    }

}
