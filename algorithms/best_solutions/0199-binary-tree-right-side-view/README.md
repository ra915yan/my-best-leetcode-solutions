# LeetCode Binary Tree Solutions

A comprehensive collection of binary tree LeetCode problem solutions with detailed explanations, visualizations, and complexity analysis.

---

## Table of Contents
1. [236. Lowest Common Ancestor of a Binary Tree](#1-236-lowest-common-ancestor-of-a-binary-tree)
2. [199. Binary Tree Right Side View](#2-199-binary-tree-right-side-view)

---

## 1. 236. Lowest Common Ancestor of a Binary Tree

**Difficulty:** Medium  
**Topics:** Tree, Depth-First Search (DFS), Binary Tree  
**LeetCode Link:** [Lowest Common Ancestor of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)

### 📝 Problem Description
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: "The lowest common ancestor is defined between two nodes `p` and `q` as the lowest node in `T` that has both `p` and `q` as descendants (where we allow a node to be a descendant of itself)."

### 📥 Examples

#### Example 1:
- **Tree Structure:** `root = [3,5,1,6,2,0,8,null,null,7,4]`
- **Input:** `p = 5`, `q = 1`  
- **Output:** `3`  
- **Explanation:** The LCA of nodes 5 and 1 is 3.

#### Example 2:
- **Tree Structure:** `root = [3,5,1,6,2,0,8,null,null,7,4]`
- **Input:** `p = 5`, `q = 4`  
- **Output:** `5`  
- **Explanation:** The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

#### Example 3:
- **Tree Structure:** `root = [1,2]`
- **Input:** `p = 1`, `q = 2`
- **Output:** `1`

---

### 🔒 Constraints
- The number of nodes in the tree is in the range `[2, 10^5]`.
- `-10^9 <= Node.val <= 10^9`
- All `Node.val` are **unique**.
- `p != q`
- `p` and `q` will exist in the tree.

---