# 🔢 Sorting Algorithms in Java

This repository contains well-structured and optimized implementations of common sorting algorithms in **Java**, ideal for:

- 📚 Learning core data structures and algorithms
- 💼 Technical interview preparation
- 🛠️ Building your GitHub project portfolio

Each algorithm is written with clear inline comments, professional formatting, and includes usage examples in the `main()` method.

---

## 📚 Implemented Algorithms

| Algorithm        | File Name          | Type               | Stable | In-place |
|------------------|--------------------|--------------------|--------|----------|
| Bubble Sort      | `BubbleSort.java`  | Comparison-based   | ✅     | ✅       |
| Insertion Sort   | `InsertionSort.java` | Comparison-based | ✅     | ✅       |
| Selection Sort   | `SelectionSort.java` | Comparison-based | ❌     | ✅       |
| Merge Sort       | `MergeSort.java`   | Divide & Conquer   | ✅     | ❌       |
| Quick Sort       | `QuickSort.java`   | Divide & Conquer   | ❌     | ✅       |
| Heap Sort        | `HeapSort.java`    | Heap-based         | ❌     | ✅       |
| Count Sort       | `CountSort.java`   | Non-comparison     | ✅     | ❌       |
| Radix Sort       | `RadixSort.java`   | Non-comparison     | ✅     | ❌       |
| Bucket Sort      | `BucketSort.java`  | Distribution-based | ✅     | ❌       |

---

## ⏱️ Time & Space Complexities

| Algorithm      | Best      | Average   | Worst     | Space      |
|----------------|-----------|-----------|-----------|------------|
| Bubble Sort    | O(n)      | O(n²)     | O(n²)     | O(1)       |
| Insertion Sort | O(n)      | O(n²)     | O(n²)     | O(1)       |
| Selection Sort | O(n²)     | O(n²)     | O(n²)     | O(1)       |
| Merge Sort     | O(n log n)| O(n log n)| O(n log n)| O(n)       |
| Quick Sort     | O(n log n)| O(n log n)| O(n²)     | O(log n)   |
| Heap Sort      | O(n log n)| O(n log n)| O(n log n)| O(1)       |
| Count Sort     | O(n + k)  | O(n + k)  | O(n + k)  | O(k)       |
| Radix Sort     | O(nk)     | O(nk)     | O(nk)     | O(n + k)   |
| Bucket Sort    | O(n + k)  | O(n + k)  | O(n²)     | O(n + k)   |

> 🔍 `n` = number of elements, `k` = range of input (or digits for radix)

---

## 🔍 When to Use Which Algorithm

- **Quick Sort**: General-purpose, fast in practice, preferred for large datasets.
- **Merge Sort**: When stable sorting is required or working with linked lists.
- **Heap Sort**: When memory usage must be minimal and worst-case is important.
- **Radix / Count / Bucket Sort**: When input is numeric and you need linear time.
- **Bubble / Insertion / Selection**: Best for educational use and small inputs.

---
🤝 Contributing
Contributions are welcome! Feel free to open an issue or submit a pull request for:

Additional sorting algorithms (Shell Sort, Tim Sort, etc.)

Optimizations or edge case handling

More sample test cases
