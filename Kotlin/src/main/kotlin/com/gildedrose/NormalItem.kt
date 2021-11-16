package com.gildedrose

class NormalItem(override val item: Item) : ItemCustom {
    override fun updateItem() {
        item.sellIn--
        item.quality--
        if (item.quality < 0) item.quality = 0
    }

}