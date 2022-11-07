#
# written by Peter John Arao
# using recursive functions
# ha?? sino sino connected??
# hahahahah hi ms.clemena
# lol . magdidiscuss tayo bukas about sa 3 topics sa dsa
# programmer ka ms.izyl??
# hindi paman po ako magaling HAHAH
# pero marunong?
# hahahah humble
# magchecheck pa ako mga activities nyo hahahahaha
#annyeong
# byee pu
# slight po? hahahah
# sige po ma'am byee po
# good night poo
# good evening po ma'am
# si Izyl po tapos si Adrian kanina umalis na
def main():
    basket = []
    fruits = ('Apple', 'Orange', 'Mango', 'Guava')
    print("Catch any of the fruits in the basket:", fruits)
    __enter_number_of_fruits_to_catch__(basket)


def __enter_number_of_fruits_to_catch__(basket):
    isNumber = False
    while not isNumber:
        try:
            number_of_fruits_to_catch = int(input("Enter the number of fruits to catch: "))
            isNumber = True
            __catch_fruits__(number_of_fruits_to_catch, basket)
        except ValueError:
            print("Invalid input. Please enter a number.")
            isNumber = False


def __insert_fruit__(basket, fruit_letter):
    fruits = ('Apple', 'Orange', 'Mango', 'Guava')
    if fruit_letter == "A" or fruit_letter == 'a':
        basket.append(fruits[0])
    elif fruit_letter == "O" or fruit_letter == 'o':
        basket.append(fruits[1])
    elif fruit_letter == "M" or fruit_letter == 'm':
        basket.append(fruits[2])
    elif fruit_letter == "G" or fruit_letter == 'g':
        basket.append(fruits[3])
    else:
        print("Invalid input. Please enter A, O, M, or G.")


def __catch_fruits__(number_of_fruits, basket):
    if len(basket) != number_of_fruits:
        __insert_fruit__(basket, input("Fruit {0} of {1}: ".format(len(basket) + 1, number_of_fruits)))
        __catch_fruits__(number_of_fruits, basket)
    __print_basket__(basket)


def __print_basket__(basket):
    basket_string = "'{}'".format("', '".join(basket))
    print(len(basket) >= 1 and "Fruits in the basket: [" + basket_string + "]" or "")
    __eat_fruit__(basket)


def __eat_fruit__(basket):
    if __is_basket_empty__(basket):
        print("No more fruits to eat.")
        exit(0)

    eat = input("Press E to eat a fruit: ")
    if eat == "E" or eat == "e":
        basket.pop()
        __print_basket__(basket)
    else:
        print("Invalid input. Please enter E to eat.")
        __eat_fruit__(basket)


def __is_basket_empty__(basket):
    return len(basket) == 0


if __name__ == "__main__":
    main()
