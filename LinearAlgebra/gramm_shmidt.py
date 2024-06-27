from math import sqrt
from typing import List


class MatrixOperations:
    """Class for basic matrix operations"""

    @staticmethod
    def matrix_multiply(A: List[List[int]], B: List[List[int]]) -> List[List[int]]:
        """
        Multiplies two matrices A and B.

        :param A: First matrix
        :param B: Second matrix
        :return: Resulting matrix after multiplication
        """
        if len(A[0]) != len(B):
            raise ValueError(
                "The number of columns in the first matrix must equal the number of rows in the second matrix"
            )

        result = [[0 for _ in range(len(B[0]))] for _ in range(len(A))]

        for i in range(len(A)):
            for j in range(len(B[0])):
                for k in range(len(B)):
                    result[i][j] += A[i][k] * B[k][j]

        return result

    @staticmethod
    def transpose_matrix(matrix: List[List[int]]) -> List[List[int]]:
        """
        Transposes a given matrix.

        :param matrix: The matrix to transpose
        :return: Transposed matrix
        """
        transposed = [[0 for _ in range(len(matrix))] for _ in range(len(matrix[0]))]

        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                transposed[j][i] = matrix[i][j]

        return transposed

    @staticmethod
    def get_norm(G: List[List[int]], matrix: List[List[int]]) -> float:
        """
        Calculates the norm of a vector in the Gram matrix space.

        :param G: Gram matrix
        :param matrix: Vector in matrix form
        :return: Norm of the vector
        """
        result = MatrixOperations.matrix_multiply(
            MatrixOperations.transpose_matrix(matrix),
            MatrixOperations.matrix_multiply(G, matrix),
        )
        return sqrt(result[0][0])

    @staticmethod
    def get_projection(
        G: List[List[int]], a: List[List[int]], b: List[List[int]]
    ) -> List[List[int]]:
        """
        Calculates the projection of vector a onto vector b in the Gram matrix space.

        :param G: Gram matrix
        :param a: Vector a
        :param b: Vector b
        :return: Projection of a onto b
        """
        numerator = MatrixOperations.matrix_multiply(
            MatrixOperations.transpose_matrix(b), MatrixOperations.matrix_multiply(G, a)
        )[0][0]
        denominator = MatrixOperations.matrix_multiply(
            MatrixOperations.transpose_matrix(b), MatrixOperations.matrix_multiply(G, b)
        )[0][0]
        if denominator == 0:
            return [[0] for _ in range(len(a))]
        return [[numerator / denominator * x[0]] for x in b]

    @staticmethod
    def vector_subtract(v1: List[List[int]], v2: List[List[int]]) -> List[List[int]]:
        """
        Subtracts vector v2 from vector v1.

        :param v1: Vector v1
        :param v2: Vector v2
        :return: Resulting vector after subtraction
        """
        return [[x[0] - y[0]] for x, y in zip(v1, v2)]


class GramSchmidt:
    """Class to perform Gram-Schmidt process"""

    def __init__(self, G: List[List[int]]):
        """
        Initializes with Gram matrix G.

        :param G: Gram matrix
        """
        self.G = G

    def gram_schmidt_process(
        self, vectors: List[List[List[int]]]
    ) -> List[List[List[int]]]:
        """
        Performs the Gram-Schmidt orthogonalization process.

        :param vectors: List of vectors to orthogonalize
        :return: Orthogonalized vectors
        """
        orthogonal_basis = []
        for v in vectors:
            for basis in orthogonal_basis:
                projection = MatrixOperations.get_projection(self.G, v, basis)
                v = MatrixOperations.vector_subtract(v, projection)
            if MatrixOperations.get_norm(self.G, v) != 0:
                orthogonal_basis.append(v)
        return orthogonal_basis


def format_number(num: float) -> str:
    """
    Formats a number to a string, removing unnecessary decimal places.

    :param num: Number to format
    :return: Formatted string
    """
    if num == -0.0:
        return "0"
    return str(int(num)) if num == int(num) else format(num, ".16f")


def main():
    G_size = int(input("Enter the size of the Gram matrix: "))
    G = []
    for i in range(G_size):
        row = list(map(int, input(f"Enter {G_size} elements for row {i+1}: ").split()))
        G.append(row)

    n_vectors = int(input("Enter the number of vectors: "))
    vectors = []
    for i in range(n_vectors):
        vector = list(
            map(int, input(f"Enter {G_size} elements for vector {i+1}: ").split())
        )
        formatted_vector = [[element] for element in vector]
        vectors.append(formatted_vector)

    gram_schmidt = GramSchmidt(G)
    orthogonal_vectors = gram_schmidt.gram_schmidt_process(vectors)

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


if __name__ == "__main__":
    main()
