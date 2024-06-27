import numpy as np
from math import sqrt


def matrix_multiply(A: np.ndarray, B: np.ndarray) -> np.ndarray:
    return np.dot(A, B)


def transpose_matrix(matrix: np.ndarray) -> np.ndarray:
    return np.transpose(matrix)


def get_norm(G: np.ndarray, matrix: np.ndarray) -> float:
    result = matrix_multiply(transpose_matrix(matrix), matrix_multiply(G, matrix))
    return sqrt(result[0, 0])


def get_projection(G: np.ndarray, a: np.ndarray, b: np.ndarray) -> np.ndarray:
    numerator = matrix_multiply(transpose_matrix(b), matrix_multiply(G, a))[0, 0]
    denominator = matrix_multiply(transpose_matrix(b), matrix_multiply(G, b))[0, 0]
    if denominator == 0:
        return np.zeros_like(a)
    return (numerator / denominator) * b


def vector_subtract(v1: np.ndarray, v2: np.ndarray) -> np.ndarray:
    return v1 - v2


def gram_schmidt_process(G: np.ndarray, vectors: list[np.ndarray]) -> list[np.ndarray]:
    orthogonal_basis = []
    for v in vectors:
        for basis in orthogonal_basis:
            projection = get_projection(G, v, basis)
            v = vector_subtract(v, projection)
        if get_norm(G, v) != 0:
            orthogonal_basis.append(v)
    return orthogonal_basis


G_size = int(input("Введите размер матрицы Грама: "))
G = np.array(
    [
        list(map(int, input(f"Введите {G_size} элементов {i+1}-й строки: ").split()))
        for i in range(G_size)
    ]
)

n_vectors = int(input("Введите количество векторов: "))
vectors = [
    np.array(
        list(map(int, input(f"Введите {G_size} элементов {i+1}-го вектора: ").split()))
    ).reshape(-1, 1)
    for i in range(n_vectors)
]

orthogonal_vectors = gram_schmidt_process(G, vectors)


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
        [
            ", ".join(map(str, [format_number(element[0]) for element in vec]))
            for vec in orthogonal_vectors
        ]
    )
    + "]"
)
print(output_vectors)
