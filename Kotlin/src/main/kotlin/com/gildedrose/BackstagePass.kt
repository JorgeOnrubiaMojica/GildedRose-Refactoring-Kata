package com.gildedrose

class BackstagePass(override val item: Item) : ItemCustom {
    override fun updateItem() {
        item.sellIn--
        if (item.sellIn < 0){
            item.quality = 0
        }
        else if (item.sellIn < 6){
            item.quality += 3
        }
        else if (item.sellIn < 11){
            item.quality += 2
        }
        else{
            item.quality++
        }
    }

}