#!/bin/bash
# Written by Maswi on Mar 3 2022

EXPORTPATH="exports/export_`date +%Y%m%d%H%M%S`.csv"

echo  "`date +%T_%F`: Starting pulling files..."

# Creting Headers
echo "MSISDN, IP_ADDRESS" > $EXPORTPATH

echo  "`date +%T_%F`: Processing available files..."


for file in files/*
    do
        if [ -f $file ]
            then
                MSISDN=$(grep -o -E '2553.{11}' "$file" | sort -u -f)
                IP=$(grep -o -E '172\.27\.[0-9]+\.[0-9]+' $file | sort -u -f)
                echo $MSISDN, $IP >> $EXPORTPATH
        fi
    done    

echo  "`date +%T_%F`: The output has been stored in $EXPORTPATH" 

echo  "`date +%T_%F`: Exiting the script..." 