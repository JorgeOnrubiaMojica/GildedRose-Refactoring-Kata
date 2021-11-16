package com.gildedrose

class ItemCustomFactory {

    companion object {
        fun create(item: Item): ItemCustom {
            return when (item.name) {
                "Aged Brie" -> AgedBrie(item)
                "Sulfuras, Hand of Ragnaros" -> Sulfuras(item)
                "Backstage passes to a TAFKAL80ETC concert" -> BackstagePass(item)
                else -> NormalItem(item)
            }
        }
    }
}