package proj.example.evaluationtask

/**
 * Created by stpl on 5/31/2017.
 */
data class Model(var worldpopulation: MutableList<Data>) {
     data class Data(var rank:Int,var country:String,var population:String,var flag:String)

}