package com.onerous.kotlin.seewhat

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.onerous.kotlin.seewhat.inTheaters.InTheatersFragment
import com.onerous.kotlin.seewhat.inTheaters.Top250Fragment
import com.onerous.kotlin.seewhat.zhihu.ZhihuFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mInTheaterFragment: Fragment by lazy { InTheatersFragment.NewInstance() }
    private val mZhihuFragment: Fragment  by lazy { ZhihuFragment.NewInstance() }
    private val mTop250Fragment: Fragment  by lazy { Top250Fragment.NewInstance() }
    private var currentFragment: Fragment? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_intheater -> {
                supportActionBar?.setTitle(R.string.toolbar_title_intheater)
                addorShowFragmentToActivity(supportFragmentManager, R.id.container, mInTheaterFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_top250 -> {
                supportActionBar?.setTitle(R.string.toolbar_title_top250)
                addorShowFragmentToActivity(supportFragmentManager, R.id.container, mTop250Fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_zhihu -> {
                supportActionBar?.setTitle(R.string.toolbar_title_zhihu)
                addorShowFragmentToActivity(supportFragmentManager, R.id.container, mZhihuFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        supportActionBar?.setTitle(R.string.toolbar_title_intheater)


        currentFragment = supportFragmentManager.findFragmentById(R.id.container)
        if (currentFragment == null) addorShowFragmentToActivity(supportFragmentManager, R.id.container, mInTheaterFragment)
    }

    fun addorShowFragmentToActivity(fragmentManager: FragmentManager,
                                    frameId: Int, fragment: Fragment) {
        if (currentFragment == null) {
            addFragmentToActivity(supportFragmentManager, R.id.container, fragment)
            currentFragment = fragment
            return
        } else if (currentFragment == fragment) return
        val transaction = fragmentManager.beginTransaction()
        if (fragment.isAdded) transaction.hide(currentFragment).show(fragment)
        else transaction.hide(currentFragment).add(frameId, fragment)
        transaction.commit()
        currentFragment?.userVisibleHint = false
        currentFragment = fragment
        currentFragment?.userVisibleHint = true
    }

    fun addFragmentToActivity(fragmentManager: FragmentManager,
                              frameId: Int, fragment: Fragment) {

        val transaction = fragmentManager.beginTransaction()
        transaction.add(frameId, fragment)
        transaction.commit()
    }

    override fun onBackPressed() {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        intent.addCategory(Intent.CATEGORY_HOME)
        startActivity(intent)
    }
}
