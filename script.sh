python getModules.py
modules=$(awk "NR % ${CIRCLE_NODE_TOTAL} == ${CIRCLE_NODE_INDEX}" __module_list.txt)
str="gradle "
for module in $modules; do
  str+=":$module:test "
done
$str
