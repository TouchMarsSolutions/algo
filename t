#!/bin/sh

if [[ $1 =~ ^[0-9]{1,4}$ ]]; then
    formatted_number=$(printf "%04d" $1)
    test_dir="src/test/kotlin/technology/touchmars/algo/leetcode/q$formatted_number"
    mkdir -p "$test_dir"
    test_file="$test_dir/Test.kt"
    echo "package technology.touchmars.algo.leetcode.q$formatted_number

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
  echo "Error: Argument must be a 1-4 digits."
fi
