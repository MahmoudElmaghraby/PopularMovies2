package com.example.maghraby.PopularMovies2.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.maghraby.PopularMovies2.Model.TrailerModel;
import com.example.maghraby.PopularMovies2.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TrailerAdapter extends BaseAdapter {

    private final Context context;
    private final LayoutInflater inflater;
    private final TrailerModel mLock = new TrailerModel();

    private List<TrailerModel> trailerList;

    public TrailerAdapter(Context context, List<TrailerModel> trailerList) {
        this.context = context;
        this.trailerList = trailerList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void add(TrailerModel object) {
        synchronized (mLock) {
            trailerList.add(object);
        }
        notifyDataSetChanged();
    }

    public void clear() {
        synchronized (mLock) {
            trailerList.clear();
        }
        notifyDataSetChanged();
    }

    public Context getContext() {
        return context;
    }

    @Override
    public int getCount() {
        return trailerList.size();
    }

    @Override
    public TrailerModel getItem(int position) {
        return trailerList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder;

        if (view == null) {
            view = inflater.inflate(R.layout.trailer_item, parent, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }

        final TrailerModel trailerModel = getItem(position);

        viewHolder = (ViewHolder) view.getTag();

        String thumbnailPath= "http://img.youtube.com/vi/" + trailerModel.getKey() + "/0.jpg";
        Picasso.with(context).load(thumbnailPath).into(viewHolder.imageView);

        viewHolder.tName.setText(trailerModel.getName());

        return view;
    }

    public static class ViewHolder {
        public final ImageView imageView;
        public final TextView tName;

        public ViewHolder(View view) {
            imageView = (ImageView) view.findViewById(R.id.trailer_image);
            tName = (TextView) view.findViewById(R.id.trailer_text);
        }
    }
}
