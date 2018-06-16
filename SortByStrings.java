class SortByStrings {
  public static void main(String[] args){
    SortByStrings s = new SortByStrings();
    System.out.println(s.sortString("good", "odg")); // should be oodg
    System.out.println(s.sortString("weather", "therapyw")); // should be //theeraw
    System.out.println(s.sortString("ipoystf", "sapeqotlifry"));// should be spotify
  }

  public String sortString(String s, String t){
    int[] count = new int[26];
    StringBuilder ret = new StringBuilder();

    for(int i = 0; i < s.length(); i++){
      char c = s.charAt(i);
      count[c-'a']++;
    }


    for(int i = 0; i < t.length(); i++){
      char c = t.charAt(i);
      for(; count[c-'a'] > 0; count[c-'a']--){
        ret.append(c);
      }
    }

    for(int i = 0; i < count.length; i++){

      for(; count[i] > 0; count[i]--){
        ret.append((char)(i+'a'));
      }
    }


    return ret.toString();
  }


}

/*
  goal: given 2 strings s,t sort the letters in s by the order in which they appear in t

  example: s = "good", t = "odg" returns "oodg"


  approach:
    - keep the track of each letter that appears in s, and how many times they appear
    - iterate through t and for each letter, add the count of that letter found in s to a return string
    - edge case: if letters exsist in s but not in t- add all the letters found in s that were not present in t after going through t

example: s = "good", t = "odg" returns "oodg"

ret = ""

g -> 1
o -> 2
d -> 1

i
odg
add 2 os to return string: ret = oo

 i
odg
add 1 d to return string: ret = ood

  i
odg
add 1 g to return string: ret = oodg

*if there were more letters left in s that were not in t add them now

time complexity: O(max(s,t)) because we iterate through both strings just once
space complexity: O(1) because we will keep track of letter counts in an array that will always be a constant size of 26(for 26 letters in the alphabet)



*/
