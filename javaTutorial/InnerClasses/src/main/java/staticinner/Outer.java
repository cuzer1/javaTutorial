package staticinner;

public class Outer {

	static void f1() {
		System.out.println("Outer Static Method");
	}

	static class Inner {
		static void f2() {
			System.out.println("Inner Static Method");
		}

		void f3() {
			System.out.println("Non Static Method inside the Inner Class");
		}
	}

	public static void main(String[] args) {

		Outer.f1();
		Outer.Inner.f2();

		Outer.Inner inner = new Outer.Inner();

		inner.f3();

	}

}
