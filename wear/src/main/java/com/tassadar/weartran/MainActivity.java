package com.tassadar.weartran;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.wearable.view.CurvedChildLayoutManager;
import android.support.wearable.view.WearableRecyclerView;

public class MainActivity extends Activity implements ItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WearableRecyclerView v = (WearableRecyclerView)findViewById(R.id.stationList);
        v.setCenterEdgeItems(true);
        v.setLayoutManager(new CurvedChildLayoutManager(this));
        v.setAdapter(new ConnectionsAdapter(this));
    }

    @Override
    public void onItemClick(RecyclerView.ViewHolder viewHolder) {
        ConnectionsAdapter.ConnectionViewHolder h = (ConnectionsAdapter.ConnectionViewHolder) viewHolder;

        Intent intent = new Intent(this, DeparturesActivity.class);
        intent.putExtra("connection", h.getConnection());
        startActivity(intent);
    }
}
