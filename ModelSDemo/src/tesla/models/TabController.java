package tesla.models;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;

public class TabController extends TabActivity {
   private static final int    ADD_ID          = Menu.FIRST;
   private static final int    ACTIVITY_CREATE = 0;
   private static final String TAG             = "TabActivity";

   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.main);

      TabHost tabHost = getTabHost(); // The activity TabHost
      TabHost.TabSpec spec; // Reusable TabSpec for each tab
      Intent intent = null; // Reusable Intent for each tab

      // Create an Intent to launch an Activity for the tab (to be reused)
      intent = new Intent().setClass(this, ChargeView.class);

      // Initialize a TabSpec for each tab and add it to the TabHost
      spec =
         tabHost.newTabSpec("charge")
            .setIndicator(getResources().getString(R.string.charge_tab), getResources().getDrawable(R.drawable.battery))
            .setContent(intent);
      tabHost.addTab(spec);

      // Do the same for the other tabs
      intent = new Intent().setClass(this, LocationView.class);
      spec =
         tabHost.newTabSpec("location")
            .setIndicator(getResources().getString(R.string.location_tab), getResources().getDrawable(R.drawable.location))
            .setContent(intent);
      tabHost.addTab(spec);

      // Do the same for the other tabs
      intent = new Intent().setClass(this, ClimateView.class);
      spec =
         tabHost.newTabSpec("climate")
            .setIndicator(getResources().getString(R.string.climate_tab), getResources().getDrawable(R.drawable.climate))
            .setContent(intent);
      tabHost.addTab(spec);

      // Do the same for the other tabs
      intent = new Intent().setClass(this, AccountView.class);
      spec =
         tabHost.newTabSpec("accounts")
            .setIndicator(getResources().getString(R.string.accounts_tab), getResources().getDrawable(R.drawable.account))
            .setContent(intent);
      tabHost.addTab(spec);

      tabHost.setCurrentTab(0);
      tabHost.setOnTabChangedListener(new OnTabChangeListener() {
         @Override
         public void onTabChanged(String arg0) {

         }
      });
   }

}
