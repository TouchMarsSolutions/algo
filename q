#!/bin/sh

if [[ $1 =~ ^[0-9]{4}$ ]]; then
  dir_name="src/main/kotlin/technology/touchmars/algo/leetcode/q$1"
  mkdir -p "$dir_name"
  class_file="$dir_name/Solution.kt"
  echo "package technology.touchmars.algo.leetcode.q$1

class Solution {

}" > "$class_file"
open "$class_file"
if [ "$2" == "t" ]; then
    ./t $1
fi
else
  echo "Error: Argument must be a 4-digit number."
fi
