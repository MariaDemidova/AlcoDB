package demidova.alcodb.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import demidova.alcodb.R
import demidova.alcodb.model.Alco

class AlcoAdapter() : RecyclerView.Adapter<AlcoAdapter.ViewHolder>() {

    var listener: OnItemViewClickListener? = null

    private var alcoList: List<Alco> = arrayListOf()

    internal fun setData(list: List<Alco>){
        this.alcoList = list
        notifyDataSetChanged()
    }

    inner class ViewHolder( itemView: View) : RecyclerView.ViewHolder(itemView) {
        var  alcoName: TextView = itemView.findViewById(R.id.name)
        var  alcoImg: ImageView = itemView.findViewById(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_alco, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.alcoName.text = alcoList[position].name
        holder.alcoImg.setImageResource(alcoList[position].img)

        holder.itemView.setOnClickListener {
            listener?.onItemClick(alcoList[position], position)

        }
    }

    override fun getItemCount(): Int {
        return alcoList.size
    }

    fun interface OnItemViewClickListener {
        fun onItemClick(alco: Alco, position: Int)
    }
}