package com.chengjuechao.exoplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    private val fragmentOne = PlayerFragment.newInstance("http://vfx.mtime.cn/Video/2019/02/04/mp4/190204084208765161.mp4")
    private val fragmentTwo = PlayerFragment.newInstance("http://vfx.mtime.cn/Video/2019/03/21/mp4/190321153853126488.mp4")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pageOne()
        findViewById<View>(R.id.btn1).setOnClickListener { pageOne() }
        findViewById<View>(R.id.btn2).setOnClickListener { pageTwo() }
    }

    private fun pageOne() {
        supportFragmentManager.beginTransaction()
            .apply {
                if (fragmentTwo.isAdded) {
                    hide(fragmentTwo)
                }
                if (fragmentOne.isAdded) {
                    show(fragmentOne)
                } else {
                    add(R.id.fl, fragmentOne)
                }
            }.commit()

    }

    private fun pageTwo() {
        supportFragmentManager.beginTransaction()
            .hide(fragmentOne)
            .apply {
                if (fragmentTwo.isAdded) {
                    show(fragmentTwo)
                } else {
                    add(R.id.fl, fragmentTwo)
                }
            }.commit()
    }

}