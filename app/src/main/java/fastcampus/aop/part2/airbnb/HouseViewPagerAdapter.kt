package fastcampus.aop.part2.airbnb

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fastcampus.aop.part2.airbnb.databinding.ItemHouseDetailForViewpagerBinding

class HouseViewPagerAdapter(val itemClicked: (HouseModel) -> Unit): ListAdapter<HouseModel, HouseViewPagerAdapter.ItemViewHolder>(diffUtil) {

    inner class ItemViewHolder(private val binding: ItemHouseDetailForViewpagerBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(houseModel: HouseModel) {
            binding.titleTextView.text =  houseModel.title
            binding.priceTextView.text = "${houseModel.price}원"

            binding.root.setOnClickListener {
                itemClicked(houseModel)
            }

            Glide
                .with(binding.thumbnailImageView.context)
                .load(houseModel.imgUrl)
                .into(binding.thumbnailImageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(ItemHouseDetailForViewpagerBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        val diffUtil = object: DiffUtil.ItemCallback<HouseModel>() {
            override fun areItemsTheSame(oldItem: HouseModel, newItem: HouseModel): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: HouseModel, newItem: HouseModel): Boolean {
                return oldItem == newItem
            }
        }
    }
}