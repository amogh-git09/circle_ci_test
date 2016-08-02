python getModules.py
modules=$(awk "NR % 2 == 1" __module_list.txt)
str="gradle "
for module in $modules; do
  str+=":$module:test "
done
$str
