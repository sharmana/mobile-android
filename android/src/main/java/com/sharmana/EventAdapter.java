package com.sharmana;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.sharmana.db.dto.EventDTO;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by MandM on 11.10.2014.
 */
public class EventAdapter extends ArrayAdapter<EventDTO> {

    private static final String LOG_TAG = "com.sharmana.EventAdapter";

    private Typeface font;

    public EventAdapter(Context context, int resource, List<EventDTO> events) {
        super(context, resource, events);
    }

    private Typeface getFont() {
        if (font == null){
            font = Typeface.createFromAsset(getContext().getAssets(), "fonts/framd.ttf");
        }
        return font;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Log.i(LOG_TAG, "View for "+position+" was created");

        Typeface font = getFont();

        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.item_event, null);
        }

        EventDTO event = getItem(position);

        if (event != null) {
            Button bEvent = (Button) view.findViewById(R.id.bEvent);
            bEvent.setTypeface(font);
            bEvent.setText(event.getName());
        }


        return view;
    }
}
