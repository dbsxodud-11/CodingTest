import math
import os
import random
import re
import sys
from copy import copy, deepcopy
import operator

# Complete the steadyGene function below.

base = dict()
base['A'] = 0
base['G'] = 1
base['C'] = 2
base['T'] = 3

def steadyGene(gene):

    # Two Pointer Method
    char_list = [[0 for _ in range(4)]]
    for i in range(len(gene)) :
        next_list = deepcopy(char_list[i])
        next_list[base.get(gene[i])] += 1
        char_list.append(next_list)
        
    target = list(map(lambda x : 0 if x < 0 else x,  
                list(map(operator.sub, char_list[len(gene)], [len(gene)//4 for _ in range(4)]                ))
             ))      
    l = 0
    r = 1
    #print(target)
    answer = 500000
    if sum(target) == 0 : return 0

    while l < len(gene) and r <= len(gene) :
        candidate = list(map(operator.sub, char_list[r], char_list[l]))
        if check(target, candidate) :
            #print(l, r)
            answer = r-l if r-l < answer else answer
            l += 1
        else :
            r += 1
            
    return answer

def check(target, candidate) :
    
    for i in range(4) :
        if target[i] == 0 : 
            continue
        else :
            if target[i] > candidate[i] :
                return False
    return True
    
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    gene = input()

    result = steadyGene(gene)

    fptr.write(str(result) + '\n')

    fptr.close()
