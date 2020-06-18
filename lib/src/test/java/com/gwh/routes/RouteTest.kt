package com.gwh.routes

import android.app.Activity
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import org.junit.Test
import java.io.Serializable

class RouteTest {

    class DummyActivity : Activity()

    @Parcelize
    data class DummyParcelable(val value: String = "value") : Parcelable {
        override fun toString(): String {
            return value
        }
    }

    class DummySerializable(val value: String = "value") : Serializable {
        override fun toString(): String {
            return value
        }
    }

    @Test
    fun `creates a route for the destination`() {
        val result = Route.to(DummyActivity::class.java)
            .create()
            .destination.simpleName

        assert(result == "DummyActivity")
    }

    @Test
    fun `creates an empty params builder`() {
        val expected = Route.Params.Builder()
            .create()
            .toString()

        val result = Route.params()
            .create()
            .toString()

        assert(result == expected)
    }

    @Test
    fun `adds a flag to the route`() {
        val flag = 1
        val result = Route.to(DummyActivity::class.java)
            .flags(flag)
            .create()
            .flags

        assert(result == flag)
    }

    @Test
    fun `combines multiple flags when adding to the route`() {
        val flag1 = 1
        val flag2 = 2
        val flag3 = 3
        val result = Route.to(DummyActivity::class.java)
            .flags(flag1)
            .flags(flag2)
            .flags(flag3)
            .create()
            .flags

        assert(result == flag1 or flag2 or flag3)
    }

    @Test
    fun `creates a route with empty params`() {
        val expected = Route(DummyActivity::class.java)

        val result = Route.to(DummyActivity::class.java)
            .create()

        assert(result.toString() == expected.toString())
    }

    @Test
    fun `returns true when comparing two routes that are equal`() {
        val route1 = Route.to(DummyActivity::class.java)
            .param("string", "string")
            .param("int", 0)
            .param("boolean", true)
            .flags(1)
            .create()

        val route2 = Route.to(DummyActivity::class.java)
            .param("string", "string")
            .param("int", 0)
            .param("boolean", true)
            .flags(1)
            .create()

        assert(route1 == route2)
    }

    @Test
    fun `adds parameters of all supported types when creating a route`() {
        val charSequenceValue: CharSequence = "value"
        val serializableValue = DummySerializable()
        val parcelableValue = DummyParcelable()
        val underTest = Route.to(DummyActivity::class.java)
            .param("parcelable", parcelableValue)
            .param("boolean", true)
            .param("byte", Byte.MAX_VALUE)
            .param("char", 'c')
            .param("short", Short.MAX_VALUE)
            .param("int", 123)
            .param("long", 123L)
            .param("float", 1.0F)
            .param("double", 1.0)
            .param("string", "value")
            .param("charSequence", charSequenceValue)
            .param("serializable", serializableValue)
            .paramParcelableList("parcelable list", listOf(parcelableValue, parcelableValue))
            .paramBooleanList("boolean list", listOf(true, false))
            .paramByteList("byte list", listOf(Byte.MIN_VALUE, Byte.MAX_VALUE))
            .paramCharList("char list", listOf('a', 'b', 'c'))
            .paramShortList("short list", listOf(Short.MIN_VALUE, Short.MAX_VALUE))
            .paramIntList("integer list", listOf(1, 2, 3))
            .paramLongList("long list", listOf(1L, 2L, 3L))
            .paramFloatList("float list", listOf(1.0F, 2.0F, 3.0F))
            .paramDoubleList("double list", listOf(1.0, 2.0, 3.0))
            .paramStringList("string list", listOf("one", "two", "three"))
            .paramCharSequenceList("charSequence list", listOf(charSequenceValue, charSequenceValue))
            .paramSerializableList("serializable list", listOf(serializableValue, serializableValue))
            .create()

        assert(underTest.getParcelable<DummyParcelable>("parcelable") == parcelableValue)
        assert(underTest.getBoolean("boolean") == true)
        assert(underTest.getByte("byte") == Byte.MAX_VALUE)
        assert(underTest.getChar("char") == 'c')
        assert(underTest.getShort("short") == Short.MAX_VALUE)
        assert(underTest.getInt("int") == 123)
        assert(underTest.getLong("long") == 123L)
        assert(underTest.getFloat("float") == 1.0F)
        assert(underTest.getDouble("double") == 1.0)
        assert(underTest.getString("string") == "value")
        assert(underTest.getCharSequence("charSequence") == charSequenceValue)
        assert(underTest.getSerializable("serializable") == serializableValue)
        assert(underTest.getParcelableList("parcelable list") == listOf(parcelableValue, parcelableValue))
        assert(underTest.getBooleanList("boolean list") == listOf(true, false))
        assert(underTest.getByteList("byte list") == listOf(Byte.MIN_VALUE, Byte.MAX_VALUE))
        assert(underTest.getCharList("char list") == listOf('a', 'b', 'c'))
        assert(underTest.getShortList("short list") == listOf(Short.MIN_VALUE, Short.MAX_VALUE))
        assert(underTest.getIntList("integer list") == listOf(1, 2, 3))
        assert(underTest.getLongList("long list") == listOf(1L, 2L, 3L))
        assert(underTest.getFloatList("float list") == listOf(1.0F, 2.0F, 3.0F))
        assert(underTest.getDoubleList("double list") == listOf(1.0, 2.0, 3.0))
        assert(underTest.getStringList("string list") == listOf("one", "two", "three"))
        assert(underTest.getCharSequenceList("charSequence list") == listOf(charSequenceValue, charSequenceValue))
        assert(underTest.getSerializableList("serializable list") == listOf(serializableValue, serializableValue))
    }

