// This problem was asked by Google.

// A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.

// Given the root to a binary tree, count the number of unival subtrees.

// For example, the following tree has 5 unival subtrees:

//    0
//   / \
//  1   0
//     / \
//    1   0
//   / \
//  1   1

class Node {
  constructor(data, left, right) {
    this._data = data;
    this._left = left;
    this._right = right;
  }

  get data() {
    return this._data;
  }

  get left() {
    return this._left;
  }

  get right() {
    return this._right;
  }

  set data(data) {
    this._data = data;
  }

  set left(left) {
    this._left = left;
  }

  set right(right) {
    this._right = right;
  }
}

console.log(countUnival(new Node(0, new Node(1, null, null), new Node(0, new Node(1, new Node(1, null, null), new Node(1, null, null)), new Node(0, null, null)))));

function countUnival(node) {
  if (node.left == null && node.right == null) return 1;
  if (node.left.data == node.data && node.right.data == node.data) return 1 + countUnival(node.left) + countUnival(node.right);
  if (node.left.data == node.data && node.right == null) return 1 + countUnival(node.left);
  if (node.left == null && node.right.data == node.data) return 1 + countUnival(node.right);
  return countUnival(node.left) + countUnival(node.right);
}