import math
import os
import random
import re
import sys
from collections import defaultdict
from copy import copy, deepcopy

# Complete the sherlockAndAnagrams function below.
def sherlockAndAnagrams(s):
    
    # hashmap : char_list -> occurence
    hashmap = defaultdict(int)
    for i in range(len(s)) :
        char_list = [0 for _ in range(26)]
        char_list[ord(s[i]) - 97] += 1
        hashmap[tuple(char_list)] += 1
        next_list = deepcopy(char_list)
        for j in range(i+1, len(s)) :
            next_list[ord(s[j])-97] += 1
            hashmap[tuple(next_list)] += 1
    # for key, value in hashmap.items() :
    #     print(str(key), value)
    
    count = 0
    for value in hashmap.values() :
        if value == 1 : continue
        else : 
            count += value * (value-1) // 2
    
    return count
    
if __name__ == '__main__':
    fptr = open("testcase_1.txt", 'w')

    q = int(input())

    for q_itr in range(q):
        s = input()

        result = sherlockAndAnagrams(s)

        fptr.write(str(result) + '\n')

    fptr.close()
