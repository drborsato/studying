// This problem was asked by Google.

// Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.

// For example, given the following Node class

// class Node:
//     def __init__(self, val, left=None, right=None):
//         self.val = val
//         self.left = left
//         self.right = right
// The following test should pass:

// node = Node('root', Node('left', Node('left.left')), Node('right'))
// assert deserialize(serialize(node)).left.left.val == 'left.left'


class Node {
  constructor(val, left, right) {
    this._val = val;
    this._left = left;
    this._right = right;
  }

  get val() {
    return this._val;
  }

  get left() {
    return this._left;
  }

  get right() {
    return this._right;
  }

  set val(val) {
    this._val = val;
  }

  set left(left) {
    this._left = left;
  }

  set right(right) {
    this._right = right;
  }
}

function serialize(node) {
  var serialization = 'Node(\'' + node.val + '\'';
  if (node.left != null) serialization += ', ' + serialize(node.left);
  if (node.right != null) serialization += ', ' + serialize(node.right);
  serialization += ')';
  return serialization;
}

function deserialize(s) {
  // console.log(s);
  var val = null;
  var leftNode = null;
  var rightNode = null;
  
  var initValIndex = 6;
  var endValIndex = findEndValIndex(s.substr(initValIndex)) + initValIndex;
  var valLength = endValIndex - initValIndex;
  val = s.substr(initValIndex,valLength);
  // console.log('val = ' + val);
  endValIndex++;//add--up end quote

  if(hasNextNode(s.substr(endValIndex))) {
    var initNodeIndex = 2;
    var initLeftIndex = endValIndex+initNodeIndex;
    leftNode = deserialize(s.substr(initLeftIndex));
    var endLeftIndex = initLeftIndex + serialize(leftNode).length;
    if(hasNextNode(s.substr(endLeftIndex))) {
      var initRightIndex = endLeftIndex+initNodeIndex;
      rightNode = deserialize(s.substring(initRightIndex));
    }
  }
  
  return new Node(val, leftNode, rightNode);
}
function hasNextNode(s) {
  if (s.startsWith(', Node(')) return true;
  return false;
}
function findEndValIndex(s) {
  for (i = 0; i < s.length; i++) {
    if (s.charAt(i) == '\'') return i;
    else if(s.charAt(i) == '\\') i++;
  }
}


var node = new Node('root', new Node('left', new Node('left.left', null, null), null), new Node('right'), null, null);
console.log(serialize(node));
var newNode = deserialize(serialize(node));
console.log(serialize(newNode));
console.log(deserialize(serialize(node)).left.left.val == 'left.left');