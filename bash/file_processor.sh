#!/bin/bash
# Written by Maswi on Mar 3 2022

EXPORTPATH="exports/export_`date +%Y%m%d%H%M%S`.csv"
MSISDN=""
IP=""
echo  "`date +%T_%F`:: Starting the script..."
echo  "`date +%T_%F`:: Clearing the exort path if exists..."
rm -rf $EXPORTPATH
echo  "`date +%T_%F`:: Appending headers..."
echo "MSISDN, IP_ADDRESS" > $EXPORTPATH

echo  "`date +%T_%F`:: Pulling available files..."

for file in files/*
    do
        if [ -f $file ]
            then
                echo  "`date +%T_%F`:: Processing $file"
                while read line
                    do
                        if grep -q "^\<" <<< "$line" 
                            then
                                MSISDN=""
                                IP=""
                                echo 'Hapa tulifika...'
                        fi
                        if [[ -z $MSISDN ]]
                            then
                                echo $line | grep -o -E '^255\d{9,12}' | sort -u -f
                                MSISDN=$(echo $line | grep -o -E '^255\d{9,12}' | sort -u -f)
                                echo "Hata mi nilifika na MSISDN=$MSISDN"
                        fi
                        if [[ -z $IP ]] 
                            then
                                echo "Hata IP alifika.."
                                IP=$(echo $line | grep -o -E '172\.27\.[0-9]+\.[0-9]+' | sort -u -f)
                        fi
                        if [[ -n $MSISDN && -n $IP ]]
                            then
                                echo $MSISDN, $IP >> $EXPORTPATH
                                MSISDN=""
                                IP=""
                        fi
                done < $file
            exit
        fi
    done    

echo  "`date +%T_%F`:: The output has been stored in $EXPORTPATH" 

echo  "`date +%T_%F`:: Exiting the script..." 