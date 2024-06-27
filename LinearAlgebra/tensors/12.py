A = [
    [3, -1, 6, 6, -5, -6, -5, 6, 5],
    [-1, -1, -3, -5, 6, -5, 0, -4, 5],
    [4, 0, -2, 2, 0, -6, -4, 3, -2],
    [-2, 2, 0, 2, -2, 3, -4, -5, 0],
    [3, 3, 2, 2, -4, -5, -1, -4, -3],
    [4, 5, 5, 2, -4, 0, 6, 5, -5],
    [-2, 4, 3, 0, -2, -1, -1, 2, 1],
    [6, -4, 3, 0, -6, 3, 1, 4, 0],
    [6, -5, -5, -5, -4, -5, 0, -3, -2],
]


layer_vertical = []
for k in range(1, 4):
    layer_horizontal = []
    for l in range(1, 4):
        column = []
        for i in range(1, 4):
            line = []
            for m in range(1, 4):
                line.append([[i, m, k, l], A[(k - 1) * 3 + i - 1][(l - 1) * 3 + m - 1]])
            column.append(line)
        layer_horizontal.append(column)
    layer_vertical.append(layer_horizontal)

B = [[0 for _ in range(9)] for _ in range(9)]

for sloy in layer_vertical:
    for column in sloy:
        for line in column:
            for el in line:
                m = el[0][0]  # k
                l = el[0][1]  # m
                k = el[0][2]  # l
                i = el[0][3]  # i
                B[(k - 1) * 3 + i - 1][(l - 1) * 3 + m - 1] = el[1]
                print(el, [i, m, k, l])
            print()
        print()
    print("----------\n")


def format_number(num):
    if num == int(num):
        return str(int(num))
    elif num == -0.0:
        return "0"
    else:
        return str(num)


output_vectors = (
    "["
    + "; ".join(
        [", ".join(map(str, [format_number(element) for element in vec])) for vec in B]
    )
    + "]"
)

print(output_vectors)
