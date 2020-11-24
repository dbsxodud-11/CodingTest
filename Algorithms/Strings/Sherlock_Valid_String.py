import os
import random
import re
import sys
from collections import defaultdict

# Complete the isValid function below.
def isValid(s):

    # hashmap1 : char -> occurrence
    # hashmap2 : occurence -> char
    hashmap1 = defaultdict(int)
    hashmap2 = defaultdict(int)
    for i in range(len(s)) :
        hashmap1[s[i]] += 1
        if hashmap2[hashmap1.get(s[i])] is None :
            hashmap2[1] += 1
        else : 
            hashmap2[hashmap1.get(s[i])-1] -= 1
            if hashmap2.get(hashmap1.get(s[i])-1) == 0 :
                del hashmap2[hashmap1.get(s[i])-1]
            hashmap2[hashmap1.get(s[i])] += 1
        
    # for key in hashmap1.keys() :
    #     print(key)
    
    del hashmap2[0]
    # Check Validity
    if len(hashmap2) == 1 :
        return "YES"
    elif len(hashmap2) == 2 :
        occur1, occur2 = hashmap2.keys()
        if max(occur1, occur2) - min(occur1, occur2) == 1 and hashmap2.get(max(occur1, occur2)) == 1 :
            return "YES"
        if min(occur1, occur2) == 1 and hashmap2.get(min(occur1, occur2)) == 1 :
            return "YES"
        else :
            return "NO"    
    return "NO"

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    result = isValid(s)

    fptr.write(result + '\n')

    fptr.close()
