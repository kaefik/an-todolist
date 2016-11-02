package ru.isaifutdinov.kaefik.an_todolist.Adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import ru.isaifutdinov.kaefik.an_todolist.R;
import ru.isaifutdinov.kaefik.an_todolist.Task.TaskToDo;

public class TaskRecyclerAdapter extends RecyclerView.Adapter<TaskRecyclerAdapter.ViewHolder> {

    private List<TaskToDo> mDataSet;  // TODO: поменять на список задач

    private final OnItemClickListener listener;


    public interface OnItemClickListener {
        void onItemClick(TaskToDo item);
    }


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        protected TextView mTitleTaskTextView; // заголовок задачи
        protected CheckBox mCheckTaskCheckBox; // признак выполнения задачи
//        protected TextView mDataCreateTaskTextView; // дата создания задачи

        public ViewHolder(View view) {
            super(view);
            mTitleTaskTextView = (TextView) view.findViewById(R.id.TitleTaskTextView);
            mCheckTaskCheckBox = (CheckBox) view.findViewById(R.id.CheckTaskCheckBox);
//            mDataCreateTaskTextView = (TextView) view.findViewById(R.id.DataCreateTaskTextView);
        }

        public void bind(final TaskToDo item, final OnItemClickListener listener) {

            mTitleTaskTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }

    public TaskRecyclerAdapter(List<TaskToDo> myDataset, OnItemClickListener listener) {
        this.mDataSet = myDataset;
        this.listener = listener;
    }


    // Create new views (invoked by the layout manager)
    @Override
    public TaskRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                  int viewType) {
//        Log.i(AddNewCityActivity.TAG_SERVICE, " onCreateViewHolder -> ");
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout. item_recyclerview, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
//        Log.i(AddNewCityActivity.TAG_SERVICE, " onBindViewHolder mDataSet -> " + mDataSet.toString());
        TaskToDo dataProvider = mDataSet.get(position);
//        Log.i(AddNewCityActivity.TAG_SERVICE, " onBindViewHolder -> " + dataProvider);

//        holder.mNameCityTextView.setText(dataProvider);
        holder.mTitleTaskTextView.setText(dataProvider.getTitle());
        holder.mCheckTaskCheckBox.setChecked(dataProvider.isCheck());
//        holder.mDataCreateTaskTextView.setText(dataProvider.getDateToDoCreate().toString());

        holder.bind(dataProvider, listener);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {

//        Log.i(AddNewCityActivity.TAG_SERVICE, " getItemCount()  -> mDataSet.size() " + Integer.toString(mDataSet.size()));
        return mDataSet.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}