import math
import os
import random
import re
import sys
# from bisect import bisect_right

# Complete the triplets function below.
def triplets(a, b, c):
    
    count = 0
    a = sorted(list(set(a)))
    b = set(b)
    c = sorted(list(set(c)))
    
    for element in b :
        a_count = bisect_right(a, element)
        c_count = bisect_right(c, element)
        count += a_count*c_count
   
    return count

def bisect_right(arr, element) :
    
    lo = 0
    hi = len(arr)
    while lo < hi :
        mid = lo + (hi - lo)//2
        if arr[mid] > element :
            hi = mid
        else :
            lo = mid+1
            
    return lo
    
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    lenaLenbLenc = input().split()

    lena = int(lenaLenbLenc[0])

    lenb = int(lenaLenbLenc[1])

    lenc = int(lenaLenbLenc[2])

    arra = list(map(int, input().rstrip().split()))

    arrb = list(map(int, input().rstrip().split()))

    arrc = list(map(int, input().rstrip().split()))

    ans = triplets(arra, arrb, arrc)

    fptr.write(str(ans) + '\n')

    fptr.close()
