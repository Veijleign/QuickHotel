package com.example.quickhotel.utils

data class SightsModel(
    val features: List<Feature>,
    val type: String
) {
    data class Feature(
        val geometry: Geometry,
        val id: String,
        val properties: Properties,
        val type: String
    ) {
        data class Geometry(
            val coordinates: List<Double>,
            val type: String
        )

        data class Properties(
            val dist: Double,
            val kinds: String,
            val name: String,
            val osm: String,
            val rate: Int,
            val wikidata: String,
            val xid: String
        )
    }
}