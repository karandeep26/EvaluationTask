package proj.example.evaluationtask

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import kotlinx.android.synthetic.main.item_view.view.*

/**
 * Created by stpl on 5/31/2017.
 */
class DataAdapter(var listener: OnClickListener) : RecyclerView.Adapter<DataAdapter.Holder>() {
    var dataList: MutableList<Model.Data>? = null


    interface OnClickListener {
        fun onClick(url: String, image: ImageView)
    }

    override fun getItemCount(): Int {
        if (dataList != null) {
            dataList?.let { dataList -> return dataList.size }
        }
        return 0
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindView(dataList!![position], listener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false))

    }

    fun setList(dataList: MutableList<Model.Data>?) {
        this.dataList = dataList


    }


    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val light="Montserrat-Light.otf"
        val regular="Montserrat-Regular.otf"
        fun bindView(item: Model.Data, listener: OnClickListener) {
            itemView.country_value.text = "  "+item.country
            itemView.country_label.setFont(regular)
            itemView.country_value.setFont(light)
            itemView.population_value.text ="  "+ item.population
            itemView.population_value.setFont(light)
            itemView.population_label.setFont(regular)
            itemView.rank_value.text ="  "+ item.rank.toString()
            itemView.rank_value.setFont(light)
            itemView.rank_label.setFont(regular)
            itemView.flag.loadUrl(item.flag)
            itemView.flag.setOnClickListener({
                listener.onClick(item.flag, itemView.flag)
            }
            )
        }
    }
}