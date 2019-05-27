// This problem was asked by Jane Street.

// cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair. For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.

// Given this implementation of cons:

// def cons(a, b):
//     def pair(f):
//         return f(a, b)
//     return pair
// Implement car and cdr.

// These names comes from lisp, cons = construct a list, car, returns first element in that list, and cdr returns the rest of that list. Since this list it is a pair, the rest of that list, will be tha last element. Based on that:

class Pair {
  constructor(a,b) {
    this._a = a;
    this._b = b;
  }

  get a() { return this._a;}
  get b() { return this._b;}
  set a(a) {this._a = a;}
  set b(b) {this._b = b;}

}

function cons(a,b) {
  return new Pair(a,b);
}

function car(cons) {
  return cons.a;
}

function cdr(cons) {
  return cons.b;
}

console.log(car(cons(3,4)));
console.log(cdr(cons(3,4)));