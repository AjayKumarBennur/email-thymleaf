package pra;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
		int[] a = { 4, 6, 8 };
		int[] b = new int[a.length];
		int min = 0;
		int temp = 0;
		int sum = 0;
		LinkedList<Integer> arrayList = new LinkedList<>();

		for (int i = 0; i < a.length; i++) {
			arrayList.add(a[i]);
		}

		while (arrayList.size() >= 1) {
			ArrayList<Integer> list = new ArrayList<Integer>();

			for (int i = 0; i < b.length; i++) {
					temp = arrayList.get(i)+arrayList.get(i+1);
					list.add(temp);
					arrayList.remove(i);
					arrayList.remove(i);
					arrayList.add(temp);
					System.out.println(temp);
				}
			for (Integer integer : list) {
				sum += integer;
			}
			if (min == 0) {
				min = sum;
			}
			if (sum < min) {
				min = temp;
			}
		}
		System.out.println(min);

	}

//		for (int i = 0; i < a.length; i++) {
//			for (int j = 1; j < a.length; j++) {
//				arrayList.add(a[i]+a[j]);
//				
//			}
//			for (Integer integer : arrayList) {
//				temp+=integer;
//			}
//	}
}
