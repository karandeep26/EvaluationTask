package proj.example.evaluationtask

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.ImageView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import proj.example.evaluationtask.service.IGetData
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var response: Observable<Response<Model>>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        val adapter = DataAdapter(object : DataAdapter.OnClickListener {
            override fun onClick(url: String,image:ImageView) {
                val intent=Intent(this@MainActivity,FullImageActivity::class.java)
                intent.putExtra("url",url)
                val options=ActivityOptionsCompat.makeSceneTransitionAnimation(this@MainActivity,image,url)
                ActivityCompat.startActivity(this@MainActivity,intent,options.toBundle())
            }
        })
        recyclerView.adapter = adapter
        var progressDialog=ProgressDialog.show(this,"Loading","")
        progressDialog.setCanceledOnTouchOutside(false)

        response = ApplicationClass.retrofit.create(IGetData::class.java).getData()
        response.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribe({ body ->
                    if (body.isSuccessful) {
                        val list = body.body()?.worldpopulation
                        adapter.setList(list)
                        adapter.notifyDataSetChanged()
                    }
                    progressDialog.dismiss()
                },{
                    progressDialog.dismiss()
                })
    }
}



