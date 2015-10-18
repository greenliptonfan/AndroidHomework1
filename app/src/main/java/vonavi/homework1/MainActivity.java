package vonavi.homework1;

import android.app.ListActivity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends ListActivity {
    String[] numeros = new String[1000];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String st = "";

        for (int i = 0; i<1000; i++) {
            String h = new Integer(i+1).toString();
            if (h.length() == 1) {
                int adr = getResources().getIdentifier("s" + h.charAt(0), "string", getPackageName());
                st = this.getResources().getString(adr);
            } else {
                if ((i+1) < 20) {
                    int adr = getResources().getIdentifier("s" + h, "string", getPackageName());
                    st = this.getResources().getString(adr);
                }
                else {
                    if ((i+1) % 100 == 0) {
                        int adr = getResources().getIdentifier("s" + h, "string", getPackageName());
                        st = this.getResources().getString(adr);
                    } else {
                        if ((i+1) % 10 == 0) {
                            if (h.length()==2) {
                                int adr = getResources().getIdentifier("s" + h, "string", getPackageName());
                                st = this.getResources().getString(adr);
                            } else {
                                    int adr = getResources().getIdentifier("s" + h.charAt(0) + "00", "string", getPackageName());
                                    st = this.getResources().getString(adr);
                                    adr = getResources().getIdentifier("s" + h.charAt(1) + "0", "string", getPackageName());
                                    st = st + " " + this.getResources().getString(adr);
                            }
                        } else {
                            if (h.length() == 2) {
                                int adr = getResources().getIdentifier("s" + h.charAt(0) + "0" , "string", getPackageName());
                                st = this.getResources().getString(adr);
                                adr = getResources().getIdentifier("s" + h.charAt(1), "string", getPackageName());
                                st = st + " " + this.getResources().getString(adr);
                            } else {
                                if ( h.charAt(1) == '0') {
                                    int adr = getResources().getIdentifier("s" + h.charAt(0) + "00", "string", getPackageName());
                                    st = this.getResources().getString(adr);
                                    adr = getResources().getIdentifier("s" + h.charAt(2), "string", getPackageName());
                                    st = st + " " + this.getResources().getString(adr);
                                } else {
                                    if ( h.charAt(1) == '1') {
                                        int adr = getResources().getIdentifier("s" + h.charAt(0) + "00", "string", getPackageName());
                                        st = this.getResources().getString(adr);
                                        adr = getResources().getIdentifier("s" + h.charAt(1) + h.charAt(2), "string", getPackageName());
                                        st = st + " " + this.getResources().getString(adr);
                                    } else {
                                        int adr = getResources().getIdentifier("s" + h.charAt(0) + "00", "string", getPackageName());
                                        st = this.getResources().getString(adr);
                                        adr = getResources().getIdentifier("s" + h.charAt(1) + "0", "string", getPackageName());
                                        st = st + " " + this.getResources().getString(adr);
                                        adr = getResources().getIdentifier("s" + h.charAt(2), "string", getPackageName());
                                        st = st + " " + this.getResources().getString(adr);
                                    }
                                }
                            }
                        }
                    }
                }
            }

            numeros[i] = st;
        }

        this.setListAdapter(new MyOwnAdapter(
                this, numeros
        ));
    }

    public class MyOwnAdapter extends ArrayAdapter<String> {
        private final Context context;
        private final String[] numeros;

        public MyOwnAdapter(Context context, String[] numeros) {
            super(context, R.layout.mylist, numeros);
            this.context = context;
            this.numeros = numeros;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myList = inflater.inflate(R.layout.mylist, parent, false);
            LinearLayout listItem = (LinearLayout) myList.findViewById(R.id.listItem);
            TextView textView = (TextView) myList.findViewById(R.id.numero);

            textView.setText(numeros[position]);

            if (position % 2 == 0) {
                listItem.setBackgroundColor(getResources().getColor(R.color.white));
            }

            return myList;
        }
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

}