package com.vnpt.media.ottplus.model;

public class Student {
	String name;
}

class StudentHighEdu extends Student {
	void doSomeThings() {
		System.out.println("i am a student_high_edu");
	}
	
	public static void main(String[] args) {
		Student obj1 = new StudentHighEdu();
		//StudentHighEdu obj2 = new Student();
		
		((StudentHighEdu)obj1).doSomeThings();
		
		// Khai báo theo cách 1 là đúng, vì khi đó StudentHighEdu là một Student nên có thể gán bằng biến có kiểu Student
		// Biến obj1 sẽ truy cập được hàm doSomeThing(), và phải ép kiểu sang StudentHighEdu trước khi sử dụng
	}
}

