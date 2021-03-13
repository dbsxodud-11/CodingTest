import math
import os
import random
import re
import sys
from collections import deque

# Complete the maxValue function below.
def maxValue(t):

    # 1. Brute Force - check all substring
    # substrings = set()
    # answer = 0
    # for i in range(len(t)) :
    #     for j in range(1, len(t)+1) :
    #         target = t[i:j]
    #         candidate = len(target)
    #         if target in substrings :
    #             continue
    #         else :
    #             for k in range(1, len(t)-j+1) :
    #                 # print(t[i+k:j+k])
    #                 if target == t[i+k:j+k] :
    #                     candidate+=len(target)
    #             answer = max(candidate, answer)
    #             substrings.add(target)
    #             # print(answer)
    # return answer

    # 2. Suffix Sort
    sufficies = []
    for i in range(len(t)) :
        sufficies.append(t[i:])
    sufficies.sort()
    # print(str(sufficies))
    
    histogram = []
    for i in range(len(t)-1) :
        x = lcp(sufficies[i], sufficies[i+1])
        histogram.append(len(x))

    # Largest Rectangle
    stack = deque()
    max_area = 0
    i=0
    while i < len(histogram) :
        if len(stack)== 0 or histogram[stack[-1]] <= histogram[i] :
            stack.append(i)
            i +=1
        else :
            candidate = histogram[stack.pop()] * (i+1 if len(stack)==0 else i-stack[-1])
            max_area = max(max_area, candidate)
    while len(stack) > 0 :
        candidate = histogram[stack.pop()] * (i+1 if len(stack)==0 else i-stack[-1])
        max_area = max(max_area, candidate)
    return max(len(t), max_area)
    
def lcp(a, b) :
    
    n = min(len(a), len(b))
    for i in range(n) :
        if a[i] != b[i] : return a[:i]
    return a
    
if __name__ == '__main__':
    fptr = open("result.txt", 'w')

    t = input()

    result = maxValue(t)

    fptr.write(str(result) + '\n')

    fptr.close()
