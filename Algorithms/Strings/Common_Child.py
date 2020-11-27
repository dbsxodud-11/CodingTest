import math
import os
import random
import re
import sys

# Complete the commonChild function below.
def commonChild(s1, s2):

    # Dynamic Programming
    # E(i, j) : length of longest string which is a common child of the input strings
    memory = [[0 for _ in range(len(s1))] for _ in range(len(s2))]
    for i in range(len(s1)) :
        for j in range(len(s2)) :
            if i == 0 and j == 0:
                memory[i][j] = diff(s1[i], s2[j])
            elif i == 0 :
                memory[i][j] = max(memory[i][j-1], diff(s1[i], s2[j]))
            elif j == 0 :
                memory[i][j] = max(memory[i-1][j], diff(s1[i], s2[j]))
            else :
                memory[i][j] = max(memory[i-1][j], memory[i][j-1], memory[i-1][j-1] + diff(s1[i], s2[j]))
                
    # for i in memory :
    #     print(str(i))                

    return memory[len(s1)-1][len(s2)-1]
             
def diff(a, b) :
    return 1 if a == b else 0
    
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s1 = input()

    s2 = input()

    result = commonChild(s1, s2)

    fptr.write(str(result) + '\n')

    fptr.close()