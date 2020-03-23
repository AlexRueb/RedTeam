#!/bin/sh

for f in "$@"
  do
    A="$(cut -d'.' -f3 <<<"$f")"
    B="$(cut -d'/' -f3 <<<"$A")"
    echo "$B"
    ./Micro.sh ../inputs/"$B".micro | diff -b ../outputs/expected/"$B".out -
done