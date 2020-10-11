package justinb99.kotlinapipoc.service

inline class FirstName(private val value: String) : Comparable<FirstName> {
    override fun compareTo(other: FirstName): Int =
        value.compareTo(other.value)
}
inline class LastName(private val value: String) : Comparable<LastName> {
    override fun compareTo(other: LastName): Int =
        value.compareTo(other.value)
}

data class StrongPerson(val first: FirstName, val last: LastName) : Comparable<StrongPerson> {
    override fun compareTo(other: StrongPerson): Int {
        val lastComp = this.last.compareTo(other.last)
        return if (lastComp == 0)
            this.first.compareTo(other.first)
        else
            lastComp
    }

}

data class WeakPerson(val first: String, val last: String) : Comparable<WeakPerson> {
    override fun compareTo(other: WeakPerson): Int {
        // WHOOPS!
        val lastComp = this.last.compareTo(other.first)
        return if (lastComp == 0)
            this.first.compareTo(other.first)
        else
            lastComp
    }
}
