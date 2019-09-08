package com.team.sear.menews

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class FirstFragment : Fragment() {

    private var v: View? = null

    private var database: FirebaseDatabase? = null
    private var ref: DatabaseReference? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_first, container, false)

        return v
    }



    private fun getNews(title: String,
                        descr: String,
                        imgLink: String,
                        link: String,
                        titleView: TextView,
                        descrView: TextView,
                        imgView: ImageView,
                        webView: WebView,
                        source: String){
        database = FirebaseDatabase.getInstance()
/*        database = FirebaseDatabase.getInstance()
      ref = database!!.reference.child("newsToSource")
            .child("source0")
            .child("title")
            ref!!.addValueEventListener(object: ValueEventListener{
                override fun onCancelled(p0: DatabaseError) {
                }

                override fun onDataChange(p0: DataSnapshot) {
                    val strL = p0.getValue(String::class.java)
                    newsList.add(setNews(strL!!,"DESCRIPTION","","LINK"))
                    setAdapter(newsList)
                }

            })*/
    }
}
