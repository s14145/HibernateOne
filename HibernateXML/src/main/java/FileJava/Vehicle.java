package FileJava;

public interface Vehicle {
	
	default void m1() {
		System.out.println("Hello");
	}
	
	static int m2(int rpm,int torque) {
		return rpm*torque;
	}

}
