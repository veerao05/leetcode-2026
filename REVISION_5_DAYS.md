# 5-Day Intensive Revision Plan

## Option A: 🔴 MUST Only (45 programs) - Recommended
**9 programs/day** - Focus on high-priority interview questions

## Option B: All Programs (103 programs)
**20-21 programs/day** - Complete coverage

---

# OPTION A: 5-Day MUST-Only Plan (45 programs)

## DAY 1: Core Java (15 programs) 🔴
| # | Program | Key Trick | Done? |
|---|---------|-----------|-------|
| 1 | Primitives | Pass by value, wrappers | ☐ |
| 2 | Serialisation | transient skips field | ☐ |
| 3 | SingletonDemo | volatile + synchronized | ☐ |
| 4 | FactoryPatternDemo | Create without new | ☐ |
| 5 | CustomException | Extend Exception | ☐ |
| 6 | CompareAndComparator | Comparable vs Comparator | ☐ |
| 7 | ConcurrentModificationException | iterator.remove() | ☐ |
| 8 | ShallowDeepCopy | Clone nested objects | ☐ |
| 9 | ImmutableClass | Final class, fields, no setters | ☐ |
| 10 | ProducerConsumer | while + wait/notify | ☐ |
| 11 | SynchronisedMethod | Method-level lock | ☐ |
| 12 | SynchronisationBlock | Block-level lock | ☐ |
| 13 | DeadLockExample | Same lock order | ☐ |
| 14 | Java8Example | filter, map, collect | ☐ |
| 15 | EmployeeExample | groupingBy, statistics | ☐ |

---

## DAY 2: Data Structures (8 programs) 🔴
| # | Program | Key Trick | Done? |
|---|---------|-----------|-------|
| 1 | CustomLinkedList | Insert, delete, reverse | ☐ |
| 2 | BinaryTree - Traversals | Pre(DLR), In(LDR), Post(LRD) | ☐ |
| 3 | BinaryTree - Left/Right View | First/Last of level | ☐ |
| 4 | BinaryTree - Height | max(left, right) + 1 | ☐ |
| 5 | BinaryTree - Diameter | lh + rh + 1 | ☐ |
| 6 | MaxAreaOfIsland | DFS count connected 1s | ☐ |
| 7 | SurroundingRegion | BFS from edges | ☐ |
| 8 | CloneGraph | Map old→new | ☐ |

---

## DAY 3: Arrays & HashMap (10 programs) 🔴
| # | Program | Pattern | Key Trick | Done? |
|---|---------|---------|-----------|-------|
| 1 | TrappingRainWater | Two Pointers | min(leftMax,rightMax) - height | ☐ |
| 2 | FindPair (TwoSum) | HashMap | Look for complement | ☐ |
| 3 | MissingInteger | Math | Expected - Actual | ☐ |
| 4 | MissingAndRepetativeNumber | HashMap | Loop 1→n, not array! | ☐ |
| 5 | ArraySubsetProblem | HashSet | Put arr1, check arr2 | ☐ |
| 6 | MajorityElement | Boyer-Moore | Count +1/-1 | ☐ |
| 7 | FirstPositiveMissingNumber | Index marking | Array as hashmap | ☐ |
| 8 | StockBuyAndSell | Track min | profit = price - minSoFar | ☐ |
| 9 | MinimumPlatformsForRailywayStation | Sort + Merge | Event counting | ☐ |
| 10 | PeakElement | Binary Search | Go to higher neighbor | ☐ |

---

## DAY 4: Sliding Window, Stack, Search (7 programs) 🔴
| # | Program | Pattern | Key Trick | Done? |
|---|---------|---------|-----------|-------|
| 1 | SubArrayWithGivenSum | Sliding Window | Expand right, shrink left | ☐ |
| 2 | ZeroSumSubarray | Prefix Sum | Repeated prefix = zero sum | ☐ |
| 3 | LargestSumOfContiguousSubArray | Kadane | Drop negative, restart | ☐ |
| 4 | LongestSubStringWithKDistinctCharacters | Sliding Window | Map.size() <= K | ☐ |
| 5 | ValidParenthesis | Stack | Push open, pop close | ☐ |
| 6 | StockSpanProblem | Monotonic Stack | Pop smaller, span = i - peek | ☐ |
| 7 | MinimumElementinSortedRotatedArray | Binary Search | Compare mid with right | ☐ |

---

