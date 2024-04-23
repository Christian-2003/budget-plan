package de.christian2003.budgetplan.models.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {FinanceTransaction.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract FinanceTransactionDao financeTransactionDao();

}
