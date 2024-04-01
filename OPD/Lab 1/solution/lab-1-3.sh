#!/usr/bin/bash

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
