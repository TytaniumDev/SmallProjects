package tesla.models;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;

public class MapOverlay extends ItemizedOverlay<OverlayItem> {

   private ArrayList<OverlayItem> mOverlays     = new ArrayList<OverlayItem>();
   private static final int       ACTIVITY_EDIT = 1;
   private static final String    TAG           = "MapOverlay";
   private Context                mContext;
   private boolean                mClickable;

   public MapOverlay(Drawable defaultMarker) {
      super(boundCenter(defaultMarker));
   }

   public MapOverlay(Drawable defaultMarker, Context context) {
      super(boundCenter(defaultMarker));
      mContext = context;
   }

   @Override
   protected OverlayItem createItem(int i) {
      return mOverlays.get(i);
   }

   @Override
   public int size() {
      return mOverlays.size();
   }

   public void addOverlay(OverlayItem overlay) {
      mOverlays.add(overlay);
      populate();
   }

   //Disable shadow
   @Override
   public void draw(Canvas canvas, MapView mapView, boolean shadow) {
      if(!shadow){
         super.draw(canvas, mapView, false);
      }
   }
}
