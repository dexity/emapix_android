package com.emapix.layouts;

import com.emapix.R;
import com.google.android.maps.GeoPoint;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ViewBubble extends MainView 
{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Add bubble
        GeoPoint point	= new GeoPoint(32818062,-117269440);
        LinearLayout bubble	= bubbleFactory(R.layout.test_view_bubble, point);
        // Set text
    	TextView tv = (TextView)bubble.findViewById(R.id.locationname);
    	tv.setText(String.format("> %f; %f", point.getLatitudeE6()*1E-6, point.getLongitudeE6()*1E-6));
        
    	TextView tvd = (TextView)bubble.findViewById(R.id.description);
    	tvd.setText("A near-normal Atlantic hurricane season is expected this year, with nine to 15 named storms and four to eight hurricanes, the National Oceanic.");//"Planning to hike in this place ...");
        
        if (Exchanger.mMapView.findViewById(bubble.getId()) == null)
        	Exchanger.mMapView.addView(bubble);
        bubble.setVisibility(View.VISIBLE);
    }
}