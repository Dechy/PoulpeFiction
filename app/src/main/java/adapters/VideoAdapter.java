package adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.ecm.clement.poulpefiction.R;
import com.ecm.clement.poulpefiction.activity.MainNavigationActivity;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.SimpleViewHolder> {
    private Context context;

    public VideoAdapter(Context context){
        this.context = context;
    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {
        public final VideoView videoView;

        public SimpleViewHolder(View view) {
            super(view);
            videoView = (VideoView) view.findViewById(R.id.videoView);
        }
    }

    @Override
    public VideoAdapter.SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(this.context).inflate(R.layout.film_video, parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VideoAdapter.SimpleViewHolder holder, int position) {

        //TODO: fix some shit here. Register @ google devconsole and use youtubeAPI?
        String url = "rtsp://v6.cache4.c.youtube.com/" + MainNavigationActivity.filmSelected.getVideos().get(position).getUrl() + "/0/0/0/video.3gp";
        MediaController mediaController= new MediaController(this.context);
        mediaController.setAnchorView(holder.videoView);
        Uri uri= Uri.parse(url);
        holder.videoView.setMediaController(mediaController);
        holder.videoView.setVideoURI(uri);
        holder.videoView.requestFocus();

        holder.videoView.start();
        Log.d("BLEH BLEH BLEH", url);

    }

    @Override
    public int getItemCount() {
        return MainNavigationActivity.filmSelected.getVideos().size();
    }
}