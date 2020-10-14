package justinb99.kotlinapipoc.service.algos

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

private val evenArray = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
private val oddArray = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)

class BinarySearchTest : StringSpec( {

    "values should not be found" {
        evenArray.binarySearch(11) shouldBe -1
        evenArray.binarySearch(0) shouldBe -1

        oddArray.binarySearch(12) shouldBe -1
        oddArray.binarySearch(0) shouldBe -1
    }

    "middle value should be found" {
        evenArray.binarySearch(6) shouldBe 5
        oddArray.binarySearch(6) shouldBe 5
    }

    "less than half value should be found" {
        evenArray.binarySearch(3) shouldBe 2
        oddArray.binarySearch(3) shouldBe 2
    }

    "greater than half value should be found" {
        evenArray.binarySearch(8) shouldBe 7
        oddArray.binarySearch(8) shouldBe 7
    }

    "all values" {
        for (v in 1..10) {
            evenArray.binarySearch(v) shouldBe v - 1
            oddArray.binarySearch(v) shouldBe v - 1
        }
        oddArray.binarySearch(11) shouldBe 10
    }


})