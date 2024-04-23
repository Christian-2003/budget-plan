package de.christian2003.budgetplan.models.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;


@Dao
public interface FinanceTransactionDao {

    @Insert
    void insertAll(FinanceTransaction... transaction);

    @Delete
    void delete(FinanceTransaction transaction);

    @Query("SELECT * FROM FinanceTransaction")
    List<FinanceTransaction> getAll();

}