## DAY 5: Dynamic Programming (5 programs) 🔴
| # | Program | Pattern | Key Trick | Done? |
|---|---------|---------|-----------|-------|
| 1 | NoOfCoins | Unbounded Knapsack | COUNT = ADD choices | ☐ |
| 2 | MinimumNoOfCoins | Unbounded Knapsack | MIN = same row (reuse) | ☐ |
| 3 | SubsetSumPartition | 0/1 Knapsack | Can make sum/2? | ☐ |
| 4 | MinJump | Greedy | Track farthest per level | ☐ |
| 5 | Queue/Stack basics | DS | Push, pop, peek | ☐ |

---

# OPTION B: 5-Day ALL Programs Plan (103 programs)

## DAY 1: Arrays + Two Pointers (21 programs)
| # | Program | Priority | Key Trick |
|---|---------|----------|-----------|
| 1 | ReverseString | 🟡 | Swap ends |
| 2 | ReverseArray | 🟡 | Recursive swap |
| 3 | MoveZeros | 🟡 | Snowplow forward |
| 4 | RemoveElement | 🟡 | Keep valid pointer |
| 5 | MovePositiveAndNegativeNos | 🟡 | Partition |
| 6 | Sort0s1s2s | 🟡 | Three pointers |
| 7 | ReArrangePositiveNegativeAlternative | 🟡 | Even=pos, Odd=neg |
| 8 | MergeSortedArray | 🟡 | Merge from end |
| 9 | TrappingRainWater | 🔴 | min(L,R) - height |
| 10 | ContainsDuplicates | 🟡 | distinct != length |
| 11 | MinMaxElement | 🟡 | stream min/max |
| 12 | SortArray | 🟡 | reverseOrder() |
| 13 | FindPair/TwoSum | 🔴 | Complement lookup |
| 14 | CountPairs | 🟡 | Count frequency |
| 15 | TripletOfGivenSum | 🟡 | Fix + TwoSum |
| 16 | MissingInteger | 🔴 | Expected - Actual |
| 17 | MissingAndRepetativeNumber | 🔴 | Loop 1→n |
| 18 | ArraySubsetProblem | 🔴 | Set contains |
| 19 | ArrayIntersection | 🟡 | Common in both |
| 20 | PairCloseToSum | 🟡 | Track closest |
| 21 | ChocolateDistribution | 🟡 | Sort + window |

---

## DAY 2: HashMap + Sliding Window (21 programs)
| # | Program | Priority | Key Trick |
|---|---------|----------|-----------|
| 1 | FirstRepeatingElement | 🟡 | count > 1 |
| 2 | FirstNonRepeatingElement | 🟡 | count == 1 |
| 3 | FirstUniqueCharInString | 🟡 | LinkedHashMap |
| 4 | DuplicatesSortedArray | 🟡 | TreeSet |
| 5 | ValidAnagram | 🟡 | Add then subtract |
| 6 | Anagram | 🟡 | Sort both |
| 7 | DistinctCharacter | 🟡 | groupingBy |
| 8 | FruitIntoBasket | 🟡 | Map.size() <= 2 |
| 9 | LongestSubStringWithKDistinctCharacters | 🔴 | Map.size() <= K |
| 10 | SubArrayWithGivenSum | 🔴 | Expand/shrink |
| 11 | ZeroSumSubarray | 🔴 | Prefix repeat |
| 12 | MaximumRepeatingStrings | 🟡 | Keep appending |
| 13 | StringCompression | 🟡 | Count consecutive |
| 14 | MaximumWordsInSentence | 🟡 | split.length |
| 15 | LargestSumOfContiguousSubArray | 🔴 | Kadane |
| 16 | MaximumProductContinousSubarray | 🟡 | Track min & max |
| 17 | LongestConsecutiveSubsequence | 🟡 | Sort, skip dup |
| 18 | MajorityElement | 🔴 | Boyer-Moore |
| 19 | FirstPositiveMissingNumber | 🔴 | Index marking |
| 20 | StockBuyAndSell | 🔴 | Track min |
| 21 | GasStation | 🟡 | Tank negative = restart |

---

