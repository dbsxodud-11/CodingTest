import math
import os
import random
import re
import sys

# Complete the pairs function below.
def pairs(k, arr):

    arr = sorted(arr)
    answer = 0
    # for i in range(len(arr)) :
    #     target = arr[i] + k 
    #     if target in arr : # O(n) time -> use hashset(arr[i] is unique)
    #         answer += 1
            
    # return answer
    array_set = set(arr)
    for i in range(len(arr)) :
        target = arr[i] + k
        if target in array_set : # O(1) time
            answer += 1
    return answer    
    
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    nk = input().split()

    n = int(nk[0])

    k = int(nk[1])

    arr = list(map(int, input().rstrip().split()))

    result = pairs(k, arr)

    fptr.write(str(result) + '\n')

    fptr.close()
