package tesla.models;

import java.lang.reflect.Method;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class ClimateView extends Activity
{
   private ImageView    car;
   private ToggleButton toggle;

   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.climateview);
      Object o = findViewById(R.id.climatePicker);
      Class c = o.getClass();
      try
      {
         Method m = c.getMethod("setRange", int.class, int.class);
         m.invoke(o, 50, 100);
         Method m2 = c.getMethod("setWrapSelectorWheel", boolean.class);
         m2.invoke(c, false);
      }
      catch (Exception e)
      {
         Log.e("", e.getMessage());
      }
      car = (ImageView) findViewById(R.id.imageView1);
      car.requestFocus();
      toggle = (ToggleButton) findViewById(R.id.toggleButton1);
      toggle.setOnClickListener(new OnClickListener()
      {
         @Override
         public void onClick(View arg0)
         {
            if (toggle.isChecked())
            {
               car.setImageResource(R.drawable.teslasideviewac);
            }
            else
            {
               car.setImageResource(R.drawable.teslasideview);
            }
         }
      });
   }
}
