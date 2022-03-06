def Pair(userInput, correctList, correctPair):
    # Split the input where the ";" is located
    newList = userInput.split(";")

    # Returns the non empty list
    if not newList[0]:
        print(newList[1])
    if not newList[1]:
        print(newList[0])

    sortedList = ""
    sortedPair = ""
    listOneCounter = 0
    listTwoCounter = 0

    while listOneCounter < len(newList[0]) and listTwoCounter < len(newList[1]):
        # Get the first element of each string
        listOneElement = newList[0][listOneCounter]
        listTwoElement = newList[1][listTwoCounter]

        # Compare the elements
        # Add the smallest into the sorted list
        # Make a pair starting with the smallest
        if listOneElement < listTwoElement:
            sortedList += listOneElement + ","
            sortedPair += "(" + listOneElement + "," + listTwoElement + ")"
            listOneCounter += 2
        else:
            sortedList += listTwoElement + ","
            sortedPair += "(" + listTwoElement + "," + listOneElement + ")"
            # Increase by two to ignore the ","
            listTwoCounter += 2

    # Make sure that the longest list is emptied and its elements are placed in the sorted string
    while listOneCounter < len(newList[0]):
        listOneElement = newList[0][listOneCounter]
        sortedList += listOneElement + ","
        # Increase by two to ignore the ","
        listOneCounter += 2

    # Make sure that the longest list is emptied and its elements are placed in the sorted string
    while listTwoCounter < len(newList[1]):
        listTwoElement = newList[1][listTwoCounter]
        sortedList += listTwoElement + ","
        # Increase by two to ignore the ","
        listTwoCounter += 2

    # Remove the "," at the end of the string
    sortedList = sortedList[:-1]

    if sortedList == correctList:
        if sortedPair == correctPair:
            print("Correct Output")
            print("Original List: " + userInput)
            print("Sorted List: " + sortedList)
            print("Sorted Pair: " + sortedPair)
            print("")
        else:
            print("Sorted List is correct but Sorted Pair is wrong")
            print("Wrong Pair: " + sortedPair)
            print("")
    else:
        if sortedPair == correctPair:
            print("Sorted Pair is correct but Sorted List is wrong")
            print("Wrong List: " + sortedList)
            print("")
        else:
            print("Wrong Output")
            print("Wrong List: " + sortedList)
            print("Wrong Pair: " + sortedPair)
            print("")


if __name__ == '__main__':
    input1 = "1,4,7,8;2,3,5,6"
    correctList1 = "1,2,3,4,5,6,7,8"
    correctPair1 = "(1,2)(2,4)(3,4)(4,5)(5,7)(6,7)"
    Pair(input1, correctList1, correctPair1)

    input2 = "H,L,M,P,P,R,S,b,d,i,n,o,o,p,s;1,5,5,6,7,8,C,U,V,V,W,f,h,r,s"
    correctList2 = "1,5,5,6,7,8,C,H,L,M,P,P,R,S,U,V,V,W,b,d,f,h,i,n,o,o,p,r,s,s"
    correctPair2 = "(1,H)(5,H)(5,H)(6,H)(7,H)(8,H)(C,H)(H,U)(L,U)(M,U)(P,U)(P,U)(R,U)(S,U)(U,b)(V,b)" \
                   "(V,b)(W,b)(b,f)(d,f)(f,i)(h,i)(i,r)(n,r)(o,r)(o,r)(p,r)(r,s)(s,s)"
    Pair(input2, correctList2, correctPair2)

    input3 = "B,E,E,F,J,N,O,P,U,W;D,G,J,L,N,R,S,V,X,Y"
    correctList3 = "B,D,E,E,F,G,J,J,L,N,N,O,P,R,S,U,V,W,X,Y"
    correctPair3 = "(B,D)(D,E)(E,G)(E,G)(F,G)(G,J)(J,J)(J,L)(L,N)(N,N)(N,R)(O,R)(P,R)(R,U)(S,U)(U,V)(V,W)(W,X)"
    Pair(input3, correctList3, correctPair3)




