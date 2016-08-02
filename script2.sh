testfiles=$(find ./* -name '*.py' | sort | awk "NR % ${CIRCLE_NODE_TOTAL} == ${CIRCLE_NODE_INDEX}")

for file in $testfiles
do
  python $file
done
