package collectionsFramework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;

public class UrlLibrary implements Iterable<String> {
	private LinkedList<String> urlLibrary = new LinkedList<>();
	
	private class UrlIterator implements Iterator<String> {

		private int idx = 0;
		StringBuilder stringBuilder = new StringBuilder();
		
		@Override
		public boolean hasNext() {
			return idx < urlLibrary.size();
		}

		@Override
		public String next() {
			try {
				URL url = new URL(urlLibrary.get(idx));
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(url.openStream())
						);
				
				String line = null;
				
				while((line = bufferedReader.readLine()) != null) {
					stringBuilder.append(line);
					stringBuilder.append("\n");
				}
				
				bufferedReader.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			idx++;
			
			return stringBuilder.toString();
		}
		
		@Override
		public void remove() {
			urlLibrary.remove(idx);
		}
		
	}
	
	public UrlLibrary() {
		urlLibrary.add("https://linktr.ee/surajmyt");
		urlLibrary.add("https://surajmyt.hashnode.dev");
		urlLibrary.add("https://github.com/surajmaity1");
		urlLibrary.add("https://www.youtube.com/@SurajMaity");
	}

	@Override
	public Iterator<String> iterator() {
		return new UrlIterator();
	}

	/*
	@Override
	public Iterator<String> iterator() {
		return ll.iterator();
	}
	*/
	
}
