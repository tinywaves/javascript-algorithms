// 采用暴力遍历判断
function Find(target, array) {
  for (let i = 0; i < array.length; i++) {
    for (let j = 0; j < array[i].length; j++) {
      if (array[i][j] === target) {
        return true
      }
    }
  }
  return false
}

function Find(target, array) {
  let col = 0, row = array.length - 1
  while (col <= array[0].length - 1 && row >= 0) {
    if (target > array[row][col]) {
      col++
    } else if (target < array[row][col]) {
      row--
    } else {
      return true
    }
  }
  return false
}

module.exports = {
  Find: Find
};
