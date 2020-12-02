import math
import operator

def generate_input_file() :

    input_file = open("user_rating.txt", "w")
    input_file.write("5 4 1 2  \n")
    input_file.write("3   4 4 5\n")
    input_file.write("1 2 3 5 4\n")
    input_file.write("4 3   4 2\n")
    input_file.write("1 5   3 4\n")
    input_file.write("2     1 5\n")
    input_file.close()

def getScore(user_rating, i, j) :

    user_i_rated = list(filter(lambda x : x!= 0, user_rating[i]))
    y_i_bar = sum(user_i_rated) / len(user_i_rated)

    neighbor_index = []
    for k in range(len(user_rating)) :
        if i == k : continue
        if user_rating[k][j] != 0 :
            neighbor_index.append(k)

    weights = dict()
    for neighbor in neighbor_index :
        weights[neighbor] = getWeight(user_rating, i, neighbor)

    numerator = 0
    denominator = 0

    for l in neighbor_index :
        user_l_rated = list(filter(lambda x : x!=0, user_rating[l]))
        y_l_bar = sum(user_l_rated) / len(user_l_rated)

        numerator += weights.get(l) * (user_rating[l][j] - y_l_bar)
        denominator += abs(weights.get(l))

    return y_i_bar + (numerator / denominator)

def getWeight(user_rating, i, l) :

    user_i = user_rating[i]
    user_l = user_rating[l]

    user_i_rated = list(filter(lambda x: x!=0, user_i))
    user_l_rated = list(filter(lambda x: x!=0, user_l))

    y_i_bar = sum(user_i_rated) / len(user_i_rated)
    y_l_bar = sum(user_l_rated) / len(user_l_rated)

    both_rated_index = []
    for k in range(len(user_rating[0])) :
        if user_i[k] != 0 and user_l[k] != 0 :
            both_rated_index.append(k)

    numerator = 0
    denominator_1 = 0
    denominator_2 = 0

    for j in both_rated_index :
        numerator += (user_i[j] - y_i_bar)*(user_l[j] - y_l_bar)
        denominator_1 += (user_i[j] - y_i_bar)**2
        denominator_2 += (user_l[j] - y_l_bar)**2

    return numerator / ((math.sqrt(denominator_1))*(math.sqrt(denominator_2)))

if __name__ == "__main__" :
    generate_input_file()

    # 2D array
    with open("user_rating.txt", "r") as f:
        lines = f.readlines()
    items = 5
    user_rating = [[0 for _ in range(items)] for _ in range(len(lines))]
    blank = [[0 for _ in range(items)] for _ in range(len(lines))]

    for i, line in enumerate(lines) :
        user_i = line.rstrip("\n")
        for j in range(items) :
            if user_i[2*j] != ' ' :
                user_rating[i][j] = int(user_i[2*j])

        # print(str(user_rating[i]))

    # Fill the Blank
    for i in range(len(user_rating)) :
        for j in range(len(user_rating[i])) :
            if user_rating[i][j] == 0 :
                score = getScore(user_rating, i, j)
                blank[i][j] = int(round(score*100)) * 0.01

    # Merge
    for i in range(len(lines)) :
        user_rating[i] = list(map(operator.add, user_rating[i], blank[i]))

    for user_i_ in user_rating :
        print(user_i_)
