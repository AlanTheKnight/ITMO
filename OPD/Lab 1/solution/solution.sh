#!/usr/bin/bash

########################
# Пункт 1              #
########################

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

########################
# Пункт 2              #
########################

chmod 660 ~/lab0/beheeyem4                   # файл beheeyem4
chmod u=rx,go=rwx ~/lab0/buneary0            # каталог buneary0 (577)
chmod 046 ~/lab0/buneary0/swablu             # файл swablu
chmod u=r,g=r,o= ~/lab0/buneary0/glalie      # файл glalie (440)
chmod u=rw,g=r,o= ~/lab0/buneary0/finneon    # файл finneon (640)
chmod u=r,g=,o=r ~/lab0/cleffa8              # файл cleffa8 (404)
chmod u=rw,g=w,o=r ~/lab0/swalot5            # файл swalot5 (624)
chmod u=rx,g=wx,o=rwx ~/lab0/tirtouga1       # каталог tirtouga1
chmod u=wx,g=x,o=x ~/lab0/tirtouga1/chimchar # каталог chimchar
chmod 046 ~/lab0/tirtouga1/pidgeotto         # файл pidgeotto
chmod u=r,g=,o= ~/lab0/tirtouga1/camerupt    # файл camerupt
chmod a=rwx ~/lab0/totodile2                 # каталог totodile2
chmod g-r ~/lab0/totodile2
chmod u=rwx,g=wx,o=rwx ~/lab0/totodile2/jumpluff # каталог jumpluff
chmod u=,g=,o=r ~/lab0/totodile2/glaceon         # файл glaceon
chmod u=rw,g=,o=r ~/lab0/totodile2/furret        # файл furret

########################
# Пункт 3              #
########################

# Создать жесткую ссылку для файла swalot5 с именем lab0/tirtouga1/pidgeottoswalot
chmod u+w ~/lab0/tirtouga1
ln ~/lab0/swalot5 ~/lab0/tirtouga1/pidgeottoswalot
chmod u-w ~/lab0/tirtouga1

# Создать символическую ссылку с именем Copy_81 на директорию tirtouga1 в каталоге lab0
ln -s ~/lab0/tirtouga1 ~/lab0/Copy_81

# Создать символическую ссылку для файла swalot5 с именем lab0/buneary0/finneonswalot:
chmod u+w ~/lab0/buneary0
ln -s ~/lab0/swalot5 ~/lab0/buneary0/finneonswalot
chmod u-w ~/lab0/buneary0

# Скопировать содержимое файла cleffa8 в новый файл lab0/tirtouga1/cameruptcleffa:
chmod u+w ~/lab0/tirtouga1
cat ~/lab0/cleffa8 > ~/lab0/tirtouga1/cameruptcleffa
chmod u-w ~/lab0/tirtouga1

# Скопировать файл cleffa8 в директорию lab0/tirtouga1/chimchar:
cp ~/lab0/cleffa8 ~/lab0/tirtouga1/chimchar

# Скопировать рекурсивно директорию totodile2 в директорию lab0/tirtouga1/chimchar:
chmod u+r ~/lab0/totodile2/glaceon
cp -r ~/lab0/totodile2 ~/lab0/tirtouga1/chimchar
chmod u-r ~/lab0/totodile2/glaceon

# Объединить содержимое файлов lab0/tirtouga1/camerupt и lab0/buneary0/finneon в новый файл lab0/beheeyem4_16:
cat ~/lab0/tirtouga1/camerupt ~/lab0/buneary0/finneon >~/lab0/beheeyem4_16

########################
# Пункт 4              #
########################

# Подсчитать количество символов содержимого файлов:
# swablu, glalie, finneon, pidgeotto, camerupt
# отсортировать вывод по увеличению количества,
# ошибки доступа не подавлять и не перенаправлять

wc -m ~/lab0/buneary0/swablu ~/lab0/buneary0/glalie ~/lab0/buneary0/finneon ~/lab0/tirtouga1/pidgeotto ~/lab0/tirtouga1/chimchar | sort -n

# Вывести список имен и атрибутов файлов в директории
# totodile2, список отсортировать по возрастанию размера,
# ошибки доступа не подавлять и не перенаправлять

ls -lSr ~/lab0/totodile2 | grep -v '^total'
# ls -l ~/lab0/totodile2 | grep -v '^total' | sort -rk5,5n

# Рекурсивно вывести содержимое файлов из директории
# lab0, имя которых заканчивается на 't', строки
# отсортировать по имени a->z, ошибки доступа перенаправить
# в файл в директории /tmp
cat ~/lab0/*/*t ~/lab0/*t 2>/tmp/s408512-error.log | sort

# Вывести список имен и атрибутов файлов в директории buneary0,
# список отсортировать по убыванию размера, ошибки доступа
# перенаправить в файл в директории /tmp
ls -lS ~/lab0/buneary0 2>/tmp/s408512-error.log

# Вывести четыре последних элемента рекурсивного списка имен
# и атрибутов файлов в директории lab0, начинающихся на символ
# 'c', список отсортировать по возрастанию количества жестких
# ссылок, ошибки доступа перенаправить в файл в директории /tmp
ls -Rl ~/lab0 2>/tmp/s408512-error.log | grep " c" | sort -rnk 2,2 | tail -n 4

# Рекурсивно вывести содержимое файлов с номерами строк из
# директории lab0, имя которых начинается на 'c', строки
# отсортировать по имени z->a, ошибки доступа перенаправить
# в файл в директории /tmp
cat -n ~/lab0/*/c* ~/lab0/c* 2>/tmp/s408512-error.log | sort -r -k 2,2

########################
# Пункт 5              #
########################

# Удалить файл beheeyem4:
rm -f ~/lab0/beheeyem4

# Удалить файл lab0/buneary0/finneon:
chmod u+w ~/lab0/buneary0
rm -f ~/lab0/buneary0/finneon
chmod u-w ~/lab0/buneary0

# Удалить символические ссылки Copy_*:
rm -f ~/lab0/Copy_*

# Удалить жесткие ссылки lab0/tirtouga1/pidgeottoswal*:
chmod u+w ~/lab0/tirtouga1
rm -f ~/lab0/tirtouga1/pidgeottoswal*
chmod u-w ~/lab0/tirtouga1

# Удалить директорию buneary0:
chmod u+w ~/lab0/buneary0
rm -rf ~/lab0/buneary0

# Удалить директорию lab0/totodile2/jumpluff:
rmdir ~/lab0/totodile2/jumpluff
