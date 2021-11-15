package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            if (!isAgedBrie(items[i].name) && !isBackstagePass(items[i].name)) {
                if (isQualityOverZero(items[i].quality) && !isSulfuras(items[i].name)) {
                    decrementQualityBy(items[i], 1)
                }
            } else {
                if (isLessThanMaximumQuality(items[i])) {
                    incrementQualityBy(items[i], 1)
                    if (isBackstagePass(items[i].name) && isLessThanMaximumQuality(items[i])) {
                        if (items[i].sellIn < 11) {
                            incrementQualityBy(items[i], 1)
                        }
                        if (items[i].sellIn < 6) {
                            incrementQualityBy(items[i], 1)
                        }
                    }

                }
            }


            if (!isSulfuras(items[i].name)) {
                items[i].sellIn = items[i].sellIn - 1
            }

            if (isExpired(items[i])) {
                if (!isAgedBrie(items[i].name)) {
                    if (!isBackstagePass(items[i].name)) {
                        if (isQualityOverZero(i)) {
                            if (isSulfuras(items[i].name)) {
                                decrementQualityBy(items[i], 1)
                            }
                        }
                    } else {
                        setQualityToZero(items[i])
                    }
                } else {
                    if (isLessThanMaximumQuality(items[i])) {
                        incrementQualityBy(items[i], 1)
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

