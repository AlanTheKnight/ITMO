#!/usr/bin/bash

if [ -d ~/lab0 ]; then
    chmod -R 777 ~/lab0
    rm -rf ~/lab0
fi

mkdir ~/lab0
cd ~/lab0

mkdir buneary0
mkdir -p tirtouga1/chimchar
mkdir -p totodile2/jumpluff

echo "satk=4 sdef=8
spd=5" >./buneary0/swablu                     # Create swablu file
echo "satk=8 sdef=8 spd=8" >./buneary0/glalie # Create glalie file
echo "Ходы   Air Cutter Aqua Tail
Bounce Defog Dive Icy Wind Ominous Wind Signal Beam Sleep Talk Snore
Swift Twister Tailwind" >./buneary0/finneon # Create finneon file

echo "Тип покемона   PSYCHIC NONE" >beheeyem4 # Create beheeyem4 file
echo "satk=5 sdef=6 spd=2" >cleffa8           # Create cleffa8 file
echo "satk=7
sdef=8 spd=6" >swalot5 # Create swalot5 file

echo "Возможности   Overland=6 Surface=1 Sky=10
Jump=3 Power2=0 Intelligence=3" >tirtouga1/pidgeotto # Create pidgeotto file
echo "Развитые способности   Anger
Point" >tirtouga1/camerupt # Create camerupt file

echo "Тип покемона   ICE NONE" >totodile2/glaceon # Create glaceon file
echo "satk=5 sdef=6 spd=9" >totodile2/furret      # Create furret file
