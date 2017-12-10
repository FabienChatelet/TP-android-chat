package io.gresse.hugo.tp2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/*import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;*/

import java.util.List;

/**
 * Display chat messages
 * <p>
 * Created by Hugo Gresse on 26/11/2017.
 */

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {


    private List<Message> mData;

    public MessageAdapter(List<Message> data) {
        mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_messages, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setData(List<Message> data) {
        mData = data;
        this.notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView mUserTextView;
        TextView mContentTextView;
        ImageView mGravatarView;

        ViewHolder(View itemView) {
            super(itemView);

            mUserTextView = itemView.findViewById(R.id.userTextView);
            mContentTextView = itemView.findViewById(R.id.contentTextView);
            //mGravatarView = itemView.findViewById(R.id.gravatarView);
        }

        void setData(Message message) {
            mUserTextView.setText(message.userName + ": ");
            mContentTextView.setText(message.content);

            /*
            if (message.userEmail == null){
                mGravatarView.setImageResource(R.drawable.common_google_signin_btn_icon_dark);
            }
            else {
                String md5 = MD5Util.md5(message.userEmail);
                String gravatarURL = "http://www.gravatar.com/avatar/" + md5 + "?s=204&d=404";
                Glide
                        .with(mGravatarView.getContext())
                        .load(gravatarURL)
                        .apply(RequestOptions.circleCropTransform())
                        .into(mGravatarView);
            }*/
        }
    }
}
