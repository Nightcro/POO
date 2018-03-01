#! /bin/bash

for file in ./2[1-9].in; do
	echo $file
	
	sed -i "s/180 200/180 200\n/g" $file
done
