if [ "$CIRCLE_BRANCH" == "dev" ] || [ "$CIRCLE_BRANCH" == "stg" ] || [ "$CIRCLE_BRANCH" == "prod" ]
then
  modules=$(awk "NR % ${CIRCLE_NODE_TOTAL} == ${CIRCLE_NODE_INDEX}" __module_list.txt)
  str="gradle --info "
  for module in $modules; do
    str+=":$module:build "
  done
  $str

  for module in $modules; do
    aws s3 sync $module/build/libs s3://tenma-dev-dap/circle_ci/$module --delete
  done
fi
