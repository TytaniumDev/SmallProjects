package tesla.models;

import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.location.Criteria;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class LocationView extends MapActivity
{
   private static final double COORDSCALE = 1e6;
   private MapView             mMapView;
   private ImageButton         mCenterButton;
   private Button              mToggleButton;

   @Override
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.locationview);
      mMapView = (MapView) findViewById(R.id.mapview);
      mMapView.setBuiltInZoomControls(true);
      mCenterButton = (ImageButton) findViewById(R.id.centerButton);
      mCenterButton.setOnClickListener(new OnClickListener()
      {
         @Override
         public void onClick(View arg0)
         {
            centerMap();
         }
      });
      mToggleButton = (Button) findViewById(R.id.mapToggleButton);
      mToggleButton.setOnClickListener(new OnClickListener()
      {
         @Override
         public void onClick(View arg0)
         {
            mMapView.setSatellite(!mMapView.isSatellite());
         }
      });
      centerMap();
   }

   @Override
   protected boolean isRouteDisplayed()
   {
      return false;
   }

   private void centerMap()
   {
      mMapView.getOverlays().clear();
      List<Overlay> mapOverlays = mMapView.getOverlays();
      Drawable drawable = this.getResources().getDrawable(R.drawable.blue_dot);
      MapOverlay itemizedoverlay = new MapOverlay(drawable, this);
      LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
      GeoPoint initGeoPoint = new GeoPoint(
            (int) (lm.getLastKnownLocation(
                  lm.getBestProvider(new Criteria(), true)).getLatitude() * COORDSCALE),
            (int) (lm.getLastKnownLocation(
                  lm.getBestProvider(new Criteria(), true)).getLongitude() * COORDSCALE));
      OverlayItem overlayItem = new OverlayItem(initGeoPoint, "", "");
      itemizedoverlay.addOverlay(overlayItem);
      mapOverlays.add(itemizedoverlay);
      mMapView.getController().animateTo(initGeoPoint);
   }
}
