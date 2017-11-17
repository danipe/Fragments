package mviel.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity implements Fragment2.OnFragmentInteractionListener2,Fragment3.OnFragmentInteractionListener3 {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if(!getFragmentManager().popBackStackImmediate()){
            super.onBackPressed();
        }

    }

    @Override
    public void onFragmentInteraction2(Uri uri) {

    }

    @Override
    public boolean estaFragment3EnActivity() {
       Fragment3 f3= (Fragment3)getFragmentManager().findFragmentById(R.id.canto_inferior_dret);
        if(f3==null)
            return false;
        else
            return true;
    }

    public boolean estaFragment2EnActivity() {
        Fragment2 f3= (Fragment2)getFragmentManager().findFragmentById(R.id.canto_superior_dret);
        if(f3==null)
            return false;
        else
            return true;
    }

    @Override
    public void onFragmentInteraction3(Uri uri) {

    }
}
