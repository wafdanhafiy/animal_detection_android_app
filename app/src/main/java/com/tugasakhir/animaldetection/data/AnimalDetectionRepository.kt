package com.tugasakhir.animaldetection.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tugasakhir.animaldetection.data.source.local.entity.ArticleEntity
import com.tugasakhir.animaldetection.data.source.local.entity.DataEntity
import com.tugasakhir.animaldetection.data.source.remote.RemoteDataSource
import com.tugasakhir.animaldetection.data.source.remote.response.ArticleResponse
import com.tugasakhir.animaldetection.data.source.remote.response.DataResponse

class AnimalDetectionRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    IAnimalDetectionRepository {
    companion object {
        @Volatile
        private var instance: AnimalDetectionRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): AnimalDetectionRepository =
            instance ?: synchronized(this) {
                instance ?: AnimalDetectionRepository(remoteDataSource).apply {
                    instance = this
                }
            }
    }

    override fun getAllArticles(): LiveData<List<ArticleEntity>>{
        val articleResult = MutableLiveData<List<ArticleEntity>>()
        remoteDataSource.getAllArticles(object : RemoteDataSource.LoadArticleCallback {
            override fun onAllArticleReceived(articleResponse: List<ArticleResponse>) {
                val articleList = ArrayList<ArticleEntity>()
                for (response in articleResponse) {
                    val article = ArticleEntity(response.id,
                        response.author,
                        response.title,
                        response.description,
                        response.release_date,
                        response.imgPath)

                    articleList.add(article)
                }
                articleResult.postValue(articleList)
            }
        })


        return articleResult
    }

    override fun getAllData(): LiveData<List<DataEntity>>{
        val dataResult = MutableLiveData<List<DataEntity>>()
        remoteDataSource.getAllData(object : RemoteDataSource.LoadDataCallback {
            override fun onAllDataReceived(dataResponse: List<DataResponse>) {
                val dataList = ArrayList<DataEntity>()
                for (response in dataResponse) {
                    val data = DataEntity(response.id,
                        response.title,
                        response.deskripsi1,
                        response.deskripsi2,
                        response.deskripsi3,
                        response.imgPath)

                    dataList.add(data)
                }
                dataResult.postValue(dataList)
            }
        })

        return dataResult
    }

}