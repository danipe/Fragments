package mviel.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class Fragment1 extends Fragment {
    private RelativeLayout layoutF1;
    private FragmentManager fm;
    private FragmentTransaction ft;

    public Fragment1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_main, container, false);
        layoutF1 = (RelativeLayout) v.findViewById(R.id.layoutF1);

        layoutF1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Has fet click en Fragment1",Toast.LENGTH_SHORT).show();
                fm = getFragmentManager();
                ft = fm.beginTransaction();
                ft.add(R.id.canto_superior_dret,Fragment2.newInstance("",""));
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        layoutF1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Fragment f2 = getFragmentManager().findFragmentById(R.id.canto_superior_dret);
                Fragment f3 = getFragmentManager().findFragmentById(R.id.canto_inferior_dret);
                Fragment2.clicks=0;
                if(f2!=null) {
                    fm.popBackStack();
                    Toast.makeText(getContext(),"Eliminamos fragment 2", Toast.LENGTH_SHORT).show();
                }
                if(f3!=null) {
                    fm.popBackStack();
                    Toast.makeText(getContext(),"Eliminamos fragment 3", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
        return v;
    }
}
