# Daily Revision Plan - 103 Programs

## Priority Legend
- 🔴 **MUST** - High priority, frequently asked in interviews
- 🟡 **MEDIUM** - Good to know, asked occasionally

## Choose Your Pace
| Pace | Problems/Day | Total Days |
|------|--------------|------------|
| Aggressive | 15-20 | 5-7 days |
| Moderate | 10 | 10-11 days |
| Relaxed | 5-7 | 15-20 days |

## Summary by Priority
| Priority | Count |
|----------|-------|
| 🔴 MUST | 45 |
| 🟡 MEDIUM | 58 |

---

## DAY 1: Two Pointers & Basic Arrays (12 programs)
| # | Program | Pattern | Priority | Key Trick |
|---|---------|---------|----------|-----------|
| 1 | ReverseString | Two Pointers | 🟡 | Swap ends, move inward |
| 2 | ReverseArray | Two Pointers | 🟡 | Recursive swap |
| 3 | MoveZeros | Two Pointers | 🟡 | Snowplow non-zeros forward |
| 4 | RemoveElement | Two Pointers | 🟡 | Keep pointer for valid elements |
| 5 | MovePositiveAndNegativeNos | Two Pointers | 🟡 | Partition like QuickSort |
| 6 | Sort0s1s2s | Dutch Flag | 🟡 | Three pointers: low, mid, high |
| 7 | ReArrangePositiveNegativeAlternative | Split & Merge | 🟡 | Even=positive, Odd=negative |
| 8 | MergeSortedArray | Two Pointers | 🟡 | Merge from end for O(1) space |
| 9 | TrappingRainWater | Two Pointers | 🔴 | Water = min(leftMax,rightMax) - height |
| 10 | ContainsDuplicates | HashSet | 🟡 | distinct().count() != length |
| 11 | MinMaxElement | Stream | 🟡 | Arrays.stream().min()/max() |
| 12 | SortArray | Stream | 🟡 | sorted(reverseOrder()) |

**Day 1 Stats:** 🔴 MUST: 1 | 🟡 MEDIUM: 11

---

## DAY 2: HashMap & Counting (12 programs)
| # | Program | Pattern | Priority | Key Trick |
|---|---------|---------|----------|-----------|
| 1 | TwoSum / FindPair | HashMap | 🔴 | Look for complement |
| 2 | CountPairs | HashMap | 🟡 | Count complement frequency |
| 3 | TripletOfGivenSum | Fix + TwoSum | 🟡 | Fix one, find pair for remaining |
| 4 | FirstRepeatingElement | LinkedHashMap | 🟡 | groupingBy + count > 1 + findFirst |
| 5 | FirstNonRepeatingElement | LinkedHashMap | 🟡 | groupingBy + count == 1 |
| 6 | FirstUniqueCharInString | LinkedHashMap | 🟡 | Same as above for strings |
| 7 | MissingInteger | Math | 🔴 | Expected - Actual = Missing |
| 8 | MissingAndRepetativeNumber | HashMap | 🔴 | Loop 1→n for missing, not array! |
| 9 | DuplicatesSortedArray | TreeSet | 🟡 | Unique + Sorted automatically |
| 10 | ValidAnagram | HashMap | 🟡 | Add then subtract, check zeros |
| 11 | Anagram | Sort | 🟡 | Sort both, compare |
| 12 | DistinctCharacter | groupingBy | 🟡 | Filter count == 1 |

**Day 2 Stats:** 🔴 MUST: 3 | 🟡 MEDIUM: 9

---

## DAY 3: Sliding Window (10 programs)
| # | Program | Pattern | Priority | Key Trick |
|---|---------|---------|----------|-----------|
| 1 | FruitIntoBasket | Sliding Window | 🟡 | Map.size() <= 2 |
| 2 | LongestSubStringWithKDistinctCharacters | Sliding Window | 🔴 | Map.size() <= K |
| 3 | SubArrayWithGivenSum | Sliding Window | 🔴 | Expand right, shrink left |
| 4 | ZeroSumSubarray | Prefix Sum | 🔴 | Repeated prefix = zero sum |
| 5 | MaximumRepeatingStrings | Expand | 🟡 | Keep appending until not found |
| 6 | StringCompression | Count consecutive | 🟡 | Write char, count while same |
| 7 | MaximumWordsInSentence | Split & Count | 🟡 | split(" ").length |
| 8 | LargestSumOfContiguousSubArray | Kadane | 🔴 | Drop negative sum, restart |
| 9 | MaximumProductContinousSubarray | Track min & max | 🟡 | Negative × negative = positive |
| 10 | LongestConsecutiveSubsequence | Sort + Count | 🟡 | Skip duplicates, count +1 diffs |

