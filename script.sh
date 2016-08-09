if [ "$CIRCLE_BRANCH" != "dev" ]
then
  python getModules.py
  modules=$(awk "NR % ${CIRCLE_NODE_TOTAL} == ${CIRCLE_NODE_INDEX}" __module_list.txt)
  str="gradle --info "
  for module in $modules; do
    str+=":$module:test "
  done
  $str
  cd rails_module
  bin/rails test
  cd ..
fi
