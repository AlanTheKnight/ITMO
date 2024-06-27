layer_vertical = []
for k in range(1, 3):
    layer_horizontalmn = []
    for l in range(1, 3):
        column = []
        for i in range(1, 4):
            line = []
            for m in range(1, 4):
                line.append([i, m, l, k, j])
            column.append(line)
        layer_horizontalmn.append(column)
    layer_vertical.append(layer_horizontalmn)


for ssloy in sssloy:
    for sloi in ssloy:
        for column in sloi:
            for line in column:
                t = line[0]
                j = line[1]
                l = line[2]
                p = line[3]
                n = line[4]
                print(line, 3*p + t - 3*i - 3*j - 3*n, end=' ')