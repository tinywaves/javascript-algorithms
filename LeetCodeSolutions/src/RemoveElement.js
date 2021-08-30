/**
 * 27、移除元素
 * @param {number[]} nums
 * @param {number} val
 * @return {number}
 */
var removeElement = function (nums, val) {
  // 记录数组的长度
  let len = nums.length
  for (let i = 0; i < len; i++) {
    // 判断元素是否等于给定值 val
    if (nums[i] === val) {
      // 把等于 val 的元素与最后一个元素进行交换
      let temp = nums[i]
      nums[i] = nums[len - 1]
      nums[len - 1] = temp
      // 数组长度减 1
      len--
      i--
    }
  }
  // 返回最终数组长度即不重复元素的个数
  return len
};