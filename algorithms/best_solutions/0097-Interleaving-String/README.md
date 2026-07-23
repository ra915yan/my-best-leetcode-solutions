# LeetCode 97: Interleaving String




## Summary
- Achieved Time $O(N \times M)$, Space $O(\min(N, M))$.
- Top_down prunes tree automatically leads to best-Time complexity
- steps: Brute Force $\rightarrow$ Top-Down DP $\rightarrow$ Bottom-Up DP $\rightarrow$ Bottom-UP DP Linear space
- Decision & Optimization problems could be reduced to Linear Space complexity



## Problem Definition

Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

An interleaving of two strings s and t is a configuration where s and t are divided into n and m substrings respectively, such that:

**Example 1:**
- **Input:** `s1 = "aabcc""`, `s2 = "dbbca"`,`s3 = "aadbbcbcac"`
- **Output:** `true`
- **Explanation:** One way to obtain s3 is:
  Split s1 into s1 = "aa" + "bc" + "c", and s2 into s2 = "dbbc" + "a".
  Interleaving the two splits, we get "aa" + "dbbc" + "bc" + "a" + "c" = "aadbbcbcac".
  Since s3 can be obtained by interleaving s1 and s2, we return true.

**Example 2:**
- **Input:** `s1 = "aabcc"`, `s2 = "dbbca"`,`s3 = "aadbbbaccc"`
- **Output:** `false`
- **Explanation:** Notice how it is impossible to interleave s2 with any other string to obtain s3.

**Example 3:**
- **Input:** `s1 = ""`, `s2 = ""`,`s3 = ""`
- **Output:** `true`

---

A walkthrough of my optimization on this problem

## 1. Brute Force

- **Objective:** Check if I can solve the problem.
- **Complexity:** Time $O(2^{\max(N, M)})$, Space $O(N + M)$ due to the recursive call frame stack.

## 2. Top-Down Dynamic Programming

- **Objective:** Optimize the time complexity to be a usable algorithm.
- **Complexity:** Time $O(N \times M)$, Space $O(N \times M)$ and recursive call frame stack.

## 3. Bottom-Up DP

- **Objective:** Use iteration instead of recursion.
- **Complexity:** Time $O(N \times M)$, Space $O(N \times M)$.

## 4. Bottom-Up DP Linear Space

- **Objective:** Decrease the space complexity.
- **Complexity:** Time $O(N \times M)$, Space $O(\min(N, M))$.
- **Note:** Linear space is possible because row $i$ depends only on row $i-1$ and the current row's preceding cell


## Performance Metrics (LeetCode Benchmarks)

| Implementation Variant | Time (ms) | beats | Memory (MB) | beats |
| :--- | :---: | :---: | :---: | :---: |
| **Bottom-Up 1D Array** | **2ms** | **76.16%** | **42.81MB** | **95.55%** |
| **Top-Down 2D** | **1ms** | **92.84%** | **42.20MB** | **70.46%** |
| **Bottom-Up 2D** | **5ms** | **38.26%** | **43.08MB** | **81.72%** |
| **Brute Force** | TLE | N/A | N/A | N/A |





## Questions you may have

- **Top-Down has better time than Bottom-Up ?**

  **reason**: Top-Down automatically prunes the decision tree leading to better results



- **why making String char array** Why convert the String to a char array ?  (It adds extra code and we do not mutate the String):

  **reason**: Java's String is full with protections and generally heavy see how many methods charAt() calls in the documentaion