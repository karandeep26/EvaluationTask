package proj.example.evaluationtask

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import proj.example.evaluationtask.service.IGetData

class MainActivity : AppCompatActivity() {
    lateinit var response: Observable<Model>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        response = ApplicationClass.retrofit?.create(IGetData::class.java)!!.getData()
        response.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    (data) ->
                    data.forEach { item-> print(item.flag) }
                })
    }
}

