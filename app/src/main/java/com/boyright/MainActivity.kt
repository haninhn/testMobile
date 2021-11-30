package com.boyright

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener{
    var imageList = arrayListOf<Image>()
    private lateinit var recyclerView: RecyclerView
    private var buttonSubmit: Button? = null
    private var Clicked = true
    private var adapter : PhotoAdapter? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = PhotoAdapter(this, imageList)
        recyclerView= findViewById(R.id.Images)
        buttonSubmit= findViewById(R.id.btnTest)
        recyclerView.adapter = adapter
        Images?.layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.HORIZONTAL,false)
        btnTest.setOnClickListener(this)
        addPhoto()

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN

        )
        }

    private fun addPhoto() {
        val image1 = Image(1,R.drawable.boy_left, false,"left", R.drawable.start)
        val image2 =Image(2,R.drawable.boy_left2, false, "right",R.drawable.start)
        val image3 =Image(3,R.drawable.boy_right,false, "left",R.drawable.start)
        val image4 =Image(4,R.drawable.fille_right, false,"right",R.drawable.start)
        imageList.add(image1)
        imageList.add(image2)
        imageList.add(image3)
        imageList.add(image4)

    }


    override fun onClick(v: View?, ) {
        buttonSubmit?.setBackgroundResource(R.drawable.check_hover)


        imageList = adapter?.get() as ArrayList<Image>

        for( i  in 0 until  imageList.size){
            if(imageList[i].selected && imageList[i].orientation == "right"){
                imageList[i].start = R.drawable.correct_1
                adapter?.notifyDataSetChanged()


            }
            else if(imageList[i].selected && imageList[i].orientation != "right"){
                imageList[i].start = R.drawable.wrong_1
            }





}

        adapter = PhotoAdapter(this, imageList)
        recyclerView.adapter = adapter
    }
}