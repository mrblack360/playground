#!/bin/bash
# Written by Maswi on Mar 3 2022

EXPORTPATH="export.csv"

echo  "`date +%T_%F`: Starting pulling files..." 

for file in files/*
    do
        if [ -f $file ]
            then
                line=$(grep '2553.\{11\}' $file)
                echo $line | cut -c 1-15
                # number=$(cut -c 1-15 $line)
                # echo $number
        fi
    done    

echo  "`date +%T_%F`: Exiting the script..." 