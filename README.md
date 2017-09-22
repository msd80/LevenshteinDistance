
Problem
-------

Your task is to count the size of the social network of the word LISTY in the dictionary provided.

We define two words as being friends if the edit distance between them is 1. For this problem, we will
be using Levenshtein distance (http://en.wikipedia.org/wiki/Levenshtein_distance) as our edit distance.

The size of a word's social network is equal to 1 (for the word itself), plus the number of words who
are friends with it, plus the number of friends each of its friends has, and so on. A word is in its own
social network, so if our dictionary is simply `[HI]` then the size of the social network for HI is 1.

Solution
--------
In the problem, we're given a "dictionary" that contains a list of words in no particular order.
The solution to the problem above is broken down into three sections: DetermineFriends, ReadDictionary,
and SocialNetwork.

The ReadDictionary essentially takes in a text file that contains the list of words and sorts them in ascending
string length order and puts them into an ArrayList. SocialNetwork takes the sorted ArrayList and can call the
findNetworkSize(String string_source) to determine the network size of string_source from the corresponding
dictionary. The process begins by creating a Node called Friend_Network that contains the source String as well
as an empty List of Friend_Network. It then calls on binary search to figure out the index of the first string
that has the length of length - 1 (Because according to Levenshtein distance, a string can only be considered
a friend if it is at most 1 char length apart). After discovering the index, loops through the dictionary to add
appropriate Strings to the List of Friend_Network of source. Once completed, calls on traverse again on its list
of Friend_Network until list results in empty. The resulting tree of nodes is then added up to return the size of
the source's network.