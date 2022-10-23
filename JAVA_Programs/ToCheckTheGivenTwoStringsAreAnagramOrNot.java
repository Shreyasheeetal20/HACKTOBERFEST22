public class A {

               public static void main(String[] args) {

                              String s1 = "adbc";

                              String s2 = "dbca";

                              if (s1.length() == s2.length()) {

                                             // To convert String into Character array

                                             char[] c1 = s1.toCharArray();

                                             char[] c2 = s2.toCharArray();

                                             // Arrays--utility class,u can use those predefined mwthods in Array variable

                                             Arrays.sort(c1);

                                             Arrays.sort(c2);

                                             // ValueOf meThod here it is converting char array into String

                                             String a = String.valueOf(c1);

                                             String b = String.valueOf(c2);

                                             if (a.equals(b)) {

                                                            System.out.println("Anagram");

                                             } else {

                                                            System.out.println("Not anagram-Exactly characters are not matching");

                                             }

                              }

                              else {

                                             System.out.println("Not Anagram-Length not equal");

                              }

               }

}
