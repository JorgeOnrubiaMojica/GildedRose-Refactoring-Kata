package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        items.forEach {
            if (!isAgedBrie(it.name) && !isBackstagePass(it.name)) {
                if (isQualityOverZero(it.quality) && !isSulfuras(it.name)) {
                    decrementQualityByOne(it)
                }
            } else {
                if (isLessThanMaximumQuality(it)) {
                    incrementQualityByOne(it)
                    if (isBackstagePass(it.name) && isLessThanMaximumQuality(it)) {
                        if (it.sellIn < 11) {
                            incrementQualityByOne(it)
                        }
                        if (it.sellIn < 6) {
                            incrementQualityByOne(it)
                        }
                    }

                }
            }


            if (!isSulfuras(it.name)) {
                it.sellIn = it.sellIn - 1
            }

            if (isExpired(it)) {
                if (!isAgedBrie(it.name)) {
                    if (!isBackstagePass(it.name)) {
                        if (isQualityOverZero(it.quality) && isSulfuras(it.name)) {
                            decrementQualityByOne(it)
                        }
                    } else {
                        setQualityToZero(it)
                    }
                } else {
                    if (isLessThanMaximumQuality(it)) {
                        incrementQualityByOne(it)
                    }
                }
            }
        }


    }

    private fun setQualityToZero(item: Item) {
        item.quality = item.quality - item.quality
    }

    private fun isExpired(item: Item) = item.sellIn < 0

    private fun incrementQualityByOne(item: Item) {
        item.quality++
    }

    private fun isLessThanMaximumQuality(item: Item) = item.quality < 50

    private fun isQualityOverZero(quality: Int) = quality > 0

    private fun decrementQualityByOne(item: Item) {
        item.quality--
    }

    private fun isSulfuras(name: String) = name == "Sulfuras, Hand of Ragnaros"

    private fun isBackstagePass(name: String) = name == "Backstage passes to a TAFKAL80ETC concert"

    private fun isAgedBrie(name: String) = name == "Aged Brie"

}

