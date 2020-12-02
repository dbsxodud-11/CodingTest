import math
import operator

def generate_input_file() :

    input_file = open("user_rating.txt", "w")
    input_file.write("5 4 1 2  \n")
    input_file.write("3   4 4 5\n")
    input_file.write("1 2 3 5 4\n")
    input_file.write("4 3   4 2\n")
    input_file.write("1 5   3 4\n")
    input_file.close()

def getScore(user_rating, i, j) :

    item_j_rated = [user_rating[k][j] for k in range(len(user_rating))]
    item_j_rated = list(filter(lambda x : x != 0, item_j_rated))
    y_bar_j = sum(item_j_rated) / len(item_j_rated)

    weights = dict()
    neighbor_index = []
    for k in range(items) :
        if k == j :
            continue
        if user_rating[i][k] != 0 :
            neighbor_index.append(k)
    
    for neighbor in neighbor_index :
        weights[neighbor] = getWeight(user_rating, j, neighbor)

    numerator = 0
    denominator = 0

    for l in neighbor_index :

        item_l_rated = [user_rating[k][l] for k in range(len(user_rating))]
        item_l_rated = list(filter(lambda x : x!= 0, item_l_rated))
        y_bar_l = sum(item_l_rated) / len(item_l_rated)

        numerator += weights.get(l) * (user_rating[i][l] - y_bar_l)
        denominator += abs(weights.get(l))

    return y_bar_j + (numerator / denominator)


def getWeight(user_rating, j, l) :

    item_l_rated = [user_rating[k][l] for k in range(len(user_rating))]
    item_l_rated = list(filter(lambda x : x!= 0, item_l_rated))
    y_bar_l = sum(item_l_rated) / len(item_l_rated)

    item_j_rated = [user_rating[k][j] for k in range(len(user_rating))]
    item_j_rated = list(filter(lambda x : x!= 0, item_j_rated))
    y_bar_j = sum(item_j_rated) / len(item_j_rated)

    both_rated_user = []
    for k in range(len(user_rating)) :
        if user_rating[k][l] != 0 and user_rating[k][j] != 0 :
            both_rated_user.append(k)

    numerator = 0
    denominator_1 = 0
    denominator_2 = 0

    for i in both_rated_user :
        numerator += (user_rating[i][j] - y_bar_j) * (user_rating[i][l] - y_bar_l)
        denominator_1 += (user_rating[i][j] - y_bar_j)**2
        denominator_2 += (user_rating[i][l] - y_bar_l)**2

    return numerator / (math.sqrt(denominator_1)*math.sqrt(denominator_2))


if __name__ == "__main__" :

    with open("user_rating.txt", "r") as f :
        lines = f.readlines()
    
    # 2D array
    items = 5
    user_rating = [[0 for _ in range(items)] for _ in range(len(lines))]
    blank = [[0 for _ in range(items)] for _ in range(len(lines))]

    for i, line in enumerate(lines) :
        user_i = line.rstrip("\n")
        for j in range(items) :
            if user_i[2*j] != ' ' :
                user_rating[i][j] = int(user_i[2*j])
    
    # Fill the Blank
    for i in range(len(user_rating)) :
        for j in range(len(user_rating[i])) :
            if user_rating[i][j] == 0 :
                score = getScore(user_rating, i, j)
                blank[i][j] = min(max(0, int(round(score*100)) * 0.01), 5)
    
    for i in range(len(lines)) :
        user_rating[i] = list(map(operator.add, user_rating[i], blank[i]))

    for user_i in user_rating :
        print(str(user_i))
