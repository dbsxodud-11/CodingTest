#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the highestValuePalindrome function below.
def highestValuePalindrome(s, n, k):
    
    count = 0
    check = [False for _ in range(n)]
    result = [None for _ in range(n)]
    # minimum changes
    for i in range(n//2) :
        if s[i] == s[n-i-1] : 
            result[i] = s[i]
            result[n-i-1] = s[n-i-1]
        else :
            if int(s[i]) > int(s[n-i-1]) :
                result[i] = s[i]
                result[n-i-1] = s[i]
                check[n-i-1] = True
            else : 
                result[i] = s[n-i-1]
                result[n-i-1] = s[n-i-1]
                check[i] = True
            count += 1
    if n%2 == 1 :
        result[n//2] = s[n//2]
    
    if count > k : 
        return '-1'
    else : # Make a highest value palindrome
        for i in range(n//2) :
            if result[i] != '9' :
                if check[i] == False and check[n-i-1] == False :
                    if count + 2 > k : continue
                    count += 2
                else : 
                    if count + 1 > k : continue
                    count += 1
                result[i] = '9'
                result[n-i-1] = '9'
        if n%2 == 1 and k > count :
            result[n//2] = '9'
            
        return "".join(result)
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    nk = input().split()

    n = int(nk[0])

    k = int(nk[1])

    s = input()

    result = highestValuePalindrome(s, n, k)

    fptr.write(result + '\n')

    fptr.close()
