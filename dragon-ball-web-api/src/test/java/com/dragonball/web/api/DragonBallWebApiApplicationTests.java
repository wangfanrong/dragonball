package com.dragonball.web.api;

import com.dragonball.model.user.entity.UserEO;
import com.dragonball.service.user.IUserService;
import org.apache.commons.lang.ArrayUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DragonBallWebApiApplicationTests {

	@Autowired
	private IUserService userService;

//	@Test
//	public void contextLoads() {
//	}

	@Test
	public void daleitou() {

		int[] result1 = this.getNum(35,5);
		int[] result2 = this.getNum(12,2);
		this.maopao(result1);
		this.maopao(result2);
		int[] result = ArrayUtils.addAll(result1, result2);
		String[] newResult = this.toString(result);
		System.out.println(Arrays.toString(newResult));
	}

	private  int[] getNum(int m,int n){
		int[] result = new int[n];
		int count1 = 0;
		while(count1 < n) {
			int num = (int) (Math.random() * m) + 1;
			boolean flag = true;
			for (int j = 0; j < n; j++) {
				if(num == result[j]){
					flag = false;
					break;
				}
			}
			if(flag){
				result[count1] = num;
				count1++;
			}
		}
		return result;
	}

	private int[] maopao(int[] result){
		for (int i=0; i<result.length;i++){
			for (int j=0; j<result.length-1-i;j++){
				if (result[j] > result[j+1]){
					int temp;
					temp = result[j+1];
					result[j+1] = result[j];
					result[j]=temp;
				}
			}
		}
		return result;
	}

	private String[] toString(int[] result){

		String[] newResult = new String[result.length];
		for (int i=0; i<result.length;i++){
			if (result[i]<10){
				newResult[i]="0"+result[i];
			}else {
				newResult[i]=String.valueOf(result[i]);
			}
		}
		return newResult;
	}

	@Test
	public void testCollection(){
//		Collection collection = new Collection() {
//			public int size() {
//				return 0;
//			}
//
//			public boolean isEmpty() {
//				return false;
//			}
//
//			public boolean contains(Object o) {
//				return false;
//			}
//
//			public Iterator iterator() {
//				return null;
//			}
//
//			public Object[] toArray() {
//				return new Object[0];
//			}
//
//			public Object[] toArray(Object[] a) {
//				return new Object[0];
//			}
//
//			public boolean add(Object o) {
//				return false;
//			}
//
//			public boolean remove(Object o) {
//				return false;
//			}
//
//			public boolean containsAll(Collection c) {
//				return false;
//			}
//
//			public boolean addAll(Collection c) {
//				return false;
//			}
//
//			public boolean removeAll(Collection c) {
//				return false;
//			}
//
//			public boolean retainAll(Collection c) {
//				return false;
//			}
//
//			public void clear() {
//
//			}
//		}
		ArrayList<String> a = new ArrayList<String>();
		ArrayList<String> b = new ArrayList<String>();
		a.add("a");
		a.add("b");
		a.add("c");
		a.add("d");
		b.add("a");
		b.add("b");
		b.add("c");
		Boolean isTrue = a.containsAll(b);
		System.out.println("*****"+isTrue);
		Boolean isHave = a.contains("e");
		System.out.println("**********"+isHave);
		UserEO userEO1 = new UserEO();
		userEO1.setUserName("董建威");
		int hashCode1 = userEO1.hashCode();

		UserEO userEO2 = new UserEO();
		userEO2.setUserName("方聪鹏");
		int hashCode2 = userEO2.hashCode();

		System.out.println(hashCode1+" and "+hashCode2);

	}

	@Test
	public void dragonBallTest(){
		System.out.println("OK");
	}

	@Test
	public void dragonBallAdd(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("num",8);
		List<UserEO> list = userService.selectByMap(map);

		System.out.println("OK");
	}

}
