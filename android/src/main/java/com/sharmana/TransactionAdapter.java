package com.sharmana;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.sharmana.db.domain.Event;
import com.sharmana.db.domain.Transaction;
import com.sharmana.db.dto.TransactionDTO;
import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by MandM on 12.10.2014.
 */
public class TransactionAdapter extends ArrayAdapter<Transaction> {

    private static final String LOG_TAG = "TransactionAdapter";

    private Event event;

    Typeface font = null;

    private Typeface getFont() {
        if (font == null){
            font = Typeface.createFromAsset(getContext().getAssets(), "fonts/framd.ttf");
        }
        return font;
    }


    public TransactionAdapter(Context context, int resource, List<Transaction> transactions) {

        super(context, resource, transactions);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.i(LOG_TAG, "View for "+position+" was created");

        Typeface font = getFont();

        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.item_transaction, null);
        }

        Transaction transaction = getItem(position);

        if (event != null) {
            TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            TextView tvTransaction = (TextView) view.findViewById(R.id.tvTransaction);
            tvTitle.setTypeface(font);
            tvTransaction.setTypeface(font);
            tvTitle.setText(transaction.getComment());
            tvTransaction.setText(transaction.getTo() + " - " + transaction.getAmount());
        }


        return view;
    }


}
