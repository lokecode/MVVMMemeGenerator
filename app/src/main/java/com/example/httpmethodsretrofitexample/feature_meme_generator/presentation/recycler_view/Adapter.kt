package com.example.httpmethodsretrofitexample.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.httpmethodsretrofitexample.R
import com.example.httpmethodsretrofitexample.databinding.RowLayoutBinding
import com.example.httpmethodsretrofitexample.feature_meme_generator.di.CallApis
import com.example.httpmethodsretrofitexample.feature_meme_generator.domain.model.MemeModel
import com.example.httpmethodsretrofitexample.feature_meme_generator.presentation.onClickListenerEvents
import com.squareup.picasso.Picasso


class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    private var myList = emptyList<MemeModel>()

    inner class MyViewHolder(val itemBinding: RowLayoutBinding): RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(RowLayoutBinding.inflate((LayoutInflater.from(parent.context))))
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val view = holder.itemBinding
        view.textView.text = myList[position].text
        Picasso.get().load(myList[position].image).into(holder.itemBinding.meme)
        onClickListenerEvents().imageBotton(myList[position].id, view)
        onClickListenerEvents().imageBotton2(myList[position].id, view)
    }

    fun setData(newList: List<MemeModel>){
        myList = newList
        notifyDataSetChanged()
    }
}