package de.christian2003.budgetplan.models.data;

import android.content.Context;

import androidx.room.Room;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class DatabaseWrapper {

    private static final String DATABASE_NAME = "database-name";


    private final AppDatabase database;

    private final Executor executor;


    public DatabaseWrapper(Context context, Executor executor) {
        database = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DATABASE_NAME).build();
        this.executor = executor;
    }


    public void makeDataRequestAsync(DatabaseCallback<List<FinanceTransaction>> callback) {
        executor.execute(() -> callback.onComplete(makeDataRequest()));
    }


    public Result<List<FinanceTransaction>> makeDataRequest() {
        try {
            List<FinanceTransaction> transactions = database.financeTransactionDao().getAll();
            return new Result.Success<>(transactions);
        }
        catch (Exception e) {
            return new Result.Error<>(e);
        }
    }

}
