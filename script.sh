python getModules.py
modules=$(awk "NR % 1 == 0" __module_list.txt)
for module in $modules; do
  gradle :$module:test
done
