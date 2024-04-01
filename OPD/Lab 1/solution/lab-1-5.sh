#!/usr/bin/bash

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
