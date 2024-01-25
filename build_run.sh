#!/bin/bash


while true; do 
    read -p "Compile all java files ?? " yn
    case $yn in 
        [Yy]* ) javac -d . *.java 
            break;;
        [Nn]* ) exit;;
        *) echo "Please answer yes or no.";;
    esac
done
while true; do 
    read -p "Run the main class " yn
    case $yn in 
        [Yy]* )  echo "
------------Launching the main class------------
            "
            java $1   
            echo "
------------Exiting the main class------------

            "
            break            
        ;;
        [Nn]* ) exit;;
        *) echo "Please answer yes or no.";;
    esac
done
while true; do
    read -p "Continue ?? " yn
    case $yn in
        [Yy]* ) bash build_run.sh $1
            break;;
        [Nn]* ) exit;;
        *) echo "Please answer yes or no.";;
    esac
done