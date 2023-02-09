#!/bin/bash

BASE_DIR="/playground/bash/"
INPUT_FILE=$1
PASSWORD='jpassword'
DB_CONNECTOR="$USER/$PASSWORD@//$HOST:$PORT/$SERVICE"
DST_FILE=$BASE_DIR/temp_dst.ctl

echo "`date +%T_%F`:: Loading data from $INPUT_FILE into $TABLE_NAME"

echo "LOAD DATA INFILE '$INPUT_FILE' INTO TABLE $TABLE_NAME APPEND FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '\"' TRAILING NULLCOLS(
#COLUMNS HERE
)" > $DST_FILE

sqlldr control=$DST_FILE userid=$DB_CONNECTOR rows=5000000 errors=999999999  LOG=$BASEDIR/index.log

echo "`date +%T_%F`:: Finished loading data from $INPUT_FILE into $TABLE_NAME"
