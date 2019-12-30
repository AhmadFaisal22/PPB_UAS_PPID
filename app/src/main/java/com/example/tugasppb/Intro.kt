package com.example.tugasppb

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.*
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.tugasppb.utils.PrefManager
import kotlinx.android.synthetic.main.activity_intro.*

class Intro : AppCompatActivity() {
    var myViewPagerAdapter: MyViewPagerAdapter? = null
    var dots: ArrayList<TextView> = ArrayList()
    var layouts: ArrayList<Int> = ArrayList()
    var prefManager: PrefManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prefManager = PrefManager(this)
        prefManager!!.showAppIntro = true
        if (!prefManager!!.showAppIntro) {
            launchHomeScreen()
            finish()
        }
        setContentView(R.layout.activity_intro)

        layouts.add(R.layout.intro_slide1)
        layouts.add(R.layout.intro_slide2)
        layouts.add(R.layout.intro_slide3)

        addBottomDots(0)
        changeStatusBarColor()
        viewPagerInitial()
        initialButton()
    }

    private fun initialButton() {
        btn_skip.setOnClickListener(View.OnClickListener {
            launchHomeScreen()
        })
        btn_next!!.setOnClickListener(View.OnClickListener {
            val current = getItem(+1)
            if (current < layouts!!.size) { // move to next screen
                view_pager!!.currentItem = current
            } else {
                launchHomeScreen()
            }
        })
    }

    private fun viewPagerInitial() {
        myViewPagerAdapter = MyViewPagerAdapter()
        view_pager.adapter = myViewPagerAdapter
        view_pager.addOnPageChangeListener(viewPagerPageChangeListener)
    }

    private fun addBottomDots(currentPage: Int) {
        dots = ArrayList()
        layouts.forEach {
            dots.add(TextView(this))
        }
        layoutDots!!.removeAllViews()
        for (i in dots.indices) {
            dots[i].text = Html.fromHtml("&#8226;")
            dots[i].textSize = 35f
            dots[i].setTextColor(ContextCompat.getColor(this, R.color.dot_light))
            layoutDots!!.addView(dots[i])
        }
        if (dots.size > 0) dots[currentPage].setTextColor(
            ContextCompat.getColor(
                this,
                R.color.dot_dark
            )
        )
    }

    private fun getItem(i: Int): Int {
        return view_pager.currentItem + i
    }

    private fun launchHomeScreen() {
//        prefManager!!.showAppIntro = false
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    var viewPagerPageChangeListener: OnPageChangeListener = object : OnPageChangeListener {
        override fun onPageSelected(position: Int) {
            addBottomDots(position)
            if (position == layouts.size - 1) {
                btn_next.setText(getString(R.string.start))
                btn_skip.setVisibility(View.GONE)
            } else {
                btn_next.setText(getString(R.string.next))
                btn_skip.setVisibility(View.VISIBLE)
            }
        }

        override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {}
        override fun onPageScrollStateChanged(arg0: Int) {}
    }

    /**
     * Making notification bar transparent
     */
    private fun changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window: Window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.setStatusBarColor(Color.TRANSPARENT)
        }
    }

    /**
     * View pager adapter
     */
    inner class MyViewPagerAdapter : PagerAdapter() {
        private var layoutInflater: LayoutInflater? = null
        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            layoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val view = layoutInflater!!.inflate(layouts[position], container, false)
            container.addView(view)
            return view
        }

        override fun getCount(): Int {
            return layouts.size
        }

        override fun isViewFromObject(view: View, obj: Any): Boolean {
            return view === obj
        }

        override fun destroyItem(
            container: ViewGroup,
            position: Int,
            `object`: Any
        ) {
            val view = `object` as View
            container.removeView(view)
        }
    }
}