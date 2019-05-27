// This problem was asked by Facebook.

// Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.

// For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

// You can assume that the messages are decodable. For example, '001' is not allowed.

/*
1 0 1 1
2 true
*/
var number = 1232201;
var s = number.toString();
console.log(countNumbersOfDecoded(s));

function countNumbersOfDecoded(s) {
  if (s.charAt[0] == '0') {
    return 0;
  } 
  var count = 1;
  var isPreviousPair = false;

  for (i = 1; i < s.length; i++) {
    if (s.charAt(i) == '0') {
      if (canBePairOfPrevious(s.charAt(i), s.charAt(i-1))) {
        if (isPreviousPair) {
          isPreviousPair = false;
          count--;
        }
      } else {
        return 0;
      }
    } else {
      if (canBePairOfPrevious(s.charAt(i), s.charAt(i-1))) {
        count++;
        isPreviousPair = true;
      } else {
        isPreviousPair = false;
      }
    }
  }

  return count;
}

function canBePairOfPrevious(actual, previous) {
  if (previous == '1') {
    return true;
  } else if (previous == '2' && parseInt(actual) < 6) {
    return true;
  }
  return false;
}