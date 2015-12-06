package sevenWonders.core.utils;

import java.util.List;
import java.util.ListIterator;

import com.google.gwt.user.client.Random;

public class GameUtils {
	private static void swap(Object[] arr, int i, int j) {
		Object tmp = arr[i];
    	arr[i] = arr[j];
    	arr[j] = tmp;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void shuffle(List<?> list) {
	    int size = list.size();
         Object arr[] = list.toArray();
         for (int i=size; i>1; i--)
             swap(arr, i-1, Random.nextInt(i));
         ListIterator it = list.listIterator();
         for (int i=0; i<arr.length; i++) {
             it.next();
             it.set(arr[i]);
         }
     }
}
