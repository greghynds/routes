@file:JvmName("Routes")

package com.gwh.routes

import android.annotation.TargetApi
import android.app.Activity
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle


/**
 * Builds an Intent for the given route.
 * Route parameters will be accessible in the Intent extras.
 */
fun Context.intentFor(route: Route): Intent {

    fun Collection<CharSequence>.toStringArray(): ArrayList<String> {
        return ArrayList(filterIsInstance<String>()
            .map { charSequence -> charSequence })
    }

    return Intent().apply {
        component = ComponentName(applicationContext, route.destination)

        val bundle = with(route.params) {
            Bundle().apply {
                parcelables.forEach { (k, v) -> putParcelable(k, v) }
                booleans.forEach { (k, v) -> putBoolean(k, v) }
                bytes.forEach { (k, v) -> putByte(k, v) }
                chars.forEach { (k, v) -> putChar(k, v) }
                shorts.forEach { (k, v) -> putShort(k, v) }
                integers.forEach { (k, v) -> putInt(k, v) }
                longs.forEach { (k, v) -> putLong(k, v) }
                floats.forEach { (k, v) -> putFloat(k, v) }
                doubles.forEach { (k, v) -> putDouble(k, v) }
                charSequences.forEach { (k, v) -> putCharSequence(k, v) }
                serializables.forEach { (k, v) -> putSerializable(k, v) }
                parcelableLists.forEach { (k, v) -> putParcelableArray(k, v.toTypedArray()) }
                booleanLists.forEach { (k, v) ->
                    putBooleanArray(
                        k,
                        v.toTypedArray().toBooleanArray()
                    )
                }
                longLists.forEach { (k, v) -> putLongArray(k, v.toTypedArray().toLongArray()) }
                byteLists.forEach { (k, v) -> putByteArray(k, v.toTypedArray().toByteArray()) }
                charLists.forEach { (k, v) -> putCharArray(k, v.toTypedArray().toCharArray()) }
                shortLists.forEach { (k, v) -> putShortArray(k, v.toTypedArray().toShortArray()) }
                integerLists.forEach { (k, v) -> putIntArray(k, v.toTypedArray().toIntArray()) }
                longLists.forEach { (k, v) -> putLongArray(k, v.toTypedArray().toLongArray()) }
                floatLists.forEach { (k, v) -> putFloatArray(k, v.toTypedArray().toFloatArray()) }
                doubleLists.forEach { (k, v) ->
                    putDoubleArray(
                        k,
                        v.toTypedArray().toDoubleArray()
                    )
                }
                charSequenceLists.forEach { (k, v) -> putCharSequenceArray(k, v.toTypedArray()) }

                // filter Strings from CharSequence list
                charSequenceLists
                    .map { (key, list) -> key to list.toStringArray() }
                    .forEach { (k, v) -> putStringArray(k, v.toTypedArray()) }
            }
        }

        putExtras(bundle)
        addFlags(route.flags)
    }
}

/**
 * Launches an Activity for the given route.
 */
fun Context.startActivity(route: Route) {
    startActivity(intentFor(route))
}

/**
 * Same as {@link android.content.Context#startActivity(Route)}
 * but returns a result when the Activity exits.
 */
fun Activity.startActivityForResult(route: Route, requestCode: Int) {
    startActivityForResult(intentFor(route), requestCode)
}

/**
 * Same as {@link android.content.Context#startActivity(Route)}
 * but returns a result when the Activity exits.
 */
@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
fun Activity.startActivityForResult(route: Route, requestCode: Int, bundle: Bundle? = null) {
    startActivityForResult(intentFor(route), requestCode, bundle)
}

/**
 * Returns route params for the Bundle entries.
 */
fun Bundle?.asParams(): Route.Params {
    val bundle = this ?: Bundle()
    val builder = Route.params()

    bundle.keySet()?.forEach { key ->
        builder.put(key, bundle.get(key))
    }

    return builder.create()
}

/**
 * Calls the [block] function with the Intent's parameters as its receiver.
 */
inline fun Activity.withParams(block: Route.Params.() -> Unit) {
    return intent.extras.asParams().block()
}