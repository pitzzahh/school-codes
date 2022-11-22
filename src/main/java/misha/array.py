from queue import PriorityQueue
prio=PriorityQueue()
prio.put("dog")
prio.put("d")
prio.put("dogs")
while not prio.empty():
    next_item=prio.get()
    print(next_item)
