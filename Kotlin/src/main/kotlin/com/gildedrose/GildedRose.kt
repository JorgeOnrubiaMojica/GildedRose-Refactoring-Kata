package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        items.forEach { ItemCustomFactory.create(it).updateItem()   }
    }


}

