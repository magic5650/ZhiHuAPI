package com.shining.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shining.myapplication.R;
import com.shining.myapplication.api.Constants;
import com.shining.myapplication.model.zhuanlan;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016-11-01.
 */

public class zlAdapter extends RecyclerView.Adapter<zlAdapter.zlHolder> {
    private List<zhuanlan> Data;
    private Context mContext;
    private LayoutInflater inflater;

    public zlAdapter(Context context, List<zhuanlan> data){
        this. mContext = context;
        this. Data = data;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getItemCount() {
        return Data.size();
    }

    //填充onCreateViewHolder方法返回的holder中的控件
    @Override
    public void onBindViewHolder(zlHolder holder,final int position) {
        zhuanlan object = Data.get(position);
        holder.zhuanlan_slug.setText(object.getSlug());
        holder.zhuanlan_name.setText(object.getName());
        String followersCount_text = mContext.getResources().getString(R.string.followersCount_text);
        String postsCount_text = mContext.getResources().getString(R.string.postsCount_text);
        holder.zhuanlan_fans_count.setText(object.getFollowersCount() +""+ followersCount_text);
        holder.zhuanlan_article_count.setText(object.getPostsCount() + "" + postsCount_text);
        holder.zhuanlan_intro.setText(object.getDescription());
        String avatarUrl = getAvatarUrl(object.getAvatar().getId(),object.getAvatar().getTemplate(),Constants.IMAGE_SIZE);
        //Picasso.with(mContext).load(avatarUrl).placeholder(R.drawable.zhuanlan_default_pic).into(holder.zhuanlan_avatar);
        Picasso.with(mContext).load(avatarUrl).placeholder(R.drawable.zhuanlan_default_pic)
                .transform(new CircleTransform()).into(holder.zhuanlan_avatar);
    }

    @Override
    public zlHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view = inflater.inflate(R.layout.zhuanlan_item,parent,false);
        return  new zlHolder(view);
    }

    //根据返回的对象生成imageUrl
    public String getAvatarUrl(String id,String template,String size) {
        String[] base_url = template.split("\\{");
        String imageUrl = base_url[0] + id + "_" + size + ".jpg";
        //Log.d(Constants.TAG,"图片网址为"+imageUrl);
        return imageUrl;
    }


    class zlHolder extends RecyclerView.ViewHolder {

        TextView zhuanlan_slug;
        ImageView zhuanlan_avatar;
        TextView zhuanlan_name;
        TextView zhuanlan_fans_count;
        TextView zhuanlan_article_count;
        TextView zhuanlan_intro;

        public zlHolder(View view) {
            super(view);
            zhuanlan_slug =(TextView) view.findViewById(R.id.zhuanlan_slug);
            zhuanlan_avatar = (ImageView) view.findViewById(R.id.zhuanlan_avatar);
            zhuanlan_name = (TextView) view.findViewById(R.id.zhuanlan_name);
            zhuanlan_fans_count = (TextView) view.findViewById(R.id.zhuanlan_fans_count);
            zhuanlan_article_count = (TextView) view.findViewById(R.id.zhuanlan_article_count);
            zhuanlan_intro = (TextView) view.findViewById(R.id.zhuanlan_intro);
        }

    }
}
