def get_minor(matrix, i, j):
    """ Возвращает минор матрицы после удаления i-ой строки и j-ого столбца """
    return [row[:j] + row[j + 1:] for row in (matrix[:i] + matrix[i + 1:])]


def determinant(matrix):
    """ Рекурсивная функция для вычисления определителя """
    # Базовый случай для матрицы 2x2
    if len(matrix) == 2:
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]

    det = 0
    for c in range(len(matrix)):
        det += ((-1) ** c) * matrix[0][c] * determinant(get_minor(matrix, 0, c))
    return det


# Пример использования
matrix = [
    [3, 0, 0, -2],
    [0, 0, -5, -3],
    [1, 1, 1, 0],
    [2, -5, -3, 4]
]

print(f"Определитель матрицы: {determinant(matrix)}")
