package justinb99.kotlinapipoc.service.algos

// Return the Index of the value within the array, or -1 if it doesn't exist
fun Array<Int>.binarySearch(value: Int): Int {
    return binarySearchRec(value, 0, this.size - 1)
}

private fun Array<Int>.binarySearchRec(value: Int, iLower: Int, iUpper: Int): Int {
    if (iLower > iUpper)
        return -1

    val iMid = (iUpper - iLower + 1) / 2 + iLower
    val midValue = this[iMid]
    return when {
        value == midValue -> iMid
        value < midValue -> binarySearchRec(value, iLower, iMid - 1)
        value > midValue -> binarySearchRec(value, iMid + 1, iUpper)
        else -> throw NotImplementedError("Should never reach else case")
    }
}