max_length = 3


def ask_birth_month(the_set):
    if len(the_set) != max_length:
        birth_month = input("Enter birth month %d: " % (len(the_set) + 1))
        the_set.add(birth_month)
        ask_birth_month(the_set)
    return the_set


def print_set(group_number, the_set):
    print("Group {0}: {1}".format(group_number, the_set))


def print_more(first_group, second_group, self_set):
    union = first_group.union(second_group, self_set)
    intersection = (first_group & second_group)
    difference = (first_group - second_group)

    print("Union: %s" % union)
    print("Intersection: %s" % intersection)
    print("Difference: %s" % difference)

    if self_set.issubset(union):
        print("You have the same birth month with one of your classmates.")
    else:
        print("You don't have the same birth month as your classmates.")


def main():

    first_group = ask_birth_month(set())

    second_group = ask_birth_month(set())

    print_set(1, first_group)
    print_set(2, second_group)

    self_set = set()
    self_set.add(input("Enter your birth month: "))

    print_more(first_group, second_group, self_set)


main()
