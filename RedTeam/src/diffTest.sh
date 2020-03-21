#!/bin/zsh

for f in "$@"
  do
    A="$(cut -d'.' -f3 <<<"$f")"
    B="$(cut -d'/' -f3 <<<"$A")"
    echo "$B"
    ./Micro ../inputs/"$B".micro | diff -b ../outputs/expected/"$B".out -
done