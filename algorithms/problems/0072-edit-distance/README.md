# LeetCode 72: Edit Distance




## Summary
- Achieved Time $O(N \times M)$, Space $O(\min(N, M))$.
- Beats 98% of leetcode users on both time and space complexity
- steps: BF -> Top_Down -> Bottom_Up -> Bottom_UP_Linear_time
- Learned how to push DP to its limits



## Problem Definition

Given two strings `word1` and `word2`, return the minimum number of operations required to convert `word1` to `word2`.

**Example 1:**
- **Input:** `word1 = "horse"`, `word2 = "ros"`
- **Output:** `3`
- **Explanation:** `horse` ➔ `rorse` (replace `'h'` with `'r'`)
  `rorse` ➔ `rose` (remove `'r'`)
  `rose` ➔ `ros` (remove `'e'`)

**Example 2:**
- **Input:** `word1 = "intention"`, `word2 = "execution"`
- **Output:** `5`
- **Explanation:** `intention` ➔ `inention` (remove `'t'`)
  `inention` ➔ `enention` (replace `'i'` with `'e'`)
  `enention` ➔ `exention` (replace `'n'` with `'x'`)
  `exention` ➔ `exection` (replace `'n'` with `'c'`)
  `exection` ➔ `execution` (insert `'u'`)

---

A walkthrough of my optimization on this problem

## 1. Brute Force

- **Objective:** Check if I can solve the problem.
- **Complexity:** Time $O(3^{\max(N, M)})$, Space $O(N + M)$ due to the recursive call frame stack.

## 2. Top-Down Dynamic Programming

- **Objective:** Optimize the time complexity to be a tractable algorithm.
- **Complexity:** Time $O(N \times M)$, Space $O(N \times M)$ and recursive call frame stack.

## 3. Bottom-Up DP

- **Objective:** Use iteration instead of recursion.
- **Complexity:** Time $O(N \times M)$, Space $O(N \times M)$.

## 4. Bottom-Up DP Linear Space

- **Objective:** Decrease the space complexity.
- **Complexity:** Time $O(N \times M)$, Space $O(\min(N, M))$.
- **Note:** The reasons we were able to make linear space are:
  1. The recurrence only sees the previous row.
  2. The output is a min/max value, not the actual path which would need the full 2D array (matrix) and a graph search on it.


  ## Performance Metrics (LeetCode Benchmarks)

| Implementation Variant   | Time (ms) |     beats       |  Memory (MB)  |       beats       |
| **Bottom-Up 1D Array**   | **3ms**   |   **98.30%**    |  **44.47MB**  |     **98.27%**    |
| **Top-Down 2D**          | **3ms**   |   **98.30%**    |  **46.91MB**  |     **83.99%**    |
| **Bottom-Up 2D**         | **5ms**   |   **68.96%**    |  **47.14MB**  |     **53.26%**    |
| **Brute Force**          |   TLE     |      N/A        |      N/A      |         N/A       |





## Questions you may have

- **why primitive int not Integer** Why use primitive int instead of Integer? 
                                    (Using null in an Integer array instead of filling an int array with -1)

  **reason**: Integer consumes 16 Bytes, while primitive int only consumes 4 bytes. 4 more times memroy usage !!



- **why making String char array** Why convert the String to a char array ?  (It adds extra code and we do not mutate the String):

  **reason**: Java's String is full with protections and generally heavy see how many methods charAt() calls in the documentaion