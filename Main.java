public class Main {
    public static void Pair(String userInput, String correctList, String correctPair)
    {
        // Split the input where the ";" is located
        String[] newList = userInput.split(";");

        // Returns the non-empty list
        if(newList[0] == null) {
            System.out.println(newList[1]);
        }
        if(newList[1] == null) {
            System.out.println(newList[0]);
        }

        String sortedList = "";
        String sortedPair = "";
        int listOneCounter = 0;
        int listTwoCounter = 0;

        while (listOneCounter < newList[0].length() && listTwoCounter < newList[1].length()) {
            // Get the first element of each string
            char listOneElement = newList[0].charAt(listOneCounter);
            char listTwoElement = newList[1].charAt(listTwoCounter);

            if (listOneElement < listTwoElement) {
                sortedList += listOneElement + ",";
                sortedPair += "(" + listOneElement + "," + listTwoElement + ")";
                listOneCounter += 2;
            } else {
                sortedList += listTwoElement + ",";
                sortedPair += "(" + listTwoElement + "," + listOneElement + ")";
                listTwoCounter += 2;
            }
        }

        while (listOneCounter < newList[0].length()) {
            char listOneElement = newList[0].charAt(listOneCounter);
            sortedList += listOneElement + ",";
            listOneCounter += 2;
        }

        while (listTwoCounter < newList[1].length()) {
            char listTwoElement = newList[1].charAt(listTwoCounter);
            sortedList += listTwoElement + ",";
            listTwoCounter += 2;
        }


        // remove the extra comma inserted at the end
        sortedList = sortedList.substring(0, sortedList.length()-1);

        if (sortedList.equals(correctList)) {
            if (sortedPair.equals(correctPair)) {
                System.out.println("Correct Output");
                System.out.println("Original List: " + userInput);
                System.out.println("Sorted List: " + sortedList);
                System.out.println("Sorted Pair: " + sortedPair);
                System.out.println("");
            } else {
                System.out.println("Sorted List is correct but Sorted Pair is wrong");
                System.out.println("Wrong Pair: " + sortedPair);
                System.out.println("");
            }
        } else {
            if (sortedPair.equals(correctPair)) {
                System.out.println("Sorted Pair is correct but Sorted List is wrong");
                System.out.println("Wrong List: " + sortedList);
                System.out.println("");
            } else {
                System.out.println("Wrong Output");
                System.out.println("Wrong List: " + sortedList);
                System.out.println("Wrong Pair: " + sortedPair);
                System.out.println("");
            }
        }
    }

    public static void main(String[] args) {
        String input1 = "1,4,7,8;2,3,5,6";
        String correctList1 = "1,2,3,4,5,6,7,8";
        String correctPair1 = "(1,2)(2,4)(3,4)(4,5)(5,7)(6,7)";
        Pair(input1, correctList1, correctPair1);

        String input2 = "H,L,M,P,P,R,S,b,d,i,n,o,o,p,s;1,5,5,6,7,8,C,U,V,V,W,f,h,r,s";
        String correctList2 = "1,5,5,6,7,8,C,H,L,M,P,P,R,S,U,V,V,W,b,d,f,h,i,n,o,o,p,r,s,s";
        String correctPair2 = "(1,H)(5,H)(5,H)(6,H)(7,H)(8,H)(C,H)(H,U)(L,U)(M,U)(P,U)(P,U)(R,U)(S,U)(U,b)(V,b)(V,b)(W,b)(b,f)(d,f)(f,i)(h,i)(i,r)(n,r)(o,r)(o,r)(p,r)(r,s)(s,s)";
        Pair(input2, correctList2, correctPair2);

        String input3 = "B,E,E,F,J,N,O,P,U,W;D,G,J,L,N,R,S,V,X,Y";
        String correctList3 = "B,D,E,E,F,G,J,J,L,N,N,O,P,R,S,U,V,W,X,Y";
        String correctPair3 = "(B,D)(D,E)(E,G)(E,G)(F,G)(G,J)(J,J)(J,L)(L,N)(N,N)(N,R)(O,R)(P,R)(R,U)(S,U)(U,V)(V,W)(W,X)";
        Pair(input3, correctList3, correctPair3);
    }
}