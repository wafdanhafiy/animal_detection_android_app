package com.tugasakhir.animaldetection.utils

import android.content.Context
import com.tugasakhir.animaldetection.data.source.remote.response.ArticleResponse
import com.tugasakhir.animaldetection.data.source.remote.response.DataResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        }catch (ex: IOException){
            ex.printStackTrace()
            null
        }
    }

    fun loadArticle(): List<ArticleResponse> {
        val list = ArrayList<ArticleResponse>()
        try {

            val responseObject = JSONObject(parsingFileToString("daftarArtikel.json").toString())
            val listArray = responseObject.getJSONArray("article")
            for (i in 0 until listArray.length()){
                val article = listArray.getJSONObject(i)

                val id = article.getString("id")
                val author = article.getString("author")
                val title = article.getString("title")
                val release_date = article.getString("date")
                val description = article.getString("content")
                val imgPath = article.getString("imgUrl")

                val articleResponse = ArticleResponse(id, author, title, description, release_date, imgPath)
                list.add(articleResponse)
            }
        }catch (e: JSONException){
            e.printStackTrace()
        }

        return list
    }

    fun loadData(): List<DataResponse> {
        val list = ArrayList<DataResponse>()
        try {

            val responseObject = JSONObject(parsingFileToString("daftarHewan.json").toString())
            val listArray = responseObject.getJSONArray("data")
            for (i in 0 until listArray.length()){
                val data = listArray.getJSONObject(i)

                val id = data.getString("id")
                val title = data.getString("title")
                val deskripsi1 = data.getString("deskripsi1")
                val deskripsi2 = data.getString("deskripsi2")
                val deskripsi3 = data.getString("deskripsi3")
                val imgPath = data.getString("imgUrl")

                val dataResponse = DataResponse(id, title, deskripsi1, deskripsi2, deskripsi3, imgPath)
                list.add(dataResponse)
            }
        }catch (e: JSONException){
            e.printStackTrace()
        }

        return list
    }

}