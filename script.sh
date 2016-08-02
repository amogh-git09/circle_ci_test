python getModules.py
modules=$(awk "NR % ${CIRCLE_NODE_TOTAL} == ${CIRCLE_NODE_INDEX}" __module_list.txt)
for module in $modules; do
  gradle :$module:test
done
