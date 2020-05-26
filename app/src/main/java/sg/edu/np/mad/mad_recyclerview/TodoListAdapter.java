package sg.edu.np.mad.mad_recyclerview;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.TodoListViewHolder> {
    List<String> data = new ArrayList<String>(){};
    private OnDeleteListener mOnDeleteListener;

    public class TodoListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txt;
        CheckBox check;
        OnDeleteListener onDeleteListener;

        public TodoListViewHolder(View itemView, OnDeleteListener onDeleteListener) {
            super(itemView);
            txt = itemView.findViewById(android.R.id.text1);
            this.onDeleteListener = onDeleteListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onDeleteListener.onDeleteClick(getAdapterPosition());
        }
    }

    @Override
    public TodoListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View item = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        TodoListViewHolder viewHolder = new TodoListViewHolder(item, mOnDeleteListener);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TodoListViewHolder holder, int position) {
        String s = data.get(position);
        holder.txt.setText(s);

    }

    @Override
    public int getItemCount() {
        return data.size();

    }

    public TodoListAdapter(List<String> input, OnDeleteListener onDeleteListener) {
        this.data = input;
        this.mOnDeleteListener = onDeleteListener;
    }



    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public interface OnDeleteListener {
        void onDeleteClick(int position);
    }
}