## DAY 3: Stack + Binary Search + DP (21 programs)
| # | Program | Priority | Key Trick |
|---|---------|----------|-----------|
| 1 | ValidParenthesis | 🔴 | Push/pop match |
| 2 | DailyTemperature | 🟡 | Stack waits |
| 3 | StockSpanProblem | 🔴 | Pop smaller |
| 4 | RemoveKDigits | 🟡 | Remove peaks |
| 5 | IndexFirstOccurrence | 🟡 | substring equals |
| 6 | GoalInterpretation | 🟡 | () → "o" |
| 7 | CipherString | 🟡 | Modulo 26 |
| 8 | CountNoOfOccurrences | 🟡 | First & last |
| 9 | MinimumElementinSortedRotatedArray | 🔴 | mid vs right |
| 10 | PeakElement | 🔴 | Higher neighbor |
| 11 | MinimiseTowerHeights | 🟡 | Split points |
| 12 | MinimumPlatformsForRailywayStation | 🔴 | Event counting |
| 13 | MaximumSumarrAmongRotations | 🟡 | Rotation formula |
| 14 | NoOfCoins | 🔴 | Unbounded - ADD |
| 15 | MinimumNoOfCoins | 🔴 | Unbounded - MIN |
| 16 | SubsetSumPartition | 🔴 | 0/1 Knapsack |
| 17 | CountWaystoReachStair | 🟡 | Fibonacci |
| 18 | Fibonacci | 🟡 | 3 vars |
| 19 | MinJump | 🔴 | Farthest reach |
| 20 | Factorial | 🟡 | Multiply 1→n |
| 21 | FactorialOfLargeNumber | 🟡 | BigInteger |

---

## DAY 4: Strings + Trees + Graphs (21 programs)
| # | Program | Priority | Key Trick |
|---|---------|----------|-----------|
| 1 | MakePalindrome | 🟡 | Skip non-alpha |
| 2 | MakePalindromeByRemoval | 🟡 | Skip one side |
| 3 | Palindrome | 🟡 | Reverse compare |
| 4 | StringReverse | 🟡 | Loop backward |
| 5 | FizzBuzz | 🟡 | %15 first |
| 6 | JewelsAndStones | 🟡 | Set contains |
| 7 | ThirdMaximum | 🟡 | skip(2) |
| 8 | StringSplitter | 🟡 | isDigit/isAlpha |
| 9 | ReShape | 🟡 | Buffer flush |
| 10 | SecondHighest | 🟡 | Cascade down |
| 11 | ArrayRotation | 🟡 | Reverse trick |
| 12 | BinaryTree - Traversals | 🔴 | DLR/LDR/LRD |
| 13 | BinaryTree - Left/Right View | 🔴 | First/Last level |
| 14 | BinaryTree - Height | 🔴 | max + 1 |
| 15 | BinaryTree - Diameter | 🔴 | lh + rh + 1 |
| 16 | MaxAreaOfIsland | 🔴 | DFS count |
| 17 | SurroundingRegion | 🔴 | BFS from edge |
| 18 | CloneGraph | 🔴 | Map old→new |
| 19 | CustomLinkedList | 🔴 | Insert/delete/reverse |
| 20 | Queue | 🔴 | FIFO |
| 21 | Stack | 🔴 | LIFO |

---

## DAY 5: Core Java (19 programs)
| # | Program | Priority | Key Trick |
|---|---------|----------|-----------|
| 1 | Primitives | 🔴 | Pass by value |
| 2 | Serialisation | 🔴 | transient |
| 3 | SingletonDemo | 🔴 | Double-check |
| 4 | FactoryPatternDemo | 🔴 | Factory pattern |
| 5 | CustomException | 🔴 | Extend Exception |
| 6 | CompareAndComparator | 🔴 | Comparable vs Comparator |
| 7 | ConcurrentModificationException | 🔴 | iterator.remove() |
| 8 | ShallowDeepCopy | 🔴 | Clone nested |
| 9 | ImmutableClass | 🔴 | Final all |
| 10 | ProducerConsumer | 🔴 | while + wait |
| 11 | SynchronisedMethod | 🔴 | Method lock |
| 12 | SynchronisationBlock | 🔴 | Block lock |
| 13 | StaticSynchronisation | 🟡 | Class lock |
| 14 | OddEvenPrg | 🟡 | Alternate notify |
| 15 | DeadLockExample | 🔴 | Same order |
| 16 | Java8Example | 🔴 | Streams |
| 17 | EmployeeExample | 🔴 | Advanced Streams |
| 18 | Commonly Asked basics | 🟡 | Review remaining |
| 19 | Final review | - | Quick scan all |

---

# Summary

| Plan | Programs | Per Day | Best For |
|------|----------|---------|----------|
| Option A (MUST only) | 45 | 9 | Quick interview prep |
| Option B (All) | 103 | 20-21 | Complete revision |

## Daily Schedule Suggestion

| Time | Activity |
|------|----------|
| Morning | 5-7 programs (fresh mind) |
| Afternoon | 5-7 programs |
| Evening | 5-7 programs + review weak ones |

## Quick Recall Tips
1. Read problem name
2. Identify pattern (Stack? Sliding Window? DP?)
3. Recall key trick (1 line)
4. Trace through small example mentally
5. Move to next (don't code unless stuck)

---
*5-Day Plan: Focus on patterns, not perfection*
*If you practiced all yourself, recall should be quick!*