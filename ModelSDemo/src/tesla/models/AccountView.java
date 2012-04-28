package tesla.models;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class AccountView extends Activity
{
   private static TextView text;

   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.accountsview);
      text = (TextView) findViewById(R.id.acctchargetext);
   }

   public static void updateCharge(int charge)
   {
      if (text != null)
      {
         text.setText(charge + "% (" + calcCharge(charge, 160) + " Miles)");
      }
   }

   private static String calcCharge(int charge, int maxMiles)
   {
      return ("" + ((charge * maxMiles) / 100));
   }
}
