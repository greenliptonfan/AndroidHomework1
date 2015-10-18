package vonavi.homework1;

        import android.content.Intent;
        import android.os.Message;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.app.Activity;
        import android.widget.ImageView;
        import android.os.AsyncTask;

        import java.util.concurrent.TimeUnit;

/**
 * Created by Валентин on 11.10.2015.
 */
public class StartActivity extends Activity {
    MyTask mt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


    mt = new MyTask();
    mt.execute();

    }

    @Override
    protected void onDestroy() {
      super.onDestroy();
      mt.cancel(false);
    }

    class MyTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {

        }

        @Override
        protected Void doInBackground(Void... params) {
            try{
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            Intent intent = new Intent(StartActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
