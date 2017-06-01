package proj.example.evaluationtask.service

import io.reactivex.Observable
import proj.example.evaluationtask.Model
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by stpl on 5/31/2017.
 */
interface IGetData {
    @GET("jsonparsetutorial.txt")
    fun getData(): Observable<Response<Model>>
}