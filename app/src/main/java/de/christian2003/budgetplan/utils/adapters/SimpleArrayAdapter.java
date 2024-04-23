package de.christian2003.budgetplan.utils.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import de.christian2003.budgetplan.R;
import de.christian2003.budgetplan.models.data.FinanceTransaction;


public class SimpleArrayAdapter extends RecyclerView.Adapter<SimpleArrayAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;

        private final TextView description;

        private final View itemView;


        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);
            this.itemView = itemView;
        }


        public TextView getName() {
            return name;
        }

        public TextView getDescription() {
            return description;
        }

        public View getItemView() {
            return itemView;
        }

    }


    private final List<FinanceTransaction> data;


    public SimpleArrayAdapter(List<FinanceTransaction> data) throws NullPointerException {
        if (data == null) {
            throw new NullPointerException();
        }
        this.data = data;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_simple, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FinanceTransaction transaction = data.get(position);
        holder.getName().setText(transaction.getName());
        holder.getDescription().setText(transaction.getDescription() == null ? "" : transaction.getDescription());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public List<FinanceTransaction> getData() {
        return data;
    }

}
