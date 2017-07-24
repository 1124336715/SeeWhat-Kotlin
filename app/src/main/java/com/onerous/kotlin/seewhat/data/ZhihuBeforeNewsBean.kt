package com.onerous.kotlin.seewhat.data

import com.onerous.kotlin.seewhat.zhihu.ZhihuMultiItem

/**
 * Created by rrr on 2017/7/19.
 */
data class ZhihuBeforeNewsBean(var date: String,
                               var stories: List<Stories>) {
    data class Stories(var type: Int,
                       var id: Int,
                       var ga_prefix: String,
                       var title: String,
                       var multipic: Boolean,
                       var images: List<String>)
}