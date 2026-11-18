# 33. Search in Rotated Sorted Array

**Approach: Modified Binary Search**

## Idea

A rotated sorted array always has at least one sorted half. At every iteration, identify the sorted half and check whether the target lies inside its range.

## Steps

1. Set two pointers: `left = 0` and `right = nums.length - 1`.
2. Calculate the middle index using `left + (right - left) / 2`.
3. If the middle element equals the target, return the middle index.
4. If the left half is sorted:
   - If the target lies between `nums[left]` and `nums[mid]`, search the left half.
   - Otherwise, search the right half.
5. If the right half is sorted:
   - If the target lies between `nums[mid]` and `nums[right]`, search the right half.
   - Otherwise, search the left half.
6. If the target is not found, return `-1`.

## Complexity

- **Time:** O(log n), because the search range is halved in each iteration.
- **Space:** O(1), because only a constant number of variables are used.

**Key concept:** Binary search on a rotated sorted array.
