#!/usr/bin/env bash

cd src/main/java;
java -jar $ANTLR_HOME/lib/antlr-4.7.2-complete.jar \
  -no-listener -visitor \
  -package com.gxk.enk.antlr -o com/gxk/enk/antlr Enkel.g4
echo "done"
