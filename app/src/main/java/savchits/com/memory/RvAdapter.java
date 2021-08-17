package savchits.com.memory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RvAdapter  extends RecyclerView.Adapter<RvAdapter.ViewHolder> {
    List<String> item;
    Context      context;

    public RvAdapter(List<String> item, Context context) {
        this.item = item;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from ( context ).inflate ( R.layout.list_item, parent, false );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(!(item.get (0).equals(item.get (1).equals(item.get (2).equals(item.get (3).equals(item.get (4).equals(item.get (2))))))))
        {
            holder.tv1.setText ( item.get ( 0 ) );
            holder.tv2.setText ( item.get ( 1 ) );
            holder.tv3.setText ( item.get ( 2 ) );
            holder.tv4.setText ( item.get ( 3 ) );
            holder.tv5.setText ( item.get ( 4 ) );
        }
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv1, tv2, tv3, tv4, tv5;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
            tv3 = itemView.findViewById(R.id.tv3);
            tv4 = itemView.findViewById(R.id.tv4);
            tv5 = itemView.findViewById(R.id.tv5);
        }
    }


}