    @Test
    fun `returns a list of parameters as key-value pairs when representing params as a string`() {
        val charSequenceValue: CharSequence = "value"
        val serializableValue = DummySerializable()
        val parcelableValue = DummyParcelable()
        val parcelable = "parcelable: value"
        val boolean = "boolean: true"
        val byte = "byte: 127"
        val char = "char: c"
        val short = "short: 32767"
        val int = "int: 123"
        val long = "long: 123"
        val float = "float: 1.0"
        val double = "double: 1.0"
        val string = "string: value"
        val charSequence = "charSequence: value"
        val serializable = "serializable: value"
        val parcelableList = "parcelable list: [value, value]"
        val booleanList = "boolean list: [true, false]"
        val byteList = "byte list: [-128, 127]"
        val charList = "char list: [a, b, c]"
        val shortList = "short list: [-32768, 32767]"
        val integerList = "integer list: [1, 2, 3]"
        val longList = "long list: [1, 2, 3]"
        val floatList = "float list: [1.0, 2.0, 3.0]"
        val stringList = "string list: [one, two, three]"
        val charSequenceList = "charSequence list: [value, value]"
        val serializableList = "serializable list: [value, value]"
        val expected = listOf(
            parcelable, boolean, byte, char, short, int,
            long, float, double, string, charSequence, serializable,
            parcelableList, booleanList, byteList, charList, shortList,
            integerList, longList, floatList, stringList, charSequenceList, serializableList
        ).joinToString(", ")
        val underTest = Route.params()
            .put("parcelable", DummyParcelable())
            .put("boolean", true)
            .put("byte", Byte.MAX_VALUE)
            .put("char", 'c')
            .put("short", Short.MAX_VALUE)
            .put("int", 123)
            .put("long", 123L)
            .put("float", 1.0F)
            .put("double", 1.0)
            .put("string", "value")
            .put("charSequence", charSequenceValue)
            .put("serializable", serializableValue)
            .putParcelableList("parcelable list", listOf(parcelableValue, parcelableValue))
            .putBooleanList("boolean list", listOf(true, false))
            .putByteList("byte list", listOf(Byte.MIN_VALUE, Byte.MAX_VALUE))
            .putCharList("char list", listOf('a', 'b', 'c'))
            .putShortList("short list", listOf(Short.MIN_VALUE, Short.MAX_VALUE))
            .putIntList("integer list", listOf(1, 2, 3))
            .putLongList("long list", listOf(1L, 2L, 3L))
            .putFloatList("float list", listOf(1.0F, 2.0F, 3.0F))
            .putStringList("string list", listOf("one", "two", "three"))
            .putCharSequenceList("charSequence list", listOf(charSequenceValue, charSequenceValue))
            .putSerializableList("serializable list", listOf(serializableValue, serializableValue))
            .create()

        val result = underTest.toString()

        assert(result == expected)
    }

    @Test
    fun `returns a string containing a destination and a list of parameters when representing a route as a string`() {
        val charSequenceValue: CharSequence = "value"
        val parcelableValue = DummyParcelable()
        val serializableValue = DummySerializable()
        val parcelable = "parcelable: value"
        val boolean = "boolean: true"
        val byte = "byte: 127"
        val char = "char: c"
        val short = "short: 32767"
        val int = "int: 123"
        val long = "long: 123"
        val float = "float: 1.0"
        val double = "double: 1.0"
        val string = "string: value"
        val charSequence = "charSequence: value"
        val serializable = "serializable: value"
        val parcelableList = "parcelable list: [value, value]"
        val booleanList = "boolean list: [true, false]"
        val byteList = "byte list: [-128, 127]"
        val charList = "char list: [a, b, c]"
        val shortList = "short list: [-32768, 32767]"
        val integerList = "integer list: [1, 2, 3]"
        val longList = "long list: [1, 2, 3]"
        val floatList = "float list: [1.0, 2.0, 3.0]"
        val stringList = "string list: [one, two, three]"
        val charSequenceList = "charSequence list: [value, value]"
        val serializableList = "serializable list: [value, value]"
        val params = listOf(
            parcelable, boolean, byte, char, short, int,
            long, float, double, string, charSequence, serializable,
            parcelableList, booleanList, byteList, charList, shortList,
            integerList, longList, floatList, stringList, charSequenceList, serializableList
        ).joinToString(", ")
        val expected = "destination = DummyActivity, params = {$params}"
        val underTest = Route.to(DummyActivity::class.java)
            .param("parcelable", DummyParcelable())
            .param("boolean", true)
            .param("byte", Byte.MAX_VALUE)
            .param("char", 'c')
            .param("short", Short.MAX_VALUE)
            .param("int", 123)
            .param("long", 123L)
            .param("float", 1.0F)
            .param("double", 1.0)
            .param("string", "value")
            .param("charSequence", charSequenceValue)
            .param("serializable", DummySerializable())
            .paramParcelableList("parcelable list", listOf(parcelableValue, parcelableValue))
            .paramBooleanList("boolean list", listOf(true, false))
            .paramByteList("byte list", listOf(Byte.MIN_VALUE, Byte.MAX_VALUE))
            .paramCharList("char list", listOf('a', 'b', 'c'))
            .paramShortList("short list", listOf(Short.MIN_VALUE, Short.MAX_VALUE))
            .paramIntList("integer list", listOf(1, 2, 3))
            .paramLongList("long list", listOf(1L, 2L, 3L))
            .paramFloatList("float list", listOf(1.0F, 2.0F, 3.0F))
            .paramStringList("string list", listOf("one", "two", "three"))
            .paramCharSequenceList("charSequence list", listOf(charSequenceValue, charSequenceValue))
            .paramSerializableList("serializable list", listOf(serializableValue, serializableValue))
            .create()

        val result = underTest.toString()

        assert(result == expected)
    }
}