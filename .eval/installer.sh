#!/bin/bash

created=0
[ -d "$1" ] && created=1 || mkdir $1
[ -d "$1/$2" ] && created=2 || mkdir $1/$2
if [ $created -lt 2 ]
then
  cd $1/$2
  git init --bare > /dev/null 2>&1
  cd ../..
fi
cd $3
if [ ! -d $4 ]
then
  git init > /dev/null 2>&1
  git add .
  git commit -m "First commit" > /dev/null 2>&1
  git remote add origin ../$1/$2
fi
cd ..
