# Red Team LITTLE Tokenizer

## Command to tokenize using Micro file
<code>./Micro.sh path/to/file/\<FILENAME></code>
outputs -> ../outputs

**example** <code>./Micro.sh ../inputs/fibonacci.micro</code>

## Command to tokenize and diff stdout against expected file
<code>./Micro.sh path/to/file/\<FILENAME> | diff -b path/to/expected/\<FILENAME> -</code>

**example** <code>./Micro.sh ../inputs/fibonacci.micro | diff -b ../outputs/expected/fibonacci.out -</code>
.out files are still generated, but only stdout is used for diff

No output from this command means no diff was found

## Command to tokenize multiple files at once
<code>./Micro.sh path/to/file/\<FILENAME1> path/to/file/\<FILENAME2></code>

### OR
<code>./Micro.sh path/to/file/*.micro</code>
