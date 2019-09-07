package com.team.sear.menews

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FirstFragment : Fragment() {

    private var v: View? = null

    @SuppressLint("StaticFieldLeak")
    private lateinit var lessonRecycler: RecyclerView

    private lateinit var newsList: ArrayList<News?>
    private lateinit var lessons: Array<News?>
    private var idLessons: ArrayList<String?>? = null
/*    @SuppressLint("StaticFieldLeak")*/
    /*private lateinit var webChanges: WebView*/


   /* private var database: FirebaseDatabase? = null
    private var ref: DatabaseReference? = null
    private var auth: FirebaseAuth? = null
    private var user: FirebaseUser? = null
    private var authListener: FirebaseAuth.AuthStateListener? = null*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_first, container, false)
        lessonRecycler = v!!.findViewById(R.id.lessonRecycler)
        lessonRecycler.layoutManager = LinearLayoutManager(context)
        setFakeNews()
        return v
    }

    private fun setFakeNews() {
        newsList = ArrayList(13)
        newsList.add(setLesson("TITLE 0","DESCRIPTION 0","","LINK 0"))
        newsList.add(setLesson("TITLE 1","DESCRIPTION 1","","LINK1"))
        newsList.add(setLesson("TITLE 2","DESCRIPTION 2","","LINK2"))
        newsList.add(setLesson("TITLE 3","DESCRIPTION 3","","LINK3"))
        newsList.add(setLesson("TITLE 4","DESCRIPTION 4","","LINK4"))
        newsList.add(setLesson("TITLE 5","DESCRIPTION 5","","LINK5"))
        newsList.add(setLesson("TITLE 6","DESCRIPTION 6","","LINK6"))
        newsList.add(setLesson("TITLE 7","DESCRIPTION 7","","LINK7"))
        newsList.add(setLesson("TITLE 8","DESCRIPTION 8","","LINK8"))
        newsList.add(setLesson("TITLE 9","DESCRIPTION 9","","LINK9"))
        newsList.add(setLesson("TITLE 10","DESCRIPTION 10","","LINK10"))
        newsList.add(setLesson("TITLE 11","DESCRIPTION 11","","LINK11"))
        setAdapter(newsList)
    }
    private fun setLesson(title: String, description: String, imgLink: String, link: String): News {
        val n = News()
        n.title = title
        n.description = description
        n.imgLink = imgLink
        n.link = link
        return n
    }
    private fun setAdapter(lessons: ArrayList<News?>) {
        lessonRecycler.adapter = NewsAdapter(lessons)
    }
}
