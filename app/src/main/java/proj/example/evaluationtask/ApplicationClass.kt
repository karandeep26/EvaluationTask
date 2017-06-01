package proj.example.evaluationtask

import android.app.Application
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by stpl on 5/31/2017.
 */
class ApplicationClass:Application() {

    override fun onCreate() {
        super.onCreate()

    }
    companion object{
        var retrofit=Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("http://www.androidbegin.com/tutorial/").build()
    }
}