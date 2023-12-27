package datastructure.linear.linkedlist.doub1e

data class TwoWayNode<T>(
    val data: T,
    var prev: TwoWayNode<T>? = null,
    var next: TwoWayNode<T>? = null,
)
