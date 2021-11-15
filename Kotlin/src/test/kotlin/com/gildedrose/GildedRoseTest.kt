package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun foo() {
        val items = arrayOf(Item("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("foo", app.items[0].name)

    }

    @Test
    fun elixir(){
        val items = arrayOf(Item("Elixir", 2, 2))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(1, app.items[0].quality)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)

    }

    @Test
    fun `sulfuras item doesnt change sellIn or quality when the day passes`(){
        val items = arrayOf(Item("Sulfuras, Hand of Ragnaros", 10, 2))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(10, app.items[0].sellIn)
        assertEquals(2, app.items[0].quality)
    }

    @Test
    fun `Aged Brie item increments quality when sellIn decrements`(){
        val items = arrayOf(Item("Aged Brie", 10, 2))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(9, app.items[0].sellIn)
        assertEquals(3, app.items[0].quality)
    }

    @Test
    fun `Aged Brie item increments twice quality when sellIn is below zero`(){
        val items = arrayOf(Item("Aged Brie", 0, 2))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(-1, app.items[0].sellIn)
        assertEquals(4, app.items[0].quality)
    }

    @Test
    fun `Backstage passes increments by two their quality if sellIn is between 10 and 5`(){
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", 9, 20))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(22, app.items[0].quality)
    }

    @Test
    fun `Backstage passes increments by three their quality if sellIn is between 5 and 1`(){
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", 3, 20))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(23, app.items[0].quality)
    }

    @Test
    fun `Backstage passes quality is zero if sellIn is below zero`(){
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", 0, 20))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }

}


