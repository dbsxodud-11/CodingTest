import math
import os
import random
import re
import sys
from collections import defaultdict
from bisect import bisect_left as bLeft, bisect_right as bRight

def getMinMax(gMap, first, last, d, substring, largest) :
    
    health_point = 0
    for i in range(len(d)) :
        for j in range(i+1, len(d)+1) :
            if j - i > largest :
                break
            target = d[i:j]
            if target not in substring : 
                break
            if target not in gMap.keys() :
                continue
            else :
                hp_list = gMap.get(target)
                # print(first, hp_list[0], getFirst(hp_list[0], first))
                # print(last, hp_list[0], getFirst(hp_list[0], last))
                health_point += hp_list[1][getLast(hp_list[0], last)] - hp_list[1][getFirst(hp_list[0], first)]
               
    return health_point
                
def getFirst(index_list, first, lo=0, hi=None) :
    
    # lo = 0
    # hi = len(index_list)
    # mid = lo + (hi - lo )//2
    # while lo < hi :
    #     mid = lo + (hi - lo) // 2
    #     if index_list[mid] >= first :
    #         hi = mid
    #     else :
    #         lo = mid+1
    # return lo
    if lo < 0:
        raise ValueError('lo must be non-negative')
    if hi is None:
        hi = len(index_list)
    while lo < hi:
        mid = (lo+hi)//2
        # Use __lt__ to match the logic in list.sort() and in heapq
        if index_list[mid] < first: lo = mid+1
        else: hi = mid
    return lo
    
def getLast(index_list, last, lo=0, hi=None) :
    
    # lo = 0
    # hi = len(index_list)
    # mid = lo + (hi - lo)//2
    # while lo < hi :
    #     mid = lo + (hi - lo) // 2
    #     if index_list[mid] > last :
    #         hi = mid
    #     else :
    #         lo = mid+1
            
    # return lo
    if lo < 0:
        raise ValueError('lo must be non-negative')
    if hi is None:
        hi = len(index_list)
    while lo < hi:
        mid = (lo+hi)//2
        # Use __lt__ to match the logic in list.sort() and in heapq
        if last < index_list[mid]: hi = mid
        else: lo = mid+1
    return lo

if __name__ == '__main__':
    n = int(input())

    genes = input().rstrip().split()

    health = list(map(int, input().rstrip().split()))

    s = int(input())

    # gMap : gene -> [indices, health_values]
    substring = set()
    gMap = defaultdict(lambda : [[], [0]])
    for i, gene in enumerate(genes) :
        gMap[gene][0].append(i)
        gMap[gene][1].append(gMap.get(gene)[1][-1]+health[i])
        for j in range(1, len(gene)+1) :
            substring.add(gene[:j])
        
        
    largest = max(list(map(len, genes)))
    
    # for key, value in gMap.items() :
    #     print(key, value)
    health_max = 0
    health_min = math.inf
    
    for s_itr in range(s):
        firstLastd = input().split()

        first = int(firstLastd[0])

        last = int(firstLastd[1])

        d = firstLastd[2]

        health_point = getMinMax(gMap, first, last, d, substring, largest)
        health_max = health_point if health_point > health_max else health_max
        health_min = health_point if health_point < health_min else health_min
    
    print(health_min, health_max)