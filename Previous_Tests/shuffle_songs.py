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

    
if __name__ == "__main__" :
    generate_input_file()