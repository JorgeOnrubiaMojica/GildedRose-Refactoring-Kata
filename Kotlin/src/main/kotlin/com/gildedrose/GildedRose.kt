package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        items.forEach {
            if (!isAgedBrie(it.name) && !isBackstagePass(it.name)) {
                if (isQualityOverZero(it.quality) && !isSulfuras(it.name)) {
                    decrementQualityBy(it, 1)
                }
            } else {
                if (isLessThanMaximumQuality(it)) {
                    incrementQualityBy(it, 1)
                    if (isBackstagePass(it.name) && isLessThanMaximumQuality(it)) {
                        if (it.sellIn < 11) {
                            incrementQualityBy(it, 1)
                        }
                        if (it.sellIn < 6) {
                            incrementQualityBy(it, 1)
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
                        if (isQualityOverZero(it.quality)) {
                            if (isSulfuras(it.name)) {
                                decrementQualityBy(it, 1)
                            }
                        }
                    } else {
                        setQualityToZero(it)
                    }
                } else {
                    if (isLessThanMaximumQuality(it)) {
                        incrementQualityBy(it, 1)
                    }
                }
            }
        }


    }

    private fun setQualityToZero(item: Item) {
        item.quality = item.quality - item.quality
    }

    private fun isExpired(item: Item) = item.sellIn < 0

    private fun incrementQualityBy(item: Item, i: Int) {
        item.quality += i
    }

    private fun isLessThanMaximumQuality(item: Item) = item.quality < 50

    private fun isQualityOverZero(quality: Int) = quality > 0

    private fun decrementQualityBy(item: Item, i: Int) {
        item.quality -= i
    }

    private fun isSulfuras(name: String) = name == "Sulfuras, Hand of Ragnaros"

    private fun isBackstagePass(name: String) = name == "Backstage passes to a TAFKAL80ETC concert"

    private fun isAgedBrie(name: String) = name == "Aged Brie"

}

