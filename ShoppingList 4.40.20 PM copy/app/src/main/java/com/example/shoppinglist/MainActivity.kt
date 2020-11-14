package com.example.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.shoppinglist.adapter.ShoppingListAdapter
import com.example.shoppinglist.data.AppDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var shoppingListAdapter: ShoppingListAdapter

    companion object {
        const val KEY_EDIT = "KEY_EDIT"
        const val KEY_DETAILS="KEY_DETAILS"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
//        setTheme(R.style.AppTheme)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolBar) // tells activity to use toolbar instead of default actionbar


        initRecyclerView()



    }

    private fun initRecyclerView() {
        Thread {
            var shoppingItemList = AppDatabase.getInstance(this).shoppingItemDao().getAllItems()
            runOnUiThread{
                shoppingListAdapter = ShoppingListAdapter(this, shoppingItemList)
                mainRecyclerView.adapter = shoppingListAdapter

//                val touchCallbackList = ShoppingRecyclerTouchCallback(shoppingListAdapter)
//                val itemTouchHelper = ItemTouchHelper(touchCallbackList)
//                itemTouchHelper.attachToRecyclerView(mainRecyclerView)
            }
        }.start()


    }




}