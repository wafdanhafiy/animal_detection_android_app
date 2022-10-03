package com.tugasakhir.animaldetection.data.source.remote

import com.tugasakhir.animaldetection.data.source.remote.response.*
import com.tugasakhir.animaldetection.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {


    companion object {

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper).apply {
                    instance = this
                }
            }
    }

    fun getAllArticles(callback: LoadArticleCallback) {
        callback.onAllArticleReceived(jsonHelper.loadArticle())
    }

    interface LoadArticleCallback{
        fun onAllArticleReceived(articleResponse: List<ArticleResponse>)
    }

    fun getAllData(callback: LoadDataCallback) {
        callback.onAllDataReceived(jsonHelper.loadData())
    }

    interface LoadDataCallback{
        fun onAllDataReceived(dataResponse: List<DataResponse>)
    }

}