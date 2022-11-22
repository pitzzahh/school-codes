from queue import PriorityQueue

prio = PriorityQueue()
prio.put("Dog")
prio.put("Cat")
prio.put("Horse")
prio.put("Cow")

while not prio.empty():
    print(prio.get())
