#!/usr/bin/env bash

function test_one() {
  test=$1
  echo "testing $test"

  C="java -jar target/enk.jar "
  R="java -cp tests $test"

  # clean
  [[ -f tests/${test}.class ]] && rm tests/${test}.class
  [[ -f tests/${test}.result ]] && rm tests/${test}.result

  # compile
  CMD="$C tests/${test}.enk"
  $CMD

  # run
  $R > tests/${test}.result

  # diff
  diff tests/${test}.result tests/${test}.expect 2>&1 > /dev/null

  [[ 0 -ne $? ]] && echo "failed on $test" && exit 1;
}

for x in $(ls tests/*.enk);
do 
  file=$(basename $x)
  name=${file%.*}
  test_one $name
done

echo ""
echo "pass"

