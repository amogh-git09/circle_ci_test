CIRCLE_NODE_TOTAL=1
CIRCLE_NODE_INDEX=0
testfiles=$(find ./* -name '*.py' | sort | awk "NR % ${CIRCLE_NODE_TOTAL} == ${CIRCLE_NODE_INDEX}")

for file in $testfiles
do
  python $file
done
