package br.com.rodrigogurgel.graphqlservice.models

enum class PetType(val value: String) {
    CAT("CAT"),
    DOG("DOG"),
    BIRD("BIRD"),
    UNKNOWN("UNKNOWN");

    companion object {
        fun getValueOrUnknown(value: String): PetType {
            return if (values().any { it.value == value }) valueOf(value) else UNKNOWN
        }
    }
}