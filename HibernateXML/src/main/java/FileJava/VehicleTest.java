package FileJava;

public class VehicleTest implements Vehicle {
	
	static int m2(int rpm,int torque) {
		return (rpm*torque)*2;
	}
	
	public void m1() {
		System.out.println("Hello");
	}

	public static void main(String[] args) {
		System.out.println(VehicleTest.m2(10,20));
		
	}

}