**Day 3 Stats:** 🔴 MUST: 4 | 🟡 MEDIUM: 6

---

## DAY 4: Stack Problems (8 programs)
| # | Program | Pattern | Priority | Key Trick |
|---|---------|---------|----------|-----------|
| 1 | ValidParenthesis | Stack | 🔴 | Push open, pop & match close |
| 2 | DailyTemperature | Monotonic Stack | 🟡 | Stack waits for warmer day |
| 3 | StockSpanProblem | Monotonic Stack | 🔴 | Pop smaller, span = i - peek |
| 4 | RemoveKDigits | Monotonic Stack | 🟡 | Remove peaks, keep valleys |
| 5 | TrappingRainWater | Stack (alt) | 🔴 | Or use two pointers |
| 6 | IndexFirstOccurrence | Sliding Window | 🟡 | substring(i, i+m).equals() |
| 7 | GoalInterpretation | Parse | 🟡 | () → "o", skip parentheses |
| 8 | CipherString | Modulo | 🟡 | (index ± shift) % 26 |

**Day 4 Stats:** 🔴 MUST: 3 | 🟡 MEDIUM: 5

---

## DAY 5: Binary Search & Sorting (10 programs)
| # | Program | Pattern | Priority | Key Trick |
|---|---------|---------|----------|-----------|
| 1 | CountNoOfOccurrences | Binary Search | 🟡 | Find first & last, subtract |
| 2 | MinimumElementinSortedRotatedArray | Binary Search | 🔴 | Compare mid with right |
| 3 | PeakElement | Binary Search | 🔴 | Go towards higher neighbor |
| 4 | ArraySubsetProblem | HashSet | 🔴 | Put arr1 in set, check arr2 |
| 5 | ArrayIntersection | HashSet | 🟡 | Common elements in both |
| 6 | ChocolateDistribution | Sort + Window | 🟡 | Sort, min diff of size m window |
| 7 | PairCloseToSum | Sort + Two Ptr | 🟡 | Track closest to target |
| 8 | MinimiseTowerHeights | Sort + Split | 🟡 | Try all split points |
| 9 | MinimumPlatformsForRailywayStation | Sort + Merge | 🔴 | Event-driven counting |
| 10 | MaximumSumarrAmongRotations | Math | 🟡 | Use rotation formula |

**Day 5 Stats:** 🔴 MUST: 4 | 🟡 MEDIUM: 6

---

## DAY 6: Dynamic Programming (8 programs)
| # | Program | Pattern | Priority | Key Trick |
|---|---------|---------|----------|-----------|
| 1 | NoOfCoins | Unbounded Knapsack | 🔴 | Count ways = ADD choices |
| 2 | MinimumNoOfCoins | Unbounded Knapsack | 🔴 | Min coins = same row (reuse) |
| 3 | SubsetSumPartition | 0/1 Knapsack | 🔴 | Can we make sum/2? |
| 4 | CountWaystoReachStair | Fibonacci | 🟡 | ways(n) = ways(n-1) + ways(n-2) |
| 5 | Fibonacci | DP | 🟡 | Keep 3 vars, shift left |
| 6 | MinJump | Greedy | 🔴 | Track farthest reach per level |
| 7 | Factorial | Loop | 🟡 | Multiply 1 to n |
| 8 | FactorialOfLargeNumber | BigInteger | 🟡 | For overflow-safe |

**Day 6 Stats:** 🔴 MUST: 4 | 🟡 MEDIUM: 4

---

## DAY 7: Strings & Palindromes (10 programs)
| # | Program | Pattern | Priority | Key Trick |
|---|---------|---------|----------|-----------|
| 1 | MakePalindrome | Two Pointers | 🟡 | Skip non-alphanumeric |
| 2 | MakePalindromeByRemoval | Two Pointers | 🟡 | On mismatch, try skip left OR right |
| 3 | Palindrome | Reverse | 🟡 | Compare with reversed |
| 4 | StringReverse | Loop backward | 🟡 | Append from end |
| 5 | FizzBuzz | Modulo | 🟡 | Check %15 first, then %3, %5 |
| 6 | JewelsAndStones | HashSet | 🟡 | Put jewels in set, count stones |
| 7 | ThirdMaximum | Stream | 🟡 | distinct().sorted().skip(2) |
| 8 | StringSplitter | Character.isX | 🟡 | Classify each char type |
| 9 | ReShape | Buffer | 🟡 | Print when buffer full |
| 10 | SecondHighest | Two vars | 🟡 | Cascade down on new max |

