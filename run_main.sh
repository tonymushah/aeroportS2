#!/bin/bash

while true; do 
    read -p "Run this class $1 ?? 
Please be aware with the cases
Answer = " yn
    case $yn in 
        [Yy]* ) echo "
------------Launching the main class------------
            "
            java $1   
            echo "
------------Exiting the main class------------

            "
            break            
        ;;
        [Nn]* ) break;;
        *) echo "You must choose yes or no";;
    esac
done
while true; do 
    read -p "Exit (Ee) or continue (Cc) ?? " ec
    case $ec in 
        [Ee]* ) exit;;
        [Cc]* ) bash run_main.sh $1;;
        * ) echo "Please choose an answer";;
    esac
done