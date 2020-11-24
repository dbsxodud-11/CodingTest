from collections import defaultdict
import random

def generate_input_file() :

    input_file = open("music.txt", "w")
    input_file.write("2002\tAnnie-Marie\n")
    input_file.write("bad guy\tBillie Eilish\n")
    input_file.write("thank u, next\tAriana Grande\n")
    input_file.write("friends\tAnne-Marie\n")
    input_file.write("Attention\tCharlie Puth\n")
    input_file.write("One Call Away\tCharile Puth\n")
    input_file.write("We don't talk anymore\tCharile Puth\n")
    input_file.write("come out and play\tBillie Eilish\n")
    input_file.write("Thinking Out Loud\tEd Sheeran\n")
    input_file.write("Shape of You\tEd Sheeran\n")

    input_file.close()

    return input_file

def shuffle_songs() :

    with open("music.txt", "r") as f :
        lines = f.readlines()

    # 가수 이름 -> 곡 개수 / 곡 리스트
    number_of_songs = defaultdict(int)
    name_of_songs = defaultdict(list) 
    for i in range(len(lines)) :
        song, singer = lines[i][:-1].split("\t")
        number_of_songs[singer] += 1
        name_of_songs[singer].append(song)

    # 가수 이름 -> 곡 리스트(Fisher-Yates Algorithm)
    for singer in name_of_songs :
        song_list = name_of_songs.get(singer)
        for i in range(len(song_list)) :
            j = random.randint(0, i)
            temp = song_list[j]
            song_list[j] = song_list[i]
            song_list[i] = temp
        name_of_songs[singer] = song_list
    
    # Interval
    intervals = defaultdict(list)
    for singer in number_of_songs.keys() :
        for i in range(number_of_songs.get(singer)) :
            # First song : random interval
            if intervals.get(singer) is None:
                intervals[singer].append(random.randint(0, 100//(number_of_songs.get(singer))))
            # Else : Randomly Distributed Interval
            else :
                intervals[singer].append(intervals.get(singer)[-1] + random.randint(1, 100//(number_of_songs.get(singer))))
        print(str(intervals.get(singer)))
    # Shuffle Songs
    playlist = [None for _ in range(100)]
    for singer, interval in intervals.items() :
        for i, index in enumerate(interval) :
            if playlist[index] is not None :
                while playlist[index] is not None :
                    index += 1
            playlist[index] = name_of_songs.get(singer)[i] + "\t" + singer + "\n" 

    playlist = list(filter(lambda x : x is not None, playlist))
    return playlist
    
if __name__ == "__main__" :
    
    #music_list = generate_input_file()
    playlist = shuffle_songs()

    for album in playlist : 
        print(album)
    # with open("music.txt", "r") as f :
    #     print(f.read())