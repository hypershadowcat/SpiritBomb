package SearchEngine;

public class Index {
	 char[] text;
	 char[] pattern;
	 int foo;
	 int java;
	
	public void setString(String text, String pattern) {
		this.text = text.toCharArray();
		this.pattern = pattern.toCharArray();
		this.foo = text.length();
		this.java = pattern.length();
	}
	
	public int search() {
		for (int i = 0; i < foo-java; i++) {
			int j = 0;
			while (j < java && text[i+j] == pattern[j]) {
				j++;
			}
			if (j == java) return i;
		}
		return -1;
	}
}
//This is an Index for the Search Engine project 