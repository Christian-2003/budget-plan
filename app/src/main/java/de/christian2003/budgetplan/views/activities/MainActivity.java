package de.christian2003.budgetplan.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.Transaction;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import de.christian2003.budgetplan.R;
import de.christian2003.budgetplan.models.data.AppDatabase;
import de.christian2003.budgetplan.models.data.FinanceTransaction;
import de.christian2003.budgetplan.utils.adapters.SimpleArrayAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database-name").build();

        RecyclerView listView = findViewById(R.id.list_view);
        SimpleArrayAdapter adapter = new SimpleArrayAdapter(new ArrayList<>());
        listView.setAdapter(adapter);

        findViewById(R.id.button_add).setOnClickListener(view -> {
            String name = ((EditText)findViewById(R.id.input_name)).getText().toString();
            String description = ((EditText)findViewById(R.id.input_description)).getText().toString();
            if (description.isEmpty()) {
                description = null;
            }
            FinanceTransaction transaction = new FinanceTransaction();
            transaction.setName(name);
            transaction.setDescription(description);
            adapter.getData().add(transaction);
            adapter.notifyItemInserted(adapter.getItemCount() - 1);
            Thread insertThread = new Thread(() -> {
                database.financeTransactionDao().insertAll(transaction);
            });
            insertThread.start();
        });

        Thread dataQueryThread = new Thread(() -> {
            if (!adapter.getData().isEmpty()) {
                return;
            }
            List<FinanceTransaction> transactions = database.financeTransactionDao().getAll();
            adapter.getData().addAll(transactions);
            adapter.notifyDataSetChanged();
        });
        dataQueryThread.start();
    }

}
