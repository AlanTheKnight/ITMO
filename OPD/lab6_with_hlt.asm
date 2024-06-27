ORG 0x0
V0: WORD $default, 0x180
V1: WORD $int1,    0x180
V2: WORD $default, 0x180
V3: WORD $int3,    0x180
V4: WORD $default, 0x180
V5: WORD $default, 0x180
V6: WORD $default, 0x180
V7: WORD $default, 0x180

ORG 0x043

X: WORD ?

max: WORD 0x0028     ; Верхняя граница ОДЗ
min: WORD 0xFFD3     ; Нижняя граница ОДЗ
default: IRET        ; Обработка прерывания по умолчанию

START:  DI
        CLA
        OUT 1        ; MR КВУ-1 на вектор 0
        OUT 5        ; MR КВУ-2 на вектор 0
        LD #0x9      ; Разрешить прерывания и вектор #1
        OUT 3        ; (1000|0001=1001) в MR КВУ-1
        LD #0xB      ; Разрешить прерывания и вектор #3
        OUT 7        ; (1000|0011=1011) в MR КВУ-3
        EI
        LD #0x26
        ST X

main:   DI           ; Запрет прерываний, чтобы обеспечить атомарность
        LD X
        ADD #3       ; X = X + 3
        CALL check
        ST X
        EI           ; Разрешить прерывания
        JUMP main

int1:   DI           ; Обработка прерывания на ВУ-1
        LD X
        HLT
        ASL
        ADD X
        NEG
        SUB #7
        OUT 2
        HLT
        EI
        IRET

int3:   DI
        LD X
        HLT
        IN 6
        PUSH
        ASL
        ADD &0
        HLT
        SUB X
        ST X
        OUT 6
        HLT
        POP
        EI
        IRET

check:                    ; Проверка принадлежности X к ОДЗ
check_min: CMP min        ; Если X > min, то проверяем максимум
           BPL check_max
           JUMP ld_min    ; Иначе загружаем минимум
check_max: CMP max        ; Проверка верхней границы
           BMI return     ; Если X < max, то возврат
ld_min:    LD min         ; Загрузка минимума
return:    RET            ; Возврат
