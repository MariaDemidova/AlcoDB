package demidova.alcodb.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import demidova.alcodb.databinding.ItemAlcoBinding
import demidova.alcodb.model.Alco

class AlcoAdapter(
    private val itemClickListener: (Alco) -> Unit
    ) :

    ListAdapter <Alco, AlcoAdapter.ViewHolder>(AlcoItemCallback) {

    private var alcoList: List<Alco> = arrayListOf()

    internal fun setData(list: List<Alco>) {
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


        fun setInfo(alco: Alco) {
            vb.root.setOnClickListener { itemClickListener(alco) }
            vb.name.text = alco.name
            vb.image.setImageResource(alco.img)
        }
    }
}

object AlcoItemCallback: DiffUtil.ItemCallback<Alco>(){
    override fun areItemsTheSame(oldItem: Alco, newItem: Alco): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Alco, newItem: Alco): Boolean {
        return oldItem == newItem
    }

}