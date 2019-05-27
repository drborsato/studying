// This problem was asked by Stripe.

// Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.

// For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

// You can modify the input array in-place.

var nums = [5,6,1,2,3,4,5,6,7,8,9,15,25];
console.log(findFirstMissingPositiveInteger(nums));

function findFirstMissingPositiveInteger(nums) {
  console.log(nums);
  for (i = 0; i < nums.length; i++) {
    var num = extractNumber(nums[i]);
    if (num > 0 && num <=nums.length) {
      // console.log('num');
      var newNum = extractNumber(nums[num-1]).toString() + ';true';
      nums[num-1] = newNum;
    }
      console.log(nums);
  }

  for (i = 0; i < nums.length; i++) {
    var check = extractCheck(nums[i]);
    if (!check) return i+1;
  }
}

function extractNumber(value) {
  val = value.toString();
  return val.split(';')[0];
}

function extractCheck(value) {
  val = value.toString();
  return val.split(';')[1];
}