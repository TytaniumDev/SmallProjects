package tesla.models;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ChargeView extends Activity
{

   private TextView    mPercent;
   private ProgressBar mBar;
   private int mProgressStatus = 100;
   private Handler mHandler = new Handler();

   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.chargeview);
      mPercent = (TextView) findViewById(R.id.textView2);
      mBar = (ProgressBar) findViewById(R.id.progressBar1);
      // Start lengthy operation in a background thread
      new Thread(new Runnable()
      {
         public void run()
         {
            while (mProgressStatus > 0)
            {
               mProgressStatus--;
               try
               {
                  Thread.sleep(500);
               }
               catch (InterruptedException e)
               {
                  e.printStackTrace();
               }

               // Update the progress bar
               mHandler.post(new Runnable()
               {
                  public void run()
                  {
                     mBar.setProgress(mProgressStatus);
                     mPercent.setText(mProgressStatus + "%");
                     AccountView.updateCharge(mProgressStatus);
                  }
               });
            }
         }
      }).start();

   }
}
