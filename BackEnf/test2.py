import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

data = pd.read_csv('test.csv')

def loss_function(m, b, points):
  total_error = 0
  for i in range(len(points)):
    x = points.iloc[i].SAT
    y = points.iloc[i].GPA
    total_error += (y - (m*x+b))**2
  total_error/float(len(points))

def gradient_descent(m_now, b_now, points, L):
  m_gradient = 0
  b_gradient = 0

  n = len(points)

  for i in range(n):
    x = points.iloc[i].GPA
    y = points.iloc[i].SAT

    m_gradient += -(2) * x * (y - (m_now * x + b_now))
    b_gradient += -(2) * (y - (m_now * x + b_now))

  m_now -= (m_gradient/n) * L
  b_now -= (b_gradient/n) * L
  return m_now, b_now

m = 0
b = 0
L = 0.0001
iterations = 1000

for i in range(iterations):
  m, b = gradient_descent(m, b, data, L)
print(m,b)
plt.scatter(data.GPA, data.SAT, color="black")
plt.plot(list(range(2,8)), [m*x+b for x in range(2,8)], color="red")
plt.show()
