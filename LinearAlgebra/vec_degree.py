import math


class MatrixOperations:
    """Class for basic matrix operations"""

    @staticmethod
    def matrix_multiply(A, B):
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
    def transpose_matrix(matrix):
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


class GramMatrix:
    """Class to handle Gram matrix operations"""

    def __init__(self, G):
        """
        Initializes the Gram matrix and performs necessary calculations

        :param G: The Gram matrix
        """
        self.G = G
        self.G_size = len(G)

    def calculate_angle(self, x, y):
        """
        Calculates the angle between two vectors in the Gram space.

        :param x: First vector (matrix form)
        :param y: Second vector (matrix form)
        :return: The angle between vectors x and y in radians
        """
        x_transposed = MatrixOperations.transpose_matrix(x)
        y_transposed = MatrixOperations.transpose_matrix(y)

        xyg = MatrixOperations.matrix_multiply(
            x_transposed, MatrixOperations.matrix_multiply(self.G, y)
        )[0][0]
        norm_x = math.sqrt(
            MatrixOperations.matrix_multiply(
                x_transposed, MatrixOperations.matrix_multiply(self.G, x)
            )[0][0]
        )
        norm_y = math.sqrt(
            MatrixOperations.matrix_multiply(
                y_transposed, MatrixOperations.matrix_multiply(self.G, y)
            )[0][0]
        )
        cos_theta = xyg / (norm_x * norm_y)
        angle = math.acos(cos_theta)
        return angle


def main():
    G_size = int(input("Enter the size of the Gram matrix: "))
    G = []
    for i in range(G_size):
        row = list(map(int, input(f"Enter {G_size} elements for row {i+1}: ").split()))
        G.append(row)

    print()

    x_size = G_size
    x = []
    for i in range(x_size):
        x.append(
            list(map(int, input(f"Enter element for row {i+1} of matrix x: ").split()))
        )

    print()

    y_size = G_size
    y = []
    for i in range(y_size):
        y.append(
            list(map(int, input(f"Enter element for row {i+1} of matrix y: ").split()))
        )

    gram_matrix = GramMatrix(G)
    result = gram_matrix.calculate_angle(x, y)
    print(f"The angle between vectors x and y in radians: {result}")


if __name__ == "__main__":
    main()
