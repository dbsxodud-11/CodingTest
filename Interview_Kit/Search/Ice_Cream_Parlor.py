import math
import os
import random
import re
import sys

# Complete the whatFlavors function below.
def whatFlavors(cost, money):
    
    counterpart = dict()
    for i, c in enumerate(cost) :
        if c in counterpart.keys() :
            if 2*c == money :
                return counterpart.get(c)[0]+1, i+1
        else :
            counterpart[c] = [i, money-c]
    
    for value in counterpart.values() :
        if value[1] in counterpart.keys() :
            first = value[0]+1
            second = counterpart.get(value[1])[0]+1
            if first != second :
                return first, second 
                
        
        
if __name__ == '__main__':
    t = int(input())

    for t_itr in range(t):
        money = int(input())

        n = int(input())

        cost = list(map(int, input().rstrip().split()))

        first, last = whatFlavors(cost, money)
        if first > last :
            temp = last
            last = first
            first = temp
        print(first, last)
