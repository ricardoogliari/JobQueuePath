package helloworld.teste.com.jobqueuepath;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.JobManager;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void go(View v){
        JobManager jobManager = new JobManager(this);
        Job job = new MyJob();
        Log.e("JOBQUEUEPATH", "DELAY: " + job.getDelayInMs());
        jobManager.addJobInBackground(job);
    }

}
