class DecodeString{


  public static void main(String[] args){
    DecodeString d = new DecodeString();
    System.out.println(d.decodeString("4[ab]")); // should be abababab
    System.out.println(d.decodeString("2[b3[a]]")); // should be baaabaaa
  }

  int index = 0;

  public String decodeString(String s){
    index = 0;
    return decodeStringHelper(s);
  }

  public String decodeStringHelper(String s) {
    StringBuilder ret = new StringBuilder();
    String num = "";

    for (int i = index; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isLetter(c)) {
        ret.append(c);
      }
      else if (Character.isDigit(c)) {
        num += c;
      }
      else if (c == '[') {
        index = i + 1;
        String temp = decodeStringHelper(s);
        for (int j = 0; j < Integer.parseInt(num); j++){
          ret.append(temp);
        }
        num = "";
        i = index;
      }
      else if (c == ']') {
        index = i;
        break;
      }
    }
    return ret.toString();
  }
}

/*
  goal: given a string with numbers, letters, and brackets return the string decoded

  example: s = "2[b3[a]]" returns "baaabaaa"

  approach:
    - everytime a letter is encountered add it to the return string
    - every time a number num is encountered, save it so that we can add num ammount of elements within the brackets
    - everytime an opening bracket is encountered use a recursive method to DFS
    - everytime a closing bracket is encountered return the return string

    - keep a global index to ensure we dont analyze an index twice and update it when necessary

  time complexity: O(n) because every character is visited once
  space complexity: O(m) where m is the deepest nested bracket level because we are using stack space





*/
