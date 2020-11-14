package com.example.shoppinglist.data


import androidx.room.*

@Dao
interface ShoppingItemDAO {
    @Query("SELECT * FROM shopping_item")
    fun getAllItems(): List<ShoppingItem>

    @Insert
    fun insertItem(item: ShoppingItem) : Long

    @Delete
    fun deleteItem(item: ShoppingItem)

    @Update
    fun updateItem(item: ShoppingItem)

    @Query("DELETE FROM shopping_item")
    fun deleteAllItems()


}