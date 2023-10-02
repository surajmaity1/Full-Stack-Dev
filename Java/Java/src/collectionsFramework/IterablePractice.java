package collectionsFramework;

public class IterablePractice {

	public static void main(String[] args) {
		UrlLibrary urlLibrary = new UrlLibrary();
		
		for(String contentHtml: urlLibrary) {
			System.out.println(contentHtml.length());
			System.out.println(contentHtml);
			
		}
	}

}
