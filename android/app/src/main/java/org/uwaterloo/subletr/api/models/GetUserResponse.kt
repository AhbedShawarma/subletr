/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package org.uwaterloo.subletr.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param firstName 
 * @param lastName 
 * @param email 
 * @param gender 
 * @param listingId 
 */


data class GetUserResponse (

    @Json(name = "first_name")
    val firstName: kotlin.String,

    @Json(name = "last_name")
    val lastName: kotlin.String,

    @Json(name = "email")
    val email: kotlin.String,

    @Json(name = "gender")
    val gender: kotlin.String,

    @Json(name = "listing_id")
    val listingId: kotlin.Int? = null

)

