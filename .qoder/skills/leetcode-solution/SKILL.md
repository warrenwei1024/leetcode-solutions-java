---
name: leetcode-solution
description: Create a LeetCode solution file for this Java project with proper directory structure, Solution.java with class-level Javadoc (problem description, @author, @date), method implementation with inline comments, trailing core-idea/complexity comments, then git add and git commit. Use when the user provides a LeetCode problem number and wants to generate a solution file.
---

# LeetCode Solution Generator

Generate a complete LeetCode solution for the `leetcode-solutions-java` project, including directory creation, Solution.java, and git commit.

## Input Required

Ask the user for (or infer from context):

| Field | Required | Default | Example |
|-------|----------|---------|---------|
| 题号 | Yes | — | `74` |
| 中文标题 | Yes | — | `搜索二维矩阵` |
| 分类目录 | No | `top100liked` | `top100liked` / `all` / `topinterview150` |
| 难度 | No | normal | `easy` / `normal` / `hard` |
| @author | No | `weijunjie` | `weijunjie` |

## Steps

### Step 1: Create Directory

```bash
mkdir "src\main\java\com\leetcode\{category}\lc_{number}_{snake_case_title}"
```

- `{number}`: 4-digit zero-padded (e.g. `0074`)
- `{snake_case_title}`: LeetCode English problem title, lowercase, spaces → underscores (e.g. `search_a_2d_matrix`)

### Step 2: Create Solution.java

Generate the file at the directory above. Use this template:

```java
package com.leetcode.{category}.lc_{number}_{snake_case_title};

/**
 * LeetCode {number}. {中文标题}
 * <p>
 * {题目描述，包含约束条件和示例要点}
 * <p>
 * 
 * @author {author}
 * @date {YYYY-MM-DD}
 */
public class Solution {

    public {returnType} {methodName}({params}) {
        // {边界处理}
        if (...) {
            return ...;
        }

        // {分步骤代码，每步带中文行内注释}
        ...

        // {返回结果}
        return ...;
    }
}

// 核心思路
// {2-5 行，解释核心算法思想和关键洞察}
//
// 时间复杂度: O(...)
// 空间复杂度: O(...)
```

### Template Rules

1. **Package name**: Use underscores for spaces, all lowercase English title. Format: `lc_{4-digit}_{snake_case}`
2. **Class Javadoc**: Include `{number}. {中文标题}`, Chinese description with `<p>` separators, `@author`, `@date` (today's date)
3. **Method body**: Add concise Chinese inline comments for each logical block (boundary checks, loops, key conditions, return)
4. **Trailing comments**: After the closing `}`, add `// 核心思路`, then `// 时间复杂度`, `// 空间复杂度`
5. **Method signature**: Derive from LeetCode problem specification (return type, method name, parameter types)

### Step 3: Git Add

```bash
git add "src\main\java\com\leetcode\{category}\lc_{number}_{snake_case_title}\Solution.java"
```

### Step 4: Git Commit

```bash
git commit -m "leetcode {number} {中文标题} {difficulty}"
```

Use the commit message format: `leetcode {4-digit} {中文标题} {difficulty}`, e.g. `leetcode 0074 搜索二维矩阵 normal`

### Step 5: Git Push

```bash
git push origin master
```

## Example

**Input**: 题号 74，标题 搜索二维矩阵，top100liked，normal

**Output file**: `src/main/java/com/leetcode/top100liked/lc_0074_search_a_2d_matrix/Solution.java`

Commit: `leetcode 0074 搜索二维矩阵 normal`
