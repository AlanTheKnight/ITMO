import sympy as sp
# Определим матрицу
A = sp.Matrix([
[6, -2, 5, 2, -3],
[3, 3, 2, 0, -2],
[-1, -1, 1, 0, 0],
[4, 3, 3, 1, -1],
[3, -2, 3, 1, 0]
])
# Вычислим характеристический многочлен
lambda_ = sp.symbols('lambda')
char_poly = A.charpoly(lambda_)
# Найдём собственные числа (корни характеристического многочлена)
eigenvalues = sp.solve(char_poly.as_expr(), lambda_)


eigenvectors = []
for eigenvalue in eigenvalues:
#Система линейных уравнений для нахождения собственных векторов
    eigenspace = (A - eigenvalue * sp.eye(A.shape[0])).nullspace()
    eigenvectors.append((eigenvalue, eigenspace))


# Определим матрицу
A = sp.Matrix([
[6, -2, 5, 2, -3],
[3, 3, 2, 0, -2],
[-1, -1, 1, 0, 0],
[4, 3, 3, 1, -1],
[3, -2, 3, 1, 0]
])
# Вычислим характеристический многочлен
lambda_ = sp.symbols('lambda')
char_poly = A.charpoly(lambda_)
# Найдём собственные числа (корни характеристического многочлена)
eigenvalues = sp.solve(char_poly.as_expr(), lambda_)
# Найдём собственные векторы и присоединённые векторы
eigenvectors = []
for eigenvalue in eigenvalues:
# Система линейных уравнений для нахождения собственных векторов
eigenspace = (A - eigenvalue * sp.eye(A.shape[0])).nullspace()
eigenvectors.append((eigenvalue, eigenspace))
# Вывод результата
for eigenvalue, vectors in eigenvectors:
print(f"Собственное число: {eigenvalue}")
for vector in vectors:
print(f" Собственный вектор: {vector}")
print()