**Day 7 Stats:** 🔴 MUST: 0 | 🟡 MEDIUM: 10

---

## DAY 8: Stock & Greedy (8 programs)
| # | Program | Pattern | Priority | Key Trick |
|---|---------|---------|----------|-----------|
| 1 | StockBuyAndSell | Track min | 🔴 | Profit = price - minSoFar |
| 2 | GasStation | Greedy | 🟡 | If tank negative, restart |
| 3 | MajorityElement | Boyer-Moore | 🔴 | Count +1/-1, candidate survives |
| 4 | FirstPositiveMissingNumber | Index marking | 🔴 | Use array as hashmap |
| 5 | ArrayRotation | Reverse trick | 🟡 | Reverse all, reverse parts |
| 6 | TripletOfGivenSum (arrays) | Sort + 2Ptr | 🟡 | Fix one, two pointer for rest |
| 7 | StockSpanProblem | Stack | 🔴 | Days of consecutive smaller |
| 8 | DailyTemperature | Stack | 🟡 | Days until warmer |

**Day 8 Stats:** 🔴 MUST: 4 | 🟡 MEDIUM: 4

---

## DAY 9: Trees & Graphs (8 programs)
| # | Program | Pattern | Priority | Key Trick |
|---|---------|---------|----------|-----------|
| 1 | BinaryTree - Traversals | DFS | 🔴 | Pre(DLR), In(LDR), Post(LRD) |
| 2 | BinaryTree - Left/Right View | BFS | 🔴 | First/Last of each level |
| 3 | BinaryTree - Height | Recursion | 🔴 | max(left, right) + 1 |
| 4 | BinaryTree - Diameter | Recursion | 🔴 | lh + rh + 1 vs child diameters |
| 5 | MaxAreaOfIsland | DFS/BFS | 🔴 | Count connected 1s |
| 6 | SurroundingRegion | BFS from edge | 🔴 | Mark edge-connected, flip rest |
| 7 | CloneGraph | HashMap + DFS | 🔴 | Map old→new nodes |
| 8 | CustomLinkedList | Pointers | 🔴 | Insert, delete, reverse |

**Day 9 Stats:** 🔴 MUST: 8 | 🟡 MEDIUM: 0

---

## DAY 10: Core Java - Threading (8 programs)
| # | Program | Pattern | Priority | Key Trick |
|---|---------|---------|----------|-----------|
| 1 | ProducerConsumer | wait/notify | 🔴 | while loop for condition |
| 2 | OddEvenPrg | synchronized | 🟡 | Alternate with notify |
| 3 | DeadLockExample | Nested locks | 🔴 | Same order to avoid deadlock |
| 4 | SynchronisedMethod | synchronized | 🔴 | Method-level lock |
| 5 | SynchronisationBlock | synchronized(obj) | 🔴 | Block-level lock |
| 6 | StaticSynchronisation | Class lock | 🟡 | Static method sync |
| 7 | SingletonDemo | Double-check | 🔴 | volatile + synchronized |
| 8 | FactoryPatternDemo | Factory | 🔴 | Create objects without new |

**Day 10 Stats:** 🔴 MUST: 6 | 🟡 MEDIUM: 2

---

## DAY 11: Core Java - Concepts (9 programs)
| # | Program | Pattern | Priority | Key Trick |
|---|---------|---------|----------|-----------|
| 1 | Serialisation | Serializable | 🔴 | transient skips field |
| 2 | ShallowDeepCopy | Cloneable | 🔴 | Deep copy clones nested objects |
| 3 | ConcurrentModificationException | Iterator | 🔴 | Use iterator.remove() |
| 4 | CompareAndComparator | Sorting | 🔴 | Comparable vs Comparator |
| 5 | ImmutableClass | Design | 🔴 | Final class, final fields, no setters |
| 6 | CustomException | Exception | 🔴 | Extend Exception class |
| 7 | Primitives | Basics | 🔴 | Wrapper classes, autoboxing |
| 8 | Java8Example | Streams | 🔴 | filter, map, collect, groupingBy |
| 9 | EmployeeExample | Streams | 🔴 | Complex grouping, statistics |

**Day 11 Stats:** 🔴 MUST: 9 | 🟡 MEDIUM: 0

---

