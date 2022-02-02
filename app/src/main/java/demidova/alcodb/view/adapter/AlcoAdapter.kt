package demidova.alcodb.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import demidova.alcodb.R
import demidova.alcodb.databinding.ItemAlcoBinding
import demidova.alcodb.model.Alco
import demidova.alcodb.presenter.AlcoPresenter
import demidova.alcodb.view.AlcoItemView

class AlcoAdapter(private val presenter: AlcoPresenter.AlcoListPresenter) :
    RecyclerView.Adapter<AlcoAdapter.ViewHolder>() {

    private var alcoList: List<Alco> = arrayListOf()

    internal fun setData(list: List<Alco>) {
        this.alcoList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemAlcoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        ).apply {
            itemView.setOnClickListener { presenter.itemClickListener() }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        presenter.bindView(holder.apply {
            pos = position

        })
    }

    override fun getItemCount(): Int {
        return presenter.getCount()
    }

    inner class ViewHolder(private val vb: ItemAlcoBinding) : RecyclerView.ViewHolder(vb.root),
        AlcoItemView {

        override var pos: Int = -1

        override fun setName(name: String) {
            vb.name.text = name
        }

        override fun setImg(img: Int) {
            vb.image.setImageResource(presenter.alcos[pos].img)
        }
    }
}