package ru.mipt.npm.kmath.matrix

import scientifik.kmath.commons.linear.CMMatrixContext
import scientifik.kmath.linear.MatrixContext
import scientifik.kmath.linear.RealMatrix
import kotlin.random.Random

private val random = Random(12224)
private val dim = 1000

/**
 * The function is called on a matrix context. It could be generic (not optimized) kmath context or wrapped optimized implementation.
 */
fun MatrixContext<Double>.doOperations(): RealMatrix {
    // creating context-specific matrix representation
    val matrix1 = produce(dim, dim) { i, j -> if (i <= j) random.nextDouble() else 0.0 }
    val matrix2 = produce(dim, dim) { i, j -> if (i <= j) random.nextDouble() else 0.0 }

    //performing operations without overhead of transforming matrices to context-specific representation
    return (matrix1 dot matrix2) + matrix2
}

fun main() {
    //calling function on specific (commons-math) context
    val result = CMMatrixContext.doOperations()
    println("Matrix computation is complete. See $result")
}