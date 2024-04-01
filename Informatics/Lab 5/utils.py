def calculateX(number):
    res = ["X" + str(number) + " ="]
    if number == 1:
        res += ["A =", "=C1"]
    elif number == 2:
        res += ["C =", "=C2"]
    elif number == 3:
        res +=  ["A + C =", "=C1 + C2"]
    elif number == 4:
        res +=  ["A + C + C =", "=C1 + C2 + C2"]
    elif number == 5:
        res +=  ["C - A =", "=C2 - C1"]
    elif number == 6:
        res +=  ["65536 - X4 =", "=65536 - C7"]
    elif number == 7:
        res +=  ["-X1 =", "=-C4"]
    elif number == 8:
        res +=  ["-X2 =", "=-C5"]
    elif number == 9:
        res +=  ["-X3 =", "=-C6"]
    elif number == 10:
        res +=  ["-X4 =", "=-C7"]
    elif number == 11:
        res +=  ["-X5 =", "=-C8"]
    elif number == 12:
        res +=  ["-X6 =", "=-C9"]
    return res
