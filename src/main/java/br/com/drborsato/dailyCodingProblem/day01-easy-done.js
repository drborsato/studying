/*
Good morning! Here's your coding interview problem for today.

This problem was recently asked by Google.

Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

Bonus: Can you do this in one pass?
*/
var Set = require("collections/set");

var input = [10, 15, 3, 7];
var k = 1;
console.log(isAddUpToK(input, k));

function isAddUpToK(nums, k) {
  var complements = new Set();
  for(i = 0; i < nums.length; i ++) {
    if (complements.contains(nums[i]) || nums[i] == k) return true;
    complements.add(k-nums[i]);
  }
  return false;
}