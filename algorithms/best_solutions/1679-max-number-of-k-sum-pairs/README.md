# 1679. Max Number of K-Sum Pairs

## 📝 Problem Statement

You are given an integer array `nums` and an integer `k`.

In one operation, you can pick two numbers from the array whose sum equals `k` and remove them from the array.

Return the maximum number of operations you can perform on the array.

---

## 💡 Examples

### Example 1:
- **Input:** `nums = [1,2,3,4]`, `k = 5`
- **Output:** `2`
- **Explanation:** Starting with `nums = [1,2,3,4]`:
  - Remove numbers `1` and `4`, then `nums = [2,3]`
  - Remove numbers `2` and `3`, then `nums = []`
  - There are no more pairs that sum up to `5`, hence a total of `2` operations.

### Example 2:
- **Input:** `nums = [3,1,3,4,3]`, `k = 6`
- **Output:** `1`
- **Explanation:** Starting with `nums = [3,1,3,4,3]`:
  - Remove the first two `3`s, then `nums = [1,4,3]`
  - There are no more pairs that sum up to `6`, hence a total of `1` operation.

---

## ⚙️ Constraints

* $1 \le \text{nums.length} \le 10^5$
* $1 \le \text{nums}[i] \le 10^9$
* $1 \le k \le 10^9$

---

## 🧠 Approach & Complexity Analysis

### Approach 1: Hash Map (Frequency Counter)
1. Maintain a frequency map `Map<Integer, Integer>` of numbers seen so far.
2. Iterate through each number `num` in `nums`:
   * Calculate the required complement: `target = k - num`.
   * If `target` exists in the map with a frequency $> 0$, we found a pair! Decrement the count of `target` and increment our operation `count`.
   * Otherwise, add/increment `num` in the map for future pairings.

### Approach 2: Sorting + Two Pointers
1. Sort the array in ascending order ($\mathcal{O}(n \log n)$).
2. Maintain two pointers: `left = 0` and `right = nums.length - 1`.
3. Evaluate `sum = nums[left] + nums[right]`:
   * If `sum == k`: Increment operation count, move both pointers inward (`left++`, `right--`).
   * If `sum < k`: Move `left++` to increase the sum.
   * If `sum > k`: Move `right--` to decrease the sum.

---

## 📊 Code Complexity Metrics

Evaluating control flow complexity and cognitive friction across both implementations:

| Method | Time Complexity | Space Complexity | Cyclomatic Complexity ($f$) | Cognitive Complexity ($h$) | Key Advantage |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **Hash Map** | $\mathcal{O}(n)$ | $\mathcal{O}(n)$ | $3$ | $3$ | **$\mathcal{O}(n)$ linear time** without modifying input array. |
| **Two Pointers** | $\mathcal{O}(n \log n)$ | $\mathcal{O}(1)^*$ | $4$ | $4$ | **$\mathcal{O}(1)$ auxiliary space**, no hash map allocations. |

> **Note on Space Complexity:** $\mathcal{O}(1)^*$ auxiliary space assumes in-place sorting (or $\mathcal{O}(\log n)$ stack space depending on language sort implementation).
