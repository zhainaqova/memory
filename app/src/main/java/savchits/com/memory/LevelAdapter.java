package savchits.com.memory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LevelAdapter extends RecyclerView.Adapter<LevelAdapter.MyViewHolder>{
LayoutInflater inflater;
private List<LevelModel> levels;


public class MyViewHolder extends RecyclerView.ViewHolder  {
    public ImageView photoView;
    public TextView  levelView;

    public MyViewHolder(View v){
        super(v);
        photoView = v.findViewById ( R.id.imageView);
        levelView = v.findViewById ( R.id.textView);

    }

}
    public LevelAdapter(Context context, List<LevelModel>levels){
        this.levels = levels;
        this.inflater = LayoutInflater.from(context);


    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView;
        itemView = LayoutInflater.from (parent.getContext () ).inflate( R.layout.levels_info, parent, false );

        return new MyViewHolder(itemView);
    }

    @Override
    public void  onBindViewHolder(final LevelAdapter.MyViewHolder holder, int position) {
        LevelModel level =levels.get(position);
        holder.levelView.setText (level.getLevel());
        holder.photoView.setImageResource (level.getPhoto());
    }
    @Override
    public int getItemCount(){
        return levels.size ();
    }

}
