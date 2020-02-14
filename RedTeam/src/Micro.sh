#!/bin/zsh
java -jar /usr/local/lib/antlr-4.8-complete.jar LITTLE.g4
javac -d . ./*.java

for f in "$@"
  do
    java Main "$f"
done