## 🔴 MUST-KNOW Programs (45 total) - Prioritized List

### Core Java (15 MUST)
| Program | Topic |
|---------|-------|
| Primitives | Pass by value, wrappers |
| Serialisation | transient, static behavior |
| SingletonDemo | Thread-safe singleton |
| FactoryPatternDemo | Factory pattern |
| CustomException | Custom exceptions |
| CompareAndComparator | Comparable vs Comparator |
| ConcurrentModificationException | Iterator.remove() |
| ShallowDeepCopy | Deep copy implementation |
| ImmutableClass | Immutable class design |
| ProducerConsumer | wait/notify pattern |
| SynchronisedMethod | Method synchronization |
| SynchronisationBlock | Block synchronization |
| DeadLockExample | Deadlock prevention |
| Java8Example | Streams API |
| EmployeeExample | Advanced Streams |

### Data Structures (8 MUST)
| Program | Topic |
|---------|-------|
| CustomLinkedList | LinkedList operations |
| BinaryTree | All traversals, views |
| MaxAreaOfIsland | Graph DFS/BFS |
| SurroundingRegion | Graph BFS |
| CloneGraph | Graph cloning |
| Stack (ValidParenthesis) | Stack operations |
| Queue | Queue operations |

### LeetCode Problems (22 MUST)
| Program | Pattern |
|---------|---------|
| TrappingRainWater | Two Pointers |
| SubArrayWithGivenSum | Sliding Window |
| ZeroSumSubarray | Prefix Sum |
| LargestSumOfContiguousSubArray | Kadane's Algorithm |
| LongestSubStringWithKDistinctCharacters | Sliding Window |
| ValidParenthesis | Stack |
| StockSpanProblem | Monotonic Stack |
| MinimumElementinSortedRotatedArray | Binary Search |
| PeakElement | Binary Search |
| ArraySubsetProblem | HashSet |
| MinimumPlatformsForRailywayStation | Greedy |
| NoOfCoins | DP - Unbounded Knapsack |
| MinimumNoOfCoins | DP - Unbounded Knapsack |
| SubsetSumPartition | DP - 0/1 Knapsack |
| MinJump | Greedy |
| StockBuyAndSell | Track Min |
| MajorityElement | Boyer-Moore |
| FirstPositiveMissingNumber | Index Marking |
| MissingInteger | Math |
| MissingAndRepetativeNumber | HashMap |
| FindPair (TwoSum) | HashMap |

---

## Quick Reference Card

### Pattern Recognition
| See This | Think This | Priority |
|----------|------------|----------|
| "Subarray sum" | Sliding Window or Prefix Sum | 🔴 |
| "Next greater/smaller" | Monotonic Stack | 🔴 |
| "K distinct" | Sliding Window + HashMap | 🔴 |
| "Sorted array search" | Binary Search | 🔴 |
| "Minimum/Maximum coins/ways" | DP (Knapsack) | 🔴 |
| "Palindrome" | Two Pointers | 🟡 |
| "Parentheses matching" | Stack | 🔴 |
| "Connected components" | BFS/DFS | 🔴 |
| "First/Last occurrence" | Binary Search variant | 🟡 |

### Complexity Cheat Sheet
| Pattern | Time | Space |
|---------|------|-------|
| Two Pointers | O(n) | O(1) |
| Sliding Window | O(n) | O(k) |
| HashMap counting | O(n) | O(n) |
| Binary Search | O(log n) | O(1) |
| Monotonic Stack | O(n) | O(n) |
| BFS/DFS | O(V+E) | O(V) |
| DP (2D table) | O(n×m) | O(n×m) |

---

## Revision Strategy

### If Short on Time (Focus on 🔴 MUST only)
- **45 programs**
- 5/day = 9 days
- 10/day = 4-5 days
- 15/day = 3 days

### Full Revision (All 103)
- 10/day = 10-11 days
- 15/day = 7 days

---

## Daily Checklist Template
```
Day: ___
Date: ___
Focus: 🔴 MUST only / All

[ ] Program 1: _________ Priority: 🔴/🟡 Recalled? Y/N
[ ] Program 2: _________ Priority: 🔴/🟡 Recalled? Y/N
[ ] Program 3: _________ Priority: 🔴/🟡 Recalled? Y/N
...

Struggled with: _____________
Need to revisit: _____________
```

---
*Total: 103 programs (45 🔴 MUST + 58 🟡 MEDIUM)*
*Organized into 11 themed days*
*Prioritized for interview preparation*