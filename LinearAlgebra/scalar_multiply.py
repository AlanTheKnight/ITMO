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
            raise ValueError("The number of columns in the first matrix must equal the number of rows in the second matrix")

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
        x.append(list(map(int, input(f"Enter element for row {i+1} of matrix x: ").split())))

    print()

    y_size = G_size
    y = []
    for i in range(y_size):
        y.append(list(map(int, input(f"Enter element for row {i+1} of matrix y: ").split())))

    result = MatrixOperations.matrix_multiply(MatrixOperations.transpose_matrix(x), MatrixOperations.matrix_multiply(G, y))[0][0]
    print(result)


if __name__ == "__main__":
    main()
