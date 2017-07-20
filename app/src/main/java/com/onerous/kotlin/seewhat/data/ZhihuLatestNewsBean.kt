package com.onerous.kotlin.seewhat.data

import com.onerous.kotlin.seewhat.zhihu.item.ZhihuItem

/**
 * Created by rrr on 2017/7/17.
 */
data class ZhihuLatestNewsBean(var date: String,
                               var stories: List<Stories>,
                               var top_stories: List<TopStories>) : ZhihuItem {
    data class Stories(var type: Int,
                       var id: Int,
                       var ga_prefix: String,
                       var title: String,
                       var multipic: Boolean,
                       var images: List<String>) : ZhihuItem

    data class TopStories(var image: String,
                          var type: Int,
                          var id: Int,
                          var ga_prefix: String,
                          var title: String) : ZhihuItem
}