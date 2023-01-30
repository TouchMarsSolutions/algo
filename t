#!/bin/sh

if [[ $1 =~ ^[0-9]{4}$ ]]; then
    test_dir="src/test/kotlin/technology/touchmars/algo/leetcode/q$1"
    mkdir -p "$test_dir"
    test_file="$test_dir/Test.kt"
    echo "package technology.touchmars.algo.leetcode.q$1

import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    @Test
    fun test() {
      val solution = Solution()
      assertEquals(1,1)
    }
}" > "$test_file"
    open "$test_file"
else
  echo "Error: Argument must be a 4-digit number."
fi
