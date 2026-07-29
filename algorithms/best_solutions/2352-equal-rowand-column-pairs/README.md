# 2352. Equal Row and Column Pairs

![Difficulty: Medium](https://img.shields.io/badge/Difficulty-Medium-yellow.svg)
![Topics: Array | Hash Table | Matrix | Trie](https://img.shields.io/badge/Topics-Array%20%7C%20Hash%20Table%20%7C%20Matrix%20%7C%20Trie-blue.svg)

## 📝 Problem Statement

Given a 0-indexed $n \times n$ integer matrix `grid`, return the number of pairs $(r_i, c_j)$ such that row $r_i$ and column $c_j$ are equal.

A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).

---

## 💡 Examples

### Example 1:
- **Input:** `grid = [[3,2,1],[1,7,6],[2,7,7]]`
- **Output:** `1`
- **Explanation:** There is 1 equal row and column pair:
  - (Row 2, Column 1): `[2,7,7]`

### Example 2:
- **Input:** `grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]`
- **Output:** `3`
- **Explanation:** There are 3 equal row and column pairs:
  - (Row 0, Column 0): `[3,1,2,2]`
  - (Row 2, Column 2): `[2,4,2,2]`
  - (Row 3, Column 2): `[2,4,2,2]`

---

## ⚙️ Constraints

* $n == \text{grid.length} == \text{grid}[i].\text{length}$
* $1 \le n \le 200$
* $1 \le \text{grid}[i][j] \le 10^5$

---

## 🧠 Approach & Complexity Analysis

### Approach 1: Frequency Map (`Map<List<Integer>, Integer>`)
Instead of performing an $O(n^3)$ brute-force element-by-element comparison, we can count row frequencies using a hash map:
1. Traverse all rows of the grid, convert each into a `List<Integer>`, and increment its count in a `rowMap`.
2. Traverse all columns, construct each column's `List<Integer>`, and query `rowMap` for matching row occurrences.

### Approach 2: Prefix Tree (Trie Table)
1. Insert each row as a path into a `Trie` where each node branches based on cell values.
2. Search each column in the `Trie`. If a path breaks early (`node == null`), exit the inner loop immediately (**early pruning**).

---

## 📊 Code Complexity Metrics

Evaluating the control flow and cognitive overhead across implemented approaches:

| Method | Time Complexity | Space Complexity | Cyclomatic Complexity ($f$) | Cognitive Complexity ($h$) | Key Advantage |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **Brute Force** | $\mathcal{O}(n^3)$ | $\mathcal{O}(1)$ | $6$ | $12$ | Simple to implement, but high nesting ($h=12$). |
| **Hash Map** | $\mathcal{O}(n^2)$ | $\mathcal{O}(n^2)$ | $5$ | $6$ | **Flat logic & lowest cognitive load.** |
| **Trie Table** | $\mathcal{O}(n^2)$ | $\mathcal{O}(n^2)$ | $7$ | $8$ | Zero object allocations per query + early exit pruning. |

> **Note on Metrics:** 
> * **Cyclomatic Complexity ($f$):** Counts the total number of linearly independent paths.
> * **Cognitive Complexity ($h$):** Measures human mental friction by penalizing nested control blocks. Sequential loops ($h=6$) reduce Cognitive Complexity by 50% compared to 3-deep nested loops ($h=12$).




