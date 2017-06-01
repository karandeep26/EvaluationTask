package proj.example.evaluationtask

import android.graphics.Typeface
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions



/**
 * Created by stpl on 6/1/2017.
 */
fun ImageView.loadUrl(url:String){
    val option=RequestOptions().fitCenter().centerCrop()
    Glide.with(this).asBitmap().load(url).apply(option).into(this)
}
fun TextView.setFont(font:String){
    this.typeface= Typeface.createFromAsset(this.context.assets,"fonts/$font")
}

