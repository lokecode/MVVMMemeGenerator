package com.example.httpmethodsretrofitexample.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.httpmethodsretrofitexample.R
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.repository.ViewModel
import com.example.httpmethodsretrofitexample.feature_meme_generator.domain.model.Data_Type
import com.squareup.picasso.Picasso


class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    private var myList = emptyList<Data_Type>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val imageId = holder.itemView.rootView.findViewById<ImageView>(R.id.imageView)
        holder.itemView.rootView.findViewById<TextView>(R.id.textView).text = myList[position].text
        Picasso.get().load(myList[position].image).into(imageId)
        holder.itemView.rootView.findViewById<ImageButton>(R.id.imageButton).setOnClickListener {
            ViewModel().deleteMeme(myList[position].id)
        }
        holder.itemView.rootView.findViewById<ImageButton>(R.id.imageButton2).setOnClickListener {
            ViewModel().updateMeme(myList[position].id)
        }
    }

    fun setData(newList: List<Data_Type>){
        myList = newList
        notifyDataSetChanged()
    }
}