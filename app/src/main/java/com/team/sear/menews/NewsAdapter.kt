package com.team.sear.menews

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.Button
import android.widget.TextView
import com.squareup.picasso.Picasso
import uk.co.senab.photoview.PhotoView

class NewsAdapter(private val news: ArrayList<News?>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    private lateinit var itemView: View
    override fun getItemCount() = news.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titletv?.text = news[position]?.title
        holder.descriptiontv?.text = news[position]?.description
/*        Picasso.get().load(news[position]?.imgLink).into(holder.newsImageView)*/
        holder.webNews?.visibility = View.GONE
        holder.backBt?.visibility = View.GONE
        holder.moreLinktv!!.setOnClickListener {

            holder.webNews!!.visibility = View.VISIBLE
            holder.backBt!!.visibility = View.VISIBLE
            holder.webNews!!.settings.javaScriptEnabled
            holder.webNews!!.settings.builtInZoomControls
            holder.webNews!!.settings.supportZoom()
            holder.webNews!!.settings.displayZoomControls
            holder.webNews!!.settings.loadWithOverviewMode
            try {
                holder.webNews!!.loadUrl(news[position]!!.link)
            } catch (e: Exception) {
            }

            holder.titletv?.visibility = View.GONE
            holder.descriptiontv?.visibility = View.GONE
            holder.moreLinktv?.visibility = View.GONE
        }

        holder.backBt!!.setOnClickListener {
            holder.titletv?.visibility = View.VISIBLE
            holder.descriptiontv?.visibility = View.VISIBLE
            holder.moreLinktv?.visibility = View.VISIBLE
            holder.webNews!!.visibility = View.GONE
            holder.backBt!!.visibility = View.GONE
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titletv: TextView? = null
        var newsImageView: PhotoView? = null
        var descriptiontv: TextView? = null
        var moreLinktv: Button? = null
        var webNews: WebView? = null
        var backBt: Button? = null

        init {
            titletv = itemView.findViewById(R.id.title)
            newsImageView = itemView.findViewById(R.id.newsImgView)
            descriptiontv = itemView.findViewById(R.id.descr)
            moreLinktv = itemView.findViewById(R.id.openLinkBt)
            webNews = itemView.findViewById(R.id.newsWebView)
            backBt = itemView.findViewById(R.id.backBt)
        }
    }
}