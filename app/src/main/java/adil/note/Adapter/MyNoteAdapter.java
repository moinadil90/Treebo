package adil.note.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import adil.note.Activity.NoteDetails;
import adil.note.R;

public class MyNoteAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {
    public static Context mContext;
    private static String TAG = "MyNoteAdapter";

    public MyNoteAdapter(Context mContext){
        this.mContext           = mContext;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View lView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_note_item, parent, false);
        ViewHolder lViewHolder = new ViewHolder(lView);
        return lViewHolder;
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView mName;
        TextView mdetails;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mName = (TextView) itemView.findViewById(R.id.name);
            mdetails = (TextView) itemView.findViewById(R.id.name_details);
        }

        @Override
        public void onClick(View v)  {
            Intent intent = new Intent(mContext,NoteDetails.class);
            switch (v.getId()) {
                default:
                    mContext.startActivity(intent);
                    break;
            }
        }
    }
    public static class ViewHolderHeader extends RecyclerView.ViewHolder{
        public ViewHolderHeader(View itemView) {
            super(itemView);
        }
    }




}
