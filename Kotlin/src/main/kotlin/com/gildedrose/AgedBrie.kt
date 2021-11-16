package com.gildedrose

class AgedBrie(override val item: Item) : ItemCustom {
    override fun updateItem() {
        item.sellIn--
        if (item.sellIn < 0) item.quality += 2 else item.quality++
        if (item.quality >= 50) item.quality = 50
    }

}