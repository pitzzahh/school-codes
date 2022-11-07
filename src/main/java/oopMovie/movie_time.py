from collections import deque

movies = deque()
snacks = deque()
max_movie_length = 3
max_snacks_length = 3


# Peter John Arao
def insert_movies(movies_queue):
    if len(movies_queue) != max_movie_length:
        movie = input("Enter movie {0} of {1}: ".format(len(movies_queue) + 1, max_movie_length))
        movies_queue.append(movie)
        insert_movies(movies_queue)


def insert_snacks(snacks_queue):
    if len(snacks_queue) != max_snacks_length:
        snack = input("Enter snack {0} of {1}: ".format(len(snacks_queue) + 1, max_snacks_length))
        snacks_queue.append(snack)
        insert_snacks(snacks_queue)
        

def check_is_done(snacks_queue_check):
    if len(snacks_queue_check) != 0:
        user_input = input("Pres S each time you finish a snack: ")
        if user_input in ['S', 's']:
            snacks_queue_check.pop()
            if len(snacks_queue_check) != 0:
                print(snacks_queue_check)
            check_is_done(snacks_queue_check)
    else:
        print("No more snacks")


insert_movies(movies)
insert_snacks(snacks)

print("Movies to watch are : {0}".format(movies))
print("Snacks available are: {0}".format(snacks))

check_is_done(snacks)
