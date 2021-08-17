package savchits.com.memory;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LevelPage extends Fragment {
    ArrayList<LevelModel> levelsList;
    View view;
    Button questionBtn;
    TextView levels;
    ImageView level_1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        view = inflater.inflate ( R.layout.levels_activity, container, false);

        questionBtn = view.findViewById (R.id.questionBtn);
        questionBtn.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( getActivity (), QuestionPage.class);
                startActivity(intent);
            }
        } );


        levels = view.findViewById (R.id.levels);

        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        // создаем адаптер
        LevelAdapter adapter = new LevelAdapter(getActivity (), levelsList);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(),recyclerView,
                                              new RecyclerItemClickListener.OnItemClickListener() {
                                                  @Override
                                                  public void onItemClick(View view, final int pos) {
                                                      if(pos == 0){
                                                          Dialog dialog = new Dialog (getActivity ());
                                                          dialog.setContentView (R.layout.dialog_activity);
                                                          dialog.getWindow ().setBackgroundDrawable ( new ColorDrawable (0) );

                                                          Button btn_start;
                                                          btn_start = dialog.findViewById (R.id.startLevel);
                                                          btn_start.setOnClickListener ( new View.OnClickListener () {
                                                              @Override
                                                              public void onClick(View v) {
                                                                  Intent intent = new Intent (v.getContext (),Memorization.class);
                                                                  startActivity ( intent );
                                                              }
                                                          } );

                                                          dialog.getWindow ().setWindowAnimations (R.style.AnimationDialog);
                                                          dialog.show ();
                                                      }else if(pos == 1){
                                                          Dialog dialog = new Dialog (getActivity ());
                                                          dialog.setContentView (R.layout.dialog_activity);
                                                          dialog.getWindow ().setBackgroundDrawable ( new ColorDrawable (0) );

                                                          Button btn_start;
                                                          btn_start = dialog.findViewById (R.id.startLevel);
                                                          btn_start.setOnClickListener ( new View.OnClickListener () {
                                                              @Override
                                                              public void onClick(View v) {
                                                                  Intent intent = new Intent (v.getContext (),Memorization.class);
                                                                  startActivity ( intent );
                                                              }
                                                          } );

                                                          dialog.getWindow ().setWindowAnimations (R.style.AnimationDialog);
                                                          dialog.show ();
                                                      }
                                                  }

                                                  @Override
                                                  public void onLongItemClick(View view, int pos) {

                                                  }
                                              })
                                           );
        setInitialData();



        return view;
    }
    private void setInitialData(){

        levelsList.add(new LevelModel ("Уровень 1",  R.drawable.level_1));
        levelsList.add(new LevelModel ("Уровень 2",  R.drawable.level_1));
        levelsList.add(new LevelModel ("Уровень 3",  R.drawable.level_1));
        levelsList.add(new LevelModel ("Уровень 4",  R.drawable.level_1));
    }
}




