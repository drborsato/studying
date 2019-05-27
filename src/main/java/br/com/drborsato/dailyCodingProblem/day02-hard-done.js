// This problem was asked by Uber.

// Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

// For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

// Follow-up: what if you can't use division?

console.log(productOfAllElementsExceptI([1,2,3,4,5]));
console.log(productExcept([1,2,3,4,5]));
console.log(productExcept2([1,2,3,4,5]));

//First, with division
function productOfAllElementsExceptI(nums) {
  var product = 1;
  for (i = 0; i < nums.length; i++) {
    product *= nums[i];
  }
  for (i = 0; i < nums.length; i++) {
    nums[i] = product / nums[i];
  }
  return nums;
}

//Without division using S(n)
function productExcept(nums) {
  var left = [1];
  for (i = 1; i < nums.length; i++) {
    left[i] = left[i-1] * nums[i-1];
  }

  var right = [];
  right[nums.length-1] = 1;
  for (i = nums.length-2; i >= 0; i--) {
    right[i] = right[i+1] * nums[i+1];
  }

  var answer = [];
  for (i = 0; i < nums.length; i++) {
    answer[i] = left[i]*right[i];
  }
  return answer;
}

//Without division using S(1)
function productExcept2(nums) {
  var answer = [1];
  for (i = 1; i < nums.length; i++) {
    answer[i] = answer[i-1] * nums[i-1];
  }

  var right = 1;
  for (i = nums.length-2; i >= 0; i--) {
    right = right * nums[i+1];
    answer[i] = answer[i] * right;

  }

  return answer;
}