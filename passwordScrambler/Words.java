import java.util.*;

public class Words {
    //static char[] alphabet = ",./<>?!@#$%^&*()_+123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
    static char[] alphabet = "rstk".toCharArray();
    //static Vector buffer = new Vector();
	static SortedSet<String> set = new TreeSet<String>(new myComp() {
        @Override
        public int compare(String a, String b) {
            if(a.length() == b.length())
                return a.compareTo(b);
            else
                return a.length()-b.length(); 
        }
    });
    
    static void generate(StringBuffer sb, int n) {
        if (n == sb.length()) {
            if(!hasDuplicates(sb.toString())){
                
                char[] word = sb.toString().toCharArray();
                Arrays.sort(word);
                String s = new String(word);
                
                //List<char[]> w = Arrays.asList(word);
                set.add(s);

                //System.out.println(sb.toString());
            }
			//buffer.add(sb.toString());
			return;
        }
        for (char letter : alphabet) {
            sb.setCharAt(n, letter);
            generate(sb, n + 1);
        }
    }

    private static boolean hasDuplicates(String string) {
    for (int i = 0; i < string.length() - 1; i++) {
        if (string.substring(i + 1).contains(string.subSequence(i, i + 1))) {
        return true;
        }
    }
    return false;
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        for (int length = 1; length <= alphabet.length; length++) {
            sb.setLength(length);
            generate(sb, 0);
        }
        //System.out.println(Arrays.toString(buffer.toArray()));

        Random r = new Random();
        for(String s : set){
            StringBuffer temp = new StringBuffer();
            for(char c : s.toCharArray()){
                switch (c){
                    case 'r': temp.append("-r");
                        break;
                    case 's' : temp.append("-s");
                        break;
                    case 't' : temp.append("-t "+ alphabet[Math.abs(r.nextInt()%alphabet.length)]);
                        break;
                    case 'k' : temp.append("-k");
                                int random = Math.abs(r.nextInt()%3);
                                if(random > 0){
                                    temp.append(" ");
                                }
                                for (int i = 0; i < random; i++){
                                    temp.append(r.nextInt()%12);
                                    if(i < random-1){
                                        temp.append(",");
                                    }
                                }
                        break;
                    }
                    temp.append(" ");
                }

            System.out.println(temp.toString());
            }
    }
}

