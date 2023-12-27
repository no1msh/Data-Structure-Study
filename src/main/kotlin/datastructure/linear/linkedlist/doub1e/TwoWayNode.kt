package datastructure.linear.linkedlist.doub1e

data class TwoWayNode<T>(
    val data: T,
    var prev: TwoWayNode<T>?,
    var next: TwoWayNode<T>?,
)
