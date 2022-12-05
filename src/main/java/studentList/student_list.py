students = {}


def add_student(student_map, limit):
    while True:
        student_number = input("Enter student number: ")
        student_first_name = input("Enter first name: ")
        student_map[student_number] = student_first_name
        limit -= 1
        last_student_number = student_number
        if limit == 0:
            break
    return last_student_number


def print_students(student_map):
    for student_number, student_first_name in student_map.items():
        print(student_number + " " + student_first_name)


last_student = add_student(students, 3)
print_students(students)

del students[last_student]

add_student(students, 1)
print_students(students)
