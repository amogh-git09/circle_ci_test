testfiles=$(find ./*/src/test/* -name '*.java' | sort | awk "NR % 2 == 0")
echo $testfiles
