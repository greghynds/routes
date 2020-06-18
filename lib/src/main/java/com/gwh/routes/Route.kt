@file:JvmName("Route")

package com.gwh.routes

import android.app.Activity
import android.os.Parcelable
import java.io.Serializable


data class Route(
    val destination: Class<out Activity>,
    val params: Params = Params.Builder().create(),
    val flags: Int = 0
) {
    fun getInt(key: String): Int? = params.getInt(key)
    fun getLong(key: String): Long? = params.getLong(key)
    fun getString(key: String): String? = params.getString(key)
    fun getBoolean(key: String): Boolean? = params.getBoolean(key)
    fun getChar(key: String): Char? = params.getChar(key)
    fun getByte(key: String): Byte? = params.getByte(key)
    fun getShort(key: String): Short? = params.getShort(key)
    fun getFloat(key: String): Float? = params.getFloat(key)
    fun getDouble(key: String): Double? = params.getDouble(key)
    fun getCharSequence(key: String): CharSequence? = params.getCharSequence(key)
    fun getSerializable(key: String): Serializable? = params.getSerializable(key)
    fun getParcelableList(key: String): List<Parcelable>? = params.getParcelableList(key)
    fun getBooleanList(key: String): List<Boolean>? = params.getBooleanList(key)
    fun getByteList(key: String): List<Byte>? = params.getByteList(key)
    fun getCharList(key: String): List<Char>? = params.getCharList(key)
    fun getShortList(key: String): List<Short>? = params.getShortList(key)
    fun getIntList(key: String): List<Int>? = params.getIntList(key)
    fun getLongList(key: String): List<Long>? = params.getLongList(key)
    fun getFloatList(key: String): List<Float>? = params.getFloatList(key)
    fun getDoubleList(key: String): List<Double>? = params.getDoubleList(key)
    fun getStringList(key: String): List<String>? = params.getStringList(key)
    fun getCharSequenceList(key: String): List<CharSequence>? = params.getCharSequenceList(key)
    fun getSerializableList(key: String): List<Serializable>? = params.getSerializableList(key)

    @Suppress("UNCHECKED_CAST")
    fun <T : Parcelable> getParcelable(key: String): T? = params.getParcelable(key) as T?
    
    override fun toString(): String {
        return "destination = ${destination.simpleName}, params = {$params}"
    }

    class Builder(private val destination: Class<out Activity>) {

        private var flags: Int = 0
        private val params = Params.Builder()

        fun flags(flags: Int): Builder {
            return apply {
                this.flags = this.flags or flags
            }
        }

        fun <T> param(key: String, value: T?, condition: Boolean = true): Builder {
            if (value != null && condition) {
                params.put(key, value)
            }
            return this
        }

        fun paramParcelableList(key: String, value: List<Parcelable>?, condition: Boolean = true): Builder {
            return apply {
                if (value != null && condition) {
                    params.putParcelableList(key, value)
                }
            }
        }

        fun paramBooleanList(key: String, value: List<Boolean>?, condition: Boolean = true): Builder {
            return apply {
                if (value != null && condition) {
                    params.putBooleanList(key, value)
                }
            }
        }

        fun paramByteList(key: String, value: List<Byte>?, condition: Boolean = true): Builder {
            return apply {
                if (value != null && condition) {
                    params.putByteList(key, value)
                }
            }
        }

        fun paramCharList(key: String, value: List<Char>?, condition: Boolean = true): Builder {
            return apply {
                if (value != null && condition) {
                    params.putCharList(key, value)
                }
            }
        }

        fun paramShortList(key: String, value: List<Short>?, condition: Boolean = true): Builder {
            return apply {
                if (value != null && condition) {
                    params.putShortList(key, value)
                }
            }
        }

        fun paramIntList(key: String, value: List<Int>?, condition: Boolean = true): Builder {
            return apply {
                if (value != null && condition) {
                    params.putIntList(key, value)
                }
            }
        }

        fun paramLongList(key: String, value: List<Long>?, condition: Boolean = true): Builder {
            return apply {
                if (value != null && condition) {
                    params.putLongList(key, value)
                }
            }
        }

        fun paramFloatList(key: String, value: List<Float>?, condition: Boolean = true): Builder {
            return apply {
                if (value != null && condition) {
                    params.putFloatList(key, value)
                }
            }
        }

        fun paramDoubleList(key: String, value: List<Double>?, condition: Boolean = true): Builder {
            return apply {
                if (value != null && condition) {
                    params.putDoubleList(key, value)
                }
            }
        }

        fun paramStringList(key: String, value: List<String>?, condition: Boolean = true): Builder {
            return apply {
                if (value != null && condition) {
                    params.putStringList(key, value)
                }
            }
        }

        fun paramCharSequenceList(key: String, value: List<CharSequence>?, condition: Boolean = true): Builder {
            return apply {
                if (value != null && condition) {
                    params.putCharSequenceList(key, value)
                }
            }
        }

        fun paramSerializableList(key: String, value: List<Serializable>?, condition: Boolean = true): Builder {
            return apply {
                if (value != null && condition) {
                    params.putSerializableList(key, value)
                }
            }
        }

        fun create() = Route(destination, params.create(), flags)
    }


    class Params(
        val parcelables: Map<String, Parcelable> = mapOf(),
        val booleans: Map<String, Boolean> = mapOf(),
        val bytes: Map<String, Byte> = mapOf(),
        val chars: Map<String, Char> = mapOf(),
        val shorts: Map<String, Short> = mapOf(),
        val integers: Map<String, Int> = mapOf(),
        val longs: Map<String, Long> = mapOf(),
        val floats: Map<String, Float> = mapOf(),
        val doubles: Map<String, Double> = mapOf(),
        val charSequences: Map<String, CharSequence> = mapOf(),
        val serializables: Map<String, Serializable> = mapOf(),
        val parcelableLists: Map<String, List<Parcelable>> = mapOf(),
        val booleanLists: Map<String, List<Boolean>> = mapOf(),
        val byteLists: Map<String, List<Byte>> = mapOf(),
        val charLists: Map<String, List<Char>> = mapOf(),
        val shortLists: Map<String, List<Short>> = mapOf(),
        val integerLists: Map<String, List<Int>> = mapOf(),
        val longLists: Map<String, List<Long>> = mapOf(),
        val floatLists: Map<String, List<Float>> = mapOf(),
        val doubleLists: Map<String, List<Double>> = mapOf(),
        val charSequenceLists: Map<String, List<CharSequence>> = mapOf(),
        val serializableLists: Map<String, List<Serializable>> = mapOf()
    ) {

        fun getString(key: String): String? {
            val value = charSequences[key]
            return if (value is String) value else null
        }

        fun getBoolean(key: String): Boolean? = booleans[key]
        fun getByte(key: String): Byte? = bytes[key]
        fun getChar(key: String): Char? = chars[key]
        fun getShort(key: String): Short? = shorts[key]
        fun getInt(key: String): Int? = integers[key]
        fun getLong(key: String): Long? = longs[key]
        fun getFloat(key: String): Float? = floats[key]
        fun getDouble(key: String): Double? = doubles[key]
        fun getCharSequence(key: String): CharSequence? = charSequences[key]
        fun getSerializable(key: String): Serializable? = serializables[key]
        fun getParcelableList(key: String): List<Parcelable>? = parcelableLists[key]
        fun getBooleanList(key: String): List<Boolean>? = booleanLists[key]
        fun getByteList(key: String): List<Byte>? = byteLists[key]
        fun getCharList(key: String): List<Char>? = charLists[key]
        fun getShortList(key: String): List<Short>? = shortLists[key]
        fun getIntList(key: String): List<Int>? = integerLists[key]
        fun getLongList(key: String): List<Long>? = longLists[key]
        fun getFloatList(key: String): List<Float>? = floatLists[key]
        fun getDoubleList(key: String): List<Double>? = doubleLists[key]
        fun getCharSequenceList(key: String): List<CharSequence>? = charSequenceLists[key]
        fun getSerializableList(key: String): List<Serializable>? = serializableLists[key]
        fun getStringList(key: String): List<String>? = charSequenceLists[key]?.filterIsInstance<String>()?.map { it }

        @Suppress("UNCHECKED_CAST")
        fun <T : Parcelable> getParcelable(key: String): T? = parcelables[key] as T?

        override fun toString(): String {
            val params = mutableListOf<String>()

            fun <T> addParam(entry: Map.Entry<String, T>) {
                params.add("${entry.key}: ${entry.value}")
            }

            fun <T> addListParam(entry: Map.Entry<String, List<T>>) {
                params.add("${entry.key}: [${entry.value.joinToString(", ")}]")
            }

            return params.apply {
                parcelables.forEach(::addParam)
                booleans.forEach(::addParam)
                bytes.forEach(::addParam)
                chars.forEach(::addParam)
                shorts.forEach(::addParam)
                integers.forEach(::addParam)
                longs.forEach(::addParam)
                floats.forEach(::addParam)
                doubles.forEach(::addParam)
                charSequences.forEach(::addParam)
                serializables.forEach(::addParam)
                parcelableLists.forEach(::addListParam)
                booleanLists.forEach(::addListParam)
                byteLists.forEach(::addListParam)
                charLists.forEach(::addListParam)
                shortLists.forEach(::addListParam)
                integerLists.forEach(::addListParam)
                longLists.forEach(::addListParam)
                floatLists.forEach(::addListParam)
                doubleLists.forEach(::addListParam)
                charSequenceLists.forEach(::addListParam)
                serializableLists.forEach(::addListParam)

            }.joinToString(", ")
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Params

            if (parcelables != other.parcelables) return false
            if (booleans != other.booleans) return false
            if (bytes != other.bytes) return false
            if (chars != other.chars) return false
            if (shorts != other.shorts) return false
            if (integers != other.integers) return false
            if (longs != other.longs) return false
            if (floats != other.floats) return false
            if (doubles != other.doubles) return false
            if (charSequences != other.charSequences) return false
            if (serializables != other.serializables) return false
            if (parcelableLists != other.parcelableLists) return false
            if (booleanLists != other.booleanLists) return false
            if (byteLists != other.byteLists) return false
            if (charLists != other.charLists) return false
            if (shortLists != other.shortLists) return false
            if (integerLists != other.integerLists) return false
            if (longLists != other.longLists) return false
            if (floatLists != other.floatLists) return false
            if (doubleLists != other.doubleLists) return false
            if (charSequenceLists != other.charSequenceLists) return false
            if (serializableLists != other.serializableLists) return false

            return true
        }

        override fun hashCode(): Int {
            var result = parcelables.hashCode()
            result = 31 * result + booleans.hashCode()
            result = 31 * result + bytes.hashCode()
            result = 31 * result + chars.hashCode()
            result = 31 * result + shorts.hashCode()
            result = 31 * result + integers.hashCode()
            result = 31 * result + longs.hashCode()
            result = 31 * result + floats.hashCode()
            result = 31 * result + doubles.hashCode()
            result = 31 * result + charSequences.hashCode()
            result = 31 * result + serializables.hashCode()
            result = 31 * result + parcelableLists.hashCode()
            result = 31 * result + booleanLists.hashCode()
            result = 31 * result + byteLists.hashCode()
            result = 31 * result + charLists.hashCode()
            result = 31 * result + shortLists.hashCode()
            result = 31 * result + integerLists.hashCode()
            result = 31 * result + longLists.hashCode()
            result = 31 * result + floatLists.hashCode()
            result = 31 * result + doubleLists.hashCode()
            result = 31 * result + charSequenceLists.hashCode()
            result = 31 * result + serializableLists.hashCode()
            return result
        }

        class Builder {

            private val parcelables: MutableMap<String, Parcelable> = mutableMapOf()
            private val booleans: MutableMap<String, Boolean> = mutableMapOf()
            private val bytes: MutableMap<String, Byte> = mutableMapOf()
            private val chars: MutableMap<String, Char> = mutableMapOf()
            private val shorts: MutableMap<String, Short> = mutableMapOf()
            private val integers: MutableMap<String, Int> = mutableMapOf()
            private val longs: MutableMap<String, Long> = mutableMapOf()
            private val floats: MutableMap<String, Float> = mutableMapOf()
            private val doubles: MutableMap<String, Double> = mutableMapOf()
            private val charSequences: MutableMap<String, CharSequence> = mutableMapOf()
            private val serializables: MutableMap<String, Serializable> = mutableMapOf()
            private val parcelableLists: MutableMap<String, List<Parcelable>> = mutableMapOf()
            private val booleanLists: MutableMap<String, List<Boolean>> = mutableMapOf()
            private val byteLists: MutableMap<String, List<Byte>> = mutableMapOf()
            private val charLists: MutableMap<String, List<Char>> = mutableMapOf()
            private val shortLists: MutableMap<String, List<Short>> = mutableMapOf()
            private val integerLists: MutableMap<String, List<Int>> = mutableMapOf()
            private val longLists: MutableMap<String, List<Long>> = mutableMapOf()
            private val floatLists: MutableMap<String, List<Float>> = mutableMapOf()
            private val doubleLists: MutableMap<String, List<Double>> = mutableMapOf()
            private val charSequenceLists: MutableMap<String, List<CharSequence>> = mutableMapOf()
            private val serializableLists: MutableMap<String, List<Serializable>> = mutableMapOf()

            fun <T> put(key: String, value: T) = apply {
                when (value) {
                    is Parcelable -> parcelables[key] = value
                    is Boolean -> booleans[key] = value
                    is Byte -> bytes[key] = value
                    is Char -> chars[key] = value
                    is Short -> shorts[key] = value
                    is Int -> integers[key] = value
                    is Long -> longs[key] = value
                    is Float -> floats[key] = value
                    is Double -> doubles[key] = value
                    is CharSequence -> charSequences[key] = value
                    is Serializable -> serializables[key] = value
                }
            }

            fun putParcelableList(key: String, value: List<Parcelable>) = apply { parcelableLists[key] = value }
            fun putBooleanList(key: String, value: List<Boolean>) = apply { booleanLists[key] = value }
            fun putByteList(key: String, value: List<Byte>) = apply { byteLists[key] = value }
            fun putCharList(key: String, value: List<Char>) = apply { charLists[key] = value }
            fun putShortList(key: String, value: List<Short>) = apply { shortLists[key] = value }
            fun putIntList(key: String, value: List<Int>) = apply { integerLists[key] = value }
            fun putLongList(key: String, value: List<Long>) = apply { longLists[key] = value }
            fun putFloatList(key: String, value: List<Float>) = apply { floatLists[key] = value }
            fun putDoubleList(key: String, value: List<Double>) = apply { doubleLists[key] = value }
            fun putStringList(key: String, value: List<String>) = apply { charSequenceLists[key] = value }
            fun putCharSequenceList(key: String, value: List<CharSequence>) = apply { charSequenceLists[key] = value }
            fun putSerializableList(key: String, value: List<Serializable>) = apply { serializableLists[key] = value }

            fun create() = Params(
                parcelables,
                booleans,
                bytes,
                chars,
                shorts,
                integers,
                longs,
                floats,
                doubles,
                charSequences,
                serializables,
                parcelableLists,
                booleanLists,
                byteLists,
                charLists,
                shortLists,
                integerLists,
                longLists,
                floatLists,
                doubleLists,
                charSequenceLists,
                serializableLists
            )
        }
    }

    companion object {
        /**
         * Creates a new Route builder for the destination Activity.
         */
        @JvmStatic
        fun to(destination: Class<out Activity>) = Builder(destination)

        /**
         * Creates a new Route params builder.
         */
        @JvmStatic
        fun params() = Params.Builder()
    }
}