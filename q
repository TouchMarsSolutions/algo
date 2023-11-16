#!/bin/sh

if [[ $1 =~ ^[0-9]{4}$ ]]; then
  dir_name="src/main/kotlin/technology/touchmars/algo/leetcode/q$1"
  class_file="$dir_name/Solution.kt"

  if [ -d "$dir_name" ]; then
      echo "Directory $dir_name already exists!"
  else
    mkdir -p "$dir_name"
  fi

  echo "package technology.touchmars.algo.leetcode.q$1
class Solution {

}" > "$class_file"

  open "$class_file"
if [ "$2" == "t" ]; then
    ./t $1
fi
else
  echo "Error: Argument must be a 4-digit number, or t followed by 4 digits."
fi
