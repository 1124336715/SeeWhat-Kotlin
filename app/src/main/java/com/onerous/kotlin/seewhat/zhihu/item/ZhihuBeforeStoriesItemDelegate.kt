package com.onerous.kotlin.seewhat.zhihu.item

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.onerous.kotlin.seewhat.R
import com.onerous.kotlin.seewhat.data.ZhihuBeforeNewsBean
import com.onerous.kotlin.seewhat.detailActivity.ZhihuStoryDetailActivity
import com.orhanobut.logger.Logger
import com.zhy.adapter.recyclerview.base.ItemViewDelegate
import com.zhy.adapter.recyclerview.base.ViewHolder

/**
 * Created by rrr on 2017/7/19.
 */
class ZhihuBeforeStoriesItemDelegate : ItemViewDelegate<ZhihuItem> {
    override fun isForViewType(item: ZhihuItem?, position: Int): Boolean = item is ZhihuBeforeNewsBean.Stories

    override fun convert(holder: ViewHolder, t: ZhihuItem?, position: Int) {
        val mContext = holder.getConvertView().getContext()

        val storiesEntity = t as ZhihuBeforeNewsBean.Stories

        holder.setText(R.id.story_title_tv, storiesEntity.title)

        if (storiesEntity.images != null) {
            val stroyImg: ImageView = holder.getView(R.id.story_iv)
            //Glide.with(holder.getConvertView().getContext()).load(storiesEntity.getImages().get(0)).into(stroyImg);
            Glide.with(mContext).load(storiesEntity.images.first()).into(stroyImg)
            holder.setVisible(R.id.multi_pic_iv, storiesEntity.images.size > 1)
            holder.setVisible(R.id.story_frame_iv, true)
        } else {
            holder.setVisible(R.id.story_frame_iv, false)
        }

        holder.getConvertView().setOnClickListener(View.OnClickListener {
            Logger.d(storiesEntity.title)
            val intent = Intent(mContext, ZhihuStoryDetailActivity::class.java)
            val bundle=Bundle()
            bundle.putInt("storyId", storiesEntity.id)
            bundle.putString("storyTitle", storiesEntity.title)
            intent.putExtra("story",bundle)
            mContext.startActivity(intent)
        })
    }

    override fun getItemViewLayoutId(): Int = R.layout.item_zhihu_stories_list;

}