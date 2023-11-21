#!/bin/sh

if [[ $1 =~ ^[0-9]{1,4}$ ]]; then
  formatted_number=$(printf "%04d" $1)
  dir_name="src/main/kotlin/technology/touchmars/algo/leetcode/q$formatted_number"
  class_file="$dir_name/Solution.kt"

  if [ -d "$dir_name" ]; then
      echo "Directory $dir_name already exists!"
  else
    mkdir -p "$dir_name"
  fi

  content="package technology.touchmars.algo.leetcode.q$formatted_number"
  if [ "$2" == "tree" ]; then
  content="$content
import technology.touchmars.algo.basic.TreeNode"
  fi

  content="$content

class Solution {



}"

  echo "$content" > "$class_file"

  open "$class_file"
if [ "$2" == "t" ]; then
    ./t $1
fi
else
  echo "Error: Argument must be a 1-4 digits, [and tree if class requires TreeNode], [or t followed indicator to create testcase]."
fi
