package helloworld.teste.com.jobqueuepath;

import android.util.Log;

import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;

/**
 * Created by ricardo on 13/07/2015.
 */
public class MyJob extends Job {
    public static final int PRIORITY = 1;
    public int nrASerSorteado = 5;

    public MyJob(){
        super(new Params(1).requireNetwork().persist());
    }

    @Override
    protected void onCancel() {
        Log.e("JOBQUEUEPATH", "OnCancel");
    }

    @Override
    public void onAdded() {
        //tarefa foi salva em disco, ainda não foi executada
        Log.e("JOBQUEUEPATH", "OnAdded");
    }

    @Override
    public void onRun() throws Throwable {
        Log.e("JOBQUEUEPATH", "OnRun");
        int nr = ((int)(Math.random()*10));
        if (nr != nrASerSorteado){
            Log.e("JOBQUEUEPATH", "Nao e o numero certo: "+nr);
            throw new Exception("Número não é o sorteado");
        } else {
            Log.e("JOBQUEUEPATH", "É o número certo!!!!");
        }
    }

    @Override
    protected boolean shouldReRunOnThrowable(Throwable throwable) {
        Log.e("JOBQUEUEPATH", "ShouldReRunOnThrowable");
        return true;
    }
}
