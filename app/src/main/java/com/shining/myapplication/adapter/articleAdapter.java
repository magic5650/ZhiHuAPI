package com.shining.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shining.myapplication.common.CommonMethod;
import com.shining.myapplication.R;
import com.shining.myapplication.api.Constants;
import com.shining.myapplication.model.article;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Administrator on 2016-11-03.
 */

public class articleAdapter extends RecyclerView.Adapter<articleAdapter.articleHolder> {

    private List<article> Data;
    private Context mContext;
    private LayoutInflater inflater;

    public articleAdapter(Context context, List<article> data){
        this.mContext = context;
        this.Data = data;
        inflater = LayoutInflater.from(mContext);
    }
    public articleAdapter(){

    }

    @Override
    public int getItemCount() {
        return Data.size();
    }

    @Override
    public articleHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = inflater.inflate(R.layout.article_item,parent,false);
        return  new articleHolder(view);
    }

    @Override
    public void onBindViewHolder(articleHolder holder,final int position) {
        article object = Data.get(position);
        holder.article_name.setText(object.getTitle());
        holder.article_content.setText(getContent(object.getContent()));
        holder.article_author.setText(object.getAuthor().getName());
        holder.article_likesCount.setText(object.getLikesCount()+""+"赞");
        holder.article_commentsCount.setText(object.getCommentsCount()+""+"评论");
        holder.article_create_time.setText(getPublishedText(object.getPublishedTime()));

        holder.article_pic.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (object.getTitleImage() == null || object.getTitleImage().equals("")){
            holder.article_pic.setImageResource(R.drawable.article_default_pic);
        }
        else {
            String ImageUrl = object.getTitleImage().replace("r.jpg", "b.jpg");
            Log.d(Constants.TAG,ImageUrl);
            Picasso.with(mContext)
                    .load(ImageUrl)
                    .placeholder(R.drawable.article_default_pic)
                    .error(R.drawable.article_default_pic)
                    .into(holder.article_pic);
        }
    }

    class articleHolder extends RecyclerView.ViewHolder {

        ImageView article_pic;
        TextView article_name;
        TextView article_content;
        TextView article_author;
        TextView article_create_time;
        TextView article_likesCount;
        TextView article_commentsCount;

        public articleHolder(View view) {
            super(view);
            article_name =(TextView) view.findViewById(R.id.article_name);
            article_pic = (ImageView) view.findViewById(R.id.article_pic);
            article_content = (TextView) view.findViewById(R.id.article_content);
            article_author = (TextView) view.findViewById(R.id.article_author);
            article_create_time = (TextView) view.findViewById(R.id.article_create_time);
            article_likesCount = (TextView) view.findViewById(R.id.article_likesCount);
            article_commentsCount = (TextView) view.findViewById(R.id.article_commentsCount);
        }

    }


/*     根据返回的对象获取日期
     publishedTime : 2016-04-06T11:56:11+08:00*/
    private String getPublishedText(String publishedTime) {
        String time = publishedTime.substring(0,19).replace("T"," ");
        SimpleDateFormat format =  new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss",new Locale("zh","CN"));
        try {
            Date date = format.parse(time);
            return CommonMethod.getStandardDate(date.getTime());
        }catch (Exception e){
            e.printStackTrace();
            return "未知";
        }
    };

/*    根据返回Content的html内容转换成文本*/
    private String getContent(String html) {
        String text= CommonMethod.getContent(html);
        int length = text.length();
        if (length > 50){
            return text.substring(0,50) + "...";
        }
        else {
            return text + "...";
        }
    };


/*    public String getImageUrl(String Url) {
        String url1 = Url.substring(0,Url.length()-5);
        String imageUrl = url1 + "b.jpg";
        return imageUrl;
    }*/

}
