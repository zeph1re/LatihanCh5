package binar.ganda.latihanch5.Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import binar.ganda.latihanch5.Model.GetAllCountryResponseItem
import binar.ganda.latihanch5.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_country_layout.view.*

class CountryAdapter(private var dataCountry : List<GetAllCountryResponseItem> ): RecyclerView.Adapter<CountryAdapter.ViewHolder>()  {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.item_country_layout, parent, false)
        return ViewHolder(itemview)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.country_name_tv.text = dataCountry[position].name
        holder.itemView.country_capital_tv.text = "Capital: ${dataCountry[position].capital}"
        holder.itemView.country_region_tv.text = "Region: ${dataCountry[position].region}"

        //Menampilkan Flag Country
        Glide.with(holder.itemView.context).load(dataCountry[position].flags.png).into(holder.itemView.country_flag)
    }

    override fun getItemCount(): Int {
        return dataCountry.size
    }
}