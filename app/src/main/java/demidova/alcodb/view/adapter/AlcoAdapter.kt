package demidova.alcodb.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import demidova.alcodb.databinding.ItemAlcoBinding
import demidova.alcodb.model.AlcoDataObject

class AlcoAdapter(
    private val itemClickListener: (AlcoDataObject) -> Unit
    ) :

    ListAdapter <AlcoDataObject, AlcoAdapter.ViewHolder>(AlcoItemCallback) {

    private var alcoList: List<AlcoDataObject> = arrayListOf()

    internal fun setData(list: List<AlcoDataObject>) {
        this.alcoList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemAlcoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.setInfo(currentList[position])
    }

    inner class ViewHolder(private val vb: ItemAlcoBinding) : RecyclerView.ViewHolder(vb.root) {


        fun setInfo(alco: AlcoDataObject) {
            vb.root.setOnClickListener { itemClickListener(alco) }
            vb.name.text = alco.strDrink
            vb.image.setImageResource(alco.img)
        }
    }
}

object AlcoItemCallback: DiffUtil.ItemCallback<AlcoDataObject>(){
    override fun areItemsTheSame(oldItem: AlcoDataObject, newItem: AlcoDataObject): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: AlcoDataObject, newItem: AlcoDataObject): Boolean {
        return oldItem == newItem
    }

}